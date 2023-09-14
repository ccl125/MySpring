package com.example.myspring.common.filed;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@JsonSerialize(using = UpperLowerCaseSerializer.class)
public @interface SerializerUpperLowerCase {

    Strategy strategy() default Strategy.UPPER;

    enum Strategy {
        UPPER, LOWER
    }

}
