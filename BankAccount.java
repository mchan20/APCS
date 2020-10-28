public class BankAccount {
  private double balance;
  private int accountID;
  private String password;

  public BankAccount(int a,String p) {
    balance = 0;
    accountID = a;
    password = p;
  }

  public double getBalance() {
    return (balance);
  }

  public String getAccountID() {
    return ("Your account ID is: " + accountID);
  }

  public void setPassword(String newPass){
    password = newPass;
  }

  public boolean deposit(double amount){
    if (amount > 0) {
      balance = balance + amount;
      return true;
    }
    else return false;
  }

   public boolean withdraw(double amount){
     double newbal = balance - amount;
     if ((amount >= 0) || (newbal >= 0)) {
       balance = newbal;
       return true;
     }
     else return false;
   }

   public String toString(){
     return (accountID + "\t" + balance);
   }
}
