// import java.util.Arrays;
// import java.util.Random;
public class Merge {
    
    //wrapper function
    public static void mergesort(int[]data) {
        mergesort(data,0,data.length-1);
    }

    
    private static void mergesort(int[]data, int lo, int hi){
        if ((hi-lo) > 0) {
            //get value to split on
            int mid = lo + (hi-lo)/2;
            // System.out.println(mid);

            //mergesort both sides
            mergesort(data, lo, mid);
            mergesort(data, mid+1,hi);

            //merge
            merge(data, lo, hi, mid);
        }
    }

    private static void merge(int[]data, int lo, int hi, int mid){
        int length1 = mid - lo + 1;
        int length2 = hi - mid;
        int[] temp1 = new int[length1];
        int[] temp2 = new int[length2];

        //fill the temp arrays

        for(int i=0;i<length1;i++) {
            temp1[i] = data[i+lo];
        }
        for(int j=0;j<length2;j++) {
            temp2[j] = data[mid + 1 + j];
        }
        // System.out.println(Arrays.toString(temp1));
        // System.out.println(Arrays.toString(temp2));
        // System.out.println();

        //merge the temp arrays
        int a = 0, b = 0;
        int k = lo;
        while ((a < length1) && (b < length2)) {
            if (temp1[a] <= temp2[b]) {
                data[k] = temp1[a];
                a++;
            }
            else {
                data[k] = temp2[b];
                b++;
            }
            k++;
        }

        while (a < length1) {
            data[k] = temp1[a];
            a++;
            k++;
        }

        while (b < length2) {
            data[k] = temp2[b];
            b++;
            k++;
        }
    }

    // public static void main(String[] args) {
    //     Random rand = new Random();
    //     int[] thing = new int[10];
    //     for(int i=0;i<10;i++) {
    //         thing[i] = rand.nextInt(20);
    //     }
    //     int[] check = thing;
    //     mergesort(thing);
    //     String a = Arrays.toString(thing);
    //     Arrays.sort(check);
    //     String b = Arrays.toString(check);
    //     System.out.println(a.equals(b));
    // }
}
