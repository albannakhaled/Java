package org.example.json.model;

public class SchoolMaster {
    private String name;
    private int age;
    private Student[] students;
    private Teacher[] teachers;
    private Departement[] departements;


    public SchoolMaster() {
    }

    public SchoolMaster(String name, int age, Student[] students, Teacher[] teachers, Departement[] departements) {
        this.name = name;
        this.age = age;
        this.students = students;
        this.teachers = teachers;
        this.departements = departements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Departement[] getDepartements() {
        return departements;
    }

    public void setDepartements(Departement[] departements) {
        this.departements = departements;
    }

    

}
