package java_1227;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Course {

    public Course(){}
    private int score ;
    private String cname;

    public Course(int score, String cname) {
        this.score = score;
        this.cname = cname;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        //1,对象.getClass()
//        Course course = new Course();
//        course.getClass();
//
//        //2,类名.class
//        Class c =Course.class;
//
//
//        //3.利用类的全路径获取
//        Class.forName("java_1227、Course");

//        Class c = Class.forName("java_1227");
//
//        Object object = c.newInstance();


        Class c = Class.forName("java.lang.Integer");
        //获取所有的属性
        Field[] fields = c.getDeclaredFields();

        //定义可变长的字符串，用来存储属性
        StringBuffer sb = new StringBuffer();
        sb.append(Modifier.toString(c.getModifiers())+"class"+c.getSimpleName()+"{\n");

        for (Field field :fields){
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers())+" ");//获取属性的修饰符
            sb.append(field.getType().getSimpleName()+" ");//属性的类型的名字
            sb.append(field.getName()+";\n");//属性名字

        }
        sb.append("}");
        System.out.println(sb);



//        Class c =Course.class;
//        Field field = c.getDeclaredField("score");
//
//        Object o = c.newInstance();
//
//        //使用反射机制
//        field.setAccessible(true);
//
//        field.set(o,98);
//        System.out.println(field.get(o));

    }
}
