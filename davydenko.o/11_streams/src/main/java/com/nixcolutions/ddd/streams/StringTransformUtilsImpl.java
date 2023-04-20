package com.nixcolutions.ddd.streams;

import com.nixsolutions.ppp.streamoptional.StringTransformUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringTransformUtilsImpl implements StringTransformUtils {
    @Override
    public List<String> findDistinctToUpperCase(String[] strings) {
        List<String> list = Arrays.asList(strings);
        return list.stream()
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    @Override
    public long countNegativeIntegers(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x < 0)
                .count();
    }
    @Override
    public long countWordsInList(List<String> words, String wordToCount) {
        return words.stream()
                .filter(x -> wordToCount.equals(x))
                .count();
    }
    @Override
    public List<String> toDistinctList(List<String[]> stringsArrays) {
        List<String> newList;
        List<String> resultList = new ArrayList<>();
        newList = stringsArrays.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        resultList.addAll(newList.stream()
                .distinct()
                .collect(Collectors.toList()));
        return resultList;
    }
    @Override
    public boolean isAllStringsLongerThen(List<String> strings, long numberOfCharacters) {
        if (numberOfCharacters < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        return strings.stream()
                .map(x -> x.length() > numberOfCharacters)
                .findAny()
                .orElse(false);
    }
    @Override
    public List<Integer> getMaxFiveNumbers(int[] numbers) {
        if (numbers.length < 5) {
            throw new IllegalArgumentException(" numbers less then 5");
        }
        return IntStream.of(numbers)
                .sorted()
                .skip(numbers.length - 5)
                .boxed()
                .collect(Collectors.toList());
    }
    @Override
    public String getStringOfNumbers(int[] numbers) {
        return IntStream.of(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
    }
    @Override
    public String getFirstCharactersAsString(List<String> strings) {
        return strings.stream()
                .map(x -> x.substring(0, 1))
                .reduce("", (x, y) -> x + y);
    }
    @Override
    public Map<Integer, List<String>> groupByLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }
}
