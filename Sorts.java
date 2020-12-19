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

  public static void selectionSort(int[] data){
    int min = 0;
    int swap = 0;
    for(int i=0;i<data.length;i++) {
      min = data[i];
      for(int j=i;j<data.length;j++) {
        if (min > data[j]) {
          min = data[j];
          swap = j;
        }
      }
      data[swap] = data[i];
      data[i] = min;
    }
  }


  public static void insertionSort(int[] data){
    int curr = 0;
    for(int i=1;i<data.length;i++) {
      curr = data[i];
      int j = i-1;
      while ((j >= 0) && (curr < data[j])) {
        data[j+1] = data[j];
        j--;
      }
      data[j+1] = curr;
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

  public static void main(String[] args) {

  }
}
