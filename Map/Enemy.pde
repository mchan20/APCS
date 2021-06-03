public class Enemy {
  int path,hp,atk,moneyDrop,step,spd;
  float xloc,yloc;
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
    fill(153);
    ellipse(x, y, 10, 10);
    fill(0);
    text(hp + "\n" + xloc + "\n" + yloc + "\n"+ dist(xloc,yloc,247,323),xloc+20,yloc-20);
  }
  
  void damage(int num) {
    hp = hp - num;
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
  }
  
  //dying code
  void death(ArrayList<Enemy> enemies) {
    if (hp <= 0) enemies.remove(this);
  }
}
