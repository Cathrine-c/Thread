package java_1213;

/**
 * 创建线程的方式
 */
public class ThreadDemo4 {
    //1.继承Thread类，重写run方法
    static class MyThread1 extends Thread {
        @Override
        public void run() {

        }
    }


    //2.实现Runnable接口，重写run方法
    static class MyThread2 implements Runnable {
        @Override
        public void run() {

        }
    }


    //3.描述可执行类,传入线程对象构造方法
    static class MyThread3 {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {


            }
        });


//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
    }


    //4.runnale只有一个接口方法，可以直接用lambda表达式

    void start() {
        new Thread(() ->{
            System.out.println();//和在run方法中写一样
        });
    }



    public static void main5(String[] args) {
        //创建20个线程，让它们同时从0加到9999
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (i < 10000) {
                        i++;
//                        if (i == 9999) {
//                            System.out.println(i);
//                        }
                        System.out.println(i);
                    }
                }
            };
            t.start();
        }




    }


    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t.start();
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());//优先级
        System.out.println(t.getState());//状态
        System.out.println(t.isAlive());//是否存活
        System.out.println(t.isDaemon());//是否后台进程
        System.out.println(t.isInterrupted());//是否被中断

    }

    public static void main3(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}


