public class Recursion {
  public static String reverse(String s) {
    if (s.length() < 1) return s;
    else {
      return reverse(s.substring(1)) + s.charAt(0);
    }
  }

  public static long countNoDoubleLetterWords(int length,String word) {
    long counter = 0;
    if (word.length() == length) {
      return 1;
    }
    for(char i='a'; i<='z';i++) {
      if (word.length() == 0 || word.charAt(0) != i){
        counter += countNoDoubleLetterWords(length, i + word);
      }
    }
    return counter;
  }

  public static double sqrt(double n){
    return sqrt(n, 1);
  }

  public static double sqrt(double n, double guess){
    double lala = ((n / guess) + guess) / 2;
    if (n == 0) return n;
    else if ((Math.abs((lala * lala) - n)/n) < 0.00001) return lala;
    else {
       return sqrt(n, lala);
    }
  }


  public static void main(String[] args) {
    System.out.println(countNoDoubleLetterWords(3,""));
    System.out.println(sqrt(0));
  }
}
