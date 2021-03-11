package com.example.ws.face;
//判断字符数组中是否有的字符都只出现过一次
public class IsUniquel {
    public boolean isUniquel(char[] chs){
        if(chs == null){
            return true;
        }
        boolean[] map=new boolean[256];

        for (int i = 0; i < chs.length; i++) {
            if(map[chs[i]]){
                return false;
            }
            map[chs[i]]=true;
        }
        return true;
    }

    public static void main(String[] args) {
        IsUniquel isUniquel=new IsUniquel();
        char[] arr={'a','b','c','c'};
        boolean b = isUniquel.isUniquel(arr);
        System.out.println(b);
    }
}
