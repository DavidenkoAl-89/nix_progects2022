package com.nixsolution.ppp.collections;


import com.nixsolutions.ppp.collections.DefaultIterator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] col = {};

        Object[] col1 = {1, 2, 3, 22, null};
        Object[] col2 = {111, "a", "b", "c", 1, 2, 3, 22};
        Object[] col4 = {1, 2, 3, 22};
        DefaultCollectionImpl collection = new DefaultCollectionImpl(col);
        DefaultCollectionImpl collection1 = new DefaultCollectionImpl(col1);
        DefaultCollectionImpl collection2 = new DefaultCollectionImpl(col2);
        DefaultCollectionImpl collection4 = new DefaultCollectionImpl(col4);

//        DefaultIterator iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            Object i = iterator.next();
//            System.out.println(i);
//        }
//        System.out.println("contains: " + collection2.contains("a"));
        collection1.add(12);
        System.out.println(Arrays.toString(collection1.toArray()));
//        System.out.println("not contains: " + collection1.contains(0));
//        System.out.println(collection2.removeAll(collection1));
//        System.out.println(Arrays.toString(collection1.toArray()));
//        System.out.println(collection2.size());
//        System.out.println(collection2.removeAll(collection1));
//        System.out.println(collection2.size());
//        System.out.println(collection2.retainAll(collection1));
//        System.out.println(Arrays.toString(collection1.toArray()));
//        System.out.println(collection1.containsAll(collection4));

        System.out.println(Arrays.toString(collection2.toArray()));
        System.out.println(collection1.remove(111));
        System.out.println(Arrays.toString(collection2.toArray()));


    }
}

