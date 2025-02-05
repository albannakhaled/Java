package org.example.json.model;

public class Teacher {
    private String name;
    private int age;
    private Departement departement;

    public Teacher() {
    }

    public Teacher(String name, int age, Departement departement) {
        this.name = name;
        this.age = age;
        this.departement = departement;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

}
