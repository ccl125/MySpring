package com.example.myspring.common.filed;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.io.IOException;

/**
 * @Author CuiChengLong
 * @Date 2023/9/14 21:50
 * @Description JsonDeserializer
 */

public class UpperLowerCaseDeSerializer extends JsonDeserializer<String> implements ContextualDeserializer {

    private DeSerializerUpperLowerCase deSerializerUpperLowerCase;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext  serializerProvider, BeanProperty property) throws JsonMappingException {
        DeSerializerUpperLowerCase annotation = property.getAnnotation(DeSerializerUpperLowerCase.class);
        if (annotation != null) {
            this.deSerializerUpperLowerCase = annotation;
        }
        return this;
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getValueAsString();
        final DeSerializerUpperLowerCase.Strategy strategy = deSerializerUpperLowerCase.strategy();
        return getValue(value, strategy);
    }

    private String getValue(String str, DeSerializerUpperLowerCase.Strategy strategy) {
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
