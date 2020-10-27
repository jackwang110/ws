package com.example.ws.base.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ArrayTest {
    public static void main(String[] args) {
        /*String log_file = System.getProperty("user.dir") ;
        System.out.println(log_file);
        System.getProperties().list(System.out);*/
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        List<String> collect = stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        for (String s:
             collect) {
            System.out.println(s);
        }
        List<Object> objects = Collections.synchronizedList(new ArrayList<>(16));
        objects.listIterator();
        new CopyOnWriteArrayList<>();
        new ConcurrentHashMap<>();
    }
}
