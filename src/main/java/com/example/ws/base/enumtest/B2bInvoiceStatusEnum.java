package com.example.ws.base.enumtest;

public enum B2bInvoiceStatusEnum {

    TET(1,"你好"),
    TET2(2,"你好2");


    private Integer status;
    private  String text;

    private B2bInvoiceStatusEnum(Integer status,String text){
        this.status = status;
        this.text = text;
    }

    private Integer getStatus(){
        return status;
    }

    private String getText(){
        return text;
    }

    public static void main(String[] args) {
        System.out.println(B2bInvoiceStatusEnum.TET2.getText());
        int x = 8;
        System.out.println(	x>>2);
    }
}
