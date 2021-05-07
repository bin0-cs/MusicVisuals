package c19383843;

import processing.core.PApplet;

public class Spiral {
    BrunoVisuals x;

    float angle = 0;

    public Spiral(BrunoVisuals x){
        this.x = x;
      }


    public void render(){
    
        x.colorMode(PApplet.HSB);
        x.fill(PApplet.map(x.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        x.noStroke();
        x.translate(x.width/2, x.height/2);


        for(int i = 0; i < 1000; i++)
        {
            x.scale((float)0.95);
            x.rotate(PApplet.radians(angle));
            x.ellipse(x.width / 2, x.height / 2, 50 + (x.getSmoothedAmplitude()* 1000), 50 + (x.getSmoothedAmplitude() * 1000));
            
        }
        angle += 0.075; 
    }
}
