package com.wusk.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wushaokang
 * @date 2021/9/14 21:28
 */
public class OomTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    run0();
                }
            });
        }
    }

    public static void run0() {
        System.out.println("模拟内存泄漏");
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
        localVariable.set(new Byte[4096 * 1024]);// 为线程添加变量
    }

}
