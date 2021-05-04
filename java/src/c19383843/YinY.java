package c19383843;
import ddf.minim.*;
import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.*;

// add visuals on the outside


import processing.core.*;

public class YinY extends Visual{

float t = 0; 
float radius;
int count;
int levels = 7;
PVector center;
int which = 0;

Minim minim; // Connect to minim
AudioInput ai; // How to connect to mic
AudioPlayer ap;
AudioBuffer ab; // Samples

WaveForm wfY;
AudioBandsVisual abvY;

float[] lerpedBuffer;
float y = 200;
float lerpedY = y;

float halfHeight = height / 2;
  float average = 0;
  float sum = 0;

public void keyPressed() {
    if (keyCode >= '0' && keyCode <= '6') {
        which = keyCode - '0';
    }
    if (keyCode == ' ') {
        if (ap.isPlaying()) {
            ap.pause();
        } else {
            ap.rewind();
            ap.play();
        }
    }
}

public void setup() {
  colorMode(HSB);
 
  startMinim();

  minim = new Minim(this);
  ap = minim.loadFile("nafas.mp3", width);
  ap.play();
  ab = ap.mix; // Connect the buffer to the mp3 file

  center = new PVector(width/2+radius/pow(2, levels), height/2);
  lerpedBuffer = new float[width];
  
}

public void settings() {
    size(1080, 700); 
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
    edges();

  
}
 
 public void yinYang(float radius, int n) {


    noStroke();
    fill(0);
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

public void edges() {

  float halfHeight = height / 2;
  float average = 0;
  float sum = 0;

  for (int i = 0; i < ab.size(); i++) {

    float c = map(i, 0, ab.size(), 0, 255);
    stroke(c, 255, 255);
    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);        
    line(0, i, lerpedBuffer[i] * halfHeight * 4, i);
    line(width, i, width - (lerpedBuffer[i] * halfHeight * 4), i);
    line(i, 0, i, lerpedBuffer[i] * halfHeight * 4);
    line(i, height, i, height - (lerpedBuffer[i] * halfHeight * 4));
}        
}

    
}
