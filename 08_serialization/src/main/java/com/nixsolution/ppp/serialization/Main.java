package com.nixsolution.ppp.serialization;

import com.nixsolutions.ppp.serializable.SerializableBean;
import com.nixsolutions.ppp.serializable.SerializableUtils;


import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new ObjectOutputStream(OutputStream.nullOutputStream());

        SerializableUtils serializableUtils = new DefaultSerializableUtils();
        SerializableUtils jsonSerializableUtils = new JsonSerializationUtils();
        SerializableBean serializableBean = new SerializableBeanImpl();



    }
}


