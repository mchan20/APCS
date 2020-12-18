import java.util.Random;

public class Tester {
  public static String arrToString(int[]arr) {
    String result = "{";
    for(int i=0;i<arr.length;i++) {
      if (i != (arr.length-1)) {
        result = result + arr[i] + ", ";
      }
      else result = result + arr[i];
    }
    result = result + "}";
    return result;
  }

  public static void main(String[] args) {
    int[]arr0 = new int[100];
    int[]arr1 = new int[100];
    Random rng = new Random();
    for(int i =  0; i < 100; i++ ){
      arr0[i] = (rng.nextInt() % 1000);
      arr1[i] = (rng.nextInt() % 1000);
    }

    System.out.println(arrToString(arr0));
    System.out.println(arrToString(arr1));

    System.out.println("----------------------");
    // Sorts.bubbleSort(arr0);
    // Sorts.bubbleSort(arr1);
    Sorts.selectionSort(arr0);
    Sorts.selectionSort(arr1);
    System.out.println(arrToString(arr0));
    System.out.println(arrToString(arr1));
    System.out.println(Sorts.inOrder(arr0));
    System.out.println(Sorts.inOrder(arr1));
  }
}
