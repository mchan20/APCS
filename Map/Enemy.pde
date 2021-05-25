public class Enemy {
  int path,hp,atk,moneyDrop;
  Enemy(int path) { //these are temporary values
    this.path = path;
    hp = 10;
    atk = 5;
    moneyDrop = 5;
  }
}

public class Goblin extends Enemy {
   Goblin(int path) {
     super(path);
   }
}
