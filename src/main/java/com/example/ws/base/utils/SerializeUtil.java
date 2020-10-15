package com.example.ws.base.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeUtil {
    public static byte[] serializeObject(Object object) throws IOException {
        /*ByteArrayOutputStream saos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(saos);
        oos.writeObject(object);
        oos.flush();
        return saos.toByteArray();*/
        ByteArrayOutputStream saos  = new ByteArrayOutputStream();
        ObjectOutputStream  oos = new ObjectOutputStream(saos);
        oos.writeObject(object);
        oos.flush();
        return saos.toByteArray();
    }

    public static Object deserializeObject(byte[] buf) throws IOException,ClassNotFoundException{
        Object object=null;
        ByteArrayInputStream sais=new ByteArrayInputStream(buf);
        ObjectInputStream ois = new ObjectInputStream(sais);
        object = ois.readObject();
        return object;
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(oos);
            close(baos);
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(bais);
            close(ois);
        }
        return null;
    }

    /**
     * 序列化 list 集合
     *
     * @param list
     * @return
     */
    public static byte[] serializeList(List<?> list) {

        if (list == null || list.size() <= 0) {
            return null;
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            for (Object obj : list) {
                oos.writeObject(obj);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(oos);
            close(baos);
        }
        return bytes;
    }

    /**
     * 反序列化 list 集合
     *
     * @return
     */
    public static List<?> unserializeList(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        List<Object> list = new ArrayList<Object>();
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            while (bais.available() > 0) {
                Object obj = (Object) ois.readObject();
                if (obj == null) {
                    break;
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(bais);
            close(ois);
        }
        return list;
    }

    /**
     * 关闭io流对象
     *
     * @param closeable
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream dout = new DataOutputStream(bout);
        String name = "XYY";
        int age = 27;
        dout.writeUTF(name);
        dout.writeInt(age);
        byte[] buff = bout.toByteArray();
        System.out.println(Arrays.toString(buff));
        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        DataInputStream dis = new DataInputStream(bin);
        String newName = dis.readUTF();
        int newAge = dis.readInt();
        System.out.println(newName + ":" + newAge);
    }
}
