package ObjectOrientedProgrammingLecture;

import java.util.Scanner;

public class Person {
    public String firstName;
    public String lastName;
    public String joinsChat() {
        return lastName + ", " + firstName + " has joined the chat!";
    }

    public static long worldPopulation = 7_860_000_000L;


    public static void main(String[] args) {
        Person ken = new Person();
        Person douglas = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println(ken);

        ken.firstName = "Ken";
        ken.lastName = "Howell";

        douglas.firstName = "Douglas";
        douglas.lastName = "Hirsh";

//        System.out.println("ken.firstName = " + ken.firstName);
//        System.out.println("ken.lastName = " + ken.lastName);
//        System.out.println("ken.joinsChat() = " + ken.joinsChat());

        // World population + class/object fields
        System.out.println("worldPopulation = " + worldPopulation);
        worldPopulation += 1;  // a new person was created, we need to adjust our worldPopulation!!!
        System.out.println("worldPopulation = " + worldPopulation);

        // Hey, we can do this (instanceObject.classField, but ehhh, let's try not to
        System.out.println("douglas.worldPopulation = " + douglas.worldPopulation);

//        System.out.println("Person.firstName = " + Person.firstName);  // This will not compile  -  instant error and the java program will not continue until refactored.




    }
}
