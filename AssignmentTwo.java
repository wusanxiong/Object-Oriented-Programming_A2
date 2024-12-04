public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        System.out.println("\n============= Part 3: Queue Interface Test =============");
        assignment.partThree();

        System.out.println("\n============= Part 4A: History Collection Test =============");
        assignment.partFourA();

        System.out.println("\n============= Part 4B: History Sorting Test =============");
        assignment.partFourB();

        System.out.println("\n============= Part 5: Ride Operation Test =============");
        assignment.partFive();

        System.out.println("\n============= Part 6: History Export Test =============");
        assignment.partSix();

        System.out.println("\n============= Part 7: History Import Test =============");
        assignment.partSeven();
    }

    public void partThree() {
        Employee operator = new Employee("Mike", 30, "E001", "USA", "Male",
                "Water Ride Operator", 55000, "Operations", "Day Shift", 
                true, 3);
        Ride waterRide = new Ride("Water Rapids", 120, operator, 6);

        Visitor v1 = new Visitor("Jack", 20, "V001", "USA", "Male", "Day Pass", false);
        Visitor v2 = new Visitor("Sharon", 25, "V002", "UK", "Female", "Season Pass", true);
        Visitor v3 = new Visitor("Benny", 30, "V003", "Canada", "Male", "Group Pass", false);
        Visitor v4 = new Visitor("Leo", 35, "V004", "Australia", "Male", "Student Pass", false);
        Visitor v5 = new Visitor("Mary", 28, "V005", "France", "Female", "Family Pass", true);

        System.out.println("\n=== Testing Add Visitor to Queue ===");
        waterRide.addVisitorToQueue(v1);
        waterRide.addVisitorToQueue(v2);
        waterRide.addVisitorToQueue(v3);
        waterRide.addVisitorToQueue(v4);
        waterRide.addVisitorToQueue(v5);

        System.out.println("\n=== Print Current Queue Status ===");
        printQueueTable(waterRide);

        System.out.println("\n=== Testing Remove Visitor ===");
        waterRide.removeVisitorFromQueue();

        System.out.println("\n=== Print Updated Queue Status ===");
        printQueueTable(waterRide);
    }

    private void printQueueTable(Ride ride) {
        System.out.println(String.format("%-10s | %-5s | %-10s", "Name", "Age", "Pass Type"));
        System.out.println("-------------------------------");
        for (Visitor visitor : ride.getQueue()) {
            System.out.println(String.format("%-10s | %-5d | %-10s", visitor.getName(), visitor.getAge(), visitor.getPassType()));
        }
    }

    public void partFourA() {
        Employee operator = new Employee("Sarah", 28, "E002", "UK", "Female",
                "Carousel Operator", 48000, "Operations", "Evening Shift", 
                true, 2);
        Ride carousel = new Ride("Magical Carousel", 100, operator, 12);

        Visitor v1 = new Visitor("Jack", 20, "V001", "USA", "Male", "Day Pass", false);
        Visitor v2 = new Visitor("Sharon", 25, "V002", "UK", "Female", "Season Pass", true);
        Visitor v3 = new Visitor("Benny", 30, "V003", "Canada", "Male", "Group Pass", false);
        Visitor v4 = new Visitor("Leo", 35, "V004", "Australia", "Male", "Student Pass", false);
        Visitor v5 = new Visitor("Mary", 28, "V005", "France", "Female", "Family Pass", true);

        System.out.println("\n=== Testing Add Visitor to History ===");
        carousel.addVisitorToHistory(v1);
        carousel.addVisitorToHistory(v2);
        carousel.addVisitorToHistory(v3);
        carousel.addVisitorToHistory(v4);
        carousel.addVisitorToHistory(v5);

        System.out.println("\n=== Testing Check Visitor in History ===");
        carousel.checkVisitorFromHistory(v1);
        carousel.checkVisitorFromHistory(new Visitor());

        System.out.println("\n=== Print Number of Visitors in History ===");
        System.out.println("Number of visitors in history: " + carousel.numberOfVisitors());

        System.out.println("\n=== Print All History Records ===");
        printHistoryTable(carousel);
    }

    private void printHistoryTable(Ride ride) {
        System.out.println(String.format("%-10s | %-5s | %-10s", "Name", "Age", "Pass Type"));
        System.out.println("-------------------------------");
        for (Visitor visitor : ride.getHistory()) {
            System.out.println(String.format("%-10s | %-5d | %-10s", visitor.getName(), visitor.getAge(), visitor.getPassType()));
        }
    }

    public void partFourB() {
        Employee operator = new Employee("David", 32, "E003", "Australia", "Male",
                "Ferris Wheel Operator", 52000, "Operations", "Night Shift", 
                true, 5);
        Ride ferrisWheel = new Ride("Giant Wheel", 110, operator, 4);

        Visitor v1 = new Visitor("Jack", 12, "V001", "USA", "Male", "Child Pass", false);
        Visitor v2 = new Visitor("Sharon", 25, "V002", "UK", "Female", "Season Pass", true);
        Visitor v3 = new Visitor("Benny", 65, "V003", "Japan", "Male", "Senior Pass", false);
        Visitor v4 = new Visitor("Leo", 35, "V004", "China", "Male", "VIP Pass", true);
        Visitor v5 = new Visitor("Mary", 28, "V005", "Germany", "Female", "Standard Pass", false);

        System.out.println("\n=== Add Visitors to History ===");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        System.out.println("\n=== History Before Sorting ===");
        ferrisWheel.printRideHistory();

        System.out.println("\n=== Executing Sort ===");
        ferrisWheel.sortVisitorHistory();

        System.out.println("\n=== History After Sorting ===");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        Employee operator = new Employee("John", 25, "E001", "Canada", "Male",
                "Ride Operator", 50000, "Operations", "Morning Shift", 
                true, 1);
        Ride rollerCoaster = new Ride("Roller Coaster", 140, operator, 4);

        Visitor[] visitors = {
            new Visitor("Jack", 20, "V001", "USA", "Male", "Regular", false),
            new Visitor("Sharon", 25, "V002", "UK", "Female", "VIP", true),
            new Visitor("Benny", 30, "V003", "Canada", "Male", "Regular", false),
            new Visitor("Leo", 35, "V004", "Australia", "Male", "Regular", false),
            new Visitor("Mary", 28, "V005", "France", "Female", "VIP", true),
            new Visitor("Tom", 22, "V006", "Germany", "Male", "Regular", false),
            new Visitor("Jerry", 27, "V007", "Spain", "Male", "VIP", true),
            new Visitor("Lucy", 31, "V008", "Italy", "Female", "Regular", false),
            new Visitor("Emma", 29, "V009", "Brazil", "Female", "Regular", false),
            new Visitor("Peter", 33, "V010", "Mexico", "Male", "VIP", true)
        };

        System.out.println("\n=== Adding 10 Visitors to Queue ===");
        for (Visitor visitor : visitors) {
            rollerCoaster.addVisitorToQueue(visitor);
        }

        System.out.println("\n=== Queue Status Before Operation ===");
        rollerCoaster.printQueue();

        System.out.println("\n=== Running One Cycle ===");
        rollerCoaster.runOneCycle();

        System.out.println("\n=== Queue Status After Operation ===");
        rollerCoaster.printQueue();

        System.out.println("\n=== View Ride History ===");
        rollerCoaster.printRideHistory();

        Ride brokenRide = new Ride("Broken Ride", 140, null, 4);
        brokenRide.addVisitorToQueue(visitors[0]);
        brokenRide.runOneCycle();

        Ride emptyRide = new Ride("Empty Ride", 140, operator, 4);
        emptyRide.runOneCycle();
    }

    public void partSix() {
        Employee operator = new Employee("John", 25, "E001", "USA", "Male",
                "Ride Operator", 50000, "Operations", "Morning Shift", 
                true, 1);
        Ride rollerCoaster = new Ride("Roller Coaster", 140, operator, 4);

        Visitor v1 = new Visitor("Jack", 20, "V001", "USA", "Male", "Regular", false);
        Visitor v2 = new Visitor("Sharon", 25, "V002", "UK", "Female", "VIP", true);
        Visitor v3 = new Visitor("Benny", 30, "V003", "Canada", "Male", "Regular", false);
        Visitor v4 = new Visitor("Leo", 35, "V004", "Australia", "Male", "Regular", false);
        Visitor v5 = new Visitor("Mary", 28, "V005", "France", "Female", "VIP", true);

        System.out.println("\n=== Adding Visitors to History ===");
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        System.out.println("\n=== History Before Export ===");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Exporting History to File ===");
        rollerCoaster.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        Ride rollerCoaster = new Ride("Roller Coaster", 140, null, 4);

        System.out.println("\n=== History Before Import ===");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Importing History from File ===");
        rollerCoaster.importRideHistory("ride_history.csv");

        System.out.println("\n=== History After Import ===");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Verify Imported Visitor Count ===");
        System.out.println("Number of visitors in history: " + rollerCoaster.numberOfVisitors());
    }
}
