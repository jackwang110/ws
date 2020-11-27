package com.example.ws.baseenum;

 enum OfferingEnum {
     STAR("star"), SEIBLE("seible"), UPP("upp"), CHRISTMAS("christmas");

     private String name;

     OfferingEnum(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }

     public static void main(String[] args) {
         System.out.println(OfferingEnum.SEIBLE.name);
     }
}
