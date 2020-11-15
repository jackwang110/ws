package com.example.ws.springdesign.prototype;

import java.io.*;
import java.util.Date;

public class QiTianDaShen extends Monkey implements Serializable,Cloneable {
    public JinGuBang jinGuBang;

    public QiTianDaShen(){
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return this.deepClone();
    }
    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaShen qiTianDaShen = (QiTianDaShen) ois.readObject();
            qiTianDaShen.birthday = new Date();
            return qiTianDaShen;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public QiTianDaShen shallowClone(QiTianDaShen target){
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        qiTianDaShen.height = target.height;
        qiTianDaShen.weight = target.weight;

        qiTianDaShen.jinGuBang = target.jinGuBang;
        qiTianDaShen.birthday = new Date();
        return qiTianDaShen;

    }
}
