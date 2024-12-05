import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.Iterator;
import java.io.*;

public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private int heightLimit;
    private Employee operator;
    private Queue<Visitor> waitingLine;      // Waiting queue
    private LinkedList<Visitor> rideHistory; // Ride history record
    private int maxRider;                    // Maximum riders per cycle
    private int numOfCycles;                 // Number of cycles run

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.heightLimit = 0;
        this.operator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
        this.numOfCycles = 0;
    }

    // Parameterized constructor
    public Ride(String rideName, int heightLimit, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.heightLimit = heightLimit;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) {
        this.heightLimit = heightLimit;
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

    public Queue<Visitor> getQueue() {
        return waitingLine;
    }

    public LinkedList<Visitor> getHistory() {
        return rideHistory;
    }

    // Implement interface methods (will be improved later)
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object cannot be null");
            return;
        }
        waitingLine.offer(visitor);
        System.out.println("Success: Visitor " + visitor.getName() + " has joined the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Error: Queue is already empty");
            return;
        }
        Visitor visitor = waitingLine.poll();
        System.out.println("Success: Visitor " + visitor.getName() + " has been removed from " + rideName + "'s queue");
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + "'s queue is empty");
            return;
        }

        System.out.println("\n" + rideName + "'s Queue:");
        System.out.println("Total visitors: " + waitingLine.size());
        int position = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(position + ". " + visitor.getName() +
                             " (ID: " + visitor.getId() +
                             ", Age: " + visitor.getAge() +
                             ", Nationality: " + visitor.getNationality() +
                             ", Gender: " + visitor.getGender() +
                             ", Ticket Type: " + visitor.getTicketType() +
                             ", VIP: " + (visitor.isVIP() ? "Yes" : "No") + ")");
            position++;
        }
        System.out.println();
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Error: " + rideName + " cannot run without an operator");
            return;
        }
        
        if (waitingLine.isEmpty()) {
            System.out.println("Error: " + rideName + " cannot run with empty queue");
            return;
        }
        
        if (maxRider < 1) {
            System.out.println("Error: " + rideName + " cannot run, minimum 1 rider required");
            return;
        }
        
        System.out.println("\n=== " + rideName + " starting cycle " + (numOfCycles + 1) + " ===");
        int count = 0;
        
        while (count < maxRider && !waitingLine.isEmpty()) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
            count++;
        }
        
        numOfCycles++;
        System.out.println("Cycle completed with " + count + " riders");
        System.out.println(rideName + " has run " + numOfCycles + " times in total");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object cannot be null");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("Success: Visitor " + visitor.getName() + " added to " + rideName + "'s history");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object cannot be null");
            return false;
        }
        boolean exists = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (exists ? " is" : " is not") + " in " + rideName + "'s history");
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + "'s history is empty");
            return;
        }

        System.out.println("\n" + rideName + "'s History:");
        System.out.println("Total riders: " + rideHistory.size());

        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor.getName() +
                             " (ID: " + visitor.getId() +
                             ", Age: " + visitor.getAge() +
                             ", Nationality: " + visitor.getNationality() +
                             ", Gender: " + visitor.getGender() +
                             ", Ticket Type: " + visitor.getTicketType() +
                             ", VIP: " + (visitor.isVIP() ? "Yes" : "No") + ")");
            position++;
        }
        System.out.println();
    }

    // Part 4B - Add sorting method
    public void sortVisitorHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("History is empty, no need to sort");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("History has been sorted by VIP status and age");
    }

    // Part 6 - Export history record to file
    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("Error: History is empty, no data to export");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                String line = String.format("%s,%d,%s,%s,%s,%s,%b",
                    visitor.getName(),
                    visitor.getAge(),
                    visitor.getId(),
                    visitor.getNationality(),
                    visitor.getGender(),
                    visitor.getTicketType(),
                    visitor.isVIP());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Success: History exported to file " + filename);
        } catch (IOException e) {
            System.out.println("Error: Exception while exporting history - " + e.getMessage());
        }
    }

    // Part 7 - Import history record from file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    if (data.length != 7) {
                        System.out.println("Warning: Skipping invalid data line - " + line);
                        continue;
                    }
                    
                    Visitor visitor = new Visitor(
                        data[0],                    // name
                        Integer.parseInt(data[1]),  // age
                        data[2],                    // id
                        data[3],                    // nationality
                        data[4],                    // gender
                        data[5],                    // ticketType
                        Boolean.parseBoolean(data[6]) // isVIP
                    );
                    
                    rideHistory.add(visitor);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Error parsing data - " + line);
                }
            }
            System.out.println("Success: Imported " + count + " history records from file");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found " + filename);
        } catch (IOException e) {
            System.out.println("Error: Exception while reading file - " + e.getMessage());
        }
    }
}
