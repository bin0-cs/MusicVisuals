package c19383843;
import ie.tudublin.Visual;
import processing.core.*;

public class Fib extends Visual{

    MyVisuals z;
    //private float lerpedAverage;
   

    //constructor
    public Fib(MyVisuals z){
      this.z = z;
    }


    public void render() {
        float c = MyVisuals.map(z.getAmplitude(), 0, 1, 0, 255);
        float r = 1f;
        int numPoints = 500;
        float thetaInc = PConstants.TWO_PI / (float) numPoints;
        z.strokeWeight(2);                
        float lastX = z.width / 2;
        float lastY = z.height / 2;
        for(int i = 0 ; i < 1000 ; i ++)
        {
            z.stroke(c, 255, 255, 40);
            float theta = i * (thetaInc + z.lerpedAverage * 0.01f);
            float x = z.width / 2 + sin(theta) * r;
            float y = z.height / 2 - cos(theta) * r;
            r += 0.5f + (z.lerpedAverage*0.25f);
            z.line(lastX, lastY, x, y);
            lastY = y;
        }
    }


    
}
