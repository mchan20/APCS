public class Radix {
  public static int nth(int n, int col) {
    n = Math.abs(n);
    return ( n / (int) Math.pow(10,col) ) % 10;
  }

  public static int length(int n) {
    String result = ""+Math.abs(n);
    return result.length();
  }

  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets) {
    for(SortableLinkedList m : buckets) {
      original.extend(m);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int lala = 0;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int maxCol = length(data.get(0));
    SortableLinkedList temp = new SortableLinkedList();
    for (int i=0;i<maxCol;i++) {
      for (int j=0;j<data.size();j++) {
        lala = data.get(j);
        temp.add(lala);
        buckets[nth(lala,i)].extend(temp);
      }
      merge(data, buckets);
    }
  }


  // public static void main(String[] args) {
  //   System.out.println(nth(123,1));
  //   System.out.println(nth(-123,1));
  //   System.out.println(nth(123,2));
  //   System.out.println(nth(-123,2));
  //   System.out.println(length(0));
  //   System.out.println(length(15));
  //   System.out.println(length(-10));
  //   System.out.println(length(5112));
  //   MyLinkedList thing[] = new MyLinkedList[4];
  //   MyLinkedList hi = new MyLinkedList();
  //   for(int i = 0;i<4;i++) {
  //     MyLinkedList la = new MyLinkedList();
  //     la.add(i+"");
  //     thing[i] = la;
  //   }
  //   for(MyLinkedList m : thing) {
  //     System.out.println(m.toString());
  //   }
  //   merge(hi,thing);
  //   System.out.println(hi.toString());
  // }
}
