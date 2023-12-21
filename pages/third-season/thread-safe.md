# thread-safe 线程安全

**线程安全**是**多线程编程**时的计算机程序代码中的一个概念。在拥有共享数据的多条线程并行执行的程序中，线程安全的代码会通过**同步机制**保证各个线程都可以正常且正确的执行，**不会出现数据污染**等意外情况。

[百度百科](https://baike.baidu.com/item/线程安全/9747724)

### 实现线程安全的三种方式

转自：https://www.cnblogs.com/lizhangyong/p/8029287.html

一个程序在运行起来的时候会转换成**进程**，通常**含有多个线程**。

通常情况下，一个**进程中的比较耗时的操作**（如长循环、文件上传下载、网络资源获取等），往往会**采用多线程来解决**。

比如显示生活中，银行取钱问题、火车票多个售票窗口的问题，通常会涉及到并发的问题，从而需要多线程的技术。

当**进程**中有**多个并发线程**进入一个重要数据的代码块时，在修改数据的过程中，很有可能**引发线程安全问题**，从而**造成数据异常**。例如，正常逻辑下，同一个编号的火车票只能售出一次，却由于线程安全问题而被多次售出，从而引起实际业务异常。

::: tip 示例

现在我们就以售票问题来演示线程安全的问题。
:::

在不对多线程数据进行保护的情况下会引发的状况

```java
public class ThreadUnSecurity {

    static int tickets = 10;

    class SellTickets implements Runnable {
        @Override
        public void run() {
            // 未加同步时产生脏数据
            while(tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "--->售出第：" + tickets + "票");
                tickets--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (tickets <= 0) {
                System.out.println(Thread.currentThread().getName() + "--->售票结束！");
            }
        }
    }

    public static void main(String[] args) {
        SellTickets sell = new ThreadUnSecurity().new SellTickets();

        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

运行结果：

```
1号窗口--->售出第：10票
2号窗口--->售出第：10票
3号窗口--->售出第：8票
4号窗口--->售出第：7票
3号窗口--->售出第：6票
4号窗口--->售出第：6票
1号窗口--->售出第：6票
2号窗口--->售出第：6票
3号窗口--->售出第：2票
1号窗口--->售出第：2票
2号窗口--->售出第：2票
4号窗口--->售出第：2票
4号窗口--->售票结束！
3号窗口--->售票结束！
2号窗口--->售票结束！
1号窗口--->售票结束！
```

我们可以看出同一张票在不对票数进行保护时会出现同一张票会被出售多次！由于线程调度中的不确定性，读者在演示上述代码时，出现的运行结果会有不同。

为了解决上述脏数据的问题，我为大家介绍3种使用比较普遍的**三种同步方式**。

### 第一种实现线程安全的方式: 同步代码块

```
synchronized
英[ˈsɪŋkrənaɪzd] 美[ˈsɪŋkrənaɪzd]  
v. (使)同步，在时间上一致，同速进行
synchronize的过去分词和过去式

synchronize
英 [ˈsɪŋkrənaɪz]   美 [ˈsɪŋkrənaɪz]  
v.(使)同步，在时间上一致，同速进行

第三人称单数： synchronizes 现在分词： synchronizing 过去式： synchronized 过去分词： synchronized
派生词： synchronization-isation n.
```

有**synchronized关键字**修饰的语句块，即为**同步代码块**。同步代码块会被**JVM自动加上内置锁**，从而**实现同步**。

```java
public class ThreadSynchronizedSecurity {

    static int tickets = 10;

    class SellTickets implements Runnable {

        @Override
        public void run() {
            // 同步代码块
            while(tickets > 0) {
                synchronized (this) {
//                    System.out.println(this.getClass().getName().toString());

                    if (tickets <= 0) {
                        return;
                    }

                    System.out.println(Thread.currentThread().getName()+"--->售出第：" + tickets + " 票");
                    tickets--;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (tickets <= 0) {
                    System.out.println(Thread.currentThread().getName() + "--->售票结束！");
                }
            }
        }
    }

    public static void main(String[] args) {
        SellTickets sell = new ThreadSynchronizedSecurity().new SellTickets();

        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

输出结果读者可自行调试，不会出现同一张票被出售多次的情况。

### 第二种实现线程安全的方式: 同步方法

即有**synchronized关键字**修饰的方法。由于**java的每个对象都有一个内置锁**，当用此关键字修饰方法时，**内置锁会保护整个方法**。在**调用该方法前**，**需要获得内置锁**，否则就处于**阻塞状态**。

```java
public class ThreadSynchronizedMethodSecurity {

    static int tickets = 10;

    class SellTickets implements Runnable{

        @Override
        public void run() {
            // 同步方法
            while (tickets > 0) {
                synMethod();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (tickets<=0) {
                    System.out.println(Thread.currentThread().getName() + "--->售票结束");
                }
            }
        }

        synchronized void synMethod() {
            synchronized (this) {
                if (tickets <=0) {
                    return;
                }

                System.out.println(Thread.currentThread().getName() + "---->售出第 " + tickets + " 票 ");
                tickets--;
            }
        }
    }

    public static void main(String[] args) {
        SellTickets sell = new ThreadSynchronizedMethodSecurity().new SellTickets();

        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

读者可自行调试上述代码的运行结果。

### 第三种实现线程安全的方式: Lock锁机制

通过**创建Lock对象**，采用**lock()加锁**，**unlock()解锁**，来**保护指定的代码块**。

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockSecurity {

    static int tickets = 10;

    class SellTickets implements Runnable{

        Lock lock = new ReentrantLock();

        @Override
        public void run() {
            // Lock锁机制
            while(tickets > 0) {
                try {
                    lock.lock();
                    if (tickets <= 0) {
                        return;
                    }

                    System.out.println(Thread.currentThread().getName()+"--->售出第：  "+tickets+" 票");
                    tickets--;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    lock.unlock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (tickets <= 0) {
                System.out.println(Thread.currentThread().getName()+"--->售票结束！");
            }

        }
    }

    public static void main(String[] args) {
        SellTickets sell = new ThreadLockSecurity().new SellTickets();

        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

::: tip 总结

由于**synchronized**是在**JVM层面实现**的，因此**系统可以监控锁的释放与否**；

而**ReentrantLock**是使用**代码实现**的，系统**无法自动释放锁**，需要在代码中的**finally子句**中**显式释放锁lock.unlock()**。

另外，在**并发量比较小**的情况下，**使用synchronized**是个不错的选择；但是在**并发量比较高**的情况下，其性能下降会很严重，此时**ReentrantLock是个不错的方案**。
:::

### 补充：　　

在使用**synchronized 代码块**时,可以与**wait()**、**notify()**、**notifyAll()**一起使用，从而进一步**实现线程的通信**。

其中，**wait()方法**会**释放占有的对象锁**，当前线程进入等待池，释放cpu，而其他正在等待的线程即可抢占此锁，获得锁的线程即可运行程序；

线程的**sleep()方法**则表示，当前线程会休眠一段时间，休眠期间，会暂时释放cpu，但**并不释放对象锁**。也就是说，在休眠期间，其他线程依然无法进入被同步保护的代码内部，当前线程休眠结束时，会重新获得cpu执行权，从而执行被同步保护的代码。

wait()和sleep()最大的不同在于**wait()会释放对象锁**，而**sleep()不会释放对象锁**。

notify()方法会**唤醒**因为调用对象的wait()而**处于等待状态的线程**，从而**使得该线程**有机会**获取对象锁**。调用notify()后，当前线程并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，才会释放对象锁。**JVM会在等待的线程中调度一个线程去获得对象锁，执行代码**。

需要注意的是，**wait()和notify()必须在synchronized代码块中调用**。

notifyAll()是唤醒所有等待的线程。

接下来，我们通过下一个程序，使得两个线程交替打印“A”和“B”各10次。请见下述代码：

```java
public class ThreadDemo {

    static final Object obj = new Object();

    //第一个子线程
    static class ThreadA implements Runnable{

        @Override
        public void run() {
            int count = 10;
            while(count > 0) {

                synchronized (ThreadDemo.obj) {
                    System.out.println("A-----" + count);
                    count--;

                    synchronized (ThreadDemo.obj) {
                        //notify()方法会唤醒因为调用对象的wait()而处于等待状态的线程，从而使得该线程有机会获取对象锁。
                        //调用notify()后，当前线程并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，
                        ThreadDemo.obj.notify();

                        try {
                            ThreadDemo.obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {

            int count = 10;

            while(count > 0) {

                synchronized (ThreadDemo.obj) {
                    System.out.println("B-----" + count);
                    count--;

                    synchronized (ThreadDemo.obj) {

                        //notify()方法会唤醒因为调用对象的wait()而处于等待状态的线程，从而使得该线程有机会获取对象锁。
                        //调用notify()后，当前线程并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，
                        ThreadDemo.obj.notify();

                        try {
                            ThreadDemo.obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }

            }

        }

    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
```
