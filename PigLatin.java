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

  public static void main(String[] args) {
    System.out.println(pigLatinSimple("mock"));
    System.out.println(pigLatinSimple("pie"));
    System.out.println(pigLatinSimple("david"));
    System.out.println(pigLatinSimple("aaron"));
  }
}
