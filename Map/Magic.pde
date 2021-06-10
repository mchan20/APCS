public class Magic extends Tower {
  int splashRange;
  PImage thing,thing2,thing3;
  Magic(float xloc, float yloc) {
    super(10, 100,50,xloc,yloc);
    //atk, atkRng, atkSpd
    level = 1;
    price = priceMagic;
    splashRange = 70;
    thing = loadImage("Magic.png");
    thing.resize(thing.width/4,thing.height/4);
    
    thing2 = loadImage("Magic2.png");
    thing2.resize((int) (thing2.width/2),(int) (thing2.height/2));
    
    thing3 = loadImage("Magic3.png");
    thing3.resize((int) (thing3.width/2),(int) (thing3.height/2));
  }
  
  void display(ArrayList<Tower> towers) {
    textSize(15);
    imageMode(CENTER);
    if (level == 1) image(thing,xloc,yloc-10);
    else if (level == 2) image(thing2,xloc,yloc-10);
    else if (level == 3) image(thing3,xloc,yloc-10);
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
