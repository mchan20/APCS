import java.util.NoSuchElementException;

public class ArraySequence implements IntegerSequence{
  int currentIndex;
  int []data;

  //Constructors
  /*Construct the sequence by copying values from the other array into the data array*/
  public ArraySequence(int [] other){
    data = other;
  }

  //Postcondition: The otherseq will be reset.
  //This constructor will copy ALL values of the `otherseq` into the data array.
  public ArraySequence(IntegerSequence otherseq){
    int thing[];
    thing = new int[otherseq.length()];
    otherseq.reset();
    for (int i = 0;i<otherseq.length();i++) {
      thing[i] = otherseq.next();
    }
    otherseq.reset();
    data = thing;
  }

  //Methods
  public boolean hasNext() {
    return (currentIndex != data.length);
  }

  public int length() {
    return data.length;
  }     //returns the total length of the sequence
  public void reset() {
    currentIndex = 0;
  };     //start over from the start of the sequence

  public int next() {
    if (!hasNext()) {
      throw new NoSuchElementException("This is the last element");
    }
    int curr = currentIndex;
    currentIndex++;
    return data[curr];
  }       //return the current value in the sequence and advances to the next element.
}
