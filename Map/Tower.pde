public class Tower {
  int atk;
  float atkRng,atkSpd;
  float xloc, yloc;
  boolean selected;
  
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
    click();
    if (selected == true) text("hello", xloc + 50, yloc + 50);
  }
  
  void click(){
   if ((mousePressed) && (mouseButton == LEFT)) {
       if (inEllipse(mouseX,mouseY)) {
           selected = true;
       }
       else deselect();
     }
   }
  
  void deselect() {
    selected = false;
  }
  
  void selected() {
    
  }
  
  boolean inEllipse(float x, float y) {
    int result = 
    ((int)Math.pow((x - xloc), 2) / (int)Math.pow(49/2, 2)) 
  + ((int)Math.pow((y - yloc), 2) / (int)Math.pow(17/2, 2));
    return result <= 1;
  }
}

public class Ranged extends Tower {
  Ranged(float xloc, float yloc) {
    super(10, 1.0,1.0,xloc,yloc);
  }
  
  void display() {
    fill(0);
    rectMode(CORNER);
    rect(xloc-48/2,yloc-17/2,49,17);
  }
  
  
}
