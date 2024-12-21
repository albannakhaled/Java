package org.example.json.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SchoolData { 

    public School createSchool() {
        School school = new School();
        school.setName("ABC School");
        school.setAddress("123 Main Street");
        school.setFoundedYear(2000);

        Director director = new Director();
        director.setName("John Doe");
        director.setAge(45);
        school.setDirector(director);

        Teacher[] teachers = new Teacher[2];
        teachers[0] = new Teacher("Jane Smith", 35, new Departement("Math", null));
        teachers[1] = new Teacher("Tom Brown", 40, new Departement("Science", null));
        school.setTeachers(teachers);

        Student[] students = new Student[2];
        students[0] = new Student("Alice", 15, new Departement("Math", null));
        students[1] = new Student("Bob", 16, new Departement("Science", null));
        school.setStudents(students);

        Departement[] departements = new Departement[2];
        departements[0] = new Departement("Math", "Building A");
        departements[1] = new Departement("Science", "Building B");
        school.setDepartements(departements);

        SchoolMaster[] schoolMasters = new SchoolMaster[2];
        schoolMasters[0] = new SchoolMaster("John Doe", 45, students, teachers, departements);
        schoolMasters[1] = new SchoolMaster("Jane Smith", 35, students, teachers, departements);
        school.setSchoolMasters(schoolMasters);

        return school;
    }

    public String toJson(School school) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(school);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}