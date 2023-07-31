package LMS;

public class Book {

    private int book_id;
    private String author;
    private String title;
    private String genreSub;

    public static int currBook_Id = 1; // current ID number. Increments by 1 on every new book

    public Book() {
        book_id = -1;
        author = "";
        title = "";
        genreSub = "";
    }

    public Book(int book_id, String author, String title, String subject) {

        if (book_id == -1) { // Book doesn't have ID
            this.book_id = currBook_Id;
            currBook_Id++;
        }

        else { // Book already has IDs
            this.book_id = book_id;
        }

        this.author = author;
        this.title = title;
        this.genreSub = subject;
    }

    // Set/Update Finctions
    public void SetBookId(int book_id) {
        this.book_id = book_id;
    }

    public void SetAuthor(String author) {
        this.author = author;
    }

    public void SetTitle(String title) {
        this.title = title;
    }

    public void SetSubject(String subject) {
        this.genreSub = subject;
    }

    // Get Functions
    public String GetTitle() {
        return this.title;
    }

    public String GetAuthor() {
        return this.author;
    }

    public int GetBookId() {
        return this.book_id;
    }

    public String GetSubject() {
        return this.genreSub;
    }

    public static int GetcurrBook() {
        return currBook_Id;
    }

    public void setcurrBook(int cBkIn) {
        currBook_Id = cBkIn;
    }

    public void printInfo() {
        System.out.println("*********************************");
        System.out.println("\nDetails Entered:");
        System.out.println("Book ID: " + this.book_id);
        System.out.println("Author: " + this.author);
        System.out.println("Title: " + this.title);
        System.out.println("Genre/Subject: " + this.genreSub);
    }
}
