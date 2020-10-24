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

  public static int[] sumRows(int[][] matrix) {
    int[]thing = new int[matrix.length];
    for(int i = 0; i< matrix.length;i++) {
      thing[i] = sum(matrix[i]);
    }
    return thing;
  }

  public static  int[] largestInRows(int[][] matrix) {
    int[]thing = new int[matrix.length];
    for(int i = 0; i< matrix.length;i++) {
      thing[i] = largest(matrix[i]);
    }
    return thing;
  }
}
