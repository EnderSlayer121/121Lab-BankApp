import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
  Admin admin = new Admin();
  CustomerList customers = new CustomerList();

  public static void main (String[] args){
    new Bank();
  }// end main

  public Bank(){
    //this.loadSampleCustomers();
    //this.saveCustomers();
    this.loadCustomers();
    this.start();
    this.saveCustomers();
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
        this.loginAsCustomer();
      } else if (userChoice.equals("2")){
        System.out.println("Entering Admin Login");
        if (this.admin.login()){
          this.startAdmin();
	}// end if
      } else {
        System.out.println("Error: Please enter only numbers from 0-2.");
      }// end if
    }// end while
  }// end start

  public void startAdmin(){
    boolean keepGoing = true;
    String userChoice;
    while (keepGoing){
      userChoice = this.admin.menu();
      if (userChoice.equals("0")){
        keepGoing = false;
      } else if (userChoice.equals("1")){
        System.out.println("Getting Report...");
        this.reportAllCustomers();
      } else if (userChoice.equals("2")){
        System.out.println("Adding Users....");
        this.addUser();
      } else if (userChoice.equals("3")){
        System.out.println("Applying interest.....");
        this.applyInterest();
      } else {
        System.out.println("Error: Please enter only numbers from 0-3.");
      }//end if
    }// end while
  }// end startAdmin

  public void loadSampleCustomers(){
    customers.add(new Customer("Alice", "1111"));
    customers.add(new Customer("Bob", "2222"));
    customers.add(new Customer("Cindy", "3333"));
    customers.add(new Customer("Mari", "0846"));
  }// end loadSampleCustomers

  public void reportAllCustomers(){
    for (Customer customer: customers){
      System.out.println(customer.getReport());
    }// end for
  }// end reportAllCustomers

  public void addUser(){
    Scanner sc = new Scanner(System.in);
    System.out.print("User Name: ");
    String userName = sc.nextLine();
    System.out.println();
    System.out.print("PIN: ");
    String PIN = sc.nextLine();
    System.out.println();
    customers.add(new Customer(userName, PIN));
  }// end addUser

  public void applyInterest(){
    for (Customer customer: customers){
      customer.savings.calcInterest();
    }// end for
  }// end applyInterest

  public void loginAsCustomer(){
    Scanner sc = new Scanner(System.in);
    System.out.print("User Name: ");
    String userNameIn = sc.nextLine();
    System.out.println();
    System.out.print("PIN: ");
    String PINIn = sc.nextLine();
    System.out.println();
    
    Customer currentCustomer = null;
    for (Customer customer: customers){
      if (customer.login(userNameIn, PINIn)){
        currentCustomer = customer;
      }// end if
    }// end for
    if (currentCustomer == null){
      System.out.println("Customer Not Found.");
    } else {
      currentCustomer.start();
    }// end if
  }// end loginAsCustomer

  public void saveCustomers(){
    try {
      FileOutputStream fout = new FileOutputStream("Customers.dat");
      ObjectOutputStream Oout = new ObjectOutputStream(fout);
      Oout.writeObject(customers);
      Oout.close();
      fout.close();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }// end try catch
  }// end saveCustomers

  public void loadCustomers(){
    try {
      FileInputStream fin = new FileInputStream("Customers.dat");
      ObjectInputStream Oin = new ObjectInputStream(fin);
      customers = (CustomerList)Oin.readObject();
      Oin.close();
      fin.close();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }// end try catch
  }// end loadCustomers

}// end Bank

class CustomerList extends ArrayList<Customer> {}
