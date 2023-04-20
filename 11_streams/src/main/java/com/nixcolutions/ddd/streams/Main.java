package com.nixcolutions.ddd.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringTransformUtilsImpl transformUtils = new StringTransformUtilsImpl();

        String[] arr = {"foo", "bar", "foo", "baz"};
        System.out.println(transformUtils.findDistinctToUpperCase(arr));
        List<Integer> integerList = new ArrayList<>();
        for (int i = -10; i <= 20; i++) {
            integerList.add(i);
        }
         System.out.println(integerList);
        System.out.println("count of negative: " + transformUtils.countNegativeIntegers(integerList));

        List<String> stringList = Arrays.asList(new String[]{"abc", "abc", "abc", "ab"});
         System.out.println(stringList);
        System.out.println("count of same words: " + transformUtils.countWordsInList(stringList, "abc"));

        int[] numbers = {1, 2, 3, 4, 5, 9, 8, 7, 6, 5};
        System.out.println("string fom int[]: " + transformUtils.getStringOfNumbers(numbers));
        System.out.println("5 biggest numbers: " + transformUtils.getMaxFiveNumbers(numbers));

        List<String[]> stringList1 = new ArrayList<>();
        stringList1.add(new String[]{"foo", "bar", "baz"});
        stringList1.add(new String[]{"foo", "bar", "fuz"});
        System.out.println(transformUtils.toDistinctList(stringList1));
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("test");
        stringList2.add("tonystark");
        stringList2.add("diobrando");
        System.out.println(transformUtils.isAllStringsLongerThen(stringList2, 3));
        System.out.println(transformUtils.getFirstCharactersAsString(stringList2));
        List<String> list = Arrays.asList(new String[]{"Irene", "Wendy", "Seulgi", "Joy", "Yeri", "Red", "Velvet"});
        System.out.println(transformUtils.groupByLength(list));
    }
}

