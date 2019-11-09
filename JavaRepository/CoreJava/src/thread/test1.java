package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class test1 {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();
    public static void main(String[] args) {
        /*
        * 什么是进程？
        *
        *  进程是程序的一次执行过程，是系统运行的基本单位，因此进程是动态的，系统每运行一个程序，就相当于是一个进程从创建，运行到消亡的过程
        *
        *  在Java中，启动main函数就是启动了一个JVM的进程，main函数所在的线程就是这个进程中的一个线程，也成为主线程
        *
        *
        * */

        /*
        *  什么是线程？
        *
        * 线程是一个比进程更小的执行单位，一个进程在执行过程中会产生多个线程，同类的多个线程会共享进程的堆和方法区资源，
        *
        * 但是每一个线程有自己的程序计数器，虚拟机栈和本地方法栈，所以系统在产生一个线程，或者在多个线程之间切换的时候，负担要小得多，所以，线程也称为轻量级进程
        *
        * */

        // java天生是多线程程序

        // 获取Java的线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

        /*
        * 并行和并发的区别？
        *
        * 并发： 同一时间段内，多个任务都在执行（单位时间内不一定同时执行）
        * 并行： 单位时间内，多个任务在同时执行
        * */


        /*
        * 产生死锁必须有四个条件：
        *
        * 1. 互斥条件： 该资源任意时刻只能由一个线程占用
        * 2. 请求与保持条件： 一个进程因请求资源而阻塞时，对已获得的资源保持不妨
        * 3. 不剥夺条件： 线程获得的资源在未使用完之前不能被其他线程强行夺走，只有自己使用完之后才释放资源
        * 4. 循环等待条件： 若干进程之间形成一种头尾相接的循环等待资源关系
        *
        * */

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + "get resource 1");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "waiting for resource 2");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "get resource 2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + "get resource 2");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "waiting for resource 1");

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + "get resource 1");
                }
            }
        }, "线程2");


        /*
        * 如何避免死锁？
        *
        * 破坏其中的一个条件就可以了
        *
        * 破坏互斥条件
        *
        * 这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
        *
        * 破坏请求与保持条件
        *
        * 一次性申请所有的资源。
        *
        * 破坏不剥夺条件
        *
        * 占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
        *
        * 破坏循环等待条件
        *
        * 靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。
        *
        *
        * */

        // 线程3和线程1就不会发生死锁
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + "get resource 1");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waiting for resource 2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "get resource 2");
                }
            }
        },"线程3").start();


        /*
        * sleep() 方法和 wait() 方法的区别和相同点
        *
        * 区别： sleep没有释放锁， 而wait释放了锁
        *
        * 二者都可以暂停线程的执行
        *
        * wait通常用于线程的交互，而sleep通常用于线程的暂停
        *
        * wait方法调用之后，线程不会自动苏醒，需要别的线程调用notify()或者notifyAll()方法来唤醒。 而sleep可以自动苏醒。 或者调用wait(long timeout)可以自动苏醒
        *
        * */


        /*
        * 为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？
        *
        * new 一个 Thread，线程进入了新建状态;调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。
        * start() 会执行线程的相应准备工作，然后自动执行 run() 方法的内容，这是真正的多线程工作。
        * 而直接执行 run() 方法，会把 run 方法当成一个 main 线程下的普通方法去执行，并不会在某个线程中执行它，所以这并不是多线程工作。
        *
        *
        * 总结： 调用 start 方法方可启动线程并使线程进入就绪状态，而 run 方法只是 thread 的一个普通方法调用，还是在主线程里执行。
        * */

    }
}
