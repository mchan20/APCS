PImage background;
int money,numberKilled,waveNumber,timer,lives;
ArrayList<Enemy> enemies;
ArrayList<Tower> towers;
ArrayList<Enemy> unkilled;
boolean pause,play,helpScreen,lose,win;
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
  play = false;
}

void draw() {
  if (!play) {
    if (helpScreen) {
      imageMode(CORNER);
      PImage startscreenbg = loadImage("startscreenbg.jpg");
      startscreenbg.resize(804,445);
      image(startscreenbg,0,0);
      textAlign(CENTER);
      textSize(40);
      text("How To Play",402,40);
      
      //guide body
      textAlign(CORNER);
      textSize(15);
      rectMode(CORNER);
      text("Kingdom Rush (or at least my version of it) is a simple tower defense game." + 
      "The main obective is to destroy all enemies before they can reach the defense point, you will lose lives if they pass through." + "\n" +
      "You get money passively and by killing enemies, you can use this money to then purchase towers." + "\n" +
      "Towers are divided into three classes. Ranged, Magic, and Artillery." + "\n" +
      "1. Ranged - fast attack speed, and single target attacks." + "\n" +
      "2. Magic - slower attack speed, but splash damage and ignore defense" + "\n" +
      "3. Artillery - slower attack speed, but high damage and splash" + "\n" +
      "Enemies have varying hp and defense stats." + "\n" +
      "Thats all there really is to it, and Have Fun!",80,50,600,600);
      
      
      //buttons
      rectMode(CENTER);
      fill(100);
      rect(352,340,60,40);
      textAlign(CENTER);
      fill(0);
      text("Play",352,340);
      
      fill(100);
      rect(452,340,60,40);
      textAlign(CENTER);
      fill(0);
      text("Back",452,340);
      
      //back and play button fxn
      if (menuClick(352,340,60,40)) {
        play = true;
      }
      else if (menuClick(452,340,60,40)) {
        helpScreen = true;
      }
      
    }
    else {
      startup();
    }
  }
  else {
    play();
  }
  if (lose) {
    imageMode(CORNER);
    image(background,0,0);
    fill(100);
    rectMode(CENTER);
    rect(804/2,445/2,400,125);
    textAlign(CENTER);
    textSize(40);
    fill(0);
    text("YOU LOSE",804/2,445/2);
  }
  if (win) {
    imageMode(CORNER);
    image(background,0,0);
    fill(100);
    rectMode(CENTER);
    rect(804/2,445/2,400,125);
    textAlign(CENTER);
    textSize(40);
    fill(0);
    text("YOU WIN",804/2,445/2);
  }
}

void startup() {
  imageMode(CORNER);
  //background graphics
  PImage startscreenbg = loadImage("startscreenbg.jpg");
  PImage KRlogo = loadImage("KRlogo.png");
  startscreenbg.resize(804,445);
  KRlogo.resize(KRlogo.width*7/8,KRlogo.height*7/8);
  image(startscreenbg,0,0);
  imageMode(CENTER);
  image(KRlogo,402,130);
  fill(255);
  textSize(30);
  textAlign(CORNER);
  text("but scuffed",402,200);
  
  //buttons to start game
  rectMode(CENTER);
  fill(100);
  rect(402,270,100,50);
  textAlign(CENTER);
  fill(0);
  text("Play",402,280);
  
  fill(100);
  rect(402,340,190,50);
  textAlign(CENTER);
  fill(0);
  text("How To Play",402,350);
  
  //code to make buttons work
  if (menuClick(402,270,100,50)) {
    play = true;
  }
  else if (menuClick(402,340,190,50)) {
    helpScreen = true;
  }
}

void play() {
  imageMode(CORNER);
  image(background,0,0);
  imageMode(CENTER);
  PImage objective = loadImage("objective.png");
  objective.resize(objective.width/24,objective.height/24);
  image(objective,372,15);
  imageMode(CORNER);
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
  Path path1 = new Path(1,2,new float[] 
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
   Path path2 = new Path(2,2,new float[] 
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
  if ((Math.abs(a.getxloc()- 372) < 2) && (Math.abs(a.getyloc() - 8) < 5) && (a.getDead() == false)) {
    enemies.remove(a);
    unkilled.add(a);
  }
}


boolean menuClick(float x, float y, float rectwidth, float rectheight) {
  //rectMode(CENTER);
  //rect(x,y,rectwidth,rectheight);
  if ((mousePressed) && (mouseButton == LEFT)) {
     return ((mouseX > x-(rectwidth/2)) && (mouseX < x+(rectwidth/2)) && (mouseY > y-(rectheight/2)) && (mouseY < y+(rectheight/2)));
  }
  return false;
} 

void winlose() {
  if (lives <= 0) {
    lose = true;
  }
  else if (numberKilled == enemyCount) {
    win = true;
  }
}
