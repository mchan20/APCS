public class Enemy {
  int path,hp,atk,moneyDrop,step,spd,timer;
  float xloc,yloc;
  boolean damaged,dead;
  Enemy(int path, int spd) { //these are temporary values
    this.path = path;
    hp = 50;
    atk = 5;
    moneyDrop = 5;
    step = 0;
    this.spd = spd;
    xloc = 0.0;
    yloc = 0.0;
  }
  
  void display(float x,float y) {
      if (damaged) {
        timer = 10;
      }
      if (timer>0) {
        //fill(255,0,0);
        ellipse(x, y, 10, 10);
        stroke(255,0,0);
        noFill();
        ellipse(x, y, 50, 50);
        line(x-55,y,x+55,y);
        line(x,y-55,x,y+55);
        stroke(0);
      }
      else {
        fill(0);
        ellipse(x, y, 10, 10);
      }
      damaged = false;
      text(hp /* + "\n" + xloc + "\n" + yloc + "\n"+ dist(xloc,yloc,247,323) */,xloc+20,yloc-20);
  }
  
  void damage(int num) {
    hp = hp - num;
    damaged = true;
  }
  
  // get methods for variables
  int getStep() {
    return step;
  }
  
  float getxloc() {
    return xloc;
  }
  
  float getyloc() {
    return yloc;
  }
  
  int getPath() {
    return path;
  }
  
  //movement code
  void move(ArrayList<Float> newCoords) {
    step = step + spd;
    if (((step*2)+1) < newCoords.size()-spd) {
      xloc = newCoords.get(getStep()*2);
      yloc = newCoords.get((getStep()*2)+1);
      display(xloc,yloc);
    }
    if (timer > 0) timer--;
  }
  
  //dying code
  void death(ArrayList<Enemy> enemies) {
    if (hp <= 0) {
      enemies.remove(this);
    }
  }
}
