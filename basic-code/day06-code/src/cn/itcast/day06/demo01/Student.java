package cn.itcast.day06.demo01;

//defined a clss:Student
//att:name/age(成员变量)
//act:eat/sleep/study（成员方法没有static）
public class Student {
    String name;
    int age;

    public void eat(){
        System.out.println("eat");
    }
    public void sleep(){
        System.out.println("sleep");
    }
    public void study(){
        System.out.println("study");
    }
}
