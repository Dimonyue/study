package com.jvm.gc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yxg
 */
public class MainTest {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnable = ()->{
            /**
             *  1）当i 为int 时，主线程休眠1s后进入安全点，但是两个子线程还在运行，
             *  并且循环是int类型，所以认为这个循环是可数的循环（counted loop），可以等待，
             *  JVM尝试在Safepoint停止，以便Java线程进行定期清理，但是直到可数循环完成后才能执行此操作。
             *  所以最后的运行结果是200000000
             *
             *  2）当i 为long时，主线程休眠1s后进入安全点，但此时两个子线程还在运行，
             *  并且循环次数是long类型，所以认为这个循环是不可数的循环，所以不等待，
             *  jvm直接在安全点停止，所以最后两个子线程是直接结束，num值不等于200000000
             *
             *  3） 当jdk在10之前，gc的安全点在循环中都有int和long 的区别
             *   当jdk≥10时，int和long没有区别，
             *   HotSpot 实现 Loop Strip Mining 优化，解决了在 counted loop 中安全点轮询的问题，
             *   而且没有太多开销。所以在 JDK10 和更高版本中没有这个问题
             *
             *  4）参考博客：https://juejin.cn/post/7139741080597037063
             */
          for(long i = 0;i<100000000;i++){
              num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num = " + num);
    }
}
