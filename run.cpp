#include<iostream>
using namespace std;

int main(){
    system("cls");
    cout << "------------------------------Compiling Book.java---------------------------------"<< endl;
    system("javac -d . Book.java");
    cout << "------------------------------Compiling Person.java-------------------------------"<< endl;
    system("javac -d . Person.java");
    cout << "------------------------------Compiling Patron.java-------------------------------"<< endl;
    system("javac -d . Patron.java");
    cout << "------------------------------Compiling Staff.java--------------------------------"<< endl;
    system("javac -d . Staff.java");
    cout << "------------------------------Compiling Librarian.java----------------------------"<< endl;
    system("javac -d . Librarian.java");
    cout << "------------------------------Compiling Clerk.java--------------------------------"<< endl;
    system("javac -d . Clerk.java");
    cout << "------------------------------Compiling Loan.java---------------------------------"<< endl;
    system("javac -d . Loan.java");
    cout << "------------------------------Compiling Library.java------------------------------"<< endl;
    system("javac Library.java");
    cout << "------------------------------Running   Library.java------------------------------"<< endl;
    system("java Library");
    cout << "\n\n------------------------------         END        --------------------------------"<< endl;
    system("pause");

}