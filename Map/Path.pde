public class Path {
  //this will hold the curved paths for the Enemies to follow
  int number;
  float[] coords;
  int stepsdist;

  Path(int stepsdist,int number,float[] coords) {
    this.number = number;
    this.coords = coords;
    this.stepsdist = stepsdist;
  }
  
  int[] showCoords(int step) {
    return new int[] {step*2, step*2 + 1};
  }
  
  int getNumber() {
    return number;
  }
  
  void showPath() {
    noFill();
    for(int i=0;i<coords.length-2;i=i+2) {
      float x = coords[i];
      float y = coords[i+1];
      float nx = coords[i+2];
      float ny = coords[i+3];
      curve(x,y,x,y,nx,ny,nx,ny);
    }
  }
  
  void splitPath() {
    for(int i=0;i<coords.length-2;i=i+2) {
      float bx = coords[i];
      float by = coords[i+1];
      float nx = coords[i+2];
      float ny = coords[i+3];
      float dist = dist(bx,by,nx,ny);
      
      int steps = int(dist / stepsdist);
      for (int j = 0; j <= steps; j++) {
        float t = j / float(steps);
        float x = curvePoint(bx, bx, nx, nx, t);
        float y = curvePoint(by, by, ny, ny, t);
        ellipse(x, y, 10, 10);
      }
    }
  }
}
