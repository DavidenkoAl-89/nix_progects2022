package com.nixsolution.ppp.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {

    StringBuilder builder = new StringBuilder();

    @Test
    public void stringBuilderCapacity() {
        StringBuilder builder = new StringBuilder(100);
        assertEquals(100, builder.capacity());
    }

    @Test
    public void stringBuilderLength() {
        StringBuilder builder = new StringBuilder("12345");
        assertEquals(5, builder.toString().length());
    }

    @Test
    public void appendToStringBuilder() {
        builder.append("s");
        builder.append(1);
        builder.append("d");
        assertEquals("s1d", builder.toString());
    }

    @Test
    public void insertStringBuilder() {
        StringBuilder builder = new StringBuilder("123890");
        builder.insert(3, "4567");
        assertEquals("1234567890", builder.toString());
    }

    @Test
    public void deleteFromStringBuilder() {
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.delete(2, 4);
        assertEquals("abefg", builder.toString());
    }

    @Test
    public void deleteCharFromStringBuilder() {
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.deleteCharAt(2);
        assertEquals("abdefg", builder.toString());
    }

    @Test
    public void capacityWithTrimToSize() {
        StringBuilder builder = new StringBuilder("hello");
        assertEquals(21, builder.capacity());
        builder.trimToSize();
        assertEquals(builder.capacity(), 5);
    }

    @Test
    public void replaceStringBuilderSubStrings() {
        StringBuilder builder = new StringBuilder("abcdefgh");
        builder.replace(0, 4, "12345678");
        assertEquals(builder.toString(), "12345678efgh");
    }

    @Test
    public void replaceStringBuilderChar() {
        StringBuilder builder = new StringBuilder("012345678");
        builder.setCharAt(5, 'f');
        assertEquals(builder.toString(), "01234f678");
    }

    @Test
    public void reverseStringBuilder() {
        StringBuilder builder = new StringBuilder("0123456789");
        builder.reverse();
        assertEquals(builder.toString(), "9876543210");
    }

    @Test
    public void substringStringBuilder() {
        StringBuilder builder = new StringBuilder("0123456789");
        assertEquals(builder.substring(3, 7), "3456");
    }
}