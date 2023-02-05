public class Ogre extends Enemy {
  Ogre(int path,int spawntimer) {
    super(path,1,spawntimer);
    hp = 150;
    maxhp = hp;
    res = 20;
    def = 15;
    thing = loadImage("ogre.png");
    thing.resize( (int) (thing.width/1.4),(int) (thing.height/1.4));
  }
}
