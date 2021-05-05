package c19383843;

import ie.tudublin.*;
import java.util.Scanner;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PFont;

public class MyVisuals extends Visual{

//Visuals 
YinY yiny;


Minim minim; // Connect to minim
AudioInput ai; // How to connect to mic
AudioPlayer ap;
AudioBuffer ab; // Samples
FFT fft;
float[] lerpedBuffer;
float y = 200;
float lerpedY = y;
int which = 0;


float halfHeight = height / 2;
float average = getAmplitude();
float sum = 0;
float lerpedAverage = 0;

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
    fullScreen(P3D, 1);
}



}
