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

  public static void main(String[] args) {
    BankAccount b1 =  new BankAccount(12,"yomama");
    System.out.println(b1.getBal());
  }
}
