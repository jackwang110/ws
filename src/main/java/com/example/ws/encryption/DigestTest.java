package com.example.ws.encryption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class DigestTest {
    public static void encodeStr(String data) {
        String encodeS = DigestUtils.md5Hex(data);
        System.out.println(encodeS);
        InputStream in;
        try {
             in = new URL( "http://commons.apache.org" ).openStream();
            System.out.println( IOUtils.toString( in ) );
        }catch (Exception e){

        }
        finally {
            //IOUtils.closeQuietly(in);
        }

    }
    private static String encodeTest(String str){
        Base64 base64 = new Base64();
        System.out.println("解码后："+str);
        try {
            str = base64.encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Base64 编码后："+str);
        return str;
    }

    private static void decodeTest(String str){
        Base64 base64 = new Base64();
        System.out.println("编码前："+str);
        //str = Arrays.toString(Base64.decodeBase64(str));
        str = new String(Base64.decodeBase64(str));
        System.out.println("Base64 解码后："+str);
    }
    public static void main(String[] args) {
       decodeTest("MTEyMzM=");
        encodeTest("MTEyMzM=");
    }
}
