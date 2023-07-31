package LMS;

public abstract class Person {
    protected int id;
    protected int dob;
    protected String password;
    protected String name;
    protected String address;
    protected int phoneNo;

    public static int currID = 1; // current ID number. Increments by 1 on every new user

    public Person(int id, String name, String address, int phone, int dob) { // Parameterized
                                                                             // Constructor

        if (id == -1) { // User doesn't have ID
            this.id = currID;
            currID++;
        }

        else { // User already has IDs
            this.id = id;
        }

        this.password = Integer.toString(this.id) + Integer.toString(dob);
        this.name = name;
        this.address = address;
        this.phoneNo = phone;
        this.dob = dob;
    }

    public Person() {
        ;
    }

    public void printInfo() {
        System.out.println("*********************************");
        System.out.println("\nDetails Entered:");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Phone No: " + this.phoneNo);
        // System.out.println("Password Generated.");
    }

    // Update Functions
    public void updAddress(String address) {
        this.address = address;
    }

    public void updPhone(int phone) {
        this.phoneNo = phone;
    }

    public void updName(String name) {
        this.name = name;
    }

    public void updPassword(String password) {
        this.password = password;
    }

    public void updDob(int dob) { // this will NOT update password.
        this.dob = dob;
    }

    // Get Functions
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhoneNumber() {
        return this.phoneNo;
    }

    public int getDob() {
        return this.dob;
    }

    public int getID() {
        return this.id;
    }

    public static int getCurr() {
        return currID;
    }

}
