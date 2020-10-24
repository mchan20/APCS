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
  public static  int sum(int[][] arr) {
    return sum(sumRows(arr));
  }

  public static int[] sumCols(int[][] matrix) {
    int numCols = matrix[0].length;
    int numRows = matrix.length;
    int[]thing = new int[numCols];
    for(int i = 0; i< numCols;i++) {
      for(int j = 0; j< numRows;j++) {
        thing[i] = thing[i] + matrix[j][i];
      }
    }
    return thing;
  }

  public static boolean isRowMagic(int[][] matrix) {
    int[]thing = sumRows(matrix);
    for(int i = 1; i<thing.length; i++) {
      if (thing[i] != thing[i-1]) return false;
    }
    return true;
  }

  public static boolean isColMagic(int[][] matrix) {
    int[]thing = sumCol(matrix);
    for(int i = 1; i<thing.length; i++) {
      if (thing[i] != thing[i-1]) return false;
    }
    return true;
  }
}
