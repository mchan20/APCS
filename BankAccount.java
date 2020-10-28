public class BankAccount {
  private double balance;
  private int accountID;
  private String password;

  public BankAccount(int a,String p) {
    balance = 0;
    accountID = a;
    password = p;
  }

  public String getBal() {
    return ("Your Balance is: " + balance);
  }

  public String getaccountID() {
    return ("Your account ID is: " + accountID);
  }

  public String password(String newpassword) {
    password = newpassword;
    return "Your password has been changed.";
  }

  public boolean deposit(double amount){
    if (amount > 0) {
      balance = balance + amount;
      return true;
    }
    else return false;
  }
}
