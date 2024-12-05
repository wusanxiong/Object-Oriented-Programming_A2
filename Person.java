public abstract class Person {
    private String name;
    private int age;
    private String id;
    private String nationality;
    private String gender;

    // Default constructor
    public Person() {
        this.name = "";
        this.age = 0;
        this.id = "";
        this.nationality = "";
        this.gender = "";
    }

    // Parameterized constructor
    public Person(String name, int age, String id, String nationality, String gender) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.nationality = nationality;
        this.gender = gender;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
