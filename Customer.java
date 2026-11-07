import java.util.*;
import java.io.*;

public class Customer extends User {
  CheckingAccount checking = new CheckingAccount();
  SavingsAccount savings = new SavingsAccount();

  public static void main (String[] args){
    Customer c = new Customer();
    if (c.login()){
      c.start();
    }//end if
  }// end main

  public Customer(){
    this.userName = "Alice";
    this.PIN = "1111";
  }// end Constructor

  public Customer(String userName, String PIN){
    this.userName = userName;
    this.PIN = PIN;
  }// end Constructor Alt

  public String getReport(){
    String report = "User: " + this.getUserName();
    report += ", Checking: " + this.checking.getBalanceString();
    report += ", Savings: " + this.savings.getBalanceString();
    return report;
  }// end getReport

  public void start(){
    boolean keepGoing = true;
    String userChoice;
    while(keepGoing){
      userChoice = this.menu();
      if (userChoice.equals("0")){
        keepGoing = false;
        System.out.println("Have a nice day.....");
      } else if (userChoice.equals("1")){
        System.out.println("Checking Account: ");
        this.checking.start();
      } else if (userChoice.equals("2")){
        System.out.println("Savings Account: ");
        this.savings.start();
      } 
        else if (userChoice.equals("3")){
          System.out.println("Change Your PIN: ");
          this.changePIN();
      } else {
        System.out.println("Please enter only numbers from 0-3.");
      }//end if
    }// end while
  }// end start

  public String menu(){
    Scanner sc = new Scanner(System.in);
    String userInput;
    System.out.println("Customer Menu:");
    System.out.println();
    System.out.println("0) Quit");
    System.out.println("1) Manage Checking Account");
    System.out.println("2) Manage Savings Account");
    System.out.println("3) Change PIN");
    System.out.println();
    System.out.print("Actions - 0-3: ");
    userInput = sc.nextLine();
    System.out.println();
    return userInput;
  }//end menu

  public void changePIN(){
    Scanner sc = new Scanner(System.in);
    String newPin;
    System.out.println();
    System.out.print("Please enter a new 4 digit PIN.");
    newPin = sc.nextLine();
    System.out.println();
    this.setPIN(newPin);
    System.out.println("New PIN is " + this.getPIN());
    System.out.println();
  }// end changePIN
}// end customer
