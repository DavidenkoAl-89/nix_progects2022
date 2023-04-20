package com.nixsolution.ppp.reflections.test;

import com.nixsolutions.ppp.reflection.Ignore;
import com.nixsolutions.ppp.reflection.Info;

public class ObjectTest2 {

    private int obj = 10;

    private String str = "abc";

    @Ignore
    private long aLong = 222L;

    ForObjectTest forObjectTest = new ForObjectTest(1);

}
