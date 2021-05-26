public class Path {
  //this will hold the curved paths for the Enemies to follow
  int number;
  float[] coords;
  
  Path(int number,int[] coords) {
    this.number = number;
    this.coords = coords;
  }
  
  int[] showCoords(int step) {
    return new int[] {step*2, step*2 + 1};
  }
  
  int getNumber() {
    return number;
  }
  
  void showPath() {
    noFill();
    beginShape();
    for(int i=0;i<coords.length;i=i+2) {
      float x = coords[i];
      float y = coords[i+1];
      curveVertex(x, y);
    }
    endShape();
  }
}
