package cn.itcast.day06.demo01;

//if you don't give a value to att,it still have a value
//String:null/int:0/double:0.0/boolean:false
public class Demo02Student {
    public static void main(String[] args) {
        Student st = new Student();
        System.out.println(st.name);
        System.out.println(st.age);
        System.out.println("===========");
        st.eat();
        st.sleep();
        st.study();
        System.out.println("===========");
        st.name = "李强";
        st.age = 12;
        System.out.println(st.name);
        System.out.println(st.age);
    }

}
