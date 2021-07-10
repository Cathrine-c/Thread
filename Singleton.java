package java_1227;

class Singleton {
    private static volatile Singleton INSTANCE ;
    private Singleton(){}
    public static Singleton getInstance(){
        if (INSTANCE == null) {
            synchronized (Singleton.class){
                INSTANCE = new Singleton();//非原子性操作

            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        //多个线程去调用同一个对象
        for (int i =0;i<20;i++){
            Singleton s = Singleton.getInstance();

        }


    }


}
