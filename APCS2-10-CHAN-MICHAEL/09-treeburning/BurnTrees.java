import java.util.*;
public class BurnTrees{
  private int[][]map;
  // private int[][]copy;
  private int ticks;
  private int height;
  private int width;
  private Frontier frontier;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;


  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();//set the left column on fire.
  }

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    return (frontier.size() < 1);
  }

  //helper function for done()
  public int[] surr(int i, int j) {
    //i must equal row number 
    //j must equal collumn number

    //find directions
    int directions[] = new int[4];
    directions[0] = i-1; //up
    directions[1] = i+1; //down
    directions[2] = j-1; //left
    directions[3] = j+1; //right

    //create array that tells you if there are trees
    int treeMap[] = new int[4];
    for(int a=0;a<treeMap.length;a++) {
      treeMap[a] = 4;
    }

    // may have a problem later with space and ash, but pretty sure i can fix that

    //check to see if bounds are an issue
    if (i == 0) treeMap[0] = SPACE;
    if (i == height-1) treeMap[1] = SPACE;
    if (j == 0) treeMap[2] = SPACE;
    if (j == width-1) treeMap[3] = SPACE;
    
    //debugging code
    // System.out.println("Current: "+ copy[i][j]);
    // System.out.println("Coords: " + i + ", "+j);
    // System.out.println(Arrays.toString(treeMap));
    // System.out.println();

    //start checking
    for (int b=0;b<directions.length;b++) {
      if (treeMap[b] != SPACE) {
        if (b==0 || b==1) {
          if (map[directions[b]][j] == TREE) {
            treeMap[b] = TREE;
          }
          else {
            treeMap[b] = SPACE;
          }
        }
        else {
          if (map[i][directions[b]] == TREE) {
            treeMap[b] = TREE;
          }
          else {
            treeMap[b] = SPACE;
          }
        }
      }
    }
    return treeMap;
  }

  public boolean notAlone(int[] surroundings) {
    for (int s : surroundings) {
      if (s == TREE) return true;
    }
    return false;
  }

  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    //looping though the array

    //loop "size" times through fire frontier
    int size = frontier.size();
    for (int a=0;a<size;a++) {
      //get coordinates of current fire
      int[] coords = frontier.remove();
      //row
      int i = coords[0];
      //collumn
      int j = coords[1];

      //get array of surroundings
      int[] surroundings = surr(i, j);

      //debugging statements
      // System.out.println("Current: "+ copy[i][j]);
      // System.out.println("Coords: " + i + ", "+j);
      // System.out.println(Arrays.toString(surroundings));
      // System.out.println();

      if (notAlone(surroundings)) {
        //loop though to set nearby trees on fire
        for (int b = 0;b < 4;b++) {
          //only do stuff if the space is a tree
          if (surroundings[b] == TREE) {
            if (b==0) {
              map[i-1][j] = FIRE;
              int[] bruh = {i-1,j};
              frontier.add(bruh);
            }
            if (b==1) {
              map[i+1][j] = FIRE;
              int[] bruh = {i+1,j};
              frontier.add(bruh);
            }
            if (b==2) {
              map[i][j-1] = FIRE;
              int[] bruh = {i,j-1};
              frontier.add(bruh);
            }
            if (b==3) {
              map[i][j+1] = FIRE;
              int[] bruh = {i,j+1};
              frontier.add(bruh);
            }
          } 
        }
      }
      //finally set the fire tile to ash.
      map[i][j] = ASH;
    }
    // int [][] myCopy = new int[map.length][];
    // for(int i = 0; i < map.length; i++) {
    //   myCopy[i] = map[i].clone();
    // }
    // copy = myCopy;
  }

  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    frontier = new Frontier();
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] thing = {i,0};
        frontier.add(thing);
      }
    }
    // int [][] myCopy = new int[map.length][];
    // for(int i = 0; i < map.length; i++) {
    //   myCopy[i] = map[i].clone();
    // }
    // copy = myCopy;
    width = map[0].length;
    height = map.length;
  }

  public String ArrtoString(){
    return Arrays.deepToString(map).replace("], ", "\n").replace("[", "").replace("]", "");
  }

  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  // public static void main(String[]args)  throws InterruptedException{
  //   // int WIDTH = 10000;
  //   // int HEIGHT = 10000;
  //   // int DELAY = 900;
  //   // double DENSITY = 0.7;
  //   // if(args.length > 1){
  //   //   WIDTH = Integer.parseInt(args[0]);
  //   //   HEIGHT = Integer.parseInt(args[1]);
  //   //   DENSITY = Double.parseDouble(args[2]);
  //   // }
  //   // if(args.length > 3){
  //   //   DELAY = Integer.parseInt(args[3]);
  //   // }
  //   // BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);

  //   long totalSteps = 0;
  //   long totalTime = 0;
  //   for(int i=0;i<100;i++) {
  //     BurnTrees b = new BurnTrees(1000,1000,0.7);
  //     long start = System.currentTimeMillis();
  //     totalSteps += b.run();
  //     totalTime += System.currentTimeMillis()-start;
  //   }
  //   System.out.println(totalSteps);
  //   System.out.println(totalTime);

  //   // System.out.println(b.animate(DELAY));
  //   //animate all screens and print the final answer
  //   // System.out.println(b.run());
  //   // System.out.println(b.outputAll());//print all screens and the final answer
  // }


}
