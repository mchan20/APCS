import java.util.ArrayDeque;

public class Frontier{
    private ArrayDeque<int[]> frontier;

    public Frontier(){
      ArrayDeque<int[]> la = new ArrayDeque<int[]>();
      frontier = la;
    }

    public int size(){
      return frontier.size();
    }

    public void add(int[]location){
      frontier.add(location);
    }
    
    public int[] remove(){
      return frontier.removeFirst();
    }
  }
