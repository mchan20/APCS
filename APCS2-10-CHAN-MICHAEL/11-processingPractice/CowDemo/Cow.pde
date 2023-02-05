public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (selected && colliding) {
      x += dx*2;
      y += dy*2;
    }
    else {
      x += dx;
      y += dy; 
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    if (colliding) {
      fill(color(255, 0, 0,100));
    }
    else fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (selected) {
      textSize(20);
      text("\n\nDX: "+dx+"\nDY: "+dy,x + radius + 10,y - 65);
      ellipse(x - (radius/3), y - (radius/3), 10, 10);
      ellipse(x + (radius/3), y - (radius/3), 10, 10);
      arc(x,y,40,25,0,PI);
    }
  }
  
  void collide(ArrayList<Cow>others) {
    colliding = false;
    for (Cow thing : others) {
      if (!(thing.x == x) && !(thing.y == y)) {
        if (dist(thing.x,thing.y,x,y) < radius + thing.radius) {
          colliding = true;
        }
      }
    }
  }
 
  
  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (mousePressed) {
     if (mouseButton == LEFT) {
       if (dist(x,y,mouseX,mouseY) < radius) {
         if (selected == true) selected = false;
         else {
           selected = true;
           c = color(random(255),random(255),random(255));
         }
       }
     }
   }
  }
  
  void turn (float angle) {
    if (keyPressed) {
      if (key == 'a') {
        angle = (angle / 180) * PI;
        float thing = atan2(dy,dx);
        float mag = sqrt(sq(dx) + sq(dy));
        dx = mag * cos(angle + thing);
        dy = mag * sin(angle + thing);
      }
    }
  }
  
  void changeSpeed(float dv){
    if (mousePressed) {
     if (mouseButton == LEFT) {
        float thing = atan2(dy,dx);
        float mag = sqrt(sq(dx) + sq(dy));
        mag += dv;
        dx = (mag) * cos(thing);
        dy = (mag) * sin(thing);
      }
    }
  }

}
