package java_1213;

public class Demo1 {
    public static void main(String[] args) {
        //匿名内部类
        A a = new A() {
            @Override
            public void x() {
                System.out.println("Y");
            }
        };

    }


    public static class A {
        public void x() {
            System.out.println("X");
        }
    }

}
