package com.nixsolution.ppp.serialization;

import com.nixsolutions.ppp.serializable.SerializableUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DefaultSerializableUtils implements SerializableUtils {
    @Override
    public void serialize(OutputStream out, Object obj) {
        if (obj == null || out == null) {
            throw new RuntimeException("object is null");
        }
        try (ObjectOutputStream ooup = new ObjectOutputStream(out)) {
            ooup.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T deserialize(InputStream in, Class<T> clazz) {
        Object obj;
        try (ObjectInputStream ois = new ObjectInputStream(in)) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clazz.cast(obj);
    }
}

