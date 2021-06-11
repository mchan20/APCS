public class Artillery extends Tower {
  int splashRange;
  PImage thing,thing2,thing3;
  Artillery(float xloc, float yloc) {
    super(20, 100,150,xloc,yloc);
    //atk, atkRng, atkSpd
    level = 1;
    price = priceArtillery;
    splashRange = 70;
    thing = loadImage("Artillery.png");
    thing.resize(thing.width,thing.height);
    
    thing2 = loadImage("Artillery2.png");
    thing2.resize((int) (thing2.width/1.75),(int) (thing2.height/1.75));
    
    thing3 = loadImage("Artillery3.png");
    thing3.resize((int) (thing3.width/2),(int) (thing3.height/2));
  }
  
  void display(ArrayList<Tower> towers) {
    textSize(15);
    imageMode(CENTER);
    if (level == 1) image(thing,xloc,yloc-5);
    else if (level == 2) image(thing2,xloc,yloc-10);
    else if (level == 3) image(thing3,xloc-5,yloc-10);
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
            enemies.get(b).setArtillery();
            for(int a=0;a<enemies.size();a++) {
              if (dist(enemies.get(b).getxloc(),enemies.get(b).getyloc(),enemies.get(a).getxloc(),enemies.get(a).getyloc()) < splashRange) {
                enemies.get(a).damage(atk*level - enemies.get(a).getDef());
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
