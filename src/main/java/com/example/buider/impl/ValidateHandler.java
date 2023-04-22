package com.example.buider.impl;

import com.example.buider.Handler;
import com.example.simple.Member;
import org.springframework.util.StringUtils;

public class ValidateHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        if(StringUtils.hasLength(member.getLoginName()) ||
                StringUtils.hasLength(member.getLoginPass())){
            System.out.println("用户名和密码校验成功，可以往下执行");
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        chain.doHandle(member);
    }
}
