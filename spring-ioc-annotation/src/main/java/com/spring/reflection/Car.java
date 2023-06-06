package com.spring.reflection;

public class Car {

    private String name;
    private Integer age;
    private String color;

    public String getName() {
        return name;
    }

    private void run(){
        System.out.println("这是一个私有方法！");
    }

    public Car() {
    }

    public Car(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
