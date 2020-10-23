public class Tester {
  public static void main(String[] args) {
    int[] arr0 = {1,2,3,4,5};
    int[] arr1 = {10, -2, -1, 2, 3};
    int[] arr2 = {410, -42, -1, 2, 3, 0, 0, 0, 12};

    //sum() test cases
    System.out.println(ArrayOps.sum(arr0));
    System.out.println(ArrayOps.sum(arr1));
    System.out.println(ArrayOps.sum(arr2));

    //sum() test cases
    System.out.println(ArrayOps.largest(arr0));
    System.out.println(ArrayOps.largest(arr1));
    System.out.println(ArrayOps.largest(arr2));


  }
}
