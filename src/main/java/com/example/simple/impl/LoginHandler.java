package com.example.simple.impl;

import com.example.simple.Handler;
import com.example.simple.Member;

public class LoginHandler extends Handler {

    @Override
    public void doHandle(Member member) {
        System.out.println("登陆成功");
        member.setRoleName("管理员");
        chain.doHandle(member);
    }
}
