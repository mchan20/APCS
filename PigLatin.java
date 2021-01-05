import java.util.*;

public class PigLatin {
  public static String pigLatinSimple(String s){
    String temp = s;
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
    String temp = s;
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
    char last = s.charAt(s.length()-1);
    char first = s.charAt(0);
    if ((first < 97) || (first > 122)) {
      return s;
    }
    else if ((last < 97) || (last > 122)) {
      return pigLatin(s.substring(0,s.length()-1)) + last;
    }
    else {
      return pigLatin(s);
    }

  }

  public static void main(String[] args) {
    // System.out.println(pigLatinSimple("mock"));
    // System.out.println(pigLatinSimple("pie"));
    // System.out.println(pigLatinSimple("david"));
    // System.out.println(pigLatinSimple("aaron"));
    //
    // System.out.println(pigLatin("the"));
    // System.out.println(pigLatin("check"));
    // System.out.println(pigLatin("skee"));
    // System.out.println(pigLatin("emu"));
    // System.out.println(pigLatin("grade"));

    System.out.println(pigLatinBest("*emu"));
    System.out.println(pigLatinBest("4chan"));
    System.out.println(pigLatinBest("fish!"));
    System.out.println(pigLatinBest("fish"));
    System.out.println(pigLatinBest("the."));
    System.out.println(pigLatinBest("cat!"));
    System.out.println(pigLatinBest("amazing?"));
    System.out.println(pigLatinBest("apple%"));
  }
}
