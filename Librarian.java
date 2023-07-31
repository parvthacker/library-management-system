package LMS;

public class Librarian extends Staff {

    int office_id; // Office Number of the Librarian
    public static int currOffice_id = 1;

    public Librarian(int id, String name, String address, int phone, int dob, double salary, int office_id) // para
                                                                                                            // cons.
    {
        super(id, name, address, phone, dob, salary);

        if (office_id == -1) {
            this.office_id = currOffice_id;
            currOffice_id++;
        } else
            this.office_id = office_id;
    }

    public Librarian() {
        super();
    }

    public void printInfo() { // Method override
        super.printInfo();
        System.out.println("Office Number: " + this.office_id + "\n");
    }

    public int getOffice() {
        return this.office_id;
    }

    public static int getCurrOffice() {
        return currOffice_id;
    }
}
