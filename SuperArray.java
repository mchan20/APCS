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
    for (int i=0;i<data.length;i++) {
      if ((data.length-1) != i) {
        result = result + data[i] + ", ";
      }
      else result = result + data[i];
    }
    result = result + "]";
    return result;
  }

  public boolean contains(String s) {
    int count = 0;
    for (int i=0;i<data.length;i++) {
      if (s == data[i]) {
        count++;
      }
    }
    return (count > 0);
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

  public void add(int index, String element) {
    String[] thing;
    thing = new String[size-index];
    for (int i=index;i<size;i++) {
      thing[i-index] = data[i];
    }
    data[index] = element;
    resize();
    for (int i=index+1;i<thing.length+index+1;i++) {
      data[i] = thing[i-index-1];
    }
  }



}
