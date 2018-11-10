package com.huawei.bes.demo;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lenovo12 on 2018/11/2.
 */
public class LoginUnSafe {
    static String usernameRef;
    static String passwordRef;
    public  static void post(String username , String password)
    {
        try
        {
            usernameRef = username ;
            if("aa".equals(usernameRef))
            {
                Thread.sleep(1000);
            }
            passwordRef = password ;
            System.out.println(Thread.currentThread().getName() + "username " + usernameRef +  "   password   " + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ALogin a = new ALogin("AThread");
        BLogin b = new BLogin("BThread");
        a.start();
        b.start();
    }
}
class ALogin extends Thread{

    public ALogin(String a)
    {
        super(a);
    }
    @Override
    public void run() {
        LoginUnSafe.post("aa" , "aa");
    }
}
class BLogin extends   Thread{
    public BLogin(String b)
    {
        super(b);
    }
    @Override
    public void run() {
        LoginUnSafe.post("bb" , "bb");
    }
}
