package com.example.ws;

import cn.hutool.json.JSONUtil;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        //Random random = new Random(11);
        //System.out.println(Math.floorDiv(1000,100)+(1000 % 100 == 0 ? 0 : 1));
    /*    String date = "2020-05-05";
        String date2 = "2020-08-12";
        Date date1 = DateUtils.parseDate(date);
        Date date3 = DateUtils.parseDate(date2);
        System.out.println(DateUtils.getDaysBetween(date3,date1));*/
        // 测试
   /*     for (int i = 0; i < 10; i++) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            System.out.println();
            System.out.println(sdf.format(date)+getStringRandom(4)+"_EDM");

        }*/
//        BlockingQueue blockingQueue = new BlockingDeque<>();
//        blockingQueue.add("a");
//        System.out.println( Objects.hash("name11"));

//        System.out.println(JSONUtil.parseArray());
    }
  /*  public static boolean isToday(Long second) {
        if (second == null) {
            return false;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sf.format(System.currentTimeMillis());
        String compare = sf.format(new Date(second * 1000L));
        return today.equals(compare);
    }*/
  List list = new ArrayList();
  public static String getStringRandom(int length) {
      String val = "";
      Random random = new Random();

      // 参数length，表示生成几位随机数
      for (int i = 0; i < length; i++) {

          String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
          // 输出字母还是数字
          if ("char".equalsIgnoreCase(charOrNum)) {
              // 输出是大写字母还是小写字母
              int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
              val += (char) (random.nextInt(26) + temp);
          } else if ("num".equalsIgnoreCase(charOrNum)) {
              val += String.valueOf(random.nextInt(10));
          }
      }
      return val;
  }


}
