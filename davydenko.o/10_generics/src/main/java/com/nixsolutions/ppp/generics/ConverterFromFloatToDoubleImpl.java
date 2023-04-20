package com.nixsolutions.ppp.generics;

public class ConverterFromFloatToDoubleImpl implements Converter<Double, Float> {
    @Override
    public Double get(Float value) {
        return Double.parseDouble(value.toString());
    }
}
