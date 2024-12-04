public class Employee extends Person {
    private String position;
    private double salary;
    private String department;
    private String shiftTime;
    private boolean isFullTime;
    private int yearsOfService;

    public Employee() {
        super();
        this.position = "";
        this.salary = 0.0;
        this.department = "";
        this.shiftTime = "";
        this.isFullTime = true;
        this.yearsOfService = 0;
    }

    public Employee(String name, int age, String id, String nationality, String gender,
                   String position, double salary, String department, String shiftTime,
                   boolean isFullTime, int yearsOfService) {
        super(name, age, id, nationality, gender);
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.shiftTime = shiftTime;
        this.isFullTime = isFullTime;
        this.yearsOfService = yearsOfService;
    }

    // Getters and setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    // Calculate annual bonus based on years of service and performance
    public double calculateAnnualBonus() {
        double baseBonus = salary * 0.1;  
        double serviceBonus = yearsOfService * 1000; 
        return baseBonus + serviceBonus;
    }
}
