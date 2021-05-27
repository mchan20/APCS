public class Enemy {
  int path,hp,atk,moneyDrop,step;
  Enemy(int path) { //these are temporary values
    this.path = path;
    hp = 10;
    atk = 5;
    moneyDrop = 5;
    step = 0;
  }
  
  void display(float x,float y) {
    fill(153);
    ellipse(x, y, 10, 10);
  }
  
  int getStep() {
    return step;
  }
  void move() {
    step++;
  }
}
