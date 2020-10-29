public class Triangle {
  //private varibles
  private Point v1, v2, v3;

  //constructors
  public Triangle(Point a, Point b, Point c) {
    v1 = a;
    v2 = b;
    v3 = c;
  }

   public Triangle(double x1, double y1,double x2, double y2,double x3, double y3) {
     v1 = new Point(x1,y1);
     v2 = new Point(x2,y2);
     v3 = new Point(x3,y3);
   }

   //methods
   public double getPerimeter() {
     double side1 = v1.distanceTo(v2);
     double side2 = v1.distanceTo(v3);
     double side3 = v2.distanceTo(v3);
     return (side1+side2+side3);
   }
}
