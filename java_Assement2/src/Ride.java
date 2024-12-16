
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> queue; 
    protected LinkedList<Visitor> history; 
    private int maxRider; 
    private int numOfCycles; 

    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
    }

    public Ride(String rideName, int capacity, Employee operator) {
        this();
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
    }

 
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            queue.offer(visitor);
            System.out.println(visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Failed to add visitor to the queue. Visitor is null.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null && queue.contains(visitor)) {
            queue.remove(visitor);
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Failed to remove visitor from the queue. Visitor not found or is null.");
        }
    }

    @Override
    public void printQueue() {
        if (!queue.isEmpty()) {
            System.out.println("Visitors in the queue:");
            for (Visitor visitor : queue) {
                System.out.println(visitor.getName());
            }
        } else {
            System.out.println("The queue is empty.");
        }
    }

    @Override
    public void runOneCycle() {
        if (this.operator == null) {
            System.out.println("The ride cannot be run without an operator.");
            return;
        }
        if (this.queue.isEmpty()) {
            System.out.println("The ride queue is empty. Cannot run the ride.");
            return;
        }
        int ridersThisCycle = Math.min(this.maxRider, this.queue.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = this.queue.poll(); 
            if (visitor != null) {
                this.history.add(visitor); 
            }
        }
        this.numOfCycles++; 
        System.out.println(ridersThisCycle + " visitors have taken the ride. Total cycles run: " + this.numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            history.add(visitor);
            System.out.println(visitor.getName() + " has been added to the ride history.");
        } else {
            System.out.println("Failed to add visitor to the history. Visitor is null.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null && history.contains(visitor)) {
            System.out.println(visitor.getName() + " is in the ride history.");
            return true;
        } else {
            System.out.println(visitor.getName() + " is not in the ride history.");
            return false;
        }
    }

    @Override
    public int numberOfVisitors() {
        return history.size();
    }

    @Override
    public void sortHistory() {
        history.sort(new VisitorComparator());
    }
    @Override
    public void printRideHistory() {
        if (!history.isEmpty()) {
            System.out.println("Visitors who have taken the ride:");
            Iterator<Visitor> iterator = history.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName());
            }
        } else {
            System.out.println("No visitors have taken the ride yet.");
        }
    }
    @Override
    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor visitor : history) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + "," + visitor.getTicketNumber() + "," + visitor.getMembershipLevel());
                writer.newLine();
            }
            System.out.println("Ride history has been exported to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    @Override
    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] visitorDetails = line.split(",");
                if (visitorDetails.length == 5) {
                    String name = visitorDetails[0];
                    int age = Integer.parseInt(visitorDetails[1]);
                    String id = visitorDetails[2];
                    String ticketNumber = visitorDetails[3];
                    String membershipLevel = visitorDetails[4];
                    Visitor visitor = new Visitor(name, age, id, ticketNumber, membershipLevel);
                    history.add(visitor);
                }
            }
            System.out.println("Ride history has been imported from " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }



    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }
}
