package com.example.buider;

import com.example.buider.impl.AuthHandler;
import com.example.buider.impl.LoginHandler;
import com.example.buider.impl.ValidateHandler;
import com.example.simple.Member;

/**
 * 责任链模式与建造者模式一混合使用
 * @author Administrator
 */
public class MemberService {

    public void login(String loginName, String loginPass){

        Handler.Builder builder = new Handler.Builder();
        Handler build = builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler())
                .build();

        build.doHandle(new Member(loginName, loginPass));
    }


    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("tom", "666");
    }
}
