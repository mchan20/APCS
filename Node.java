public class Node{
  public Node(String value){
    data = value;
    next = null;
    prev = null;
  }
  private String data;
  private Node next,prev;

  public String getData() {
    return data;
  }

  public void setData(String value) {
    data = value;
  }

  private Node getNext() {
    return next;
  }

  public void setNext(Node other){
    next = other;
  }

  private Node getPrev() {
    return prev;
  }

  public void setPrev(Node other){
    prev = other;
  }

}
