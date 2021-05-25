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
  for(int i = 0;i<10;i++) {
    dings.add(new Enemies()); //creating 10 enemies (kinda like that cow lab)
  }
}

void draw() {
  image(background,0,0);
  textSize(20);
  fill(0);
  text("money: "        + money + "\n" 
     + "numberKilled: " + numberKilled + "\n"
     + "waveNumber: "   + waveNumber,4,20);
  //for(Enemy a : dings) {
    
  //}
}
