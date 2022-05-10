
//import java.util.Date;
import java.text.ParseException;
import java.util.HashMap;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class parkingsystem {

    private static Scanner scanner;
    private static HashMap<Integer, Vehicle> vehicles;

    private static final int MAX_CAR_LIMIT = 20, MAX_BIKE_LIMIT = 40;

    private static int carCount = 0, bikeCount = 0;
    private static Object Car;

    public static void parkVehicle(int ticketId) {
        System.out.println("1. Park Car.");
        System.out.println("2. Park Bike.");
        System.out.print("Enter Vehicle Type: ");
        int vehicleType = scanner.nextInt();

        switch (vehicleType) {
            case 1:
                if (++carCount <= MAX_CAR_LIMIT) {
                    System.out.print("Enter The Registration Number: ");
                    String registrationNumber = scanner.next();

                    System.out.print("Enter Entry Time (hh:mm-aa): ");
                    String entryTime = scanner.next();
                    Ticket.setRegistrationNumber(registrationNumber);
                    Car car = new Car();
                    Ticket.setEntryTime(entryTime);
                    Ticket.getTicketId();
                    vehicles.put(++ticketId, car);

                    System.out.println("Car Successfully Parked!");
                } else {
                    System.out.println("Parking Slots Full!!");
                }
                System.out.println();
                break;
            case 2:
                if (++bikeCount <= MAX_BIKE_LIMIT) {
                    System.out.print("Enter The Registration Number: ");
                    String registrationNumber = scanner.next();
                    Ticket.setRegistrationNumber(registrationNumber);
                    System.out.print("Enter Entry Time (hh:mm-aa): ");
                    String entryTime = scanner.next();

                    Bike bike = new Bike();
                    Ticket.setEntryTime(entryTime);
                    vehicles.put(++ticketId, bike);

                    System.out.println("Bike Successfully Parked!");
                } else {
                    System.out.println("Parking Slots Full!!");
                }
                System.out.println();
                break;
        }
    }

    public static void unparkVehicle(int ticketId) {
        System.out.print("Enter the TicketID: ");
        String ticketID = scanner.next();

        if (vehicles.containsKey(ticketId)) {
            System.out.print("Enter Exit Time (hh:mm-aa): ");
            String exitTime = scanner.next();
            //Ticket.setRegistrationNumber(registrationNumber);
            Vehicle vehicle = (Vehicle) vehicles.remove(ticketId);
            Ticket.setExitTime(exitTime);

            if (vehicle.getType().equals(Car))
                carCount--;
            else
                bikeCount--;

            try {
                App.calculateTotalTime(entryTime, exitTime);
            } catch (ParseException e) {

                e.printStackTrace();
            }

        } else {
            System.out.println("vehicle not parked");
        }
        System.out.println();
    }
}