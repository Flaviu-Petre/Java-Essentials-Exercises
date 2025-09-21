package models;

import java.util.List;

public class School {
    //region variables
    private String _name;
    private List<Classroom> _classrooms;
    //endregion

    //region constructor
    public School(String name, List<Classroom> classrooms) {
        this._name = name;
        this._classrooms = classrooms;
    }
    //endregion

    //region getters
    public String getName() {
        return _name;
    }

    public List<Classroom> getClassrooms() {
        return _classrooms;
    }
    //endregion

    //region setters
    public void setName(String name) {
        this._name = name;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this._classrooms = classrooms;
    }
    //endregion

    //region methods
    public void addClassroom(Classroom classroom) {
        _classrooms.add(classroom);
    }

    public void removeClassroom(Classroom classroom) {
        if (!_classrooms.contains(classroom)) {
            System.out.println("Classroom not found in the school.");
            return;
        }
        _classrooms.remove(classroom);
    }

    public double calculateAverageSchoolGrade(){
        double totalGrade = 0;
        for(Classroom classroom : _classrooms)
            totalGrade += classroom.calculateAverageClassGrade();

        return totalGrade / _classrooms.size();
    }
    //endregion
}
