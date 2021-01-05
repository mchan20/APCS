import java.util.*;

public class PigLatin {
  public static String pigLatinSimple(String s){
    String temp = s.toLowerCase();
    String lala = "";
    if ((temp.charAt(0) == 'a') || (temp.charAt(0) == 'e') || (temp.charAt(0) == 'i') || (temp.charAt(0) == 'o') || (temp.charAt(0) == 'u')) {
      lala = temp + "hay";
    }
    else {
      lala = temp.substring(1,temp.length()) + temp.charAt(0) + "ay";
    }
    return lala;
  }

  public static String pigLatin(String s){
    String[] diagraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    boolean has = false;
    for (String item : diagraphs) {
      if (s.substring(0,2).equals(item)) {
        has = true;
      }
    }
    String temp = s.toLowerCase();
    String lala = "";
    if (has) {
      lala = temp.substring(2,temp.length()) + temp.substring(0,2) + "ay";
    }
    else if ((temp.charAt(0) == 'a') || (temp.charAt(0) == 'e') || (temp.charAt(0) == 'i') || (temp.charAt(0) == 'o') || (temp.charAt(0) == 'u')) {
      lala = temp + "hay";
    }
    else {
      lala = temp.substring(1,temp.length()) + temp.charAt(0) + "ay";
    }
    return lala;
  }

  public static String pigLatinBest(String s){
    String temp = s.toLowerCase();
    char last = temp.charAt(temp.length()-1);
    char first = temp.charAt(0);
    if (temp.length() < 2) {
      return temp + "hay";
    }
    if ((first < 97) || (first > 122)) {
      return temp;
    }
    else if ((last < 97) || (last > 122)) {
      return pigLatin(temp.substring(0,temp.length()-1)) + last;
    }
    else {
      return pigLatin(temp);
    }

  }

  public static void main( String[]args ){
    int count = 0;
    int ocount = 0;
    Scanner n = new Scanner( System.in );
    while (n.hasNextLine()) {
      ocount = 0;
      if (count > 0) System.out.println();
      Scanner thing = new Scanner( n.nextLine() );
      while (thing.hasNext()) {
        if (ocount > 0) System.out.print(" ");;
        String temp = thing.next();
        System.out.print(pigLatinBest(temp));
        ocount++;
      }
      count++;
    }
    System.out.println();
  }
}
