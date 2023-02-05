import java.util.*;
import java.io.*;
import java.util.Arrays;

public class MazeGenerator {
    private static boolean isSafe(char[][]maze,int rows,int cols) {
        int i = 0;
        if ((rows != 0) && (rows != maze.length-1) && (cols != 0) && (cols != maze[0].length-1)) {
            if (maze[rows+1][cols] == ' ') i++;
            if (maze[rows][cols-1] == ' ') i++;
            if (maze[rows][cols+1] == ' ') i++;
            if (maze[rows-1][cols] == ' ') i++;
            return (i < 2);
        }
        return false;
    }

    public static char[][] makeArray(int rows, int cols) {
        char[][] thing = new char[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                thing[i][j] = '#';
            }
        }
        return thing;
    }

    public static int getlength(String filename) throws FileNotFoundException{
        int count = 0;
        File text = new File(filename);

        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
            inf.nextLine();
            count++;
        }
        inf.close();
        return count;
    }

    public static char[][] readBoard(String filename) throws FileNotFoundException{
        int length = getlength(filename);
        int i = 0;
        char result[][] = new char[length][];
        File text = new File(filename);

        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
            String line = inf.nextLine();
            result[i] = line.toCharArray();
            i++;
        }
        inf.close();
        return result;
    }

    public static String toString(char[][] maze){
        return Arrays.deepToString(maze).replace("], ", "\n").replace("[", "").replace("]", "").replace(", ","");
    }

    public static void placeES(char[][] maze) {
        maze[1][1] = 'S';
        maze[maze.length-2][maze[0].length-2] = 'E';
    }

    public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol, int lala) {
        int a = 0;
        if (!isSafe(maze, startrow, startcol)) {
            return;
        }
        else {
            maze[startrow][startcol] = ' ';
            final ArrayList<Integer> thing = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
            Collections.shuffle(thing);
            for (int i=0;i<4;i++) {
                a = thing.get(i);
                if (a==0) {
                    if (isSafe(maze, startrow+1, startcol)) {
                        generate(maze, rows, cols, startrow+1,startcol,lala);
                    }
                }
                if (a==1) {
                    if (isSafe(maze, startrow-1, startcol)) {
                        generate(maze, rows, cols, startrow-1,startcol,lala);
                    }
                }
                if (a==2) {
                    if (isSafe(maze, startrow, startcol+1)) {
                        generate(maze, rows, cols, startrow,startcol+1,lala);
                    }
                }
                if (a==3) {
                    if (isSafe(maze, startrow, startcol-1)) {
                        generate(maze, rows, cols, startrow,startcol-1,lala);
                    }
                }
            }
        }
    }

    public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol) {
        generate(maze, rows, cols, startrow, startcol, 0);
        placeES(maze);
    }

    // public static void main(String[] args) throws FileNotFoundException {
    //     char[][] bruh = makeArray(10,7);
    //     System.out.println(toString(bruh));
    //     System.out.println();
    //     System.out.println();
    //     generate(bruh, 0, 0, 1, 1);
    //     System.out.println(toString(bruh));
    // }
}
