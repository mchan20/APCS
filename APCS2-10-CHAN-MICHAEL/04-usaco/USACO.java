import java.util.Scanner; 
import java.io.*;
import java.util.Arrays;

public class USACO {
   //Two required Methods:

   public static int bronze(String filename) throws FileNotFoundException {
      int count = 0;
      int instructNum = 0;
      File input = new File(filename);
      Scanner sc = new Scanner(input);
      
      //first line parsing data, initializing 2d array
      Scanner firstLine = new Scanner(sc.nextLine());
      int R = firstLine.nextInt();
      int C = firstLine.nextInt();
      int E = firstLine.nextInt();
      int N = firstLine.nextInt();
      int[][] result = new int[R][C];
      int[][] instructions = new int[N][3];

      //2d array formation code, for lines 2 to R+1
      for (int i=0;i<R;i++) {
         Scanner line = new Scanner(sc.nextLine());
         while (line.hasNextInt()) {
            int elevation = line.nextInt();
            result[i][count] = elevation;
            count++;
         }
         count = 0;
      }
      
      //instruction parsing
      while(sc.hasNextLine()) {
         Scanner line = new Scanner(sc.nextLine());
         while (line.hasNextInt()) {
            int instruct = line.nextInt();
            instructions[instructNum][count] = instruct;
            count++;
         }
         count = 0;
         instructNum++;
      }
      sc.close();
      
      //actual solving
      for (int[] I : instructions) {
         //get instructions
         int R_s = I[0]-1;
         int C_s = I[1]-1;
         int D_s = I[2];

         //temp array to compare stuff
         int[][] temp = new int[3][3];

         //put values into temp array
         for (int i=R_s;i<R_s+3;i++) {
            for (int j=C_s;j<C_s+3;j++) {
               temp[i-R_s][j-C_s] = result[i][j];
            }
         }
         
         int max = findMax(temp);

         //change values
         for (int i=R_s;i<R_s+3;i++) {
            for (int j=C_s;j<C_s+3;j++) {
               int curr = result[i][j];
               if (curr >= max-D_s) {
                  result[i][j] = max-D_s;
               }
            }
         }
      }

      //calculate depths
      // for (int i=0;i<R;i++) {
      //    for (int j = 0;j<C;j++) {
      //       int curr = result[i][j];
      //       if ((E-curr) < 0) {
      //          result[i][j] = 0;
      //       }
      //       else {
      //          result[i][j] = E-curr;
      //       }
      //    }
      // }

      //find aggregated sum;
      int sum = 0;
      for (int i=0;i<R;i++) {
         for (int j = 0;j<C;j++) {
            int curr = result[i][j];
            if ((E-curr) > 0) {
               sum += (E-curr);
            }
         }
      }
      return (sum*72*72);
   }

   public static int findMax(int mat[][]) { 
      int maxElement = Integer.MIN_VALUE; 
      for (int i = 0; i < 3; i++) { 
         for (int j = 0; j < 3; j++) { 
            if (mat[i][j] > maxElement) { 
               maxElement = mat[i][j]; 
            } 
         } 
      } 
      return maxElement; 
   }

   public static long silver(String filename) throws FileNotFoundException {
      File input = new File(filename);
      Scanner sc = new Scanner(input);
      
      //first line parsing data, initializing 2d array
      Scanner firstLine = new Scanner(sc.nextLine());
      int N = firstLine.nextInt();
      int M = firstLine.nextInt();
      int T = firstLine.nextInt();
      char[][] pasture = new char[N][M];

      //2d array formation code, for lines 2 to R+1
      for (int i=0;i<N;i++) {
         String line = sc.nextLine();
         pasture[i] = line.toCharArray();
      }

      //getting coordinates for start and end
      Scanner lastLine = new Scanner(sc.nextLine());
      int R1 = lastLine.nextInt()-1;
      int C1 = lastLine.nextInt()-1;
      int R2 = lastLine.nextInt()-1;
      int C2 = lastLine.nextInt()-1;
      sc.close();

      //solving time
      int[][][] result = new int[2][N][M];
      result[0][R1][C1] = 1;
      result[1][R1][C1] = 1;
      for(int i=0;i<T;i++) {
         for (int j=0;j<N;j++) {
            for (int k=0;k<M;k++) {
               if (pasture[j][k] != '*') {
                  // adds together from adjacent squares
                  if ((j == 0) && (k == 0)) {
                     result[1][j][k] = result[0][j+1][k] + result[0][j][k+1];
                  }
                  else if ((j == 0) && (k == M-1)) {
                     result[1][j][k] = result[0][j+1][k] + result[0][j][k-1];
                  }
                  else if ((k == 0) && (j == N-1)) {
                     result[1][j][k] = result[0][j-1][k] + result[0][j][k+1];
                  }
                  else if (j == 0) {
                     result[1][j][k] = result[0][j+1][k] + result[0][j][k-1] + result[0][j][k+1];
                  }
                  else if (k == 0) {
                     result[1][j][k] = result[0][j+1][k] + result[0][j-1][k] + result[0][j][k+1];
                  }
                  else if ((j == N-1) && (k == M-1)) {
                     result[1][j][k] = result[0][j-1][k] + result[0][j][k-1];
                  }
                  else if (j == N-1) {
                     result[1][j][k] = result[0][j-1][k] + result[0][j][k-1] + result[0][j][k+1];
                  }
                  else if (k == M-1) {
                     result[1][j][k] = result[0][j-1][k] + result[0][j+1][k] + result[0][j][k-1];
                  }
                  else {
                     result[1][j][k] = result[0][j+1][k] + result[0][j-1][k] + result[0][j][k-1] + result[0][j][k+1];
                  }
               }
            }
         }
         result[0] = result[1];
         // System.out.println(toString(result[0]));
         // System.out.println();
         result[1] = new int[N][M];
      }
      return result[0][R2][C2];
   }

   public static String toString(char[][] arr){
      return Arrays.deepToString(arr).replace("], ", "\n").replace("[", "").replace("]", "").replace(", ","");
   }

   public static String toString(int[][] arr){
      return Arrays.deepToString(arr).replace("], ", "\n").replace("[", "").replace("]", "");
   }

   //Example Usage:
   // public static void main(String[] args) throws FileNotFoundException {
   //    // int ans = USACO.bronze("lake1.input");
   //    // long ans2 = USACO.silver("cowPath1.input");
   //    // System.out.println(bronze("imput.txt"));
   //    System.out.println(silver("imput.txt"));
   // }
}
