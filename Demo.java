public class Demo {
  public static void main(String[] args) {
    if (args.length == 0) {
      for (int i = 1; i <= 5; i++) {
        for (int j = 5; j >= i; j--) {
          System.out.print(i+"");
        }
        System.out.println();
      }
    }
    else {
      int length = Integer.parseInt(args[0]);
      for (int i = 1; i <= length; i++) {
        for (int j = length; j >= i; j--) {
          System.out.print(i+"");
        }
        System.out.println();
      }
    }
  }
}
