public class Tower {
  int atk;
  float atkRng,atkSpd;
  float xloc, yloc;
  
  Tower(int atk, float atkRng, float atkSpd, float xloc, float yloc) {
    this.atk = atk;
    this.atkRng = atkRng;
    this.atkSpd = atkSpd;
    this.xloc = xloc;
    this.yloc = yloc;
  }
  
  void display() {
    // basically just displays an invisible ellipse at the marked locations
    fill(0);
    ellipse(xloc, yloc, 49,17);
    noFill();
  }
}
