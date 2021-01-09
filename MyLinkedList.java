public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
  }
  public int size() {
    return size;
  }
  public boolean add(String value) {
    Node n = new Node(value);
    n.setPrev(end);
    n.setNext(null);
    if (size() == 0) {
      start = n;
      end = n;
    }
    else {
      end.setNext(n);
      end = n;
    }
    size++;
    return true;
  }
  public void add(int index, String value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    Node n = new Node(value);
    n.setPrev(getNode(index-1));
    n.setNext(getNode(index));
    getNode(index-1).setNext(n);
    getNode(index).setPrev(n);
    size++;
  }
  public String get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    return getNode(index).getData();
  }
  public String set(int index, String value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    Node n = new Node(value);
    n.setPrev(getNode(index-1));
    n.setNext(getNode(index+1));
    getNode(index-1).setNext(n);
    getNode(index+1).setPrev(n);
    return value;
  }

  public String toString() {
    String ans = "";
    Node current = start;
    int count = 0;
    while (current != null) {
      if (count == 0) {
        ans = ans + current.getData();
      }
      else {
        ans = ans + ", " + current.getData();
      }
      count++;
      current = current.getNext();
    }
    return ans;
  }

  public String remove(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    String result = getNode(index).getData();
    getNode(index-1).setNext(getNode(index+1));
    getNode(index+1).setPrev(getNode(index-1));
    size--;
    return result;
  }

  public void printelements() {
    Node current = start;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }

  private Node getNode(int index) {
    Node current = start;
    for (int i=0; i<index;i++) {
      current = current.getNext();
    }
    return current;
  }
  // //Any helper method that returns a Node object MUST BE PRIVATE!
  public static void main(String[] args) {
    MyLinkedList hi = new MyLinkedList();
    hi.add("one");
    hi.add("two");
    hi.add("three");
    hi.add("three");
    hi.add(2,"two point five");
    hi.remove(2);
    hi.add("three");
    System.out.println(hi.toString());
  }
}
