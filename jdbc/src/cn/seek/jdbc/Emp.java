package cn.seek.jdbc;

import java.util.Date;

public class Emp {
    private  int id;
    private String name;
    private String gender;
    private double salary;
    private Date JOIN_DATE;
    private int dept_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJOIN_DATE() {
        return JOIN_DATE;
    }

    public void setJOIN_DATE(Date JOIN_DATE) {
        this.JOIN_DATE = JOIN_DATE;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", date=" + JOIN_DATE +
                ", dept_id=" + dept_id +
                '}';
    }
}
