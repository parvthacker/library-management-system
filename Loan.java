package LMS;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Loan {

    private int loan_id;
    public static int currLoan_id = 1;

    private int patron;
    private int book;
    private int issuer;
    private int receiver;
    private LocalDateTime issue;
    private LocalDateTime due;
    private LocalDateTime receive;
    private int fine;
    private boolean finePaid;

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static long loanDays = 14;
    public static long fineAmt = 5;
    private long overdue;

    public Loan(int id, int patron, int book, int issuer, LocalDateTime issue) {
        this.loan_id = id;
        this.patron = patron;
        this.book = book;
        this.issuer = issuer;
        this.issue = issue;
    }

    public Loan(int patron, int book, int issuer) {
        this.loan_id = currLoan_id++;
        this.patron = patron;
        this.book = book;
        this.issuer = issuer;
        LocalDateTime temp = LocalDateTime.now();
        this.issue = temp;

        due = issue.plusDays(loanDays);
        String formattedDate = due.format(myFormatObj);
        System.out.println("Due on " + formattedDate);
    }

    public void returnBook(int receiver) {
        this.receiver = receiver;
        LocalDateTime temp = LocalDateTime.now();
        this.receive = temp;

        Duration diff = Duration.between(issue, receive);
        System.out.println("Returned in " + diff.toDays() + "Days.");

        overdue = (diff.toDays() > loanDays) ? (diff.toDays() - loanDays) : 0;
        this.fine = (int) (fineAmt * overdue);
        System.out.println("Fine = " + this.fine);
    }

    public void printInfo() {
        System.out.println("\nLoan ID: " + this.loan_id);
        System.out.println("Patron ID: " + this.patron);
        System.out.println("Book ID: " + this.book);
        System.out.println("Issuer ID: " + this.issuer + "\n");
    }

    public int getPatron() {
        return this.patron;
    }

    public int getBook() {
        return this.book;
    }

    public int getIssuer() {
        return this.issuer;
    }

    public int getReceiver() {
        return this.receiver;
    }

    public LocalDateTime getIssue() {
        return this.issue;
    }

    public LocalDateTime getDue() {
        return this.due;
    }

    public LocalDateTime getReceive() {
        return this.receive;
    }

    public int getFine() {
        return this.fine;
    }

    public boolean getFinePaid() {
        return this.finePaid;
    }

    public int getLoan_id() {
        return this.loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public void setFinePaid(boolean finePaid) {
        this.finePaid = finePaid;
    }

    public static int getCurrLoan() {
        return currLoan_id;
    }

}