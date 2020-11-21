public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+getValue();
  }
  //---------ONLY EDIT BELOW THIS LINE------------

  /*
  *Return true when the values are within 0.001% of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    double difference = Math.abs(getValue() - other.getValue());
    if ((other.getValue() == 0) || (getValue() == 0)) {
      return ((other.getValue() == 0) && (getValue() == 0));
    }
    else {
      return ((difference / getValue()) <= 0.00001);
    }
  }

  /*
  *Return a new RealNumber that has the value of:
  *the sum of this and the other
  */
  public RealNumber add(RealNumber other){
    return new RealNumber(getValue() + other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *the product of this and the other
  */
  public RealNumber multiply(RealNumber other){
    return new RealNumber(getValue() * other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *this divided by the other
  */
  public RealNumber divide(RealNumber other){
    return new RealNumber(getValue() / other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *this minus the other
  */
  public RealNumber subtract(RealNumber other){
    return new RealNumber(getValue() - other.getValue());
  }
}
