import java.util.*;

public class SavingsAccount extends CheckingAccount {
  double interestRate = .05d;

  public static void main (String[] args){
    SavingsAccount sv = new SavingsAccount();
    sv.start();
  }// end main

  public void setInterestRate(double interestRate){
    this.interestRate = interestRate;
  }// end setInterestRate
  
  public double getInterestRate(){
    return this.interestRate;
  }// end getInterestRate

  public void calcInterest(){
    double interestAmount = this.balance * this.interestRate;
    this.balance += interestAmount;
    System.out.println("New Balance: " + this.getBalanceString());
  }// end calcInterest
}// end SavingsAccount
