public class Tower {
  int atk,level,price,atkSpd,atkcooldown;
  float atkRng;
  float xloc, yloc;
  boolean selected;
  
  
  final int priceRanged = 200;
  final int priceMagic = 400;
  final int priceArtillery = 500;
  
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
  
  //get methods
  boolean getSelected() {
    return selected;
  }
  
  //display tower
  void display(ArrayList<Tower> towers) {
    // basically just displays an invisible ellipse at the marked locations
    //level 0
    if (level == 0) {
      fill(0);
      //ellipse(xloc, yloc, 49,17);
      noFill();
    }
    if (!selected(towers) || selected) click();
  }
  
  boolean selected(ArrayList<Tower> towers) {
    for(Tower a : towers) {
      if (a.getSelected() == true) return true;
    }
    return false;
  }
  
  int selection(ArrayList<Tower> towers, int money) {
    if (selected == true) {
      if (level == 0) return selectedV3(towers, money);
      else return selectedV3(towers, money);
    }
    else return 0;
  }
  
  void click(){
   if ((mousePressed) && (mouseButton == LEFT)) {
       if (inEllipse(mouseX,mouseY)) {
           selected = true;
       }
       else if (!menuClick(630,65,340,110)) selected = false;
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
    else if (type == 2) {
      int curr = towers.indexOf(this);
      towers.add(new Artillery(xloc,yloc));
      towers.remove(curr);
    }
  }
  
  void downgrade(ArrayList<Tower> towers) {
    int curr = towers.indexOf(this);
    towers.add(new Tower(atk,0,atkSpd,xloc,yloc));
    towers.remove(curr);
  }
  
  int selectedV3(ArrayList<Tower> towers,int money) {
    //menu box
    stroke(0);
    ellipse(xloc,yloc,atkRng*2,atkRng*2);
    rectMode(CENTER);
    textAlign(LEFT);
    fill(95,85,85,191);
    rect(630,65,340,110);
    fill(0);
    if (level == 0) {
      text("Tower Selection",630-165,30);
    }
    else {
      text("Tower Menu" + "                       Lv: " + level,630-165,30);
    }
    textSize(15);
    textAlign(CENTER);
    
    //Ranged/upgrade button
    fill(95,85,85,191);
    rect(460+65,80,80,40);
    fill(0);
    if (level == 0) text("Ranged",460+65,80);
    else text("Upgrade",460+65,80);
    if (menuClick(460+65,80,80,40)) {
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
    
    //Magic/sell button
    fill(95,85,85,191);
    rect(630,80,80,40);
    fill(0);
    if (level == 0) text("Magic",630,80);
    else text("Sell",630,80);
    if (menuClick(630,80,80,40)) {
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
    //cancel button
    fill(95,85,85,191);
    rect(800-65,80,80,40);
    fill(0);
    if (level == 0) text("Artillery",800-65,80);
    else text("Cancel",800-65,80);
    if (menuClick(800-65,80,80,40)) {
      if (level == 0) {
        if (money > priceArtillery) {
          upgrade(2,towers);
          return priceArtillery;
        }
      }
      else {
        selected = false;
      }
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
      if (!enemies.get(b).getDead())
        if (dist(enemies.get(b).getxloc(),enemies.get(b).getyloc(),xloc,yloc) < atkRng) {
          if (atkcooldown == 0) {
            if (atk*level >= enemies.get(b).getDef()) enemies.get(b).damage(atk*level - enemies.get(b).getDef());
            else enemies.get(b).damage(0);
            atkcooldown = atkSpd;
          }
        }
      }
    }
  }
