import java.util.NoSuchElementException;

public class Range implements IntegerSequence{
  //instance variables
  private int start,end,current;

  //constructor
  public Range(int start,  int end) {
    this.start = start;
    this.end = end;
    current = start;
  }

  //methods
  public void reset(){  }
  public int length(){  }
  public boolean hasNext(){  }

  //@throws NoSuchElementException
  public int next(){    }

}
