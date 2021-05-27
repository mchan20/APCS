public class Enemy {
  int path,hp,atk,moneyDrop,step,spd;
  Enemy(int path, int spd) { //these are temporary values
    this.path = path;
    hp = 10;
    atk = 5;
    moneyDrop = 5;
    step = 0;
    this.spd = spd;
  }
  
  void display(float x,float y) {
    fill(153);
    ellipse(x, y, 10, 10);
  }
  
  int getStep() {
    return step;
  }
  void move(ArrayList<Float> newCoords) {
    step = step + spd;
    if (((step*2)+1) < newCoords.size()-spd) {
      display(newCoords.get(getStep()*2),newCoords.get((getStep()*2)+1));
    }
      
  }
}
