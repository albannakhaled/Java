package org.example.json.model;

public class School {
    private String name;
    private String address;
    private int foundedYear;
    private Director director;
    private Teacher[] teachers;
    private Student[] students;
    private Departement[] departements;
    private SchoolMaster[] schoolMasters;

    public School() {
    }

    public School(String name, String address, int foundedYear, Director director, Teacher[] teachers, Student[] students, Departement[] departements, SchoolMaster[] schoolMasters) {
        this.name = name;
        this.address = address;
        this.foundedYear = foundedYear;
        this.director = director;
        this.teachers = teachers;
        this.students = students;
        this.departements = departements;
        this.schoolMasters = schoolMasters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Departement[] getDepartements() {
        return departements;
    }

    public void setDepartements(Departement[] departements) {
        this.departements = departements;
    }

    public SchoolMaster[] getSchoolMasters() {
        return schoolMasters;
    }

    public void setSchoolMasters(SchoolMaster[] schoolMasters) {
        this.schoolMasters = schoolMasters;
    }

    
}
