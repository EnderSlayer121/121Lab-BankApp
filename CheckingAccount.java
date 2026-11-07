import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
  double balance;

  public static void main(String[] args){
    CheckingAccount ca = new CheckingAccount();
    ca.start();
  }// end main

  public CheckingAccount(){
    this.balance = 0d;
  }// end constructor v1

  public CheckingAccount(double balance){
    this.balance = balance;
  }// end constructor v2

  public String menu(){
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("0) Quit");
    System.out.println("1) Check Balance");
    System.out.println("2) Make a Deposit");
    System.out.println("3) Make a Withdrawal");
    System.out.println();
    System.out.print("Please Choose Between 0-3: ");
    String userChoice = sc.nextLine();
    System.out.println();
    return userChoice;
  }// end menu

  public void start(){
    boolean keepGoing = true;
    String response;
    while (keepGoing){
      response = menu();
      if (response.equals("0")){
        keepGoing = false;
      }
      else if (response.equals("1")){
        this.checkBalance();
      }
      else if (response.equals("2")){
        this.makeDeposit();
      }
      else if (response.equals("3")){
        this.makeWithdrawal();
      }
      else{
        System.out.println("Error: Invalid Input.");
      }// end if
    }//end while
  }// end start
  
  public double getBalance(){
    return this.balance;
  }// end getBalance

  public void setBalance(double balance){
    this.balance = balance;
  }// end setBalance

  public String getBalanceString(){
    String output = String.format("$%.02f", this.balance);
    return output;
  }//end getBalanceString

  private double getDouble(){
    Scanner sc = new Scanner(System.in);
    String outputString = sc.nextLine();
    double output = 0d;
    try{
      output = Double.parseDouble(outputString);
    }
    catch (Exception e){
      System.out.println("Not a legal input, changing to 0.");
      output = 0d;
    }// end try catch
    return output;
  }// getDouble

  public void checkBalance(){
    System.out.print("Current Balance: ");
    System.out.println(this.getBalanceString());
  }//end checkBalance

  public void makeDeposit(){
    System.out.print("How much to deposit? ");
    double deposit = this.getDouble();
    System.out.println();
    this.balance += deposit;
    System.out.print("New Balance: ");
    System.out.println(this.getBalanceString());
  }// end makeDeposit

  public void makeWithdrawal(){
    boolean keepGoing = true;
    double withdrawal = 0d;
    while (keepGoing){
      System.out.print("How much to withdrawal? ");
      withdrawal = this.getDouble();
      System.out.println();
      if (withdrawal >= 0d){
        keepGoing = false;
      } else {
        System.out.println("Error: Withdrawals cannot be a negative number.");
        System.out.println();
      }// end if
    }// end while
    this.balance -= withdrawal;
    System.out.print("New Balance: ");
    System.out.println(this.getBalanceString());
  }// end makeWithdrawal
}// end CheckingAccount
