# Java 多线程

## 进程与线程

* **进程**

  进程是操作系统结构的基础；是一次程序的执行；是一个程序及其数据在处理机上顺序执行时所发生的活动。操作系统中，几乎所有运行中的任务对应一条进程（Process）。一个程序进入内存运行，即变成一个进程。进程是处于运行过程中的程序，并且具有一定独立功能。描述进程的有一句话非常经典的话——**进程是系统进行资源分配和调度的一个独立单位。**

  进程是系统中独立存在的实体，拥有自己独立的资源，拥有自己私有的地址空间**。**进程的实质，就是程序在多道程序统中的一次执行过程，它是动态产生，动态消亡的，具有自己的生命周期和各种不同的状态。进程具有并发性，它可以同其他进程一起并发执行，按各自独立的、不可预知的速度向前推进。　

  （注意，并发性（concurrency）和并行性（parallel）是不同的。**并行指的是同一时刻，多个指令在多台处理器上同时运行。并发指的是同一时刻只能有一条指令执行，但多个进程指令被快速轮换执行，看起来就好像多个指令同时执行一样。**）

  进程由**程序**、**数据**和**进程控制块**三部分组成。

* **线程**

  线程，有时被称为轻量级进程(Lightweight Process，LWP），是程序执行流的最小单元。一个标准的线程由线程ID，当前指令指针(PC），寄存器集合和堆栈组成。另外，线程是进程中的一个实体，是被系统独立调度和分派的基本单位，**线程自己不拥有系统资源，只拥有一点儿在运行中必不可少的资源，但它可与同属一个进程的其它线程共享进程所拥有的全部资源**。一个线程可以创建和撤消另一个线程，同一进程中的多个线程之间可以并发执行。由于线程之间的相互制约，致使线程在运行中呈现出间断性。每一个程序都至少有一个线程，若程序只有一个线程，那就是程序本身。

  **线程是程序中一个单一的顺序控制流程。在单个程序中同时运行多个线程完成不同的工作，称为多线程。**

  在Java Web中要注意，线程是JVM级别的，在不停止的情况下，跟JVM共同消亡，就是说如果一个Web服务启动了多个Web应用，某个Web应用启动了某个线程，如果关闭这个Web应用，线程并不会关闭，因为JVM还在运行，所以别忘了设置Web应用关闭时停止线程。

## 线程的生命周期及五种基本状态

Java中线程的生命周期

![线程生命周期](../document/images/java-thread1.jpg)

上图中基本上囊括了Java中多线程各重要知识点。掌握了上图中的各知识点，Java中的多线程也就基本上掌握了。

**Java线程具有五种基本状态**

**新建状态（New）：**当线程对象对创建后，即进入了新建状态，如：Thread t = new MyThread()。

**就绪状态（Runnable）：**当调用线程对象的start()方法（t.start();），线程即进入就绪状态。处于就绪状态的线程，只是说明此线程已经做好了准备，随时等待CPU调度执行，并不是说执行了t.start()此线程立即就会执行。

**运行状态（Running）：**当CPU开始调度处于就绪状态的线程时，此时线程才得以真正执行，即进入到运行状态。注：就绪状态是进入到运行状态的唯一入口，也就是说，线程要想进入运行状态执行，首先必须处于就绪状态中。

**阻塞状态（Blocked）：**处于运行状态中的线程由于某种原因，暂时放弃对CPU的使用权，停止执行，此时进入阻塞状态，直到其进入到就绪状态，才有机会再次被CPU调用以进入到运行状态。根据阻塞产生的原因不同，阻塞状态又可以分为三种：

*1.等待阻塞 -- 运行状态中的线程执行wait()方法，使本线程进入到等待阻塞状态；*

*2.同步阻塞 -- 线程在获取synchronized同步锁失败(因为锁被其它线程所占用)，它会进入同步阻塞状态；*

*3.其他阻塞 -- 通过调用线程的sleep()或join()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。*

**死亡状态（Dead）：**线程执行完了或者因异常退出了run()方法，该线程结束生命周期。

## 创建多线程的方式

* 继承Thread类，重写该类的run()方法

  thread  run()  start() 是干什么的？为什么一调他们就开始运行里面的方法了？以及区别？

  这个属于线程的同步机制问题，也就是线程安全问题，实际开发中用到多线程的例子很多，比如说：银行排号、火车站买票等，就是很多机器同时访问共享数据的时候就是这个了。

  线程启动之后（被调之后），会运行被覆盖的run方法。

  先说用thread.run()来启动线程，会顺序执行，run启动一条线程之后将这条线程走完之后，才执行下面的run，想想火车站排票？要是用run就等于一条长蛇队了。

  再说用thread.start来启动线程，这个才是真正实现了多线程运行，thread.start()不用等待被覆盖的run执行完也可以直接继续执行下面的代码，线程处于就绪状态，交替执行直到结束。

* 实现java.lang.Runnable接口

* 使用Callable和Future接口创建线程

  注意：继承Thread类和实现Runable接口实现线程，线程的调度有所区别

  * 继承Thread类的：在线程调度使用的时候

    ~~~java
    //实现
    public class ThreadDemo2 extends Thread {
        private String name;
        public ThreadDemo2(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Thread 开始运行");
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程" + name + "运行：" + i);
                try {
                    sleep((int) Math.random() * 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "Thread 运行结束");
        }
    }
    
    // 使用
    ThreadDemo2 threadAt = new ThreadDemo2("At");
    threadAt.start();
    ~~~

  * 实现Runable接口

    ~~~java
    // 实现
    public class ThreadDemo1 implements Runnable {
        private String name;
        public ThreadDemo1(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Runnable 开始运行");
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程" + name + "运行：" + i);
                try {
                    sleep((int) Math.random() * 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "Runnable 运行结束");
        }
    }
    
    // 使用
    ThreadDemo1 threadA = new ThreadDemo1("Aa");
    Thread threadAa = new Thread(threadA);
    threadAa.start();
    ~~~

  * 注意实现调度使用的时候，使用的start是start还是run。

## 线程调度

* **线程加入——`join()`**

  `join` —— 让一个线程等待另一个线程完成才继续执行。如A线程执行体中调用B线程的`join()`方法，则A线程被阻塞，直到B线程执行完为止，A才能得以继续执行。

  join()方法，等待其他线程终止。*在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个线程运行结束，当前线程再由阻塞转为就绪状态。*

  join是Thread类的一个方法，启动线程后直接调用，*join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。*

  **为什么要用join() 方法？**

  ​     在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。

* **线程休眠——sleep()**

  sleep() 的作用是让**当前线程休眠**，即当前线程会从“运行状态”进入到“休眠(阻塞)状态”。sleep()会指定休眠时间，线程休眠的时间会大于/等于该休眠时间；在线程重新被唤醒时，它会由“阻塞状态”变成“就绪状态”，从而等待cpu的调度执行。常用来暂停程序的运行。同时注意，**sleep()方法不会释放锁**。

  sleep仅会影响当前线程

* **线程让步——yield()**

  ​     yield()是Thread类的静态方法。**它能让当前线程暂停，但不会阻塞该线程，而是由“运行状态”进入到“就绪状态”**，从而让其它具有相同优先级的等待线程获取执行。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权，也有可能是当前线程又进入到“运行状态”继续运行！值得注意的是，**yield()方法不会释放锁**。

* **线程中断——interrupt()**

  我们经常通过判断线程的中断标记来控制线程。　 　

  　 interrupt()是Thread类的一个实例方法，用于中断本线程。这个方法被调用时，会立即将线程的中断标志设置为“true”。所以当中断处于“阻塞状态”的线程时，由于处于阻塞状态，中断标记会被设置为“false”，抛出一个 InterruptedException。所以我们在线程的循环外捕获这个异常，就可以退出线程了。

  　 interrupt()并不会中断处于“运行状态”的线程，它会把线程的“中断标记”设置为true，所以我们可以不断通过isInterrupted()来检测中断标记，从而在调用了interrupt()后终止线程，这也是通常我们对interrupt()的用法。

  　 interrupted()是Thread类的一个静态方法，它返回一个布尔类型指明当前线程是否已经被中断，isInterrupted()是Thread类的实例方法，返回一个布尔类型来判断线程是否已经被中断。它们都能够用于检测对象的“中断标记”。区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。

## 线程安全与线程同步

* **线程不安全**

  ~~~java
  public class DrawMoneyRunnable implements Runnable{
      private Account account;
      private double drawAmount;
      public DrawMoneyRunnable(Account account, double drawAmount) {
          super();
          this.account = account;
          this.drawAmount = drawAmount;
      }
      public void run() {
          if (account.getBalance() >= drawAmount) {  //1
              System.out.println("取钱成功， 取出钱数为：" + drawAmount);
              double balance = account.getBalance() - drawAmount;
              account.setBalance(balance);
              System.out.println("余额为：" + balance);
          }
      }
  }
  
  public class ThreadTest {
      public static void main(String[] args) {
          Account account = new Account("123456", 1000);
          DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account, 700);
          Thread myThread1 = new Thread(drawMoneyRunnable);
          Thread myThread2 = new Thread(drawMoneyRunnable);
          myThread1.start();
          myThread2.start();
      }
  
  }
  
  取钱成功， 取出钱数为：700.0
  余额为：300.0
  取钱成功， 取出钱数为：700.0
  余额为：-400.0
  ~~~

  

  对于一张只有1000余额的银行卡，你们一共可以取出1400，这显然是有问题的。

  ​     经过分析，问题在于Java多线程环境下的执行的不确定性。CPU可能随机的在多个处于就绪状态中的线程中进行切换，因此，很有可能出现如下情况：当thread1执行到//1处代码时，判断条件为true，此时CPU切换到thread2，执行//1处代码，发现依然为真，然后执行完thread2，接着切换到thread1，接着执行完毕。此时，就会出现上述结果。

  ​     因此，讲到线程安全问题，其实是指多线程环境下对共享资源的访问可能会引起此共享资源的不一致性。因此，为避免线程安全问题，应该避免多线程环境下对此共享资源的并发访问。

* 多线程同步

  **为何要使用同步？** 

  ​     java允许多线程并发控制，当多个线程同时操作一个可共享的资源变量时（如数据的增删改查），将会导致数据不准确，相互之间产生冲突，因此加入同步锁以避免在该线程没有完成操作之前，被其他线程的调用，从而保证了该变量的唯一性和准确性。

  * **同步方法**

  ​     对共享资源进行访问的方法定义中加上synchronized关键字修饰，使得此方法称为同步方法。可以简单理解成对此方法进行了加锁，其锁对象为当前方法所在的对象自身。多线程环境下，当执行此方法时，首先都要获得此同步锁（且同时最多只有一个线程能够获得），只有当线程执行完此同步方法后，才会释放锁对象，其他的线程才有可能获取此同步锁，以此类推...。

  ​     在上例中，共享资源为account对象，当使用同步方法时，可以解决线程安全问题。只需在run()方法前加上synchronized关键字即可。

  ~~~java
  public synchronized void run() {
          if (account.getBalance() >= drawAmount) {
              System.out.println("取钱成功，取出：" + drawAmount);
              double balance = account.getBalance() - drawAmount;
              account.setBalance(balance);
              System.out.println("余额为：" + balance);
          }
      }
  ~~~

  * **同步代码块**

  ​     正如上面所分析的那样，解决线程安全问题其实只需限制对共享资源访问的不确定性即可。使用同步方法时，使得整个方法体都成为了同步执行状态，会使得可能出现同步范围过大的情况，于是，针对需要同步的代码可以直接另一种同步方式——同步代码块来解决。

  同步代码块的格式为：

  ```java
  /**
  synchronized (obj) {           
      //...
  }
  */
  @Override
      public void run() {
          synchronized (account){
              if (account.getBalance() >= drawAmount) {
                  System.out.println("取钱成功，取出：" + drawAmount);
                  double balance = account.getBalance() - drawAmount;
                  account.setBalance(balance);
                  System.out.println("余额为：" + balance);
              }
          }
  
      }
  ```

  ​      其中，obj为锁对象，因此，选择哪一个对象作为锁是至关重要的。一般情况下，都是选择此共享资源对象作为锁对象。

  ​      如上例中，最好选用account对象作为锁对象。（当然，选用this也是可以的，那是因为创建线程使用了runnable方式，如果是直接继承Thread方式创建的线程，使用this对象作为同步锁其实没有起到任何作用，因为是不同的对象了。因此，选择同步锁时需要格外小心...）

* `synchronized`关键字

  * 原理

    在java中，每一个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在。**当前线程调用某对象的synchronized方法时，就获取了该对象的同步锁。例如，synchronized(obj)，当前线程就获取了“obj这个对象”的同步锁。**

    **不同线程对同步锁的访问是互斥的。**也就是说，某时间点，对象的同步锁只能被一个线程获取到！通过同步锁，我们就能在多线程中，实现对“对象/方法”的互斥访问。 例如，现在有个线程A和线程B，它们都会访问“对象obj的同步锁”。假设，在某一时刻，线程A获取到“obj的同步锁”并在执行一些操作；而此时，线程B也企图获取“obj的同步锁” —— 线程B会获取失败，它必须等待，直到线程A释放了“该对象的同步锁”之后线程B才能获取到“obj的同步锁”从而才可以运行。

  * 基本规则

    第一条：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对**“该对象”的该“synchronized方法”或者“synchronized代码块”的访问**将被阻塞。

    第二条：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然**可以访问“该对象”的非同步代码块**。

    第三条：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对**“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问**将被阻塞。

  * 实例锁和全局锁

    **实例锁** -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。实例锁对应的就是synchronized关键字。

    **全局锁** -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。

    就是说，一个非静态方法上的synchronized关键字，代表该方法依赖其所属对象。一个静态方法上synchronized关键字，代表该方法依赖这个类本身。

## 线程通信

* wait()：导致当前线程等待并使其进入到等待阻塞状态。直到其他线程调用该同步锁对象的notify()或notifyAll()方法来唤醒此线程。

* notify()：唤醒在此同步锁对象上等待的单个线程，如果有多个线程都在此同步锁对象上等待，则会任意选择其中某个线程进行唤醒操作，只有当前线程放弃对同步锁对象的锁定，才可能执行被唤醒的线程。

* notifyAll()：唤醒在此同步锁对象上等待的所有线程，**只有当前线程放弃对同步锁对象的锁定，才可能执行被唤醒的线程。**

  ~~~java
  // 存取钱的demo
  ~~~

  注意：

  * wait()方法执行后，当前线程立即进入到等待阻塞状态，其后面的代码不会执行；

  * notify()/notifyAll()方法执行后，将唤醒此同步锁对象上的（任意一个-notify()/所有-notifyAll()）线程对象，但是，此时还并没有释放同步锁对象，也就是说，*如果notify()/notifyAll()后面还有代码，还会继续执行，直到当前线程执行完毕才会释放同步锁对象，或者执行了wait（）方法*

  * notify()/notifyAll()执行后，如果下面有sleep()方法，则会使当前线程进入到阻塞状态，但是同步对象锁没有释放，依然自己保留，那么一定时候后还是会继续执行此线程，接下来同2；

  * wait()/notify()/nitifyAll()完成线程间的通信或协作都是基于相同对象锁的，因此，如果是不同的同步对象锁将失去意义，同时，同步对象锁最好是与共享资源对象保持一一对应关系；

  * 当wait线程唤醒后并执行时，是接着上次执行到的wait()方法代码后面继续往下执行的。

## 线程优先级和守护线程

* thread.setDaemon(true)必须在thread.start()之前设置，否则会抛出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。 

* 在Daemon线程中产生的新线程也是Daemon的。

* 守护线程应该永远不去访问固有资源，如文件、数据库，因为它会在任何时候甚至在一个操作的中间发生中断。

## 线程池

**线程池介绍**

在web开发中，服务器需要接受并处理请求，所以会为一个请求来分配一个线程来进行处理。如果每次请求都新创建一个线程的话实现起来非常简便，但是存在一个问题：

**如果并发的请求数量非常多，但每个线程执行的时间很短，这样就会频繁的创建和销毁线程，如此一来会大大降低系统的效率。可能出现服务器在为每个请求创建新线程和销毁线程上花费的时间和消耗的系统资源要比处理实际的用户请求的时间和资源更多。**

那么有没有一种办法使执行完一个任务，并不被销毁，而是可以继续执行其他的任务呢？

这就是线程池的目的了。线程池为线程生命周期的开销和资源不足问题提供了解决方案。通过对多个任务重用线程，线程创建的开销被分摊到了多个任务上。

**什么时候使用线程池？**

- 单个任务处理时间比较短
- 需要处理的任务数量很大

**使用线程池的好处**

- 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
- 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。

在`《阿里巴巴java开发手册》`中指出了线程资源必须通过线程池提供，不允许在应用中自行显示的创建线程，这样一方面是线程的创建更加规范，可以合理控制开辟线程的数量；另一方面线程的细节管理交给线程池处理，优化了资源的开销。而线程池不允许使用`Executors`去创建，而要通过`ThreadPoolExecutor`方式，这一方面是由于`jdk`中`Executor`框架虽然提供了如`newFixedThreadPool()`、`newSingleThreadExecutor()`、`newCachedThreadPool()`等创建线程池的方法，但都有其局限性，不够灵活；另外由于前面几种方法内部也是通过T`hreadPoolExecutor`方式实现，使用`ThreadPoolExecutor`有助于大家明确线程池的运行规则，创建符合自己的业务场景需要的线程池，避免资源耗尽的风险。

* `ThreadPoolExecutor`

  构造方法解析：

  ~~~java
  public ThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                RejectedExecutionHandler handler) {
          if (corePoolSize < 0 ||
              maximumPoolSize <= 0 ||
              maximumPoolSize < corePoolSize ||
              keepAliveTime < 0)
              throw new IllegalArgumentException();
          if (workQueue == null || threadFactory == null || handler == null)
              throw new NullPointerException();
          this.acc = System.getSecurityManager() == null ?
                  null :
                  AccessController.getContext();
          this.corePoolSize = corePoolSize;
          this.maximumPoolSize = maximumPoolSize;
          this.workQueue = workQueue;
          this.keepAliveTime = unit.toNanos(keepAliveTime);
          this.threadFactory = threadFactory;
          this.handler = handler;
      }
  ~~~

  参数解析：

  ~~~properties
  corePoolSize:指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去；
  
  maximumPoolSize:指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量；
  
  keepAliveTime:当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁；
  
  unit:keepAliveTime的单位
  
  workQueue:任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种；
  
  threadFactory:线程工厂，用于创建线程，一般用默认即可；
  
  handler:拒绝策略；当任务太多来不及处理时，如何拒绝任务；
  ~~~

  * **workQueue任务队列**

    * **直接提交队列**：设置为SynchronousQueue队列，SynchronousQueue是一个特殊的BlockingQueue，它没有容量，每执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。

      使用SynchronousQueue队列，提交的任务不会被保存，总是会马上提交执行。如果用于执行任务的线程数量小于maximumPoolSize，则尝试创建新的进程，如果达到maximumPoolSize设置的最大值，则根据你设置的handler执行拒绝策略。因此这种方式你提交的任务不会被缓存起来，而是会被马上执行，在这种情况下，你需要对你程序的并发量有个准确的评估，才能设置合适的maximumPoolSize数量，否则很容易就会执行拒绝策略；  

    * **有界的任务队列**

      使用ArrayBlockingQueue有界任务队列，若有新的任务需要执行时，线程池会创建新的线程，直到创建的线程数量达到corePoolSize时，则会将新的任务加入到等待队列中。若等待队列已满，即超过ArrayBlockingQueue初始化的容量，则继续创建线程，直到线程数量达到maximumPoolSize设置的最大线程数量，若大于maximumPoolSize，则执行拒绝策略。在这种情况下，线程数量的上限与有界任务队列的状态有直接关系，如果有界队列初始容量较大或者没有达到超负荷的状态，线程数将一直维持在corePoolSize以下，反之当任务队列已满时，则会以maximumPoolSize为最大线程数上限。