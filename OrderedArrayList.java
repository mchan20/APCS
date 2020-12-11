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
    int lala = 0;
    for(int i=0;i<size()-1;i++) {
      if (element.compareTo(get(i+1)) < 0) {
        lala = i;
        i = size()-1;
      }
    }
    super.add(lala,element);
    return true;
  }

  public void add(int index, T element) {
    add(element);
  }

  public T set(int index, T element) {
    T thing = get(index);
    remove(index);
    add(element);
    return thing;
  }



}
