public class Sorts{
  /**Bubble sort of an int array.
  *@postcondition The array will be modified such that the elements will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void bubbleSort(int[] data){
    int temp = 0;
    while (!inOrder(data)) {
      for(int i=0;i<data.length-1;i++) {
        temp = data[i];
        if (temp > data[i+1]) {
          data[i] = data[i+1];
          data[i+1] = temp;
        }
      }
    }
  }

  public static boolean inOrder(int[] thing) {
    if (thing.length > 0) {
      int last = thing[0];
      for(int i = 1;i<thing.length;i++) {
        if (last > thing[i]) return false;
        last = thing[i];
      }
    }
    return true;
  }
}
