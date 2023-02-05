import java.util.Random;

import java.util.Arrays;
/*Modify the array such that:
       *1. A random index from start to end inclusive is chosen, the corresponding
       *   element is designated the pivot element.
       *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
       *3. all elements in range that are larger than the pivot element are placed after the pivot element.
       *4. Only the indices from start to end inclusive are considered in range
       *@return the index of the final position of the pivot element.
       */
public class Preliminary {
    public static int partition (int [] data, int start, int end){
        //pick rand index and switch with end
        Random rand = new Random();
        int index = rand.nextInt(end-start)+start;
        int pivot = data[index];  
        int j=end;
        int i=start;
        while (j >= i) {
            while (data[i] < pivot) i++;
            while (data[j] > pivot) j--;
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        //return boundary edge
        return i;
    }

    public static void main(String[] args) {
        int[] thing = {999,999,999,4,3,2,1,0,999,999,999};
        System.out.println(thing[partition(thing, 3, 7)]);
        System.out.println(Arrays.toString(thing));
    }
}