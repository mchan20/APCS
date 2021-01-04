import java.util.*;

public class MakeStars {
  public static void main( String[]args ){
    int count = 0;
    Scanner n = new Scanner( System.in );
    //use hasNextLine()/nextLine() to loop over
    //all of the data

    //If you want to read the input word by word
    //this can be replaced with hasNext() and next()
    while (n.hasNextLine()) {
      if (count > 0) System.out.println();
      Scanner thing = new Scanner( n.nextLine() );
      while (thing.hasNext()) {
        String temp = thing.next();
        for(int i=0;i<temp.length();i++) {
          System.out.print("*");
        }
        System.out.print(" ");
      }
      count++;
    }
  }
}
