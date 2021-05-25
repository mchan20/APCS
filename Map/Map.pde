PImage background;
int money;
int numberKilled;
int waveNumber;

void setup() {
  size(804,445);
  background = loadImage("lvl1layout.png");
  money = 0;
  numberKilled = 0;
  waveNumber = 0;
}

void draw() {
  image(background,0,0);
  textSize(20);
  fill(0);
  text("money: "        + money + "\n" 
     + "numberKilled: " + numberKilled + "\n"
     + "waveNumber: "   + waveNumber,4,20);
}
