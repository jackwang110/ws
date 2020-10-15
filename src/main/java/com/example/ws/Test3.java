package com.example.ws;

public class Test3 {
    public static void main(String[] args) {
        //String str = "截止到${event.sr_kit_coupon.cacheMonth@0!\"\"}月${event.sr_kit_coupon.cacheDay@0!\"\"}日您星享俱乐部帐户内的尾号${event.sr_kit_coupon.cardNumber@0!\"\"}会员星礼包中还有${event.sr_kit_coupon.coupons@0!\"\"}次晚间相聚好礼未使用，有效期至${event.sr_kit_coupon.expirationMonth@0!\"\"}月${event.sr_kit_coupon.expirationDay@0!\"\"}日。";
        String str = "12345";
        StringBuilder sb = new StringBuilder();
        if(str.contains("$") && str.contains("@") && str.contains("{")){
            String[] split = str.split("\\$\\{");
            for (int i = 0; i < split.length; i++) {
                if(split[i].contains("@")){
                    String a = split[i].split("@")[0];
                    if( i> 0 && a != null ){
                        sb.append(a).append(",");
                    }
                }
            }
            if(sb.length() > 0 ){
                sb.deleteCharAt(sb.length() -1);
            }
            System.out.println(sb);
        }
        }
    }

