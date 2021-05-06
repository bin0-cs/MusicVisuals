package c19383843;
import processing.core.PApplet;

public class Planet {
    MyVisuals x;


    public Planet(MyVisuals x) {
        this.x = x;
    }

    public void draw() {

        x.noFill();
        x.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        x.strokeWeight(1);

        float c = PApplet.map(x.average, 0, 1, 0, 255);
        x.stroke(c, 255, 255);

        x.pushMatrix();
        x.noFill();
        x.rotateX(PApplet.radians(x.rotation));
        x.rotateY(PApplet.radians(x.rotation));
        x.rotateZ(PApplet.radians(x.rotation));
        x.sphere(600 * x.lerpedAverage);
        x.popMatrix();
        x.rotation += 1;


    }


}
