package com.huawei.bes.demo;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by lenovo12 on 2018/11/3.
 */
public class ThreadTT extends Thread{
    private int i;
    @Override
    public   void run()
    {
        long startTime = System.currentTimeMillis();
     while(true)
      {
          i++;
          Thread.yield();
          if(i == 500000)
              break;
      }
        long endTime = System.currentTimeMillis();
        System.out.println("用时"+ (endTime - startTime) + "毫秒");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTT t = new ThreadTT();
        t.start();

    }
}
