package models;

import java.util.Set;

public class Classroom {
    //region variables
    private Set<Student> _students;
    //endregion

    //region constructor
    public Classroom(Set<Student> students) {
        this._students = students;
    }
    //endregion

    //region getters and setters
    public Set<Student> get_students() {
        return _students;
    }

    public void set_students(Set<Student> students) {
        this._students = students;
    }
    //endregion

    //region methods
    public void addStudent(Student student) {
        _students.add(student);
    }

    public void removeStudent(Student student) {
        if (!_students.contains(student)) {
            System.out.println("Student not found in the classroom.");
            return;
        }
        _students.remove(student);
    }

    public void displayStudents() {
        System.out.println("students in the classroom:");
        for (Student student : _students) {
            System.out.println(student.getName());
        }
    }

    public double calculateAverageClassGrade(){
        double totalSum = 0.0;
        for(Student student : _students)
            totalSum += student.calculateAverageGrade();

        return totalSum / _students.size();
    }
    //endregion

}