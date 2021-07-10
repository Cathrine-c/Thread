package java_1227;



public class SequencePrint {
    //有三个线程，每个线程只能打印A/B/C
    //要求：同时打印三个线程，按CBA顺序打印


    public static void main(String[] args) {
        Thread c = new Thread(new PrintTask("C",null));
        Thread b = new Thread(new PrintTask("B",c));
        Thread a = new Thread(new PrintTask("A",b));

        a.start();
        b.start();
        c.start();

    }


    private static class PrintTask implements Runnable{

        private Thread joinTask;

        private String content;

        public PrintTask(String content,Thread joinTask) {
            this.content = content;
            this.joinTask = joinTask;
        }


        @Override
        public void run() {
            try {
            if (joinTask != null) {
                joinTask.join();
            }
            System.out.println(content);

            }catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

}
