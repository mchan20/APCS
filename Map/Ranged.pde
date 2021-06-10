public class Ranged extends Tower {
  PImage thing,thing2,thing3;
  Ranged(float xloc, float yloc) {
    //atk, atkRng, atkSpd
    //atkRng is the radius! atkRng * 2 is what i should be using for ellipse generation (it is the major axis)
    super(5, 100,25,xloc,yloc);
    level = 1;
    price = priceRanged;
    thing = loadImage("Ranged.png");
    thing.resize(thing.width/4,thing.height/4);
    
    thing2 = loadImage("Ranged2.png");
    thing2.resize((int) (thing2.width/3.5),(int) (thing2.height/3.5));
    
    thing3 = loadImage("Ranged3.png");
    thing3.resize((int) (thing3.width/2),(int) (thing3.height/2));
  }
  
  void display(ArrayList<Tower> towers) {
    //rectMode(CORNER);
    //rect(xloc-48/2,yloc-17/2,49,17);
    textSize(15);
    imageMode(CENTER);
    if (level == 1) image(thing,xloc,yloc-10);
    else if (level == 2) image(thing2,xloc-5,yloc-10);
    else if (level == 3) image(thing3,xloc-5,yloc-10);
    noFill();
    text(atkcooldown,xloc-10,yloc+30);
    if (atkcooldown > 0) atkcooldown--;
    if (!selected(towers)) click();
    if (timer > 0) timer--;
  }
}
