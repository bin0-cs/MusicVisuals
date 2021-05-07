package c19383843;

import ie.tudublin.*;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.*;



public class BrunoVisuals extends Visual{

//Visuals 
Menu menu;
YinY yiny;
Fib fviz;
Visual viz;
Spiral sprl;


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
PFont font;
float angle = 0;
float border = 0.05f;


float halfHeight = height / 2;
float halfWidth = width / 2;
float average = getAmplitude();
float sum = 0;
float lerpedAverage = 0;



public void setup() {
    
    colorMode(RGB);
    frameRate(60);
    startMinim();
    loadAudio("nafas.mp3");
    ap = getAudioPlayer();
    fft = getFFT();
    font = createFont("OpenSans-Regular.ttf", 26);
    textFont(font);
    
    
    center = new PVector(width/2+radius/pow(2, levels), height/2);
    yiny = new YinY(this);
    fviz = new Fib(this);
    menu = new Menu(this);
    sprl = new Spiral(this);

    
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
    smooth(8);
    //size(1080, 1080);
    fullScreen(P3D, 1);
    //fullScreen(P3D, SPAN);

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
    lerpedAverage = lerp(lerpedAverage, getAmplitude() , 0.1f);
    background(0);



    switch(which){

        case 0 : {
            
            menu.setup();

            break;
        }

        case 1 : {
        
            yiny.render();
          
            break;
        }
        
        case 2 : {

            sprl.render();
          
            break;
        }

        case 3 : {

            fviz.render();

            break;
        }

         default : {
            
            menu.setup();

            break;
        }
     
    }


}

}


