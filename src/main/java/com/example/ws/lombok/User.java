package com.example.ws.lombok;

import lombok.Builder;

import java.util.Date;
@Builder
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private Integer age;
    private Date signupTime;

    public static void main(String[] args) {
        User user = new User(1001, "pollyduan", "123456", "pollyduan@pollyduan.com", 30, new Date());
        //或者
        user=User.builder()
                .age(30)
                .userName("pollyduan")
                .build();
        System.out.println(user.toString());
    }
}
