public class Tower {
  int atk,level,price,atkSpd,atkcooldown;
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
      ellipse(xloc, yloc, 49,17);
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
  
  boolean menuClick(float x, float y, float rectwidth, float rectheight) {
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
        }
      }
    }
  }
}

public class Ranged extends Tower {
  Ranged(float xloc, float yloc) {
    super(5, 200,100,xloc,yloc);
    level = 1;
    price = priceRanged;
  }
  
  void display() {
    fill(0);
    rectMode(CORNER);
    rect(xloc-48/2,yloc-17/2,49,17);
    noFill();
    ellipse(xloc,yloc,atkRng,atkRng);
    text(atkcooldown,xloc+50,yloc);
    if (atkcooldown > 0) atkcooldown--;
    click();
  }
}

public class Magic extends Tower {
  Magic(float xloc, float yloc) {
    super(5, 200,100,xloc,yloc);
    level = 1;
    price = priceMagic;
  }
  
  void display() {
    fill(100);
    rectMode(CORNER);
    rect(xloc-48/2,yloc-17/2,49,17);
    noFill();
    ellipse(xloc,yloc,100,100);
    click();
  }
}
