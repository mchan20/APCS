public class ArrayOps {
  public static int sum(int[] arr) {
    int sum = 0;
    for(int i=0;i < arr.length;i++) {
      sum = sum + arr[i];
    }
    return sum;
  }

  public static  int largest(int[]arr) {
    int max = arr[0];
    for (int i=0; i<arr.length;i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

}
