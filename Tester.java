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

  public static int[][] create2DArrayRandomized(int rows, int cols,int maxValue) {
    double r = 0;
    double thing = 0;
    int rand = 0;
    int[][]x = new int[rows][];
    for(int i = 0;i<rows;i++) {
      thing = Math.random();
      rand = (int) (thing * cols);
      x[i] = new int[rand+1];
      for(int j = 0;j<rand+1;j++) {
        r = Math.random();
        x[i][j] = (int) (r * maxValue);
      }
    }
    return x;
  }

  public static String arrayDeepToString(int[][]arr) {
    String result = "{";
    String realresult = "{";
    for(int i = 0;i<arr.length;i++) {
      result = "{";
      for(int j = 0;j<arr[i].length;j++) {
        if (j != (arr[i].length-1)) {
          result = result + arr[i][j] + ", ";
        }
        else result = result + arr[i][j];
      }
      result = result + "}";

      if (i != (arr.length-1)) {
        realresult = realresult + result + ", ";
      }
      else realresult = realresult + result;
    }
    return realresult + "}";
  }

  public static void main(String[] args) {
    int[] arr0 = {1,2,3,4,5};
    int[] arr1 = {10, -2, -1, 2, 3};
    int[] arr2 = {410, -42, -1, 2, 3, 0, 0, 0, 12};
    int[][]x = create2DArrayRandomized(2,4,10);
    int[][]y = create2DArrayRandomized(3,4,10);
    int[][]z = create2DArrayRandomized(4,4,10);
    
    //sum() test cases
    System.out.println(ArrayOps.sum(arr0));
    System.out.println(ArrayOps.sum(arr1));
    System.out.println(ArrayOps.sum(arr2));

    //largest() test cases
    System.out.println(ArrayOps.largest(arr0));
    System.out.println(ArrayOps.largest(arr1));
    System.out.println(ArrayOps.largest(arr2));

    //sumRows() test cases
    System.out.println(arrayDeepToString(x) + "       "  + arrToString(ArrayOps.sumRows(x)));
    System.out.println(arrayDeepToString(y) + "       "  + arrToString(ArrayOps.sumRows(y)));
    System.out.println(arrayDeepToString(z) + "       "  + arrToString(ArrayOps.sumRows(z)));

    //sum() (the 2d array one) test cases
    System.out.println(arrayDeepToString(x) + "       "  + ArrayOps.sum(x));
    System.out.println(arrayDeepToString(y) + "       "  + ArrayOps.sum(y));
    System.out.println(arrayDeepToString(z) + "       "  + ArrayOps.sum(z));


  }
}
