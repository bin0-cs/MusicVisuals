package c19383843;
import ie.tudublin.Visual;
import processing.core.*;
import processing.core.PApplet;

public class Fib extends Visual{

    MyVisuals z;
    private float lerpedAverage;
   

    //constructor
    public Fib(MyVisuals z){
      this.z = z;
    }


    public void render() {
        float c = z.map(z.getAmplitude(), 0, 1, 0, 255);
        float r = 1f;
        int numPoints = 10;
        float thetaInc = z.TWO_PI / (float) numPoints;
        z.strokeWeight(2);                
        float lastX = z.width / 2;
        float lastY = z.height / 2;
        for(int i = 0 ; i < 1000 ; i ++)
        {
            z.stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + z.lerpedAverage * 0.01f);
            float x = width / 2 + sin(theta) * r;
            float y = height / 2 - cos(theta) * r;
            r += 0.5f + (lerpedAverage*0.01f);
            line(lastX, lastY, x, y);
            lastY = y;
        }
    }


    
}
