package com.nixsolution.ppp.basetypes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BaseTypesUtilImpl baseTypesUtil = new BaseTypesUtilImpl();
        int[] ints = {10, 1, 3, 5, 25};
        System.out.println(Arrays.toString(baseTypesUtil.sort(ints)));
        float arithmeticMean = baseTypesUtil.arithmeticMean(ints);
        System.out.println("Average is: " + arithmeticMean);
        String sum = baseTypesUtil.plus("123.4", "100.000");
        System.out.println("Sum is: " + sum);
        String minus = baseTypesUtil.minus("100.100", "20.055");
        System.out.println("Difference is: " + minus);
        String multiply = baseTypesUtil.mul("10.1", "10.05");
        System.out.println("Multiply is: " + multiply);
        String divide = baseTypesUtil.div("1234567890987654321234567890987654321234567890987654321234567890", "50000000000000000000000000");
        System.out.println("Divide is: " + divide);
        String value = baseTypesUtil.toggleScientificNotation("9.88E08");
        System.out.println(value);
        String value1 = baseTypesUtil.toggleScientificNotation("-1212121212");
        System.out.println(value1);
        String format = baseTypesUtil.format(1000000.003,"ru");
        System.out.println(format);

    }
}
