package cn.itcast.day06.demo02;
/*成员变量和局部变量的区别
1.定义的位置不一样:
    局部变量：在方法的内部
    成员变量：在方法的外部，直接写在类当中
2.作用范围不一样：
    局部变量作用范围：方法中才可以使用，出了方法不能用
    成员变量：整个类全部可以通用
3.默认值不一样：
    局部变量：没有默认值，如果使用需要手动赋值
    成员变量：如果没有赋值，会有默认值，String-null、double-0.00、boolean-false
*/
public class Demo01Phone {
    String name;//成员变量

    public static void main(String[] args) {
        Phone ph = new Phone();
        System.out.println(ph.brand);
        System.out.println(ph.color);
        System.out.println(ph.price);
        System.out.println("============");

        ph.call();
        ph.sendMessage();

        System.out.println("==========");
        ph.brand = "aplle";
        ph.color = "golden";
        ph.price = 599.99;

        System.out.println(ph.brand);
        System.out.println(ph.color);
        System.out.println(ph.price);

    }
}
