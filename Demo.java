public class Demo{
  //methods
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

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    removeDuplicates(a);
    removeDuplicates(b);
    SuperArray thing = new SuperArray();
    if (a.size() => b.size()) {
      for (int i=0;i<a.size();i++) {
        if b.contains(a.get(i)) {
          thing.add(a.get(i))
        }
      }
    }
    else {
      for (int i=0;i<b.size();i++) {
        if a.contains(b.get(i)) {
          thing.add(b.get(i))
        }
      }
    }
    return thing;
  }

  //main
  public static void main(String[]args){
    SuperArray words = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);  }
}
