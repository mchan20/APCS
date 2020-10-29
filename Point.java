public class Point{
  private double x,y;

  //construct a point given coordinates
  public Point(double X, double Y){
    x=X;
    y=Y;
  }

  //construct a point given a point  (redundant , just provides flexibility)
  public Point(Point p){
    x= p.x;  //private access in the same file is allowed!
    y= p.y;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    double xsquare = (x1-x2)*(x1-x2);
    double ysquare = (y1-y2)*(y1-y2);
    return Math.sqrt(xsquare+ysquare);
  }

  public double distanceTo(Point other){
    return distance(getX(),getY(),other.getX(),other.getY());
  }

  public boolean equals(Point other) {
    return ((getX() == other.getX()) && (getY() == other.getY()));
  }
}
