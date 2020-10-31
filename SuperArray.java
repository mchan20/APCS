public class SuperArray {
  //Instance Variables
  private String[] data;
  private int size;

  //Constructor
  public SuperArray() {
    size = 0;
    data = new String[10];
  }

  //Methods
  public int size() {
    return size;
  }

  public boolean add(String element) {
    data[size] = element;
    return true;
  }

  // public String get(int index) {
  //   return data[size];
  // }

  public String set(int index, String element) {
    String thing = data[index];
    data[index] = element;
    return thing;
  }

}
