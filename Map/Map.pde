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
  //for(Enemy a : dings) {
    
  //}
  noFill();
  curve(5, 26, 5, 26, 73, 24, 73, 61);
  curve(5, 26, 73, 24, 73, 61, 15, 65);
  fill(255);
  ellipseMode(CENTER);
  int steps = 6;
  for (int i = 0; i <= steps; i++) {
    float t = i / float(steps);
    float x = curvePoint(5, 5, 73, 73, t);
    float y = curvePoint(26, 26, 24, 61, t);
    ellipse(x, y, 5, 5);
    x = curvePoint(5, 73, 73, 15, t);
    y = curvePoint(26, 24, 61, 65, t);
    ellipse(x, y, 5, 5);
  }
}
