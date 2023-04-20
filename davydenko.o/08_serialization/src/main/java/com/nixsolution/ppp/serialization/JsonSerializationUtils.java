package com.nixsolution.ppp.serialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nixsolutions.ppp.serializable.SerializableUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JsonSerializationUtils implements SerializableUtils {
    JsonMapper mapper = new JsonMapper();
    @Override
    public void serialize(OutputStream out, Object obj) {
        if (obj == null || out == null) {
            throw new RuntimeException("object is null");
        }
        try {
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(out, obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public <T> T deserialize(InputStream in, Class<T> clazz) {
        try {
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return mapper.readValue(in, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
