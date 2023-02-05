import java.util.Random;
import java.util.Arrays;

public class Quick {
    // note: start/end have been renamed to lo/hi in this to match the diagram, otherwise it is the same.
    // public static int partition(int[]data ,int lo, int hi){
    public static int partition(int[]data ,int lo, int hi){
        Random rand = new Random();
        int index = rand.nextInt(hi-lo)+lo;
        int pivot = data[index];
        data[index] = data[hi];
        data[hi] = pivot;
        int i = lo-1;
        for (int j=lo;j<hi;j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            else if (data[j] == pivot) {
                boolean bruh = rand.nextBoolean();
                if (bruh) {
                    i++;
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        int temp2 = data[i+1];
        data[i+1] = data[hi];
        data[hi] = temp2;
        return i+1;
    }

    /*return the value that is the kth smallest value of the array.
           *@param data must have a length > 0
           *@param k is 0 to data.length-1 inclusive
           *@postcondition The array can be modified. (If we did not want to modify the array, we could make a copy before we start the process)
           */
    public static int quickselect(int []data, int k){
        int a = partition(data, 0, data.length-1);
        while (a != k) {
            if (k > a) {
                a = partition(data,a+1,data.length-1);
            }
            else if (k < a) {
                a = partition(data,0,a-1);
            }
        }
        return data[a];
    }

    public static void quicksort(int[] data){
        quicksort(data,0,data.length-1);
    }

    public static void quicksort(int[] data,int lo,int hi) {
        if (hi > lo) {
            int a = partition(data, lo, hi);
            quicksort(data,lo,a-1);
            quicksort(data,a+1,hi);
        }   
    }

    // public static void main(String[] args) {
    //     // Random rand = new Random();
    //     // int trials = 100000;
    //     // int[] lala = new int[trials];
    //     // for (int i=0;i<trials;i++) {
    //     //     lala[i] = rand.nextInt(2);
    //     // }
    //     // final long startTime = System.currentTimeMillis();
    //     // quicksort(lala);
    //     // final long endTime = System.currentTimeMillis();
    //     // System.out.println(Arrays.toString(lala));
    //     // System.out.println("Total execution time: " + (endTime - startTime));

    //     int[] thing = {999,999,999,4,3,3,3,2,1,0,999,999,999};
    //     // quicksort(thing);
    //     System.out.println(quickselect(thing, 4));
    //     System.out.println(Arrays.toString(thing));

    // }
}
