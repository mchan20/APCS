public class Enemy {
  int path,hp,atk,moneyDrop,step,spd,timer,spawnTimer;
  float xloc,yloc;
  boolean damaged,dead,splashTarget,artTarget;
  PImage thing,explosion;
  Enemy(int path, int spd,int spawnTimer) { //these are temporary values
    this.path = path;
    hp = 50;
    atk = 5;
    moneyDrop = 5;
    step = 0;
    this.spd = spd;
    xloc = 0.0;
    yloc = 0.0;
    this.spawnTimer = spawnTimer;
    dead = false;
    if (path == 1) thing = loadImage("wulf.png");
    else thing = loadImage("wulf2.png");
    thing.resize(thing.width/4,thing.height/4);
    explosion = loadImage("explosion.png");
    explosion.resize(explosion.width/8,explosion.height/8);
  }
  
  void display(float x,float y) {
    imageMode(CENTER);
    image(thing,xloc,yloc-10);
    if (damaged) {
      timer = 10;
    }
    if (timer>0) {
      if (splashTarget) {
        stroke(0,0,255);
        noFill();
        ellipse(x, y, 140, 140);
      }
      if (artTarget) {
        image(explosion, xloc,yloc);
      }
      else {
        stroke(255,0,0);
        noFill();
        ellipse(x, y, 50, 50);
        line(x-55,y,x+55,y);
        line(x,y-55,x,y+55);
        stroke(0);
      }
    }
    if (timer == 0) {
      splashTarget = false;
    }
    damaged = false;
    text(hp,xloc+20,yloc-20);
  }
  
  void setSplash() {
    splashTarget = true;
  }
  
  void setArtillery() {
    artTarget = true;
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
  
  boolean getDead() {
    return dead;
  }
  
  //movement code
  void move(ArrayList<Float> newCoords) {
    if (frameCount >= spawnTimer) {
      step = step + spd;
      if (((step*2)+1) < newCoords.size()-spd) {
        xloc = newCoords.get(getStep()*2);
        yloc = newCoords.get((getStep()*2)+1);
        display(xloc,yloc);
      }
      if (timer > 0) timer--;
    }
  }
  
  //dying code
  void death(ArrayList<Enemy> enemies) {
    if (hp <= 0) {
      enemies.remove(this);
      dead = true;
    }
  }
}
