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
  public void reset(){
    current = start;
  }
  public int length(){
    return end - start + 1;
  }
  public boolean hasNext(){
    return (current != end);
  }

  //@throws NoSuchElementException
  public int next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("This is the last element");
    }
    int curr = current;
    current++;
    return curr;
  }

}
