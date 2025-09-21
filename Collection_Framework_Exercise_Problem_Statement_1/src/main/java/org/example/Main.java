package org.example;

import models.Classroom;
import models.School;
import models.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
            Student student1 = new Student("John Doe", Map.of("Math", 85, "Science", 90, "History", 78));
            Student student2 = new Student("Jane Smith", Map.of("Math", 92, "Science", 88, "History", 95));
            Student student3 = new Student("Alice Johnson", Map.of("Math", 75, "Science", 80, "History", 70));
            Student student4 = new Student("Bob Brown", Map.of("Math", 88, "Science", 82, "History", 84));
            Student student5 = new Student("Charlie White", Map.of("Math", 90, "Science", 85, "History", 92));
            Student student6 = new Student("Diana Green", Map.of("Math", 95, "Science", 90, "History", 88));

            //display with presition of 2 decimal places
            System.out.printf("Student %s has an average grade of %.2f%n", student2.getName(), student2.calculateAverageGrade());

            Classroom classroom1 = new Classroom(Set.of(student1, student4));
            Classroom classroom2 = new Classroom(Set.of(student2, student3));
            Classroom classroom3 = new Classroom(Set.of(student5, student6));

            classroom1.displayStudents();

            System.out.printf("The average grade of the classroom is %.2f%n", classroom1.calculateAverageClassGrade());

            School school = new School("Green Valley High", List.of(classroom1, classroom2, classroom3));

            System.out.printf("The average grade of the school is %.2f%n", school.calculateAverageSchoolGrade());
        }
    }