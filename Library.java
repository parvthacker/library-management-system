
import LMS.Librarian;
import LMS.Clerk;
import LMS.Book;
import LMS.Loan;
import LMS.Patron;

import java.io.File;
import java.io.FileWriter;
import java.io.Console;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.awt.Desktop;

public class Library {

    public static void createEmptyLibrarian() {
        try {
            File myObj = new File("Librarian.csv");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("Librarian.csv");
                myWriter.write("ID,Password,Name,Address,Phone No.,DOB,Salary,Office ID\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
    }

    public static void createEmptyClerk() {
        try {
            File myObj = new File("Clerk.csv");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("Clerk.csv");
                myWriter.write("ID,Name,Address,Phone No.,DOB,Salary,Desk ID\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
    }

    public static void createEmptyLibrM() {
        // ------------------------ Create Patron Records -----------------------
        try {
            File myObj = new File("Patron.csv");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("Patron.csv");
                myWriter.write("ID, Name, Address,Phone No, DOB\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
        // ------------------------ Create Books Records -----------------------
        try {
            File myObj = new File("Books.csv");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("Books.csv");
                myWriter.write("ID, Author, Title, Genre or Subject\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
        // ------------------------ Create Loan Records -----------------------
        try {
            File myObj = new File("Loan.csv");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("Loan.csv");
                myWriter.write(
                        "Loan ID, Patron ID, Book ID, Issuer ID, Issue Date Time, Reciever ID, Return Date Time, Fine Amount, Fine Paid\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
        // ------------------------ Create State -----------------------
        try {
            File myObj = new File("State.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("State.txt");
                myWriter.write("1\n1\n1");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
        // ------------------------ Create StateB -----------------------
        try

        {
            File myObj = new File("StateB.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("StateB.txt");
                myWriter.write("1\n1");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
    }

    public static void pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }

    public static void clrscr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********************************************************");
        System.out.println("*                                                         *");
        System.out.println("*                Library Management System                *");
        System.out.println("*                                                         *");
        System.out.println("***********************************************************");

    }

    public static void createDefaultLogin() {
        try {
            File myObj = new File("Login.txt");
            if (myObj.createNewFile())
                ;
            FileWriter myWriter = new FileWriter("Login.txt");
            myWriter.write("admin");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
            System.out.print("\u001B[0m");// RESET COLOUR

            e.printStackTrace();
        }
    }

    public static boolean login(String password) {
        Console console = System.console();
        if (console == null) {
            System.out.println("\u001B[31m" + "\tCouldn't get Console instance");
            System.out.print("\u001B[0m");// RESET COLOUR
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("\tEnter password: ");
        String passwordIn = new String(passwordArray);

        if (password.equals(passwordIn))
            return true;
        else
            return false;
    }

    public static int login(int i) {

        String username = "", password = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter Username: ");
        String UsrIn = sc.nextLine();

        Console console = System.console();
        if (console == null) {
            System.out.println("\u001B[31m" + "\tCouldn't get Console instance");
            System.out.print("\u001B[0m");// RESET COLOUR
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("\tEnter password: ");
        String passwordIn = new String(passwordArray);

        File lbrDat = new File("Librarian.csv");
        try {
            Scanner lbrReader = new Scanner(lbrDat);
            while (lbrReader.hasNextLine()) {
                password = lbrReader.nextLine();
                password = password.replace("\n", "");
                String datArr[] = password.split(",");
                password = datArr[1];
                username = datArr[0];
                if (username.equals(UsrIn) && password.equals(passwordIn)) {
                    return Integer.parseInt(UsrIn);
                }

            }
            lbrReader.close();
        } catch (Exception c) {
            System.out.println("\u001B[31m" + "Error in librarian login file handling: " + c);
            System.out.print("\u001B[0m");// RESET COLOUR
        }
        return 0;
    }

    public static boolean admin() {

        createEmptyLibrarian(); // Create required empty
        createEmptyClerk(); // files if not present

        String name, address;
        int phone, dob, id;
        double salary;
        boolean flag = false, edited = false; // Flag flags errors, edited flags record not found for edit & remove.

        Scanner sc = new Scanner(System.in);

        // ----------------------- START OF LOGIN --------------------------
        createDefaultLogin();
        String password = "";

        File admDat = new File("Login.txt");
        try {
            Scanner admReader = new Scanner(admDat);
            password = admReader.nextLine();
            admReader.close();
        } catch (Exception c) {
            System.out.println("\u001B[31m" + "Error in admin login file handling: " + c);
            System.out.print("\u001B[0m");// RESET COLOUR
        }

        boolean valid = login(password);

        if (valid) {
            System.out.println("\u001B[92m" + "\tLogin Sucessful.");
            System.out.print("\u001B[0m");// RESET COLOUR

        } else {
            System.out.println("\u001B[31m" + "\tIncorrect Password.");
            System.out.print("\u001B[0m");// RESET COLOUR
            return false;
        }
        // ----------------------- END OF LOGIN --------------------------

        // ----------------------- START OF STATE --------------------------
        // Update Static variables to previous program state for auto-assign IDs

        try {
            try {
                File myObj = new File("State.txt");
                if (myObj.createNewFile()) {
                    FileWriter myWriter = new FileWriter("State.txt");
                    myWriter.write("1\n1\n1\n");
                    myWriter.close();
                }
            } catch (IOException e) {
                System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                System.out.print("\u001B[0m");// RESET COLOUR

                e.printStackTrace();
            }

            File myObj = new File("State.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine(); // CurrID - Person
            id = Integer.parseInt(data);
            Librarian.currID = id;

            data = myReader.nextLine(); // CurrID - Person
            id = Integer.parseInt(data);
            Librarian.currOffice_id = id;

            data = myReader.nextLine(); // CurrID - Person
            id = Integer.parseInt(data);
            Clerk.currdesk_id = id;

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // ----------------------- END OF STATE --------------------------

        // ----------------------- START OF MENU --------------------------
        boolean loopAdminMenu = true;
        while (loopAdminMenu) {
            clrscr();
            System.out.println("*                                                         *");
            System.out.println("*                        ADMIN MENU                       *");
            System.out.println("*                                                         *");
            System.out.println("*  Librarian                      Clerk                   *");
            System.out.println("*  1 --> Add                      2 --> Add               *");
            System.out.println("*  3 --> View All                 4 --> View All          *");
            System.out.println("*  5 --> Remove                   6 --> Remove            *");
            System.out.println("*  7 --> Edit                     8 --> Edit              *");
            System.out.println("*                 9 --> Logout                            *");
            System.out.println("*                10 --> Exit                              *");
            System.out.println("***********************************************************");

            int choiceAdminMenu = 0;

            try {
                choiceAdminMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "\n\tInvalid Input. Try again.");
                System.out.print("\u001B[0m");// RESET COLOUR
                pressEnterKeyToContinue();
                continue;
            }

            switch (choiceAdminMenu) {
                // ----------------------- Add Librarian --------------------------
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    address = sc.nextLine();
                    System.out.print("Enter Phone No: ");
                    phone = sc.nextInt();
                    System.out.print("Enter dob (YYYYMMDD): ");
                    dob = sc.nextInt();
                    System.out.print("Enter Salary: ");
                    salary = sc.nextDouble();

                    Librarian addLibr = new Librarian(-1, name, address, phone, dob, salary, -1);
                    addLibr.printInfo();

                    try {
                        FileWriter myWriter = new FileWriter("Librarian.csv", true);
                        myWriter.write(
                                addLibr.getID() + "," + addLibr.getPassword() + "," + addLibr.getName()
                                        + "," + addLibr.getAddress() + ","
                                        + addLibr.getPhoneNumber() + "," + addLibr.getDob() + ","
                                        + addLibr.getSalary() + "," + addLibr.getOffice() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred during adding Librarian.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessfully added.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;

                // ----------------------- Add Clerk --------------------------
                case 2:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    address = sc.nextLine();
                    System.out.print("Enter Phone No: ");
                    phone = sc.nextInt();
                    System.out.print("Enter dob (YYYYMMDD): ");
                    dob = sc.nextInt();
                    System.out.print("Enter Salary: ");
                    salary = sc.nextDouble();

                    Clerk addClk = new Clerk(-1, name, address, phone, dob, salary, -1);
                    addClk.printInfo();

                    try {
                        FileWriter myWriter = new FileWriter("Clerk.csv", true);
                        myWriter.write(
                                addClk.getID() + "," + addClk.getName() + "," + addClk.getAddress() + ","
                                        + addClk.getPhoneNumber() + "," + addClk.getDob() + ","
                                        + addClk.getSalary() + "," + addClk.getDesk() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred during adding Clerk.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessfully added.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }

                    pressEnterKeyToContinue();
                    break;

                // ----------------------- Open Librarian --------------------------
                case 3:
                    try {
                        File file = new File("librarian.csv");
                        if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or
                                                          // not
                        {
                            System.out.println("Option not supported");
                            break;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists()) // checks file exists or not
                            desktop.open(file); // opens the specified file
                    } catch (Exception e) {
                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessful.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    break;

                // ----------------------- Open Clerk --------------------------
                case 4:
                    try {
                        File file = new File("Clerk.csv");
                        if (!Desktop.isDesktopSupported()) {
                            System.out.println("Option not supported");
                            break;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists()) // checks file exists or not
                            desktop.open(file); // opens the specified file
                    } catch (Exception e) {
                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessful.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;

                // ----------------------- Remove Librarian --------------------------
                case 5:
                    try {
                        try {
                            File myObj = new File("Librarian2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Librarian2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Librarian2.csv", true);

                        System.out.print("Enter ID to remove: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Librarian.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");
                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                continue;
                            } else {
                                myWriter.write(data + "\n");
                            }

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Librarian.csv");
                        fileDel.delete();
                        File file = new File("Librarian2.csv");
                        File rename = new File("Librarian.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during removing Librarian.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully removed.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;
                // ----------------------- Remove Clerk --------------------------
                case 6:
                    try {
                        try {
                            File myObj = new File("Clerk2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Clerk2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Clerk2.csv", true);

                        System.out.print("Enter ID to remove: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Clerk.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");
                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                continue;
                            } else {
                                myWriter.write(data + "\n");
                            }

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Clerk.csv");
                        fileDel.delete();
                        File file = new File("Clerk2.csv");
                        File rename = new File("Clerk.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during removing Clerk.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully removed.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                // ----------------------- Edit Librarian --------------------------
                case 7:
                    try {
                        try {
                            File myObj = new File("Librarian2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Librarian2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Librarian2.csv", true);

                        System.out.print("Enter ID to edit: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Librarian.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");

                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                System.out.println("Enter blank to keep unchanged");
                                sc.nextLine();
                                System.out.print("Address: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[3] = name;
                                System.out.print("Phone: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[4] = name;
                                System.out.print("Salary: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[6] = name;
                                System.out.print("Password: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[1] = name;
                                System.out.print("Office: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[7] = name;

                                data = datArr[0] + "," + datArr[1] + "," + datArr[2] + "," + datArr[3] + ","
                                        + datArr[4] + "," + datArr[5] + "," + datArr[6] + "," + datArr[7];
                            }
                            myWriter.write(data + "\n");

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Librarian.csv");
                        fileDel.delete();
                        File file = new File("Librarian2.csv");
                        File rename = new File("Librarian.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during editing Librarian.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully edited.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                // ----------------------- Edit Clerk --------------------------
                case 8:
                    try {
                        try {
                            File myObj = new File("Clerk2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Clerk2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Clerk2.csv", true);

                        System.out.print("Enter ID to edit: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Clerk.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");

                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                System.out.println("Enter blank to keep unchanged");
                                sc.nextLine();
                                System.out.print("Address: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[2] = name;
                                System.out.print("Phone: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[3] = name;
                                System.out.print("Salary: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[5] = name;
                                System.out.print("Desk: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[6] = name;

                                data = datArr[0] + "," + datArr[1] + "," + datArr[2] + "," + datArr[3] + ","
                                        + datArr[4] + "," + datArr[5] + "," + datArr[6];
                            }
                            myWriter.write(data + "\n");

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Clerk.csv");
                        fileDel.delete();
                        File file = new File("Clerk2.csv");
                        File rename = new File("Clerk.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during editing Clerk.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully edited.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                // ----------------------- Return to Login Menu --------------------------
                case 9:
                    loopAdminMenu = false;
                    try {
                        File myObj = new File("State.txt");
                        if (myObj.createNewFile())
                            ;
                        FileWriter myWriter = new FileWriter("State.txt");
                        id = Librarian.getCurr();
                        myWriter.write(id + "\n");
                        id = Librarian.getCurrOffice();
                        myWriter.write(id + "\n");
                        id = Clerk.getCurrDesk();
                        myWriter.write(id + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    }
                    return false;

                // ----------------------- EXIT --------------------------
                case 10:
                    try {
                        File myObj = new File("State.txt");
                        if (myObj.createNewFile())
                            ;
                        FileWriter myWriter = new FileWriter("State.txt");
                        id = Librarian.getCurr();
                        myWriter.write(id + "\n");
                        id = Librarian.getCurrOffice();
                        myWriter.write(id + "\n");
                        id = Clerk.getCurrDesk();
                        myWriter.write(id + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    }
                    return true;

                // ----------------------- DEFAULT --------------------------
                default:
                    System.out.println("\u001B[31m" + "\tInvalid Input.");
                    System.out.print("\u001B[0m");// RESET COLOUR
                    pressEnterKeyToContinue();
                    break;

            }
        }
        return false;
    }

    public static boolean librM() {
        createEmptyLibrM(); // Create required empty files if not present
        createEmptyLibrarian();

        String name, address, genre;
        int phone, dob, id, issuerid, UsrID = 0;
        boolean flag = false, edited = false; // Flag flags errors, edited flags record not found for
                                              // edit & remove.

        Scanner sc = new Scanner(System.in);

        // ----------------------- START OF LOGIN --------------------------
        UsrID = login(1);

        if (UsrID != 0) {
            System.out.println("\u001B[92m" + "\tLogin Sucessful.");
            System.out.print("\u001B[0m");// RESET COLOUR

        } else {
            System.out.println("\u001B[31m" + "\tIncorrect Details.");
            System.out.print("\u001B[0m");// RESET COLOUR
            return false;
        }
        // ----------------------- END OF LOGIN --------------------------
        // ----------------------- START OF STATE --------------------------
        // Update Static variables to previous program state for auto-assign IDs

        try {
            try {
                File myObj = new File("State.txt");
                if (myObj.createNewFile()) {
                    FileWriter myWriter = new FileWriter("State.txt");
                    myWriter.write("1\n1\n1\n");
                    myWriter.close();
                }
            } catch (IOException e) {
                System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                System.out.print("\u001B[0m");// RESET COLOUR

                e.printStackTrace();
            }

            File myObj = new File("State.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine(); // CurrID - Person
            id = Integer.parseInt(data);
            Librarian.currID = id;

            data = myReader.nextLine(); // CurrID - Librarian Office
            id = Integer.parseInt(data);
            Librarian.currOffice_id = id;

            data = myReader.nextLine(); // CurrID - Clerk desk
            id = Integer.parseInt(data);
            Clerk.currdesk_id = id;

            myReader.close();

            File myObjB = new File("StateB.txt");
            Scanner myReaderB = new Scanner(myObjB);

            data = myReaderB.nextLine(); // CurrID - Book ID
            id = Integer.parseInt(data);
            Book.currBook_Id = id;

            data = myReaderB.nextLine(); // CurrID - Loan ID
            id = Integer.parseInt(data);
            Loan.currLoan_id = id;

            myReaderB.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // ----------------------- END OF STATE --------------------------
        // ----------------------- START OF MENU --------------------------
        boolean loopMenu = true;
        while (loopMenu) {
            clrscr();
            System.out.println("*                                                         *");
            System.out.println("*                      LIBRARIAN MENU                     *");
            System.out.println("*                                                         *");
            System.out.println("*   Patron                         Book                   *");
            System.out.println("*   1 --> Add                      2 --> Add              *");
            System.out.println("*   3 --> View All                 4 --> View All         *");
            System.out.println("*   5 --> Remove                   6 --> Remove           *");
            System.out.println("*   7 --> Edit                     8 --> Edit             *");
            System.out.println("*                                                         *");
            System.out.println("*   Issue & Return                 Exit                   *");
            System.out.println("*   9 --> Issue                   12 --> Logout           *");
            System.out.println("*  10 --> Recieve                 13 --> Exit             *");
            System.out.println("*  11 --> View All                                        *");
            System.out.println("***********************************************************");

            int choiceMenu = 0;

            try {
                choiceMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "\n\tInvalid Input. Try again.");
                System.out.print("\u001B[0m");// RESET COLOUR
                pressEnterKeyToContinue();
                continue;
            }

            switch (choiceMenu) {

                case 1: // ----------------------- Add Patron ------------------------
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    address = sc.nextLine();
                    System.out.print("Enter Phone No: ");
                    phone = sc.nextInt();
                    System.out.print("Enter dob (YYYYMMDD): ");
                    dob = sc.nextInt();

                    Patron addPatron = new Patron(-1, name, address, phone, dob);
                    addPatron.printInfo();

                    try {
                        FileWriter myWriter = new FileWriter("Patron.csv", true);
                        myWriter.write(
                                addPatron.getID() + "," + addPatron.getName()
                                        + "," + addPatron.getAddress() + ","
                                        + addPatron.getPhoneNumber() + "," + addPatron.getDob() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred during adding Patron.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessfully added.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;

                case 2: // ----------------------- Add Book --------------------------
                    sc.nextLine();
                    System.out.print("Enter Book ID (-1 to auto assign): ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Title: ");
                    address = sc.nextLine();
                    System.out.print("Enter Genre / Subject: ");
                    genre = sc.nextLine();

                    Book addBk = new Book(-1, name, address, genre);
                    addBk.printInfo();

                    try {
                        FileWriter myWriter = new FileWriter("Books.csv", true);
                        myWriter.write(
                                addBk.GetBookId() + "," + addBk.GetAuthor() + "," + addBk.GetTitle() + ","
                                        + addBk.GetSubject() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred during adding Book.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessfully added.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }

                    pressEnterKeyToContinue();
                    break;

                case 3: // ----------------------- View Patron -----------------------
                    try {
                        File file = new File("Patron.csv");
                        if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or
                                                          // not
                        {
                            System.out.println("Option not supported");
                            break;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists()) // checks file exists or not
                            desktop.open(file); // opens the specified file
                    } catch (Exception e) {
                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessful.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    break;

                case 4: // ----------------------- View Books ------------------------
                    try {
                        File file = new File("Books.csv");
                        if (!Desktop.isDesktopSupported()) {
                            System.out.println("Option not supported");
                            break;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists()) // checks file exists or not
                            desktop.open(file); // opens the specified file
                    } catch (Exception e) {
                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessful.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;

                case 5: // ----------------------- Remove Patron ---------------------
                    try {
                        try {
                            File myObj = new File("Patron2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Patron2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Patron2.csv", true);

                        System.out.print("Enter ID to remove: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Patron.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");
                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                continue;
                            } else {
                                myWriter.write(data + "\n");
                            }

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Patron.csv");
                        fileDel.delete();
                        File file = new File("Patron2.csv");
                        File rename = new File("Patron.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during removing Patron.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully removed.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;

                case 6: // ----------------------- Remove Books ----------------------
                    try {
                        try {
                            File myObj = new File("Books2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Books2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Books2.csv", true);

                        System.out.print("Enter ID to remove: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Books.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");
                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                continue;
                            } else {
                                myWriter.write(data + "\n");
                            }

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Books.csv");
                        fileDel.delete();
                        File file = new File("Books2.csv");
                        File rename = new File("Books.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during removing Book.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully removed.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                case 7: // ----------------------- Edit Patron -----------------------
                    try {
                        try {
                            File myObj = new File("Patron2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Patron2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Patron2.csv", true);

                        System.out.print("Enter ID to edit: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Patron.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");

                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                System.out.println("Enter blank to keep unchanged");
                                sc.nextLine();
                                System.out.print("Name: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[1] = name;
                                System.out.print("Address: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[2] = name;
                                System.out.print("Phone No: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[3] = name;
                                System.out.print("DOB: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[4] = name;

                                data = datArr[0] + "," + datArr[1] + "," + datArr[2] + "," + datArr[3] + ","
                                        + datArr[4];
                            }
                            myWriter.write(data + "\n");

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Patron.csv");
                        fileDel.delete();
                        File file = new File("Patron2.csv");
                        File rename = new File("Patron.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during editing Patron.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully edited.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                case 8: // ----------------------- Edit Book -------------------------
                    try {
                        try {
                            File myObj = new File("Books2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Books2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Books2.csv", true);

                        System.out.print("Enter ID to edit: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Books.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");

                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                System.out.println("Enter blank to keep unchanged");
                                sc.nextLine();
                                System.out.print("ID: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[0] = name;
                                System.out.print("Author: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[1] = name;
                                System.out.print("Title: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[2] = name;
                                System.out.print("Genre / Subject: ");
                                name = sc.nextLine();
                                if (!name.equals(""))
                                    datArr[3] = name;

                                data = datArr[0] + "," + datArr[1] + "," + datArr[2] + "," + datArr[3];
                            }
                            myWriter.write(data + "\n");

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Books.csv");
                        fileDel.delete();
                        File file = new File("Books2.csv");
                        File rename = new File("Books.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during editing Clerk.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully edited.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                case 9: // ----------------------- Issue Book ------------------------
                    sc.nextLine();
                    System.out.print("Patron ID: ");
                    id = sc.nextInt();
                    System.out.print("Book ID: ");
                    phone = sc.nextInt();

                    Loan issueBk = new Loan(id, phone, UsrID);
                    issueBk.printInfo();

                    try {
                        FileWriter myWriter = new FileWriter("Loan.csv", true);
                        myWriter.write(
                                issueBk.getLoan_id() + "," + issueBk.getPatron()
                                        + "," + issueBk.getBook() + ","
                                        + issueBk.getIssuer() + "," + issueBk.getIssue() + ",,,,\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred during adding Record.");
                        System.out.print("\u001B[0m");// RESET COLOUR
                        flag = true;
                        e.printStackTrace();
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessfully issued.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    pressEnterKeyToContinue();
                    break;
                case 11: // ----------------------- View Book -------------------------
                    try {
                        File file = new File("Loan.csv");
                        if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or
                                                          // not
                        {
                            System.out.println("Option not supported");
                            break;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists()) // checks file exists or not
                            desktop.open(file); // opens the specified file
                    } catch (Exception e) {
                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!flag) {
                            System.out.println("\u001B[92m" + "Sucessful.");
                            System.out.print("\u001B[0m");
                            flag = false;
                        }
                    }
                    break;
                case 10: // ----------------------- Return Book -----------------------
                    try {
                        try {
                            File myObj = new File("Loan2.csv");
                            if (myObj.createNewFile()) {
                                FileWriter myWriter = new FileWriter("Loan2.csv");
                                myWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                            System.out.print("\u001B[0m");// RESET COLOUR

                            e.printStackTrace();
                        }
                        FileWriter myWriter = new FileWriter("Loan2.csv", true);

                        System.out.print("Enter Loan ID to recieve: ");
                        int idRem = sc.nextInt();
                        File myObj = new File("Loan.csv");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            data = data.replace("\n", "");
                            String datArr[] = data.split(",");

                            if (datArr[0].equals(Integer.toString(idRem))) {
                                edited = true;
                                sc.nextLine();
                                id = Integer.parseInt(datArr[0]); // Loan ID
                                phone = Integer.parseInt(datArr[1]); // Patron ID
                                dob = Integer.parseInt(datArr[2]); // Book ID
                                issuerid = Integer.parseInt(datArr[3]); // Issuer ID
                                LocalDateTime temp = LocalDateTime.parse(datArr[4]);

                                Loan returnLoan = new Loan(id, phone, dob, issuerid, temp);
                                returnLoan.returnBook(UsrID);
                                System.out.print("Fine Paid (y/n): ");
                                String pay = sc.nextLine();
                                System.out.println("---" + pay + "---");
                                boolean paid = (pay == "y" || pay == "Y") ? true : false;
                                returnLoan.setFinePaid(paid);

                                data = returnLoan.getLoan_id() + "," + returnLoan.getPatron()
                                        + "," + returnLoan.getBook() + ","
                                        + returnLoan.getIssuer() + "," + returnLoan.getIssue() + "," +
                                        returnLoan.getReceiver() + "," + returnLoan.getReceive() + ","
                                        + returnLoan.getFine() + "," + returnLoan.getFinePaid();
                            }
                            myWriter.write(data + "\n");

                        }
                        myReader.close();
                        myWriter.close();

                        File fileDel = new File("Loan.csv");
                        fileDel.delete();
                        File file = new File("Loan2.csv");
                        File rename = new File("Loan.csv");
                        file.renameTo(rename);

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                        flag = true;
                    } catch (IOException e) {
                        System.out
                                .println("\u001B[31m" + "\n\tAn error occurred during editing Loan data.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                        flag = true;
                    } finally {
                        if (!edited) {
                            System.out.println("\u001B[31m" + "Not Found.");
                            System.out.print("\u001B[0m");// RESET COLOUR
                        }

                        else if (!flag && edited) {
                            System.out.println("\u001B[92m" + "Sucessfully recieved.");
                            System.out.print("\u001B[0m");
                            flag = false;
                            edited = false;
                        }
                    }
                    pressEnterKeyToContinue();

                    break;

                case 12: // ----------------------- Return to Login Menu --------------
                    loopMenu = false;
                    try {
                        File myObj = new File("State.txt");
                        if (myObj.createNewFile())
                            ;
                        FileWriter myWriter = new FileWriter("State.txt");
                        id = Librarian.getCurr();
                        myWriter.write(id + "\n");
                        id = Librarian.getCurrOffice();
                        myWriter.write(id + "\n");
                        id = Clerk.getCurrDesk();
                        myWriter.write(id + "\n");
                        myWriter.close();
                        File myObjB = new File("StateB.txt");
                        if (myObjB.createNewFile())
                            ;
                        FileWriter myWriterB = new FileWriter("StateB.txt");
                        id = Book.GetcurrBook();
                        myWriterB.write(id + "\n");
                        id = Loan.getCurrLoan();
                        myWriterB.write(id + "\n");
                        myWriterB.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    }
                    return false;

                case 13: // ----------------------- EXIT -----------------------------
                    try {
                        File myObj = new File("State.txt");
                        if (myObj.createNewFile())
                            ;
                        FileWriter myWriter = new FileWriter("State.txt");
                        id = Librarian.getCurr();
                        myWriter.write(id + "\n");
                        id = Librarian.getCurrOffice();
                        myWriter.write(id + "\n");
                        id = Clerk.getCurrDesk();
                        myWriter.write(id + "\n");
                        myWriter.close();
                        File myObjB = new File("StateB.txt");
                        if (myObjB.createNewFile())
                            ;
                        FileWriter myWriterB = new FileWriter("StateB.txt");
                        id = Book.GetcurrBook();
                        myWriterB.write(id + "\n");
                        id = Loan.getCurrLoan();
                        myWriterB.write(id + "\n");
                        myWriterB.close();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "\n\tAn error occurred. In Creating a file.");
                        System.out.print("\u001B[0m");// RESET COLOUR

                        e.printStackTrace();
                    }
                    return true;

                default: // ----------------------- DEFAULT --------------------------
                    System.out.println("\u001B[31m" + "\tInvalid Input.");
                    System.out.print("\u001B[0m");// RESET COLOUR
                    pressEnterKeyToContinue();
                    break;

            }
        }
        return false;
    }

    public static void main(String args[]) {

        boolean loop1 = true;
        while (loop1) {

            System.out.print("\u001B[0m");// RESET COLOUR

            clrscr();
            Scanner sc = new Scanner(System.in);
            System.out
                    .print("\u001B[36m"
                            + "\t2CS302 - OOP Innovative Assignment \n\t21BCE183 Parv Thacker\tSem 3 CSE C1");
            System.out.println("\u001B[0m" + "\n                           LOGIN\n");
            System.out.print("\t1.Librarian Login\n\t2.Administrative Login\n\t3.Exit\n\tEnter: ");
            int choice = 0;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "\n\tInvalid Input. Try again.");
                System.out.print("\u001B[0m");// RESET COLOUR
                pressEnterKeyToContinue();
                continue;
            }

            switch (choice) {

                case 1:
                    if (librM())
                        loop1 = false;
                    pressEnterKeyToContinue();
                    break;

                case 2:
                    if (admin())
                        loop1 = false;
                    pressEnterKeyToContinue();
                    break;

                case 3:
                    loop1 = false;
                    break;

                default:
                    System.out.println("\u001B[31m" + "\tInvalid Input.");
                    System.out.print("\u001B[0m");// RESET COLOUR
                    pressEnterKeyToContinue();
                    break;

            }
        }

    }

}
