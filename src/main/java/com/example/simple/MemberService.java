package com.example.simple;

import com.example.simple.impl.AuthHandler;
import com.example.simple.impl.LoginHandler;
import com.example.simple.impl.ValidateHandler;

public class MemberService {

    public void login(String loginName, String loginPass){

        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandle(new Member(loginName, loginPass));
    }


    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("tom", "666");
    }
}
