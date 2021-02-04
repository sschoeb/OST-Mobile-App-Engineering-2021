package ch.paixon.exercise_adapterview_solution;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person(1, "Stefan", "Zürich"));
        persons.add(new Person(2, "Peter", "Basel"));
        persons.add(new Person(3, "Frank", "Bern"));
        persons.add(new Person(4, "Hans", "Mailand"));
        persons.add(new Person(5, "Jakob", "Madrid"));
        persons.add(new Person(6, "Florian", "London"));
        persons.add(new Person(7, "Roger", "Grabs"));
        persons.add(new Person(8, "Jonas", "Amsterdam"));
        persons.add(new Person(9, "Valon", "Moskau"));
        persons.add(new Person(10, "Didier", "Berlin"));
        persons.add(new Person(11, "Lara", "Barcelona"));
    }

    public static List<Person> getPersons() {
        return persons;
    }
}
