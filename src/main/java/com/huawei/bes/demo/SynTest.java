package com.huawei.bes.demo;


class MyThread extends  Thread{
    @Override
    public void run()
    {
        SynTest service = new SynTest();
        service.service1();
    }
}
public class SynTest {
    public synchronized void service1(){
        System.out.println("服务1");
        service2();
    }
    public synchronized void service2(){
        System.out.println("服务2");
        service3();
    }
    public synchronized void service3(){
        System.out.println("服务3");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }

}

