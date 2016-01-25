package com.gcarneiro.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gabriel.carneiro
 * @since 25/01/16.
 */
public class CreateTable {

    public static void main(String[] args) {
        TableCreator tableCreator = new TableCreator();

        tableCreator.addStringColumn("Name", "name");
        tableCreator.addNumberColumn("Age", "age");
        tableCreator.addDateColumn("Birth date", "birthDate");
        tableCreator.addBooleanColumn("Married", "married");

        tableCreator.setRows(createRows());

        System.out.println(tableCreator.createAsciiTable());
    }

    private static List<Person> createRows() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Elvis Presley", 44, new Date(), true));
        people.add(new Person("Santa", 99999, new Date(), false));
        people.add(new Person("Mario", 50, new Date(), true));
        people.add(new Person("Luke", 30, new Date(), false));
        people.add(new Person("This guy has a really long name WTF?!", 30, new Date(), false));
        return people;
    }

    private static class Person {
        private String name;
        private int age;
        private Date birthDate;
        private boolean married;

        public Person(String name, int age, Date birthDate, boolean married) {
            this.name = name;
            this.age = age;
            this.birthDate = birthDate;
            this.married = married;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public boolean isMarried() {
            return married;
        }
    }
}