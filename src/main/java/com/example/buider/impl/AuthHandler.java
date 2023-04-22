package com.example.buider.impl;


import com.example.buider.Handler;
import com.example.simple.Member;

public class AuthHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        if(null == member){
            System.out.println("用户不存在！");
            return;
        }
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
        }
    }
}
