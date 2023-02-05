public class Kernel {
  float[][]kernel;

  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
    kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    // ok we gotta do smth with get() method
    // ok i think we are gonna do a nested loop to get the -1,0,1 thing
    float rsum = 0.0;
    float gsum = 0.0;
    float bsum = 0.0;
    for(int i = -1;i<=1;i++) {
      for(int j = -1;j<=1;j++) {
        //srcKernel[i+1][j+1] = img.get(x+i,y+j) + kernel[i+1][j+1];
        rsum = rsum + (red(img.get(x+i,y+j)) * kernel[i+1][j+1]);
        gsum = gsum + (green(img.get(x+i,y+j)) * kernel[i+1][j+1]);
        bsum = bsum + (blue(img.get(x+i,y+j)) * kernel[i+1][j+1]);
      }   
    }
    return color(rsum,gsum,bsum);
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    for (int x = 1; x < source.width-1; x++) {
      for (int y = 1; y < source.height-1; y++) {
        int loc = x + y * source.width;
        destination.pixels[loc] = calcNewColor(source,x,y);
      }
    }
    destination.updatePixels();
  }

}
