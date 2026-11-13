import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
  Admin admin = new Admin();
  CustomerList customers = new CustomerList();

  public static void main (String[] args){
    new Bank();
  }// end main

  public Bank(){
    this.start();
  }// end constructor

  public String menu(){
    Scanner sc = new Scanner(System.in);
    String userInput;
    System.out.println("Bank Menu:");
    System.out.println();
    System.out.println("0) Quit");
    System.out.println("1) Login as Customer");
    System.out.println("2) Login as Admin");
    System.out.println();
    System.out.print("Actions - 0-2: ");
    userInput = sc.nextLine();
    System.out.println();
    return userInput;
  }// end menu

  public void start(){
    boolean keepGoing = true;
    String userChoice;
    while (keepGoing){
      userChoice = this.menu();
      if (userChoice.equals("0")){
        keepGoing = false;
        System.out.println("Goodbye....");
      } else if (userChoice.equals("1")){
        System.out.println("Entering Customer Login");
      } else if (userChoice.equals("2")){
        System.out.println("Entering Admin Login");
        this.startAdmin();
      } else {
        System.out.println("Error: Please enter only numbers from 0-2.");
      }// end if
    }// end while
  }// end start

  public void startAdmin(){
    if (this.admin.login()){
      
    }//end if
  }// end startAdmin

}// end Bank

class CustomerList extends ArrayList<Customer> {}
