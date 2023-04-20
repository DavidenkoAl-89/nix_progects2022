package com.nixsolution.ppp.serialization;

import com.nixsolutions.ppp.serializable.SingletonBean;

public class SingletonBeanImpl implements SingletonBean {
    private static SingletonBeanImpl singleton = new SingletonBeanImpl();
    private SingletonBeanImpl() {
    }
    public static SingletonBeanImpl getInstance() {
        return singleton;
    }
    public Object readResolve() {
        return getInstance();
    }
}
