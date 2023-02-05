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
    if (element == null) {
      throw new IllegalArgumentException("You cannot add null to this list");
    }
    int lala = 0;
    for(int i=0;i<size();i++) {
      lala = size();
      if (element.compareTo(get(i)) <= 0) {
        lala = i;
        i = size();
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
