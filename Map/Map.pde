PImage background;
int money;
int numberKilled;
int waveNumber;
ArrayList<Enemy> enemies;
ArrayList<Tower> towers;

void setup() {
  size(804,445); //size of image (will probably make slightly bigger)
  background = loadImage("lvl1layout.png");
  money = 0; 
  numberKilled = 0;
  waveNumber = 0;
  enemies = new ArrayList<Enemy>();
  towers = new ArrayList<Tower>();
  for(int i = 0;i<10;i++) {
    enemies.add(new Enemy(1,2)); //creating 10 enemies (kinda like that cow lab)
  }
  for(int i = 0;i<1;i++) {
    towers.add(new Tower(1,1.0,1.0,247,323)); //creating 10 enemies (kinda like that cow lab)
  }
  towers.add(new Ranged(247,323));
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
  Path path1 = new Path(1,0.3,new float[] 
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
  //path1.showPath();
  ArrayList <Float> newCoords = path1.splitPath();
  
  for(Enemy a : enemies) {
    a.move(newCoords);
  }
  for(Tower b : towers) {
    b.display();
  }
  money++;
}
