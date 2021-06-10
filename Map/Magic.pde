public class Magic extends Tower {
  int splashRange;
  PImage thing;
  Magic(float xloc, float yloc) {
    super(10, 100,50,xloc,yloc);
    //atk, atkRng, atkSpd
    level = 1;
    price = priceMagic;
    splashRange = 70;
    thing = loadImage("Magic.png");
    thing.resize(thing.width/4,thing.height/4);
  }
  
  void display(ArrayList<Tower> towers) {
    textSize(15);
    imageMode(CENTER);
    image(thing,xloc,yloc-10);
    noFill();
    text(atkcooldown,xloc-10,yloc+30);
    if (atkcooldown > 0) atkcooldown--;
    if (!selected(towers)) click();
    if (timer > 0) timer--;
  }
  
  void attack(ArrayList<Enemy> enemies) {
    for(int b=0;b<enemies.size();b++) {
      if (!enemies.get(b).getDead()) {
        if (dist(enemies.get(b).getxloc(),enemies.get(b).getyloc(),xloc,yloc) < atkRng) {
          if (atkcooldown == 0) {
            enemies.get(b).setSplash();
            for(int a=0;a<enemies.size();a++) {
              if (dist(enemies.get(b).getxloc(),enemies.get(b).getyloc(),enemies.get(a).getxloc(),enemies.get(a).getyloc()) < splashRange) {
                enemies.get(a).damage( (int) (atk*level * ((100 - enemies.get(a).getRes()) / 100.0)));
              }
            }
            atkcooldown = atkSpd;
            timer = 10;
          }
        }
      }    
    }
  }
}  
