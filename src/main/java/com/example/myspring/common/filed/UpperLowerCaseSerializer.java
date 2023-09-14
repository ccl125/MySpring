package com.example.myspring.common.filed;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;


import java.io.IOException;

/**
 * @Author CuiChengLong
 * @Date 2023/9/14 21:50
 * @Description
 */

public class UpperLowerCaseSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private SerializerUpperLowerCase serializerUpperLowerCase;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (StrUtil.isBlank(value)) {
            gen.writeString(value);
            return;
        }
        if (serializerUpperLowerCase != null) {
            final SerializerUpperLowerCase.Strategy strategy = serializerUpperLowerCase.strategy();
            gen.writeString(getValue(value, strategy));
        } else {
            gen.writeString(value);
        }

    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty property) throws JsonMappingException {
        SerializerUpperLowerCase annotation = property.getAnnotation(SerializerUpperLowerCase.class);

        if (annotation != null) {
            this.serializerUpperLowerCase = annotation;
        }
        return this;
    }

    private String getValue(String str, SerializerUpperLowerCase.Strategy strategy) {
        switch (strategy) {
            case LOWER:
                return str.toLowerCase();
            case UPPER:
                return str.toUpperCase();
            default:
                throw new IllegalArgumentException("Illegal Sensitive Strategy");
        }
    }

}
