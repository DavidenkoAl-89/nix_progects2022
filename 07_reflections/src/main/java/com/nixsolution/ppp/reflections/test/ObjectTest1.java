package com.nixsolution.ppp.reflections.test;

import com.nixsolutions.ppp.reflection.Ignore;


public class ObjectTest1 {

    private int obj = 10;

    private String str = "abc";

    @Ignore
    private long aLong = 1222L;

     ForObjectTest forObjectTest = new ForObjectTest(2);
}
