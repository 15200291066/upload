package com.huawei.bes.demo;

/**
 * Created by lenovo12 on 2018/11/5.
 */
public class SharedNum {
    private int num = 0;
    public synchronized void addI(String username) throws InterruptedException {
        if("a".equals(username))
        {
            num = 100;
            System.out.println("a is over");
        }
        else
        {
            num = 200;
            System.out.println("b is over");
        }
        System.out.println(username + "num = " + num);
    }

    public static void main(String[] args) {
        SharedNum sharedNum = new SharedNum();
        ThreadA a = new ThreadA(sharedNum);
        ThreadB b = new ThreadB(sharedNum);
        a.start();
        b.start();
    }
}
class ThreadA extends  Thread{
    private SharedNum sharedNum ;
    public ThreadA(SharedNum sharedNum)
    {
        this.sharedNum = sharedNum ;
    }
    @Override
    public void run()
    {
        try {
            sharedNum.addI("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadB extends  Thread{
    private SharedNum sharedNum ;
    public ThreadB(SharedNum sharedNum)
    {
        this.sharedNum = sharedNum ;
    }
    @Override
    public void run()
    {
        try {
            sharedNum.addI("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
