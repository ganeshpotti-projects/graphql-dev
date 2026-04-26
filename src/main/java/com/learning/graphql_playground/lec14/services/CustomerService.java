package com.learning.graphql_playground.lec14.services;

import com.learning.graphql_playground.lec14.dto.CustomerDto;
import com.learning.graphql_playground.lec14.dto.CustomerEvent;
import com.learning.graphql_playground.lec14.dto.DeleteResponseDto;
import com.learning.graphql_playground.lec14.enums.Action;
import com.learning.graphql_playground.lec14.enums.Status;
import com.learning.graphql_playground.lec14.repositories.CustomerRepository;
import com.learning.graphql_playground.lec14.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerEventService customerEventService;

    public Flux<CustomerDto> allCustomers(){
        return customerRepository.findAll().map(EntityDtoUtil::toDto);
    }

    public Mono<CustomerDto> customerById(Integer id){
        return customerRepository.findById(id).map(EntityDtoUtil::toDto);
    }

    public Mono<CustomerDto> createCustomer(CustomerDto customerDto){
        return customerRepository.save(EntityDtoUtil.toEntity(customerDto))
                .map(EntityDtoUtil::toDto)
                .doOnNext(c -> customerEventService.emitEvent(CustomerEvent.create(c.getId(), Action.CREATED)));
    }

    public Mono<CustomerDto> updateCustomer(Integer id, CustomerDto customerDto){
        return customerRepository.save(EntityDtoUtil.toEntity(id, customerDto))
                .map(EntityDtoUtil::toDto)
                .doOnNext(c -> customerEventService.emitEvent(CustomerEvent.create(c.getId(), Action.UPDATED)));
    }

    public Mono<DeleteResponseDto> deleteCustomer(Integer id){
        return customerRepository.deleteById(id)
                .doOnSuccess(c -> customerEventService.emitEvent(CustomerEvent.create(id, Action.DELETED)))
                .thenReturn(DeleteResponseDto.create(id, Status.SUCCESS))
                .onErrorReturn(DeleteResponseDto.create(id, Status.FAILURE));
    }


 }
