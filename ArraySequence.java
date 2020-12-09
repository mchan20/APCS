import java.util.NoSuchElementException;

public class ArraySequence implements IntegerSequence{
  int currentIndex;
  int []data;

  /*Construct the sequence by copying values from the other array into the data array*/
  public ArraySequence(int [] other){
    for(int i=0;i< other.length;i++) {
      data[i] = other[i];
    }
  }

  boolean hasNext() {
    return (currentIndex != (data.length-1);
  }

  int length() {
    return data.length;
  }     //returns the total length of the sequence
  void reset() {
    currentIndex = 0;
  };     //start over from the start of the sequence

  int next() {
    if (!hasNext()) {
      throw new NoSuchElementException("This is the last element");
    }
    int curr = currentIndex;
    currentIndex++;
    return data[curr];
  }       //return the current value in the sequence and advances to the next element.
}
