package com.nixsolutions.ppp.generics;

public class ConvertIntegerToStringImpl implements Converter<String, Integer[]> {
    @Override
    public String get(Integer[] value) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : value) {
            sb.append(integer).append(" ");
        }
        return sb.toString().trim();
    }
}
