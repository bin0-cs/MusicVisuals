package c19383843;

//import com.jogamp.graph.font.Font;

import processing.core.PConstants;

public class Menu {

    BrunoVisuals x;


    Menu(BrunoVisuals x) {
        this.x = x;
    }

    public void setup(){

        x.textAlign(PConstants.CENTER,PConstants.CENTER);
        x.fill(255);
        x.stroke(255);
        x.text("| Spacebar to Start & Stop |", x.width/2, x.height/2 - 50);
        x.text("| Cycle through Visuals 0-3 |", x.width/2, x.height/2 + 50);

        x.lights();
        x.angle += 0.01f;
        float s = 100 + (100 * x.lerpedAverage * 10);
        x.fill(s);
        

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

            x.pushMatrix();
            x.translate(x.width /2, x.height/ 4f, 0);
            x.rotateY(x.angle);
            x.rotateX(x.angle);
            x.box(s);
            x.popMatrix();

            x.pushMatrix();
            x.translate(x.width /2, x.height / 1.3f, 0);
            x.rotateY(x.angle);
            x.rotateX(x.angle);
            x.box(s);
            x.popMatrix();
    }
    
}
