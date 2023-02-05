import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = -1;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = -1;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String result = "{";
    if (size() == 0) return "{}";
    // 3 cases
    if (end >= 0) {
      //both are positive, just go from start to end
      if (start >= 0) {
        for (int i=start;i<=end;i++) {
          if (i != end) {
            result = result + data[i] + ", ";
          }
          else {
            result = result + data[i];
          }
        }
      }
      //if end is potitive and start is negative, then you have to do what i did already
      else {
        //first we add the start section, have to do that data.length-start stuff.
        for (int i=data.length+start;i<data.length;i++) {
          result = result + data[i] + ", ";
        }
        //then we add the end part from the start
        for (int i=0;i<=end;i++) {
          if (i != end) {
            result = result + data[i] + ", ";
          }
          else {
            result = result + data[i];
          }
        }
      }
    }
    //now we do the last case, where end is negative. here we just do start --> end, but with data.length
    else {
      if (end >= start) {
        for (int i=data.length+start;i<=data.length+end;i++) {
          if (i != data.length+end) {
            result = result + data[i] + ", ";
          }
          else {
            result = result + data[i];
          }
        }
      }
      else {
        if (data.length+end >= 0) {
          for (int i=data.length+start;i<data.length;i++) {
            result = result + data[i] + ", ";
          }
          for (int i=0;i<=data.length+end;i++) {
            if (i != data.length+end) {
              result = result + data[i] + ", ";
            }
            else {
              result = result + data[i];
            }
          }
        }
        else {
          for (int i=data.length+start;i<data.length;i++) {
            if (i != data.length+end) {
              result = result + data[i] + ", ";
            }
            else {
              result = result + data[i];
            }
          }
        }
      }
    }
    return result + "}";
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException("this deque does not permit null elements");
    //two cases, if start is positive or negative.
    int temp = start-1;
    if (size()+1 > data.length) resize();
    if (temp >= 0) {
      data[temp] = element;
    }
    else {
      if (data.length+temp < 0) {
        start = 0;
        temp = -1;
        if (end<0) {
          end = end+data.length;
        }
      }
      data[data.length+temp] = element;
    }
    start--;
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException("this deque does not permit null elements");
    //two cases, if end is positive or negative.
    int temp = end+1;
    if (size()+1 > data.length) resize();
    if (temp >= 0) {
      if (temp == data.length) {
        temp = 0;
        end = -1;
        if (start>0) {
          start = start-data.length;
        }
      }
      data[temp] = element;
    }
    else {
      data[data.length+temp] = element;
    }
    end++;
    size++;
  }

  public E removeFirst(){
    int a = 0;
    //throws an exception if deque is empty 
    if (size() > 0) {
      // 2 cases again, if first is postive or negative.
      if (start >= 0) {
        a = start;
      }
      else {
        a = data.length+start;
      }
      E thing = data[a];
      data[a] = null;
      start++;
      size--;
      return thing;
    }
    else throw new NoSuchElementException("There is nothing to remove.");
  }

  public E removeLast(){
    int a = 0;
    if (size() > 0) {
      // 2 cases
      if (end >= 0) {
        a = end;
      }
      else a = data.length+end;
      E thing = data[a];
      data[a] = null;
      end--;
      size--;
      return thing;
    }
    else throw new NoSuchElementException("There is nothing to remove.");
  }

  public E getFirst(){
    if (start >= 0) {
      if ((size() == 0) || (data[start] == null)) throw new NoSuchElementException("There is nothing to get.");
      return data[start];
    }
    else {
      if ((size() == 0) || (data[data.length+start] == null)) throw new NoSuchElementException("There is nothing to get.");
      return data[start+data.length];
    }
  }

  public E getLast(){
    if (end >= 0) {
      if ((size() == 0) || (data[end] == null)) throw new NoSuchElementException("There is nothing to get.");
      return data[end];
    }
    else {
      if ((size() == 0) || (data[data.length+end] == null)) throw new NoSuchElementException("There is nothing to get.");
      return data[end+data.length];
    }
  }

  public void resize() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[data.length+20];
    int difference = d.length - data.length;
    if (end >= 0) {
      //both are positive, just go from start to end
      if (start >= 0) {
        for (int i=start;i<=end;i++) {
          d[i] = data[i];
        }
      }
      //if end is potitive and start is negative, then you have to do what i did already
      else {
        //first we add the start section, have to do that data.length-start stuff.
        for (int i=data.length+start;i<data.length;i++) {
          d[i+difference] = data[i];
        }
        //then we add the end part from the start
        for (int i=0;i<=end;i++) {
          d[i] = data[i];
        }
      }
    }
    //now we do the last case, where end is negative. here we just do start --> end, but with data.length
    else {
      for (int i=data.length+start;i<=data.length+end;i++) {
        d[i+difference] = data[i];
      }
    }
    data = d;
  }

  public void debug() {
    System.out.println();
    System.out.println("This is start: "+start);
    System.out.println("This is end: "+end);
    System.out.println("This is size: "+size);
    System.out.println("This is the result: "+toString());
    System.out.println("This is the true data array: "+Arrays.toString(data));
    System.out.println();
  }

  // public static void main(String[] args) {
  //   // MyDeque<Integer> thing = new MyDeque<Integer>();
  //   // // thing.debug();
  //   // // thing.resize();
  //   // // thing.debug();
  //   // // thing.addLast(1);

  //   // // adding tester
  //   // for (int i=0;i<10;i++) {
  //   //   // thing.addFirst(i);
  //   //   thing.addLast(i);
  //   //   thing.debug();
  //   // }

  //   // //removing tester
  //   // for (int i=0;i<7;i++) {
  //   //   System.out.println(thing.removeFirst());
  //   //   // System.out.println(thing.removeLast());
  //   //   thing.debug();
  //   // }
  //   // thing.addLast(14);
  //   // thing.debug();
  //   test6(10000000);
  // }

  // public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
  //   if(a==null && b==null)
  //     return true;
  //   if(a==null || b==null)
  //       return false;
  //   if(a.size()!=b.size())
  //     return false;
  //   if(a.size()==0 && b.size()==0)
  //     return true;

  //   try{
  //     while(b.size()>0){
  //       if(!a.removeFirst().equals(b.removeFirst())){
  //         return false;
  //       }
  //     }
  //   }catch(NoSuchElementException e){
  //     return false;
  //   }
  //   return b.size()==0;
  // }

  // public static int test6(int max){
  //   MyDeque<Integer> a = new MyDeque<Integer>();
  //   ArrayDeque<Integer>b = new ArrayDeque<Integer>();

  //   for(int i = 0; i < max; i++){
  //     int op = (int)(Math.random()*4);
  //     if(op == 0){
  //       a.addLast(i);
  //       b.addLast(i);
  //     }
  //     if(op == 1){
  //       a.addFirst(i);
  //       b.addFirst(i);
  //     }
  //     if(op == 2){
  //       if(b.size()>0){
  //         if(! a.getLast().equals(b.getLast())){
  //           System.out.println("Fail test6a "+a.getLast()+" vs "+b.getLast());
  //           return 0;
  //         }
  //         a.removeLast();
  //         b.removeLast();
  //       }
  //     }
  //     if(op == 3){
  //       if(b.size()>0){
  //         if(! a.getFirst().equals(b.getFirst())){
  //           System.out.println("Fail test6a "+a.getFirst()+" vs "+b.getFirst());
  //           return 0;
  //         }
  //         a.removeFirst();
  //         b.removeFirst();
  //       }
  //     }
  //   }
  //   if( equals(a,b) ){
  //     System.out.println("hi");
  //     return 1;
  //   }
  //   System.out.println("Fail test6 end");
  //   return 0;
  // }


}