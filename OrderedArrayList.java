public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
  //Contructors
  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  //Methods
  public boolean add(T element) {
    int index = 0;
    for(int i=0;i<size()-1;i++) {
      if (get(i).compareTo(get(i+1)) < 0) {
        index = i;
        i = size()-1;
      }
    }
    super.add(index,element);
    return true;
  }

  public void add(int index, T element) {
    int thing = 0;
    for(int i=0;i<size()-1;i++) {
      if (get(i).compareTo(get(i+1)) < 0) {
        index = i;
        i = size()-1;
      }
    }
    super.add(thing,element);
  }



}
