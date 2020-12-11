import java.util.ArrayList;


public class NoNullArrayList<T> extends ArrayList<T> {
  //Contructors
  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int initialCapacity) {
    super(initialCapacity);
  }
}
