package c19383843;

import ie.tudublin.*;
import java.util.Scanner;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.*;


public class MyVisuals extends Visual{

//Visuals 
Menu menu;
YinY yiny;
Fib fviz;


Minim minim; // Connect to minim
AudioInput ai; // How to connect to mic
AudioPlayer ap;
AudioBuffer ab; // Samples
FFT fft;
float[] lerpedBuffer;
float y = 200;
float lerpedY = y;
int which = 0;
float t = 0; 
float radius;
int count;
int levels = 7;
PVector center;


float halfHeight = height / 2;
float halfWidth = width / 2;
float average = getAmplitude();
float sum = 0;
float lerpedAverage = 0;
float smoothAmp;

public void setup() {
    
    colorMode(RGB);
   
    frameRate(70);
  
   startMinim();
    loadAudio("nafas.mp3");
    ap = getAudioPlayer();
    ap.play();
    fft = getFFT();
    
    
    center = new PVector(width/2+radius/pow(2, levels), height/2);
    yiny = new YinY(this);
    fviz = new Fib(this);

    
  }

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
public void settings()
{
    // size(600, 600, P3D);
    //size(1080, 1080);
    fullScreen(P3D, 1);

}


public void draw(){
    calculateAverageAmplitude();
    ab = getAudioBuffer();
    try {
        calculateFFT();
    }
    catch(VisualException e)
    {
        e.printStackTrace();
    }
    calculateFrequencyBands();
    smoothAmp = getSmoothedAmplitude();
    float c = map(getAmplitude(), 0, 1, 0, 255);
    lerpedAverage = lerp(lerpedAverage, getAmplitude() , 0.1f);
    background(0);



    switch(which){

        case 0 : {

            //load menu

            break;
        }

        case 1 : {

            yiny.render();
           
          
            break;
        }
        
        case 2 : {
        fviz.render();
          
            break;
        }
    }








}

public void fib() {
    float c = map(getSmoothedAmplitude(), 0, 1, 0, 255);
    float r = 1f;
    int numPoints = 500;
    float thetaInc = TWO_PI / (float) numPoints;
    strokeWeight(2);                
    float lastX = width / 2; 
    float lastY = height / 2;
    for(int i = 0 ; i < 1000 ; i ++)
    {
        stroke(c, 255, 255, 40);
        float theta = i * (thetaInc + lerpedAverage * 0.01f);
        float x = width / 2 + sin(theta) * r;
        float y = height / 2 - cos(theta) * r ;
        r += 0.5f + (lerpedAverage*0.25f);
        line(lastX, lastY, x, y);
        lastY = y;
    }
}

}
