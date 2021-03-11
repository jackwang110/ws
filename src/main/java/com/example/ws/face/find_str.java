package com.example.ws.face;
//在有序但含有空的数组中查找字符串
public class find_str {
    public static int findStr(String[] strs, String str){
        int l = 0, r = strs.length - 1, mid, k = -1, i;
        if (str.equals("") || str == null) {
            return -1;
        }
        while (l <= r){
            mid = (l + r) / 2;
            if (strs[mid] == null) {
                i = mid;
                while (strs[i] == null && --i >= l);
                if (i < l || str.compareTo(strs[i]) > 0) {//i<l说明左半区都为空
                    l = mid + 1;//注意这里不要写成i+1
                }
                else if (str.compareTo(strs[i]) < 0) {
                    r = i - 1;
                }else {
                    k = i;
                    r = i - 1;
                }
            } else {
                if (str.compareTo(strs[mid]) > 0) {
                    l = mid + 1;
                }else if (str.compareTo(strs[mid]) < 0) {
                    r = mid - 1;
                }else {
                    k = mid;
                    r = mid - 1;
                }
            }
        }

        return k;
    }
}
