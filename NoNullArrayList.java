import java.util.ArrayList;


public class NoNullArrayList<T> extends ArrayList<T> {
  //Contructors
  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  //Methods
  public boolean add(T element) {
    if (element == null) {
      throw new IllegalArgumentException("You cannot add null to this list");
    }
    super.add(element);
    return true;
  }

  public void add(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("You cannot add null to this list");
    }
    super.add(index, element);
  }

  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("You cannot add null to this list");
    }
    super.set(index, element);
  }
}
