package InheritanceAndPolymorphism;

import ObjectOrientedProgrammingLecture.Person;

public class InAndPolyTester {

    public static void main(String[] args) {
//        Person person = new Person("Douglas", "Hirsh");
//
//        System.out.println("person.joinsChat() = " + person.joinsChat());
//
//        System.out.println("person.sayHello() = " + person.sayHello());
//
//        Employee employee = new Employee("Kenneth", "Howell");
//
//        String greeting = employee.joinsChat();
//        System.out.println("greeting = " + greeting);
//
//        employee.doWork();
//
//        System.out.println("employee.sayHello() = " + employee.sayHello());

        Vehicle genericVehicle = new Vehicle();
        genericVehicle.start();

        Bus bus = new Bus(80);
        bus.setHeadlightsOn(true);
        bus.start();
        bus.honkHorn();
        bus.setNumberOfOccupants(2);
        System.out.println("Zooming in a bus at " + bus.getMaxSpeed() + " MPH with " + bus.getNumberOfOccupants() + " occupants inside.");

        System.out.println();

        Jet fastJet = new Jet(2000);
        fastJet.setNumberOfOccupants(1);
        fastJet.start();
        System.out.println("Zooming in a fast jet at " + fastJet.getMaxSpeed() + " MPH with " + fastJet.getNumberOfOccupants() + " occupants inside.");

        System.out.println();

        Vehicle fasterBus1 = spawnVehicle("bus", 120);
        fasterBus1.start();
//        fasterBus1.honkHorn(); // cannot work since fasterBus1 is Vehicle class instance not Bus, fasterBus1 can access to all the methods in Bus class

        Bus fasterBus2 = (Bus)spawnVehicle("bus", 120);
        fasterBus2.honkHorn();

        System.out.println();

        Vehicle slowerJet = spawnVehicle("jet", 700);
        slowerJet.setNumberOfOccupants(2);
        slowerJet.start();
    }


    public static Vehicle spawnVehicle(String vehicleType, int maxSpeed) {
        Vehicle vehicle = null;

        switch(vehicleType) {
            case "vehicle":
                vehicle = new Vehicle(maxSpeed);
                break;
            case "bus":
                vehicle = new Bus(maxSpeed);
                break;
            case "jet":
                vehicle = new Jet(maxSpeed);
                break;
        }

        return vehicle;
    }
}
