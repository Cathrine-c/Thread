package java_1213;

/**
 * 处理异常的方式：
 * 线程对象.setUncaughtExceptionHandler
 * 或者在run()方法中处理
 */

public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    if (i == 20) {
                        throw new RuntimeException();
                        //某个线程如果抛异常，抛到run方法，整个线程直接终止，但是不会影响其他线程
                    }
                    System.out.println(i);
                }
            }
        };

        t.start();

        //main线程还在执行，子线程已经挂起
        while (true) {

        }
    }
}
