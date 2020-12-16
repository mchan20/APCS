public class Sorts{
  /**Bubble sort of an int array.
  *@postcondition The array will be modified such that the elements will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void bubbleSort(int[] data){
    while (!inOrder(data)) {
      for(int i;i<data.)
    }
  }

  public boolean inOrder(int[] data) {
    int last = data[0];
    for(int i = 1;i<data.length;i++) {
      if (last > data[i]) return false;
      last = data[i];
    }
    return true;
  }
}
