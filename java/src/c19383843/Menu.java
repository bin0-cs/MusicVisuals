package c19383843;

//import com.jogamp.graph.font.Font;

import processing.core.PConstants;

public class Menu {

    MyVisuals x;


    Menu(MyVisuals x) {
        this.x = x;
    }

    public void setup(){

        x.lights();
        x.strokeWeight(2);
        float c = MyVisuals.map(x.lerpedAverage, 0, 1, 0, 255);
        x.stroke(c, 255, 255);
        x.noFill();
        x.angle += 0.01f;
        float s = 100 + (100 * x.lerpedAverage * 10);
        

            x.pushMatrix();
            x.translate(x.width / 4, x.height / 2, 0);
            x.rotateY(x.angle);
            x.rotateX(x.angle);
            x.box(s);
            x.popMatrix();

            x.pushMatrix();
            x.translate(x.width * 0.75f, x.height / 2, 0);
            x.rotateY(x.angle);
            x.rotateX(x.angle);
            x.box(s);
            x.popMatrix();

        x.textAlign(PConstants.CENTER,PConstants.CENTER);
        x.stroke(255);
        
        x.text("| SPACEBAR to Start & Stop |", x.width/2, x.height/2+50);
        x.text("| Cycle through Visuals 0-5 |", x.width/2, x.height/2 +100);
    }
    
}
