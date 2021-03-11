package com.example.ws;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Map<String, Object> benefit = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        benefit.put("benefitId","1-MIIBRSI");
        benefit.put("benefitNum","1");
        benefit.put("benefitStartDate","01/01/2021");
        benefit.put("benefitEndDate","01/21/2021");
        List<Object> listBenefits=new ArrayList<>();
        listBenefits.add(benefit);
        String list= JSON.toJSONString(listBenefits);
        System.out.println(list);
        new HashMap<>();
    }
}
