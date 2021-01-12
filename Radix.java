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
      if (m != null) original.extend(m);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int lala = 0;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i=0;i<10;i++) {
      buckets[i] = new SortableLinkedList();
    }
    SortableLinkedList temp = new SortableLinkedList();
    int maxCol = length(data.get(0));
    for (int i=0;i<maxCol;i++) {
      for (int j=0;j<data.size();j++) {
        lala = data.get(j);
        if (lala < Math.pow(10,i)) {
          buckets[0].add(lala);
        }
        else {
        buckets[nth(lala,i)].add(lala);
        }
      }
      clear(data);
      merge(data, buckets);
    }
  }

  public static void clear(SortableLinkedList list) {
    SortableLinkedList temp = new SortableLinkedList();
    temp.extend(list);
  }


  public static void main(String[] args) {
    SortableLinkedList hi = new SortableLinkedList();
    hi.add(111);
    hi.add(271);
    hi.add(71);
    hi.add(151);
    hi.add(91);
    System.out.println(hi.toString());
    radixSortSimple(hi);
    System.out.println(hi.toString());
  }
}
