package LMS;

import java.util.ArrayList;;

public class Patron extends Person {
    protected int curr_borrowed;

    public static int currID = 1; // current ID number. Increments by 1 on every new user

    public Patron(int id, String name, String address, int phone, int dob) {
        super(id, name, address, phone, dob);
        this.curr_borrowed = 0;
    }

    public void issueBook() {
        this.curr_borrowed++;
    }

    public void returnBook() {
        this.curr_borrowed--;
    }

    public void updBook(int borrowed) {
        this.curr_borrowed = borrowed;
    }

    public int getBookP() {
        return this.curr_borrowed;
    }

}
