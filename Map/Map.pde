PImage background;
int money;
int numberKilled;
int waveNumber;
int timer;
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
  //for(int i = 0;i<1;i++) {
    towers.add(new Tower(1,1.0,1,247,323));
    //towers.add(new Tower(1,1.0,1.0,447,323));
  //}
  timer = frameCount;
}

void draw() {
  image(background,0,0);
  textSize(20);
  fill(0);
  textAlign(LEFT);
  text("money: "        + money + "\n" 
     + "numberKilled: " + numberKilled + "\n"
     + "waveNumber: "   + waveNumber + "\n"
     + "time: "   + timer,4,20);
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
  for(int b=0;b<towers.size();b++) {
    towers.get(b).display();
    money = money - towers.get(b).selection(towers, money);
    towers.get(b).attack(enemies);
  }
  money++;
  timer = frameCount / 60;
}
