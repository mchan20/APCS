public class Demo {
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
  public static int[][] create2DArray(int rows, int cols,int maxValue) {
    double r = 0;
    int[][]x = new int[rows][cols];
    for(int i = 0;i<rows;i++) {
      for(int j = 0;j<cols;j++) {
        r = Math.random();
        x[i][j] = (int) (r * maxValue);
      }
    }
    return x;
  }

  public static void main(String[] args) {
    // if (args.length == 0) {
    //   for (int i = 1; i <= 5; i++) {
    //     for (int j = 5; j >= i; j--) {
    //       System.out.print(i+"");
    //     }
    //     System.out.println();
    //   }
    // }
    // else {
    //   int length = Integer.parseInt(args[0]);
    //   for (int i = 1; i <= length; i++) {
    //     for (int j = length; j >= i; j--) {
    //       System.out.print(i+"");
    //     }
    //     System.out.println();
    //   }
    // }
    System.out.println(arrayDeepToString(create2DArray(3,4,9)).replace("}, ","},\n "));
  }
}
