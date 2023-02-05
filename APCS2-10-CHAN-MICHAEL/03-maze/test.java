import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class test {
    public static void main(String args[]) {
        Random rand = new Random();
        char[][] bruh = MazeGenerator.makeArray(rand.nextInt(20)+3, rand.nextInt(20)+3);
        MazeGenerator.generate(bruh, 0, 0, 1, 1);
        String lala = MazeGenerator.toString(bruh);
        try {
            FileWriter myWriter = new FileWriter("input.txt");
            myWriter.write(lala);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          try {
            Maze thing = new Maze("input.txt");
            System.out.println(thing.solve());
            System.out.println(thing.toString());
            } catch (FileNotFoundException e) {
                System.out.println("oops");
            }
    }
}
