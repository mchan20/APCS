PImage background;
int money;
int numberKilled;
int waveNumber;
int timer;
int lives;
ArrayList<Enemy> enemies;
ArrayList<Tower> towers;
ArrayList<Enemy> unkilled;
boolean pause;
int enemyCount;

void setup() {
  size(804,445); //size of image (will probably make slightly bigger)
  background = loadImage("lvl1layout.png");
  money = 1000; 
  numberKilled = 0;
  waveNumber = 0;
  enemies = new ArrayList<Enemy>();
  towers = new ArrayList<Tower>();
  unkilled = new ArrayList<Enemy>();
  
  // add all enemies
  for(int i = 0;i<3;i++) {
     enemies.add(new Enemy(1,2,i*40));
  }
  enemies.add(new Enemy(2,2,4));
  
  for(int i = 0;i<3;i++) {
     enemies.add(new Enemy(2,2,300+i*40));
  }
  
  for(int i = 0;i<3;i++) {
     enemies.add(new Enemy(1,2,600+i*40));
  }
  
  for(int i = 0;i<4;i++) {
     enemies.add(new Enemy(2,2,600+i*40)); 
  }
  
  //add all towers
  towers.add(new Tower(1,1.0,1,247,323));
  towers.add(new Tower(1,1.0,1,321,321));
  towers.add(new Tower(1,1.0,1,390,321));
  towers.add(new Tower(1,1.0,1,454,291));
  
  towers.add(new Tower(1,1.0,1,354,217));
  towers.add(new Tower(1,1.0,1,283,217));
  towers.add(new Tower(1,1.0,1,210,217));
  
  towers.add(new Tower(1,1.0,1,390,110));
  towers.add(new Tower(1,1.0,1,318,110));
  towers.add(new Tower(1,1.0,1,251,110));
  
  towers.add(new Tower(1,1.0,1,427,65));
  
  towers.add(new Tower(1,1.0,1,488,214));
  towers.add(new Tower(1,1.0,1,551,214));
  
  towers.add(new Tower(1,1.0,1,561,356));
  
  timer = frameCount;
  pause = true;
  enemyCount = enemies.size();
}

void draw() {
  imageMode(CORNER);
  image(background,0,0);
  textSize(20);
  fill(0);
  textAlign(LEFT);
  text("money: "        + money + "\n" 
     + "numberKilled: " + numberKilled + "\n"
     + "lives: "   + lives + "\n"
     + "time: "   + timer,4,20);
  //for pathing purposes
  fill(0);
  text("X: " + mouseX + "\n" 
     + "Y: " + mouseY,4,410);
  Path path1 = new Path(1,0.75,new float[] 
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
   Path path2 = new Path(2,0.75,new float[] 
  {797,412,
   522,412,
   486,367,
   504,329,
   616,254,
   584,171,
   419,171,
   211,165,
   178,117,
   201,57,
   352,57,
   372,8});
  //path2.showPath();
  ArrayList <Float> newCoords = path1.splitPath();
  ArrayList <Float> newCoords2 = path2.splitPath();

  if (pause == true) {
    for(int a=0;a<enemies.size();a++) {
      if (enemies.get(a).getPath() == 1) enemies.get(a).move(newCoords);
      else enemies.get(a).move(newCoords2);
      finish(newCoords,enemies.get(a));
      enemies.get(a).death(enemies);
      numberKilled = enemyCount - enemies.size();

    }
    
    for(int b=0;b<towers.size();b++) {
      towers.get(b).display(towers);
      money = money - towers.get(b).selection(towers, money);
      towers.get(b).attack(enemies);
    }
  }
  money++;
  timer = frameCount / 60;
  lives = 5 - unkilled.size();
  winlose();
}

void pause() {
  if (keyPressed) {
      if (key == 'a') {
        pause = false;
      }
  }
}

void unpause() {
  if (keyPressed) {
      if (key == 's') {
        pause = true;
      }
  }
}

void finish(ArrayList<Float> coords, Enemy a) {
  if ((a.getxloc() == coords.get(coords.size()-4) && a.getyloc() == coords.get(coords.size()-3)) && (a.getDead() == false)) {
    enemies.remove(a);
    unkilled.add(a);
  }
}

void winlose() {
  if (lives == 0) {
    fill(100);
    rectMode(CENTER);
    rect(804/2,445/2,400,125);
    textAlign(CENTER);
    textSize(40);
    fill(0);
    text("YOU LOSE",804/2,445/2);
  }
  else if (numberKilled == enemyCount) {
    fill(100);
    rectMode(CENTER);
    rect(804/2,445/2,400,125);
    textAlign(CENTER);
    textSize(40);
    fill(0);
    text("YOU WIN",804/2,445/2);
  }
}
