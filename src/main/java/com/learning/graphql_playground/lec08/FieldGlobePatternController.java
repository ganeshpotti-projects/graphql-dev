package com.learning.graphql_playground.lec08;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.logging.Level;

@Controller
public class FieldGlobePatternController {

    @QueryMapping
    public Object level1(DataFetchingFieldSelectionSet selectionSet){
        System.out.println(selectionSet.contains("level2"));
        System.out.println(selectionSet.contains("level2/level3"));
        return null;
    }

}
