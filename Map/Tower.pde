public class Tower {
  int atk,level,price;
  float atkRng,atkSpd;
  float xloc, yloc;
  boolean selected;
  
  Tower(int atk, float atkRng, float atkSpd, float xloc, float yloc) {
    this.atk = atk;
    this.atkRng = atkRng;
    this.atkSpd = atkSpd;
    this.xloc = xloc;
    this.yloc = yloc;
    level = 0;
    price = 0;
  }
  
  void display() {
    // basically just displays an invisible ellipse at the marked locations
    fill(0);
    ellipse(xloc, yloc, 49,17);
    noFill();
    click();
    if (selected == true) selected();
  }
  
  void click(){
   if ((mousePressed) && (mouseButton == LEFT)) {
       if (inEllipse(mouseX,mouseY)) {
           selected = true;
       }
     }
   }
   
  
  void deselect() {
    selected = false;
  }
  
  void selected() {
    //menu box
    rectMode(CENTER);
    fill(95,85,85,191);
    rect(804/2,445/2,400,125);
    //upgrade button
    rect(804/2-120,253, 80,45);
    if (menuClick(804/2-120,253, 80,45)) {
      text("hi",804/2,445/2);
    }
    
    //sell button
    rect(804/2,253,80,45);
    //cancel button
    rect(803/2+120,253,80,45);
    
  }
  
  boolean menuClick(float x, float y, float rectwidth, float rectheight) {
    if ((mousePressed) && (mouseButton == LEFT)) {
       return ((mouseX > x-(rectwidth/2)) && (mouseX < x+(rectwidth/2)) && (mouseY > y-(rectheight/2)) && (mouseY < y+(rectheight/2)));
    }
    return false;
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
