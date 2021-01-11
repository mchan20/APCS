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
    if (index == 0) {
      n.setNext(start);
      start.setPrev(n);
      start = n;
    }
    else if (index == size()) {
      n.setPrev(end);
      end.setNext(n);
      end = n;
    }
    else {
      Node prev = getNode(index-1);
      Node next = getNode(index);
      n.setPrev(prev);
      n.setNext(next);
      prev.setNext(n);
      next.setPrev(n);
    }
    size++;
  }
  public String get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    return getNode(index).getData();
  }
  public String set(int index, String value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    Node n = new Node(value);
    if (index == 0) {
      n.setNext(getNode(index+1));
      getNode(index+1).setPrev(n);
      start = n;
    }
    else if (index == (size()-1)) {
      end = n;
      end.setPrev(getNode(index-1));
      getNode(index-1).setNext(end);
    }
    else {
      Node prev = getNode(index-1);
      Node next = getNode(index+1);
      n.setPrev(prev);
      n.setNext(next);
      prev.setNext(n);
      next.setPrev(n);
    }
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

  public String toStringReversed() {
    String ans = "";
    Node current = end;
    int count = 0;
    while (current != null) {
      if (count == 0) {
        ans = ans + current.getData();
      }
      else {
        ans = ans + ", " + current.getData();
      }
      count++;
      current = current.getPrev();
    }
    return ans;
  }

  public String remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
    }
    String result = getNode(index).getData();
    if (index == 0) {
      start = getNode(1);
      start.setPrev(null);
    }
    else if (index == (size()-1)) {
      end = getNode(index-1);
      end.setNext(null);
    }
    else{
      Node prev = getNode(index-1);
      Node next = getNode(index+1);
      prev.setNext(next);
      next.setPrev(prev);
    }
    size--;
    return result;
  }

  public void extend(MyLinkedList other){
    end.setNext(other.getNode(0));
    other.getNode(0).setPrev(end);
    end = other.getNode(other.size()-1);
    size = size() + other.size();
    other.clear();
  }

  public void printElements() {
    Node current = start;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }

  public void printElementsRev() {
    Node current = end;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getPrev();
    }
  }

  private Node getNode(int index) {
    Node current = start;
    for (int i=0; i<index;i++) {
      current = current.getNext();
    }
    return current;
  }

  public void clear() {
    start = null;
    end = null;
    size = 0;
  }
  // //Any helper method that returns a Node object MUST BE PRIVATE!
  // public static void main(String[] args) {
  //   // MyLinkedList hi = new MyLinkedList();
  //   // hi.add("one");
  //   // hi.add("two");
  //   // hi.add("three");
  //   // hi.add("three");
  //   // hi.add(2,"two point five");
  //   // hi.remove(2);
  //   // hi.add("three");
  //   // System.out.println(hi.toString());
  //   MyLinkedList a = new MyLinkedList();
  //   MyLinkedList b = new MyLinkedList();
  //   for(int i = 0; i < 10; i++){
  //     if(i < 5){
  //       a.add(i+"");
  //     }else{
  //       b.add(i+"");
  //     }
  //   }
  //   System.out.println();
  //   System.out.println("A:"+a+a.size());
  //   System.out.println("B:"+b+b.size());
  //
  //   a.extend(b);
  //   System.out.println("A:"+a+a.size());
  //   System.out.println("B:"+b+b.size());
  //   System.out.println("A reversed:"+a.toStringReversed()+a.size());
  //   System.out.println("B reversed:"+b.toStringReversed()+b.size());
  // }
  // public static void main(String[] args) {
  //   MyLinkedList hi = new MyLinkedList();
  //   hi.add("one");
  //   hi.add("two");
  //   hi.add(0,"thing");
  //   hi.add(2,"thing1");
  //   // hi.set(0,"thing2");
  //   // // hi.set(hi.size()-1,"lol");
  //   System.out.println(hi.toString());
  //   hi.remove(1);
  //   // // hi.remove(hi.size());
  //   System.out.println(hi.toString());
  //
  //   System.out.println(hi.toStringReversed());
  //
  //   // hi.printElementsRev();
  // }
}
