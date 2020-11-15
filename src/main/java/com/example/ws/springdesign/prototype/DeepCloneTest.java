package com.example.ws.springdesign.prototype;

public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();

        try {
            QiTianDaShen clone = (QiTianDaShen)qiTianDaShen.clone();
            System.out.println("深克隆"+(clone==qiTianDaShen));
        }catch (Exception e){
            e.printStackTrace();
        }

        QiTianDaShen q = new QiTianDaShen();
        QiTianDaShen n = q.shallowClone(q);
        System.out.println("浅克隆"+(q.jinGuBang == n.jinGuBang));
    }
}
