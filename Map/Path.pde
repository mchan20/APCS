public class Path {
  //this will hold the curved paths for the Enemies to follow
  int number;
  float[] coords;

  Path(int number,float[] coords) {
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
      if ((i == 0) || (i == coords.length-2)) {
        curveVertex(x, y);
      }
      curveVertex(x, y);
    }
    endShape();
    noFill();
  }
  
  void splitPath() {
    int steps = 6;
    for (int i = 0; i <= steps; i++) {
      float t = i / float(steps);
      float x = curvePoint(coords[0], coords[0], coords[2], coords[coords.length-2], t);
      float y = curvePoint(coords[1], coords[1], coords[3], coords[coords.length-2], t);
      ellipse(x, y, 10, 10);
    }
  }
}
