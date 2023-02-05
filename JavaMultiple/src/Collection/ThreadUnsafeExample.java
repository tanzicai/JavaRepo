package Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        /**
         * CountDownLatch的作用很简单，就是一个或者一组线程在开始执行操作之前，必须要等到其他线程执行完才可以。
         * 我们举一个例子来说明，在考试的时候，老师必须要等到所有人交了试卷才可以走。此时老师就相当于等待线程，而学生就好比是执行的线程。
         */
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        /**
         *   ExecutorService是Java提供的线程池，也就是说，每次我们需要使用线程的时候，可以通过ExecutorService获得线程。
         *   它可以有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞，同时提供定时执行、定期执行、单线程、并发数控制等功能，也不用使用TimerTask了。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }

}


class CPUCacheTroble{
    /**
     * 可见性：一个线程对共享变量的修改，另外一个线程能够立刻看到。
     */
        static int i = 0;
        static int j = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{

            i = 10;
        });
        executorService.execute(()->{

            j = i;
        });
        System.out.println("i:"+i+",j:"+j);

        }

}

class Trouble2{
    /**
     * 原子性: 分时复用引起
     * 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。
     *
     * 定义了一个int型变量，定义了一个boolean类型变量，然后分别对两个变量进行赋值操作。
     * 从代码顺序上看，语句1是在语句2前面的，那么JVM在真正执行这段代码的时候会保证语句1一定会在语句2前面执行吗?
     * 不一定，为什么呢? 这里可能会发生指令重排序（Instruction Reorder）。
     *
     *在执行程序时为了提高性能，编译器和处理器常常会对指令做重排序。
     * 重排序分三种类型：
     * 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。指
     * 令级并行的重排序。现代处理器采用了指令级并行技术（Instruction-Level Parallelism， ILP）来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
     * 内存系统的重排序。由于处理器使用缓存和读 / 写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。
     */
    private static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) {
//        int i =0;
//        boolean flag = false;
//
//        i =1;
//       flag = true;


    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> unmodifiableMa1p = Collections.unmodifiableMap(map);
    //unmodifiableMap.put("a", 1);Exception in thread "main" java.lang.UnsupportedOperationException


    /**
     * 相对线程安全需要保证对这个对象单独的操作是线程安全的，在调用的时候不需要做额外的保障措施。
     * 但是对于一些特定顺序的连续调用，就可能需要在调用端使用额外的同步手段来保证调用的正确性。
     * 在 Java 语言中，大部分的线程安全类都属于这种类型，例如 Vector、HashTable、Collections 的 synchronizedCollection() 方法包装的集合等。
     * 对于下面的代码，如果删除元素的线程删除了 Vector 的一个元素，而获取元素的线程试图访问一个已经被删除的元素，那么就会抛出 ArrayIndexOutOfBoundsException。
     */
        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
//            ExecutorService executorService = Executors.newCachedThreadPool();
//            executorService.execute(() -> {
//
//                for (int i = 0; i < vector.size(); i++) {
//                    vector.get(i);
//                }
//            });
//            executorService.execute(() -> {
//                for (int i = 0; i < vector.size(); i++) {
//                    vector.remove(i);
//                }
//            });
//            executorService.shutdown();
//        }

        /**
         * 如果要保证上面的代码能正确执行下去，就需要对删除元素和获取元素的代码进行同步。
         */

        executorService.execute(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("remove:"+i);
                    vector.remove(i);
                }
            }
        });
        executorService.execute(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("get:"+vector.get(i));

                }
            }
        });

    }
}