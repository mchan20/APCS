public class Goblin extends Enemy {
  Goblin(int path,int spawntimer) {
    super(path,1,spawntimer);
    hp = 30;
    thing = loadImage("goblin.png");
    thing.resize(thing.width/3,thing.height/3);
  }
}
