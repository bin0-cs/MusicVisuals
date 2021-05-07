package c19383843;
//import ie.tudublin.Visual;
import processing.core.*;

public class Fib {

    MyVisuals z;

    //constructor
    public Fib(MyVisuals z){
      this.z = z;
    }


    public void render() {
    

        int numPoints = 500;
        float c = MyVisuals.map(z.getSmoothedAmplitude(), 0, 1, 0, 255);
        float r = 1f;
        float thetaVar = PConstants.TWO_PI / (float) numPoints;
        z.strokeWeight(2);                
        float lastX = z.width / 2;
        float lastY = z.height / 2;
        for(int i = 0 ; i < 1000 ; i ++)
        {
            z.stroke(c, 255, 255, 100);
            float theta = i * (thetaVar + z.lerpedAverage * 0.01f);
            float x = z.width / 2 + PApplet.sin(theta) * r;
            float y = z.height / 2 - PApplet.cos(theta) * r;
            r += 0.5f + (z.lerpedAverage*0.35f);
            z.line(lastX, lastY, x, y);
            lastY = y;
        }
    }


    
}
