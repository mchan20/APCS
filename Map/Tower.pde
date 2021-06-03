public class Tower {
  int atk,level,price,atkSpd,atkcooldown,timer;
  float atkRng;
  float xloc, yloc;
  boolean selected;
  
  
  final int priceRanged = 200;
  final int priceMagic = 500;
  
  Tower(int atk, float atkRng, int atkSpd, float xloc, float yloc) {
    this.atk = atk;
    this.atkRng = atkRng;
    this.atkSpd = atkSpd;
    this.xloc = xloc;
    this.yloc = yloc;
    level = 0;
    price = 0;
    atkcooldown = atkSpd;
  }
  
  void display() {
    // basically just displays an invisible ellipse at the marked locations
    //level 0
    if (level == 0) {
      fill(0);
      //ellipse(xloc, yloc, 49,17);
      noFill();
    }
    click();
  }
  
  int selection(ArrayList<Tower> towers, int money) {
    if (selected == true) {
      if (level == 0) return selectedFirst(towers, money);
      else return selected(towers, money);
    }
    else return 0;
  }
  
  void click(){
   if ((mousePressed) && (mouseButton == LEFT)) {
       if (inEllipse(mouseX,mouseY)) {
           selected = true;
       }
     }
   }
   
  
  void deselect() {
    selected = false;
  }
  
  void upgrade(int type, ArrayList<Tower> towers) {
    if (type == 0) {
      int curr = towers.indexOf(this);
      towers.add(new Ranged(xloc,yloc));
      towers.remove(curr);
    }
    else if (type == 1) {
      int curr = towers.indexOf(this);
      towers.add(new Magic(xloc,yloc));
      towers.remove(curr);
    }
  }
  
  void downgrade(ArrayList<Tower> towers) {
    int curr = towers.indexOf(this);
    towers.add(new Tower(atk,atkRng,atkSpd,xloc,yloc));
    towers.remove(curr);
  }
  
  int selectedFirst(ArrayList<Tower> towers,int money) {
    textAlign(RIGHT);
    //menu box
    rectMode(CENTER);
    fill(95,85,85,191);
    rect(804/2,445/2,400,125);
    fill(0);
    text("Tower Selection",804/2-40,200);
    textAlign(CENTER);
    //Ranged button
    fill(95,85,85,191);
    rect(804/2-120,253, 80,45);
    fill(0);
    text("Ranged",804/2-120,253);
    if (menuClick(804/2-120,253, 80,45)) {
      if (money > priceRanged) {
        upgrade(0,towers);
        return priceRanged;
      }
    }
    
    //Magic button
    fill(95,85,85,191);
    rect(804/2,253,80,45);
    fill(0);
    text("Magic",804/2,253);
    if (menuClick(804/2,253,80,45)) {
      if (money > priceMagic) {
        upgrade(1,towers);
        return priceMagic;
      }
    }
    
    //cancel button
    fill(95,85,85,191);
    rect(803/2+120,253,80,45);
    fill(0);
    text("Cancel",803/2+120,253);
    if (menuClick(803/2+120,253,80,45)) {
      selected = false;
    }
    return 0;
  }
  
  int selected(ArrayList<Tower> towers,int money) {
    //menu box
    ellipse(xloc,yloc,atkRng*2,atkRng*2);
    rectMode(CENTER);
    textAlign(LEFT);
    fill(95,85,85,191);
    rect(804/2,445/2,400,125);
    fill(0);
    text("Tower Menu" + "                Current Level: " + level,804/2-190,200);
    
    textAlign(CENTER);
    //upgrade button
    fill(95,85,85,191);
    rect(804/2-120,253, 80,45);
    fill(0);
    text("Upgrade",804/2-120,253);
    if (menuClick(804/2-120,253, 80,45)) {
      int temp = (int) (price*Math.pow(2,level));
      if (money > temp) {
        level++;
        selected = false;
        return temp;
      }
    }
    
    //sell button
    fill(95,85,85,191);
    rect(804/2,253,80,45);
    fill(0);
    text("Sell",804/2,253);
    if (menuClick(804/2,253,80,45)) {
      int temp = (int) ((price * (1 - Math.pow(2,level))) / (1-2));
      downgrade(towers);
      selected = false;
      return (int) (temp * -0.8);
    }
    //cancel button
    fill(95,85,85,191);
    rect(803/2+120,253,80,45);
    fill(0);
    text("Cancel",803/2+120,253);
    if (menuClick(803/2+120,253,80,45)) {
      selected = false;
    }
    return 0;
  }
  
  int selectedV2(ArrayList<Tower> towers,int money) {
    //display level
    textAlign(CENTER);
    fill(100);
    rectMode(CENTER);
    rect(732,27,75,50);
    fill(0);
    text("Lv. " +level,732,27);
    noFill();
    
    //range circle
    stroke(204, 102, 0);
    ellipse(xloc,yloc,atkRng*2,atkRng*2);
    
    stroke(0);
    //circle around tower
    int menuwidth = 150;
    int buttondimensions = 50;
    ellipse(xloc,yloc,menuwidth,menuwidth);
    //buttons
    rectMode(CENTER);
    fill(255,0,0,191);
    //button at 45 degrees
    //buy Ranged tower/sell tower
    if (menuClick(xloc + menuwidth/2 * cos(PI/4),yloc - menuwidth/2 * sin(PI/4),buttondimensions,buttondimensions)) {
      if (level == 0) {
        if (money > priceRanged) {
          upgrade(0,towers);
          return priceRanged;
        }
      }
      else {
        int temp = (int) (price*Math.pow(2,level));
        if (money > temp) {
          level++;
          selected = false;
          return temp;
        }
      }
    }
    
    //button at 135 degrees
    //buy magic tower/sell tower
    fill(0,255,0,191);
    if (menuClick(xloc + menuwidth/2 * cos(3*PI/4),yloc - menuwidth/2 * sin(3*PI/4),buttondimensions,buttondimensions)) {
      if (level == 0) {
        if (money > priceMagic) {
          upgrade(1,towers);
          return priceMagic;
        }
      }
      else {
        int temp = (int) ((price * (1 - Math.pow(2,level))) / (1-2));
        downgrade(towers);
        selected = false;
        return (int) (temp * -0.8);
      }
    }
    fill(0,0,255,191);
    //button at 225 degrees
    //cancel
    if (menuClick(xloc + menuwidth/2 * cos(5*PI/4),yloc - menuwidth/2 * sin(5*PI/4),buttondimensions,buttondimensions)) {
      selected = false;
    }
    
    fill(95,85,85,191);
    //button at 315 degrees
    if (menuClick(xloc + menuwidth/2 * cos(7*PI/4),yloc - menuwidth/2 * sin(7*PI/4),buttondimensions,buttondimensions)) {
      selected = false;
    }
    return 0;
  }
  
  boolean menuClick(float x, float y, float rectwidth, float rectheight) {
    //rectMode(CENTER);
    //rect(x,y,rectwidth,rectheight);
    if ((mousePressed) && (mouseButton == LEFT)) {
       return ((mouseX > x-(rectwidth/2)) && (mouseX < x+(rectwidth/2)) && (mouseY > y-(rectheight/2)) && (mouseY < y+(rectheight/2)));
    }
    return false;
  } 
  
  boolean inEllipse(float x, float y) {
    int result = 
    ((int)Math.pow((x - xloc), 2) / (int)Math.pow(49/2, 2)) 
  + ((int)Math.pow((y - yloc), 2) / (int)Math.pow(17/2, 2));
    return result <= 1;
  }
  
  //code to attack enemies
  void attack(ArrayList<Enemy> enemies) {
    for(int b=0;b<enemies.size();b++) {
      if (dist(enemies.get(b).getxloc(),enemies.get(b).getyloc(),xloc,yloc) < atkRng) {
        if (atkcooldown == 0) {
          enemies.get(b).damage(atk);
          atkcooldown = atkSpd;
          timer = 10;
        }
      }
    }
  }
}

public class Ranged extends Tower {
  Ranged(float xloc, float yloc) {
    //atk, atkRng, atkSpd
    //atkRng is the radius! atkRng * 2 is what i should be using for ellipse generation (it is the major axis)
    super(5, 100,100,xloc,yloc);
    level = 1;
    price = priceRanged;
  }
  
  void display() {
    if (timer > 0) fill(255,0,0);
    else fill(0);
    rectMode(CORNER);
    rect(xloc-48/2,yloc-17/2,49,17);
    noFill();
    text(atkcooldown,xloc+50,yloc);
    if (atkcooldown > 0) atkcooldown--;
    click();
    if (timer > 0) timer--;
  }
}

public class Magic extends Tower {
  Magic(float xloc, float yloc) {
    super(5, 100,100,xloc,yloc);
    //atk, atkRng, atkSpd
    level = 1;
    price = priceMagic;
  }
  
  void display() {
    fill(100);
    rectMode(CORNER);
    rect(xloc-48/2,yloc-17/2,49,17);
    noFill();
    ellipse(xloc,yloc,atkRng*2,atkRng*2);
    text(atkcooldown,xloc+50,yloc);
    if (atkcooldown > 0) atkcooldown--;
    click();
  }
}
