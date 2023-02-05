public class Shaman extends Enemy {
  int cooldown;
  int abilityTimer;
  boolean healing;
  
  Shaman(int path,int spawntimer) {
    super(path,1,spawntimer);
    hp = 30;
    maxhp = 30;
    res = 85;
    abilityTimer = 50;
    cooldown = abilityTimer;
    thing = loadImage("shaman.png");
    thing.resize(thing.width/2,thing.height/2);
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
        if (healing) stroke(0,255,0);
        else stroke(255,0,0);
        noFill();
        ellipse(x, y, 50, 50);
        line(x-55,y,x+55,y);
        line(x,y-55,x,y+55);
        stroke(0);
      }
    }
    if (timer == 0) {
      splashTarget = false;
      healing = false;
    }
    damaged = false;
    text(hp,xloc+20,yloc-20);
    if (cooldown > 0) cooldown--;
    heal();
  }
  
  void heal() {
    if (cooldown == 0) {
      if (maxhp > hp) damage(-5);
      cooldown = abilityTimer;
      splashTarget = false;
      artTarget = false;
      healing = true;
    }
  }
}
