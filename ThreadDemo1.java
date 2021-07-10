package java_1213;

/**
 * 创建线程的方式
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        //1.使用thread类，重写run方法
        Thread t1 = new Thread(){
           // int i =0;
            @Override
            public void run() {
                while (true) {
//                   i++;
//                    System.out.println("i:"+i);
                }
            }

        };


//        Thread t2 = new Thread(){
//            int j =0;
//            @Override
//            public void run() {
//                while (j<500){
//                    j++;
//                    System.out.println("j:"+j);
//                }
//            }
//        };

        t1.start();
       // t2.start();
    }

}
