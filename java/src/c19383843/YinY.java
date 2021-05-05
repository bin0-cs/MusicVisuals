package c19383843;

import ie.tudublin.Visual;
import processing.core.*;

public class YinY extends Visual{

  int width,height;
  MyVisuals x;
  float t = 0; 
  float radius;
  int count;
  int levels = 7;
  PVector center;

    //constructors
    public YinY(MyVisuals x, int width, int height){
      this.x = x;
      this.width = width;
      this.height = height;
    }




public void setup() {
  size(1080, 1080);
  center = new PVector(width/2+radius/pow(2, levels), height/2);
}


public void draw() {

    count = 0;

  t = map(frameCount, 1, 1440, 0, 1);

  radius = map((float) (cos(TAU*t)/2+0.5), 0, 1, 1000, 10000);

    push();
    translate(width/2, height/2);
    rotate(TAU*t*2);
    guide(radius, levels);
    pop();
   
    push();
    translate(width-center.x, height-center.y);
    rotate(TAU*t*2);
   
    yinYang(radius, levels);
    pop();


  
}
 
 public void yinYang(float radius, int n) {

    //noStroke();
    fill(0);
    stroke(255);
    strokeWeight(2);
    arc(0, 0, radius, radius, 0, PI);
    fill(255);
    arc(0, 0, radius, radius, PI, TAU);
  if(n==1) {

    
      fill(0);
      ellipse(-radius/4, 0, radius/2, radius/2);
      fill(255);
      ellipse(radius/4, 0, radius/2, radius/2);
  
 
      ellipse(-radius/4, 0, radius/4, radius/4);
 
      fill(0);
      ellipse(radius/4, 0, radius/4, radius/4);

  } 
  
  else {
    push();
    translate(radius/4, 0);
    rotate(TAU*t*2);
    yinYang(radius/2, n-1);
    pop();
 
    push();
    translate(-radius/4, 0);
    rotate(TAU*t*2);
    yinYang(radius/2, n-1);
    pop();
  }
}
 


public void guide(float radius, int n) {
  count++;
 
  if (n==1) {
    if (count==pow(2, levels-1)) {
      center.set(screenX(0, 0), screenY(0, 0));
    }
  } else {
    push();
    translate(radius/4, 0);
    rotate(TAU*t*2);
    guide(radius/2, n-1);
    pop();
 
    push();
    translate(-radius/4, 0);
    rotate(TAU*t*2);
    guide(radius/2, n-1);
    pop();
  }
}


    
}
