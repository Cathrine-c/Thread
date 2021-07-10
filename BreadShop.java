package java_1227;

/**
 * 消费者-生产者模式
 * 用面包店生产消费面包为例
 */

public class BreadShop {


    private static int COUNT;//面包库存

    private static int sumProduce ;
    //消费者任务线程
    public static class Consumer implements Runnable{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            //一直消费
            try {
                while (true) {
                    synchronized (BreadShop.class) {
                        if (sumProduce == 900) {
                            break;
                        }

                        if (COUNT == 0) {
                            BreadShop.class.wait();//释放锁
                        } else {
                            System.out.printf("消费者 %s 消费了10个面包\n",name);

                            COUNT-=10;
                            //通知由BreadShop.class.wait();进入阻塞的线程
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(500);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

         }
    }



     //生产者任务线程
    public static class Maker implements Runnable{

        private String name;

         public Maker(String name) {
             this.name = name;
         }


         @Override
        public void run() {
            //一直生产
             int n = 30;
            try {
             //   while (n-- >0) {
                for (int i =0;i<30;i++){
                    synchronized (BreadShop.class) {
                        if (COUNT +3> 100) {
                            BreadShop.class.wait();//释放锁
                        } else {
                            System.out.printf("生产者 %s 生产了3个面包\n",name);

                            COUNT+=3;
                            sumProduce+=3;
                            //通知由BreadShop.class.wait();进入阻塞的线程
                            BreadShop.class.notifyAll();
                            Thread.sleep(300);
                        }
                    }
                    Thread.sleep(300);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
        //同时启动20个消费者线程
        //同时启动10个生产者线程
        Thread[] consumers = new Thread[20];
        for (int i =0;i<20;i++){
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));

            }

        Thread[] makers = new Thread[10];
        for (int i =0;i<10;i++){
            makers[i] = new Thread(new Maker(String.valueOf(i)));

        }
        for (int i =0;i<20;i++){
            consumers[i].start();
        }

        for (int i =0;i<10;i++){
            makers[i].start();
        }

    }



    }



