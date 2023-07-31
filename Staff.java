package LMS;

public class Staff extends Person {
    protected double salary;

    public Staff(int id, String name, String address, int phone, int dob, double salary) {
        super(id, name, address, phone, dob);
        this.salary = salary;
    }

    public Staff() {
        super();
    }

    public void printInfo() { // Method Override
        super.printInfo();
        System.out.println("Salary: " + this.salary);
    }

    public double getSalary() {
        return this.salary;
    }
}