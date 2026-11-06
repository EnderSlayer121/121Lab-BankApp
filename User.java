import java.util.*;

abstract class User implements HasMenu, Serializable {
  String userName = "";
  String PIN = "";

  public boolean login(){
    Scanner sc = new Scanner(System.in);
    boolean success = false;
    System.out.print("User Name: ");
    String userNameIn = sc.nextLine();
    System.out.println();
    if (userNameIn.equals(this.userName)){
      SYstem.out.print("PIN: ");
      String PINIn = sc.nextLine();
      System.out.println();
      if (PINIn.equals(this.PIN)){
        System.out.println("Login Sucessful......");
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
    this.PIN = PIN;
  }// end setPIN

  public String getPIN(){
    return this.PIN;
  }// end getPIN

  public abstract String getReport(){
    
  }// end getReport

}// end user
