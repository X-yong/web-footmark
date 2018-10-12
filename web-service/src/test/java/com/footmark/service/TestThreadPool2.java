package com.footmark.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/11 13:45
 */
public class TestThreadPool2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor =  Executors.newFixedThreadPool(2);
        List list = new ArrayList();
        long start =System.currentTimeMillis();
        //System.out.println(start);



	/*		executor.execute(new Runnable() {
				@Override
				public void run() {
				//	list.clear();
					System.out.println(Thread.currentThread().getName());
					for (int i = 1000; i < 2000; i++) {
						list.add(i);
					}

				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					for (int i = 2000; i < 3000; i++) {
						list.add(i);
					}

				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					for (int i = 3000; i < 4000; i++) {
						list.add(i);
					}
				}
			});*/
        for ( int i = 0; i < 10000000; i++) {
            list.add(i);
         //   list.add(i);
           /* final int index = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.err.println(Thread.currentThread().getName()+","+index);
                    list.add(index);
                    if(index == 9999999) {
                        long end = System.currentTimeMillis();
                        //Thread.sleep(30000);
                        //  System.out.println(list.size());
                        System.out.println("时间："+ (end - start));
                    }
                }
            });*/

        }
        long end = System.currentTimeMillis();
        //Thread.sleep(30000);
        //  System.out.println(list.size());
        System.out.println("时间："+ (end - start));
    }
}