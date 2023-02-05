import java.util.*;
import java.io.*;
import java.util.Arrays;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.
        When the file is not found then:
            throw a FileNotFoundException

        You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
        '#' - Walls - locations that cannot be moved onto
        ' ' - Empty Space - locations that can be moved onto
        'E' - the location of the goal (exactly 1 per file)
        'S' - the location of the start(exactly 1 per file)

        You may also assume the maze has a border of '#' around the edges.
        So you don't have to check for out of bounds!
    */
    public Maze(String filename) throws FileNotFoundException{
        maze = readBoard(filename);
        // animate = true;
    }

    public static char[][] readBoard(String filename) throws FileNotFoundException {
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

    public static int getlength(String filename) throws FileNotFoundException {
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


    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public static void clearTerminal(){
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*Return the string that represents the maze.
        It should look like the text file with some characters replaced.
    */
    public String toString(){
        return Arrays.deepToString(maze).replace("], ", "\n").replace("[", "").replace("]", "").replace(", ","");
    }

    public int[] findS() {
        int[] thing = new int[2];
        for (int i=0;i<maze.length;i++) {
            for (int j=0;j<maze[0].length;j++) {
                if (maze[i][j] == 'S') {
                    thing[0] = i;
                    thing[1] = j; 
                }
            }
        }
        return thing;
    }

    /*Wrapper Solve Function returns the helper function
        Note the helper function has the same name, but different parameters.
        Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
        // only clear the terminal if you are running animation
        if(animate){
            clearTerminal();
        }
        int[] sCords = findS();
        return solve(sCords[0],sCords[1]);
        // return 0;
    }

    /*
        Recursive Solve function:

        A solved maze has a path marked with '@' from S to E.

        Returns the number of @ symbols from S to E when the maze is solved,
        Returns -1 when the maze has no solution.

        Postcondition:
        The 'S' is replaced with '@'
        The 'E' remain the same
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */

    public boolean ok(int a, int b) {
        return (maze[a][b] == ' ' || maze[a][b] == 'E');
    }

    public boolean okBack(int a, int b) {
        return (maze[a][b] == '@');
    }

    public int countAt() {
        int count = 0;
        for (int i=0;i<maze.length;i++) {
            for (int j=0;j<maze[0].length;j++) {
                if (maze[i][j] == '@') count++;
            }
        }
        return count;
    }

    private int solve(int row, int col){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(100);
        }
        if (maze[row][col] == 'E') return countAt();
        else {
            maze[row][col] = '@';
            if (ok(row+1,col)) {
                return solve(row+1,col);
            }
            if (ok(row,col+1)) {
                return solve(row,col+1);
            }
            if (ok(row-1,col)) {
                return solve(row-1,col);
            }
            if (ok(row,col-1)) {
                return solve(row,col-1);
            }
            else {
                maze[row][col] = '.';
                if (okBack(row+1,col)) {
                    return solve(row+1,col);
                }
                if (okBack(row,col+1)) {
                    return solve(row,col+1);
                }
                if (okBack(row-1,col)) {
                    return solve(row-1,col);
                }
                if (okBack(row,col-1)) {
                    return solve(row,col-1);
                } 
            }
        }
        return -1; //so it compiles
    }
    // public static void main(String[] args) {
    //     try {
    //         Maze thing = new Maze("input.txt");
    //         System.out.println(thing.solve());
    //         System.out.println(thing.toString());
    //     } catch (FileNotFoundException e) {
    //         System.out.println("oops");
    //     } 
    // }
}
