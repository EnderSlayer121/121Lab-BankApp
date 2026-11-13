import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu, Serializable {
  
  public static void main(String[] args){
    Admin a = new Admin();
    a.login();
  }// end main, for testing only

  public Admin(){
    this.userName = "admin";
    this.PIN = "0000";
  }// end constructor

  public String menu(){
    Scanner sc = new Scanner(System.in);
    String userInput;
    System.out.println("Admin Menu:");
    System.out.println();
    System.out.println("0) Quit");
    System.out.println("1) Full Customer Report");
    System.out.println("2) Add User");
    System.out.println("3) Apply Interest to Savings Accounts");
    System.out.println();
    System.out.print("Actions - 0-3: ");
    userInput = sc.nextLine();
    System.out.println();
    return userInput;
  }// end menu

  public void start(){
 // thing, yeah... its in Bank.java bru.
  }// end start

  public String getReport(){
    String report = "Admin Username: " + this.getUserName();
    report += ", Admin Password: " + this.getPIN();
    return report;
  }//end getReport
}// end Admin
