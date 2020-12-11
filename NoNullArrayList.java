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
  public boolean add(T value) {
    if (value.equals(null)) {
      throw new IllegalArgumentException("You cannot add null to this list");
    }
    super.add(value);
    return true;
  }


}
