package com.huawei.bes.demo;

/**
 * Created by lenovo12 on 2018/11/5.
 */
public class BESObject {
    public synchronized  void methondA() throws InterruptedException
    {
        System.out.println("begin methodA  Thread Name is " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("end method A " + System.currentTimeMillis());
    }
    public synchronized void methondB() throws InterruptedException
    {
        System.out.println("begin methodB  Thread Name is " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("end method B " + System.currentTimeMillis());
    }

    public static void main(String[] args) {
//        BESObject besObject = new BESObject();
//        ThreadC c = new ThreadC(besObject);
//        ThreadD d = new ThreadD(besObject);
//        c.setName("C");
//        d.setName("D");
//        c.start();
//        d.start()
        Integer i = 150;
        Integer j = 150;
        Integer o = 50;
        Integer p = 50;
        System.out.println(i == j);
        System.out.println(o == p);
        System.out.println(o.equals(i));
    }
}
class ThreadC extends  Thread{
    private BESObject besObject;
    public ThreadC(BESObject besObject)
    {
        this.besObject = besObject;
    }
    @Override
    public void run()
    {
        try {
            besObject.methondA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadD extends  Thread{
    private BESObject besObject;
    public ThreadD(BESObject besObject)
    {
        this.besObject = besObject;
    }
    @Override
    public void run()
    {
        try {
            besObject.methondB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}