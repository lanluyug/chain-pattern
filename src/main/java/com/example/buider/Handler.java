package com.example.buider;

import com.example.simple.Member;

public abstract class Handler<T> {

    protected Handler chain;

    private void next(Handler handler){
        this.chain = handler;
    }

    public abstract void doHandle(Member member);

    public static class Builder<T>{
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler){
            if(head == null){
                head = tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build(){
            return this.head;
        }
    }
}
