public class Magic extends Tower {
  int splashRange;
  Magic(float xloc, float yloc) {
    super(10, 100,50,xloc,yloc);
    //atk, atkRng, atkSpd
    level = 1;
    price = priceMagic;
    splashRange = 70;
  }
  
  void display(ArrayList<Tower> towers) {
    PImage thing = loadImage("Magic.png");
    thing.resize(thing.width/4,thing.height/4);
    imageMode(CENTER);
    image(thing,xloc,yloc-10);
    noFill();
    text(atkcooldown,xloc+50,yloc);
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
                enemies.get(a).damage(atk*level);
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
