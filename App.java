import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static HashMap<String, Vehicle> vehicles;

    private static final int MAX_CAR_LIMIT = 20, MAX_BIKE_LIMIT = 40;

    private static int carCount = 0, bikeCount = 0;

    private static double calculateTotalTime(String entryTime, String exitTime) throws ParseException {
        DateFormat timeFormat = new SimpleDateFormat("hh:mm-aa");// converts string to date

        Date start = timeFormat.parse(entryTime);
        Date end = timeFormat.parse(exitTime);// returns in ms

        double totalTime = 0;
        if (start.before(end)) {// checks whether start time starts before end time
            double deltaTime = (end.getTime() - start.getTime()) / 1000;// ms-sec
            totalTime = Math.ceil(deltaTime / 60);// sec-min
        }
        return totalTime;
    }

    private static void displayMenu() {
        System.out.println("WELCOME TO PARKING MANAGEMENT SYSTEM");
        System.out.println("-------------------------------------");
        System.out.println("1. Park A Vehicle.");
        System.out.println("2. Take A Vehicle");
        System.out.println("3. Get Avaliable Slots");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void parkVehicle() {
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

                    Car car = new Car(registrationNumber);
                    car.setEntryTime(entryTime);
                    vehicles.put(registrationNumber, car);

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

                    System.out.print("Enter Entry Time (hh:mm-aa): ");
                    String entryTime = scanner.next();

                    Bike bike = new Bike(registrationNumber);
                    bike.setEntryTime(entryTime);
                    vehicles.put(registrationNumber, bike);

                    System.out.println("Bike Successfully Parked!");
                } else {
                    System.out.println("Parking Slots Full!!");
                }
                System.out.println();
                break;
        }
    }

    public static void unparkVehicle() {
        System.out.print("Enter the Registration Number: ");
        String registerNumber = scanner.next();

        if (vehicles.containsKey(registerNumber)) {
            System.out.print("Enter Exit Time (hh:mm-aa): ");
            String exitTime = scanner.next();

            Vehicle vehicle = (Vehicle) vehicles.remove(registerNumber);
            vehicle.setExitTime(exitTime);

            if (vehicle.getType().equals("Car"))
                carCount--;
            else
                bikeCount--;

            double totalTime;
            try {
                totalTime = calculateTotalTime(vehicle.getEntryTime(), vehicle.getExitTime());
                String output = String.format("Time Parked: %.2f minutes and You have to pay: Rs. %.2f", totalTime,
                        totalTime * 2);
                System.out.println(output);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("vehicle not parked");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        vehicles = new HashMap<String, Vehicle>();
        scanner = new Scanner(System.in);
        int choice;

        try {
            do {
                displayMenu();
                choice = scanner.nextInt();
                System.out.println();
                switch (choice) {
                    case 1:
                        parkVehicle();
                        break;
                    case 2:
                        unparkVehicle();
                        break;

                    case 3:
                        System.out.println("Available Slot of Cars: " + (MAX_CAR_LIMIT - carCount));
                        System.out.println("Available Slot of Bikes: " + (MAX_BIKE_LIMIT - bikeCount));
                        break;
                }
            } while (choice > 0 && choice < 4);
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }
}
