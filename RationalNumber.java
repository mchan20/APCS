public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno) {
    super(0.0);
    if (deno < 0) {
      numerator = (-1 * nume);
      denominator = (-1 * deno);
    }
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else {
      numerator = nume;
      denominator = deno;
    }
    reduce();
  }

  public double getValue(){
    return (double) getNumerator() / (double) getDenominator();
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(getDenominator(),getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return ((getNumerator() == other.getNumerator()) && (getDenominator() == other.getDenominator()));
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return getNumerator() + "/" + getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    int newa = 0;
    int newb = 0;
    int r = 1;
    if ((a == 0) || (b == 0)) return 0;
    if (Math.abs(a) >= Math.abs(b)) {
      newa = Math.abs(a);
      newb = Math.abs(b);
    }
    else {
      newa = Math.abs(b);
      newb = Math.abs(a);
    }
    r = newa % newb;
    while (r > 0) {
      newa = newb;
      newb = r;
      r = newa % newb;
    }
    return newb;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int thing = gcd(getNumerator(),getDenominator());
    if (thing > 0) {
      numerator = numerator / thing;
      denominator = denominator/ thing;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getNumerator(),getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getDenominator(),getDenominator()*other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber((getNumerator()*other.getDenominator() + getDenominator()*other.getNumerator()), getDenominator()*other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */

  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(((getNumerator()*other.getDenominator()) - (getDenominator()*other.getNumerator())), getDenominator()*other.getDenominator());
  }
}
