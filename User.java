import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {
  String userName = "";
  String PIN = "";

  public boolean login(){
    Scanner sc = new Scanner(System.in);
    boolean success = false;
    System.out.print("User Name: ");
    String userNameIn = sc.nextLine();
    if (userNameIn.equals(this.userName)){
      System.out.print("PIN: ");
      String PINIn = sc.nextLine();
      System.out.println();
      if (PINIn.equals(this.PIN)){
        System.out.println("Login Successful......");
	System.out.println();
        success = true;
      }
      else {
        System.out.println("Wrong PIN...");
      }//end if
    }
    else {
      System.out.println("Wrong User Name...");
    }// end if
    return success;
  }// end login

  public boolean login(String userName, String PIN){
    boolean success = false;
    if (userName.equals(this.userName)){
      if (PIN.equals(this.PIN)){
        System.out.println("Login Successful.......");
        success = true;
      }
      else {
        System.out.println("Wrong PIN...");
      }// end if
    }
    else {
      System.out.println("Wrong User Name...");
    }// end if
    return success;
  }// end login alt

  public void setUserName(String userName){
    this.userName = userName;
  }// end setUserName

  public String getUserName(){
    return this.userName;
  }// end getUserName

  public void setPIN(String PIN){
    if (PIN.matches("^\\d{4}$")){
      this.PIN = PIN;
    }
    else {
      System.out.println("PIN must be 4 digits...");
      System.out.println("Setting PIN to 0000...");
      this.PIN = "0000";
    }// end if
  }// end setPIN

  public String getPIN(){
    return this.PIN;
  }// end getPIN

  public abstract String getReport();

}// end user
