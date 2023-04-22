package com.example.simple;

public abstract class Handler {

    protected Handler chain;

    public void next(Handler handler){
        this.chain = handler;
    }

    public abstract void doHandle(Member member);
}
