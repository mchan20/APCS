import java.util.*;
public class MyHeap {
    /*Swap the element at the provided index downward into the correct position.
    This will swap with the larger of the child nodes provided thatchild is larger.
    This stops when a leaf is reached, or neither child is larger.
    *@param size the number of heap elements in the data array.
            This is needed to allow a partially full array to be provided.
    *@precondition the children of data[index] are valid heaps.
    *@precondition index is between 0 and size-1 inclusive
    *@precondition size is between 0 and data.length-1 inclusive.
    */
    private static void pushDown(int[]data, int size, int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        // swap if left is larger
        if ((left < size) && (data[left] > data[largest])) {
            largest = left;
        }

        // swap is right is larger
        if ((right < size) && (data[right] > data[largest])) {
            largest = right;
        }

        // if you did any switching, then 
        if (largest != index) {
            int thing = data[index];
            data[index] = data[largest];
            data[largest] = thing;
            pushDown(data, size, largest);
        }
    }

    /*Reorder the provided array to be a valid heap.
    *@param data is the array to be modified
    */
    public static void buildHeap(int[]data) {
        for (int i = ((data.length / 2) - 1); i >= 0; i--) {
            pushDown(data, data.length, i);
        }
    }

    /*Swap the root node with the element at the provided index.
    *Then push the new root down, but not past the index that it swapped with.
    *@precondition: size is between 0 and data.length inclusive.
    */
    private static void remove(int[]data,int size) {
        int swap = data[size];
        data[size] = data[0];
        data[0] = swap;
        pushDown(data, size, 0);
    }

    /*Sort the provided array
    *@param data is the array to be sorted
    */
    public static void heapsort(int[]data) {
        buildHeap(data);
        for(int i=data.length-1;i>=0;i--) {
            remove(data,i);
        }
    }

    // public static void main(String[] args) {
    //     Random rand = new Random(); 
    //     int[] arr = new int[10];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = rand.nextInt(100); 
    //     }
    //     int[] copy = arr;
    //     Arrays.sort(copy);
    //     heapsort(arr);
    //     System.out.println(copy.equals(arr));
    // }
}