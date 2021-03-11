package com.example.ws.loadbanlance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestRobinRandom {
    static Map<String,Integer> ipMap=new HashMap<>();
    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",2);
        ipMap.put("192.168.13.3",4);

    }
    public String RobinRandom(){
        Map<String, Integer> ipServerMap = new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);
        Set<String> ipSet=ipServerMap.keySet();
        Iterator<String> ipIterator=ipSet.iterator();


        ArrayList<String> ipArrayList=new ArrayList<String>();
        while (ipIterator.hasNext()){
            String serverName = ipIterator.next();
            Integer integer = ipServerMap.get(serverName);
            for (int i = 0; i < integer; i++) {
                ipArrayList.add(serverName);
            }

        }
        Random random = new Random();
        int i = random.nextInt(ipArrayList.size());
        String s = ipArrayList.get(i);
        return s;
    }

    public static void main(String[] args) {
        TestRobinRandom testRobinRandom = new TestRobinRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(testRobinRandom.RobinRandom());
        }
    }

}
