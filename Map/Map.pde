PImage background;
int money;
int numberKilled;
int waveNumber;
ArrayList<Enemy> dings;

void setup() {
  size(804,445); //size of image (will probably make slightly bigger)
  background = loadImage("lvl1layout.png");
  money = 0; 
  numberKilled = 0;
  waveNumber = 0;
  dings = new ArrayList<Enemy>();
  for(int i = 0;i<10;i++) {
    dings.add(new Enemy(1)); //creating 10 enemies (kinda like that cow lab)
  }
}

void draw() {
  image(background,0,0);
  textSize(20);
  fill(0);
  text("money: "        + money + "\n" 
     + "numberKilled: " + numberKilled + "\n"
     + "waveNumber: "   + waveNumber,4,20);
  //for pathing purposes
  fill(0);
  text("X: " + mouseX + "\n" 
     + "Y: " + mouseY,4,410);
  Path path1 = new Path(12,1,new float[] 
  {4,378,
   134,378,
   209,279,
   391,273,
   419,226,
   419,171,
   211,165,
   178,117,
   201,57,
   352,57,
   372,8});
  path1.showPath();
  ArrayList <Float> newCoords = path1.splitPath();
  
  for(Enemy a : dings) {
    if (((a.getStep()*2)+1) < newCoords.size()-1) {
      a.move();
      a.display(newCoords.get(a.getStep()*2),newCoords.get((a.getStep()*2)+1));
    }
  }
}
