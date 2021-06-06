public class Ranged extends Tower {
  PImage thing;
  Ranged(float xloc, float yloc) {
    //atk, atkRng, atkSpd
    //atkRng is the radius! atkRng * 2 is what i should be using for ellipse generation (it is the major axis)
    super(5, 100,25,xloc,yloc);
    level = 1;
    price = priceRanged;
    thing = loadImage("Ranged.png");
    thing.resize(thing.width/4,thing.height/4);
  }
  
  void display(ArrayList<Tower> towers) {
    //rectMode(CORNER);
    //rect(xloc-48/2,yloc-17/2,49,17);
    textSize(15);
    imageMode(CENTER);
    image(thing,xloc,yloc-10);
    noFill();
    text(atkcooldown,xloc-10,yloc+30);
    if (atkcooldown > 0) atkcooldown--;
    if (!selected(towers)) click();
    if (timer > 0) timer--;
  }
}
