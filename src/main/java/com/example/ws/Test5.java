package com.example.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test5 {
    public static void main(String[] args) throws Exception{
  /*      HashMap<String, Object> map = new HashMap<>();
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));*/
        /*Map<String, String> map = new HashMap<String, String>(7);
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));*/
  /*      Map<String, String> map = new HashMap<String, String>(13);
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));*/

    /*    File f = new File("D:/desktop/text.txt");
// OutputStreamWriter 是字符流通向字节流的桥梁,创建了一个字符流通向字节流的对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f),
                "UTF-8");
        osw.write("我是字符流转换成字节流输出的");
        osw.close();*/
        File f = new File("D:/desktop/text.txt");
        InputStreamReader inr = new InputStreamReader(new FileInputStream(f),
                "UTF-8");
        char[] buf = new char[1024];
        int len = inr.read(buf);
        System.out.println(new String(buf,0,len));
        inr.close();
    }

    static int f () {
        int ret = 0;
        try {
            return ret; // 返回 0，finally 内的修改效果不起作用
        } finally {
            ret++;
            System.out.println("finally 执行");
        }
    }
    // 测试 修改引用类型
    static int[] f2 () {
        int[] ret = new int[]{0};
        try {
            return ret; // 返回 [1]，finally 内的修改效果起了作用
        } finally {
            ret[0]++;
            System.out.println("finally1 执行");
        }
    }
}
