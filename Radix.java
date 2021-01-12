public class Radix {
  public static int nth(int n, int col) {
    n = Math.abs(n);
    return ( n / (int) Math.pow(10,col) ) % 10;
  }

  public static int length(int n) {
    return 0;
  }

  public static void merge(MyLinkedList original,MyLinkedList[]buckets) {

  }
  public static void main(String[] args) {
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
  }
}
