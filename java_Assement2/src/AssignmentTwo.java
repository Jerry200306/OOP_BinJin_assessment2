import java.util.Scanner;
public class AssignmentTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number to select the method to run:");
        System.out.println("1 - Run partThree()");
        System.out.println("2 - Run partFourA()");
        System.out.println("3 - Run partFourB()");
        System.out.println("4 - Run partFive()");
        System.out.println("5 - Run partSix()");
        System.out.println("6 - Run partSeven()");
        System.out.print("选择：");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                partThree();
                break;
            case 2:
                partFourA();
                break;
            case 3:
                partFourB();
                break;
            case 4:
                partFive();
                break;
            case 5:
                partSix();
                break;
            case 6:
                partSeven();
                break;
            default:
                System.out.println("Invalid input！");
                break;
        }

        scanner.close();
    }

    public static void partThree() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));


        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);


        ride.removeVisitorFromQueue(v3);


        ride.printQueue();
    }
    public static void partFourA() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);


        System.out.println("Checking if a visitor is in the collection:");
        ride.checkVisitorFromHistory(v3);

        System.out.println("Number of visitors in the collection: " + ride.numberOfVisitors());


        ride.printRideHistory();
    }
    public static void partFourB() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));


        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);


        System.out.println("Visitors before sorting:");
        ride.printRideHistory();


        ride.sortHistory();


        System.out.println("Visitors after sorting:");
        ride.printRideHistory();
    }
    public static void partFive() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));
        ride.setMaxRider(3);


        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V" + i, "T" + i, "Level" + i);
            ride.addVisitorToQueue(visitor);
        }
        System.out.println("Visitors in the queue before running the ride:");
        ride.printQueue();

        ride.runOneCycle();


        System.out.println("Visitors in the queue after running the ride:");
        ride.printQueue();


        System.out.println("Visitors who have taken the ride:");
        ride.printRideHistory();
    }
    public static void partSix() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));


        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);


        String filePath = "ride_history.txt";
        ride.exportRideHistory(filePath);
    }
    public static void partSeven() {

        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));


        String filePath = "ride_history.txt";
        ride.importRideHistory(filePath);


        System.out.println("Number of visitors imported: " + ride.history.size());


        System.out.println("Visitors in the LinkedList:");
        ride.printRideHistory();
    }
}

