package com.nixsolution.ppp.serialization;

import com.nixsolutions.ppp.serializable.SerializableBean;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SerializableBeanImpl implements SerializableBean {
    private String name;
    private transient String email;
    private transient int zip;
    public SerializableBeanImpl() {
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int getZip() {
        return zip;
    }
    @Override
    public void setZip(int zip) {
        this.zip = zip;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(String.join(";", name,
                email, String.valueOf(zip)));
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String[] array = in.readObject().toString().split(";");
        this.name = array[0];
        this.email = array[1];
        this.zip = Integer.parseInt(array[2]);
    }
}