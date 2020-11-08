public class SuperArray {
  //Instance Variables
  private String[] data;
  private int size;

  //Constructor
  public SuperArray() {
    size = 0;
    data = new String[10];
  }

  public SuperArray(int initialCapacity) {
    size = 0;
    data = new String[initialCapacity];
  }

  //Methods
  public int size() {
    return size;
  }

  public boolean add(String element) {
    if (size >= data.length) {
      resize();
    }
    data[size] = element;
    size++;
    return true;
  }

  public String get(int index) {
    return data[index];
  }

  public String set(int index, String element) {
    String thing = data[index];
    data[index] = element;
    return thing;
  }

  private void resize() {
    String[] thing;
    thing = new String[data.length+1];
    for (int i=0;i<data.length;i++) {
      thing[i] = data[i];
    }
    data = thing;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void clear() {
    String[] thing;
    thing = new String[data.length];
    data = thing;
    size = 0;
  }

  public String toString() {
    String result = "[";
    for (int i=0;i<size;i++) {
      if ((size-1) != i) {
        result = result + data[i] + ", ";
      }
      else result = result + data[i];
    }
    result = result + "]";
    return result;
  }

  public boolean contains(String s){
    int i = 0;
    while (i<data.length){
      if ((data[i] != null) && (data[i].equals(s))) {
        return true;
      }
      i = i + 1;
    }
    return false;
  }

  public static String arrToString(String[]arr) {
    String result = "{";
    for(int i=0;i<arr.length;i++) {
      if (i != (arr.length-1)) {
        result = result + arr[i] + ", ";
      }
      else result = result + arr[i];
    }
    result = result + "}";
    return result;
  }

  public void add(int index, String element){
    if ((index < size) && (index >= 0)) {
      int newIndex = size -1 ;
      for (int i = 0; i < size - index;i++){
        data[newIndex+1] = data[newIndex];
        newIndex = newIndex - 1;
      }
      size++;
      data[index] = element;
    }
  }

  public String remove(int index) {
    String value = data[index];
    if ((index < size) && (index >= 0)) {
      for (int i=index;i<size-1;i++) {
        data[i] = data[i+1];
      }
      data[size-1] = null;
      size--;
    }
    return value;
  }

  public int indexOf(String s) {
    for (int i = 0; i < size(); i ++) {
      if (data[i].equals(s)) {
        return i;
      }
    }
    return -1;
  }

  public String[] toArray() {
    String[] hello;
    hello = new String[size];
    for (int i=0;i<size;i++) {
      hello[i] = data[i];
    }
    return hello;
  }

  public static void removeDuplicates(SuperArray s){
    for(int i=0;i<s.size();i++) {
      String thing = s.get(i);
      for(int j=i+1;j<s.size();j++) {
        String bruh = s.get(j);
        if (thing.equals(bruh)) {
          s.remove(j);
          j--;
        }
      }
    }
  }


}
