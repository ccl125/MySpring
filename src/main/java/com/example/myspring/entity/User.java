package com.example.myspring.entity;

import com.example.myspring.common.filed.DeSerializerUpperLowerCase;
import com.example.myspring.common.filed.SerializerUpperLowerCase;
import lombok.Data;

/**
 * @Author CuiChengLong
 * @Date 2023/9/14 21:41
 * @Description
 */
@Data
public class User {

//    @SerializerUpperLowerCase(strategy = SerializerUpperLowerCase.Strategy.LOWER)
    @DeSerializerUpperLowerCase(strategy = DeSerializerUpperLowerCase.Strategy.UPPER)
    private String uuId;

//    @SerializerUpperLowerCase(strategy = SerializerUpperLowerCase.Strategy.LOWER)
    @DeSerializerUpperLowerCase(strategy = DeSerializerUpperLowerCase.Strategy.UPPER)
    private String domain;

}
