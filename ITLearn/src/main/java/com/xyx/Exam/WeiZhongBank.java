package com.xyx.Exam;

import java.util.ArrayList;

public class WeiZhongBank implements Runnable{
    /*public static void main(String[] args) {
        Thread t = new Thread(new WeiZhongBank());
        t.start();
    }*/

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
    public void go(){
        start(1);
    }
    public void start(int i){}
    private void test(){
        System.out.println(1 + 1 + "wow!");
    }
    static public void main(String [] args){
        new WeiZhongBank().test();
//        String[] a = new String[10];
        System.out.println(_i);
        Animal a = new Mouse();
        Animal b = new Dog();

        a.move();
        b.move();

        WeiZhongBank weiZhongBank = new WeiZhongBank();
        a.sleep();

    }
    static {
        _i = 20;
    }
    public static int _i = 10;
    private float f = 1.0f;
    int i = 12;
    static int j = 1;

}

class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
    public void sleep(){
        System.out.println("Animal.sleep");
    }
}
class Dog extends Animal{
    public void move(){
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以飞脚");
    }
}

class Mouse extends Animal{
    public void sleep(){
        super.sleep();
        System.out.println("Mouse.sleep");
    }
}

