package LMS;

public class Clerk extends Staff {

    int desk_id; // desk Number of the Clerk
    public static int currdesk_id = 1;

    public Clerk(int id, String name, String address, int phone, int dob, double salary, int desk_id) // para
                                                                                                      // cons.
    {
        super(id, name, address, phone, dob, salary);

        if (desk_id == -1) {
            this.desk_id = currdesk_id;
            currdesk_id++;
        } else
            this.desk_id = desk_id;
    }

    public Clerk() {
        super();
    }

    public void printInfo() { // Method override
        super.printInfo();
        System.out.println("Desk Number: " + this.desk_id);
    }

    public int getDesk() {
        return this.desk_id;
    }

    public static int getCurrDesk() {
        return currdesk_id;
    }
}
