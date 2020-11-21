package com.example.ws.thread.lock;

import lombok.Getter;

public enum Country {
    ONE(1,"齐国"), TWO(2,"楚国");

    @Getter private Integer code;
    @Getter private String name = "未知";
    private Country(Integer code,String name){
        this.code = code;
        this.name = name;
    }
    public static String foreCountry(int index){
        Country[] countries = Country.values();
        for (Country country:
        countries) {
            if(country.code == index){
                return country.getName();
            }
        }
        return "未知";
    }
}
