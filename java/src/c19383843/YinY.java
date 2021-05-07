package c19383843;

//import ie.tudublin.Visual;
import processing.core.*;

public class YinY {
  BrunoVisuals x;

    //constructor
    public YinY(BrunoVisuals x){
      this.x = x;
    }


public void render(){

    x.count = 0;
    x.t = PApplet.map(x.frameCount, 1, 1440, 0, 1);
    x.radius = BrunoVisuals.map((float) (BrunoVisuals.cos(PConstants.TAU*x.t)/2+0.5), 0, 1, 1000, 10000);
    x.push();
    x.translate(x.width/2, x.height/2);
    x.rotate(PConstants.TAU*x.t*2);
    guide(x.radius, x.levels);
    x.pop();
    x.push();
    x.translate(x.width-x.center.x, x.height-x.center.y);
    x.rotate(PConstants.TAU*x.t*2);
    yinYang(x.radius, x.levels);
    x.pop();

}
 
 public void yinYang(float radius, int n) {
    x.noStroke();
    x.fill(0);
    x.arc(0, 0, radius, radius, 0, PConstants.PI);
    x.fill(255);
    x.arc(0, 0, radius, radius, PConstants.PI, PConstants.TAU);
  if(n==1) {
      x.fill(0);
      x.ellipse(-radius/4, 0, radius/2, radius/2);
      x.fill(255);
      x.ellipse(radius/4, 0, radius/2, radius/2);
  
 
      x.ellipse(-radius/4, 0, radius/4, radius/4);
 
      x.fill(0);
      x.ellipse(radius/4, 0, radius/4, radius/4);
  } 
  else {
    x.push();
    x.translate(radius/4, 0);
    x.rotate(PConstants.TAU*x.t*2);
    yinYang(radius/2, n-1);
    x.pop();

    x.push();
    x.translate(-radius/4, 0);
    x.rotate(PConstants.TAU*x.t*2);
    yinYang(radius/2, n-1);
    x.pop();
  }
}
 

public void guide(float radius, int n) {
  x.count++;
 
  if (n==1) {
    if (x.count==PApplet.pow(2, x.levels-1)) {
     x.center.set(x.screenX(0, 0), x.screenY(0, 0));
    }
  } else {
    x.push();
    x.translate(radius/4, 0);
    x.rotate(PConstants.TAU*x.t*2);
    guide(radius/2, n-1);
    x.pop();
 
    x.push();
    x.translate(-radius/4, 0);
    x.rotate(PConstants.TAU*x.t*2);
    guide(radius/2, n-1);
    x.pop();
  }
}


    
}
