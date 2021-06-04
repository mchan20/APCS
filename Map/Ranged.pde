public class Ranged extends Tower {
  Ranged(float xloc, float yloc) {
    //atk, atkRng, atkSpd
    //atkRng is the radius! atkRng * 2 is what i should be using for ellipse generation (it is the major axis)
    super(5, 100,100,xloc,yloc);
    level = 1;
    price = priceRanged;
  }
  
  void display(ArrayList<Tower> towers) {
    //rectMode(CORNER);
    //rect(xloc-48/2,yloc-17/2,49,17);
    PImage thing = loadImage("Ranged.png");
    thing.resize(thing.width/4,thing.height/4);
    imageMode(CENTER);
    image(thing,xloc,yloc-10);
    noFill();
    text(atkcooldown,xloc+50,yloc);
    if (atkcooldown > 0) atkcooldown--;
    if (!selected(towers)) click();
    if (timer > 0) timer--;
  }
}
