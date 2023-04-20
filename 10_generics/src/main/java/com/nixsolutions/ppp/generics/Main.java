package com.nixsolutions.ppp.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Converter<Double, Float> converter = new ConverterFromFloatToDoubleImpl();
        System.out.println(converter.get(123.45600128173828f));
        Converter<String, Integer[]> converter1 = new ConvertIntegerToStringImpl();
        Integer[] ints = {1, 2, 3, 4, 5};
        System.out.println(converter1.get(ints));
        Summator<Float> summator = new SummatorNumberImpl();
        List<Float> list = new ArrayList<>();
        List<Float> list1 = new ArrayList<>();
        list.add(1f);
        list.add(2f);
        list.add(3f);
        list1.add(4f);
        list1.add(5f);
        list1.add(6f);
        Map<String, List<Float>> map = new HashMap<>();
        map.put("key 1", list);
        map.put("key 2", list1);
        System.out.println(summator.sum(map));
        Summator<BigDecimal> summatorBd = new SummatorBigDecimalImpl();
        List<BigDecimal> listBd = new ArrayList<>();
        List<BigDecimal> listBb1 = new ArrayList<>();
        listBd.add(BigDecimal.valueOf(1));
        listBd.add(BigDecimal.valueOf(2));
        listBd.add(BigDecimal.valueOf(3));
        listBb1.add(BigDecimal.valueOf(4));
        listBb1.add(BigDecimal.valueOf(5));
        listBb1.add(BigDecimal.valueOf(6));
        Map<String, List<BigDecimal>> mapBd = new HashMap<>();
        mapBd.put("key 1", listBd);
        mapBd.put("key 2", listBb1);
        System.out.println(summatorBd.sum(mapBd));


    }
}
