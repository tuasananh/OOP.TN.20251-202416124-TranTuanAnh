package com.hust.kstn.parameters;

public class TestingParameters {

    public static void main(String[] args) {
        Student s1 = new Student(1, "A");
        Student s2 = new Student(2, "B");
        swap(s1, s2);
        System.out.println("First student: " + s1.getName());
        System.out.println("Second student: " + s2.getName());
    }

    public static void swap(Student s1, Student s2) {
        int s1Id = s1.getId();
        String s1Name = s1.getName();
        s1.setId(s2.getId());
        s1.setName(s2.getName());
        s2.setId(s1Id);
        s2.setName(s1Name);
    }
}
