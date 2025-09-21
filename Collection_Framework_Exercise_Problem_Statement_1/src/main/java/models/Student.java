package models;

import java.util.Map;

public class Student {
    //region variables
    private String _name;
    private Map <String, Integer> _grades;
    //endregion

    //region constructor
    public Student(String name, Map<String, Integer> grades) {
        this._name = name;
        this._grades = grades;
    }
    //endregion

    //region getters
    public String getName() {
        return _name;
    }

    public Map<String, Integer> getGrades() {
        return _grades;
    }
    //endregion

    //region setters
    public void setName(String name) {
        this._name = name;
    }

    public void setGrades(Map<String, Integer> grades) {
        this._grades = grades;
    }
    //endregion

    //region methods
    public double calculateAverageGrade(){
        double sum = 0;
        for(var entry : _grades.entrySet())
            sum += entry.getValue();
        return sum / _grades.size();
    }
    //endregion
}
