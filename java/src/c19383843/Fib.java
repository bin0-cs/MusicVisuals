package c19383843;
//import ie.tudublin.Visual;
import processing.core.*;

public class Fib {

    MyVisuals x;

    //constructor
    public Fib(MyVisuals x){
      this.x = x;
    }


    public void render() {
    
        int numPoints = 500;
        float c = MyVisuals.map(x.getSmoothedAmplitude(), 0, 1, 0, 255);
        float r = 1f;
        float thetaVar = PConstants.TWO_PI / (float) numPoints;
        x.strokeWeight(2);                
        float lastX = x.width / 2;
        float lastY = x.height / 2;
        for(int i = 0 ; i < 1000 ; i ++)
        {
            x.stroke(c, 255, 255, 100);
            float theta = i * (thetaVar + x.lerpedAverage * 0.01f);
            float z = x.width / 2 + PApplet.sin(theta) * r;
            float y = x.height / 2 - PApplet.cos(theta) * r;
            r += 0.5f + (x.lerpedAverage*0.35f);
            x.line(lastX, lastY, z, y);
            lastY = y;
        }
    }


    
}
