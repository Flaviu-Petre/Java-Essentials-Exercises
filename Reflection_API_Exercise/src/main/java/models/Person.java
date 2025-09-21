package models;

public class Person {
    //region fields
    private String name;
    private int age;
    //endregion

    //region constructors
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //endregion

    //region getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //endregion

    //region setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion

    //region methods
    private void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    private void displayInfoWithAdditionalInfo(String additionalInfo) {
        System.out.println("Name: " + name + ", Age: " + age + ", Additional Info: " + additionalInfo);
    }

    private void sayHello() {
        System.out.println("Hello my name is {name}");
    }
    //endregion
}
