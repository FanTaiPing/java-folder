package com.fan.entity;

public class testDemo {
    public static void main(String[] args){
        Demo<String,Integer> demo = new Demo<>();
        demo.setS1("defew");
        demo.setS2(14415);
        System.out.println(demo.getS1() +"\n"+ demo.getS2());
    }
}
