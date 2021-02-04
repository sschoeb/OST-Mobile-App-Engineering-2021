package ch.paixon.exercise_adapterview_solution;

public class Person {

    private String name;
    private String address;
    private int id;

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

}