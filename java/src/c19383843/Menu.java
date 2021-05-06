package c19383843;

import com.jogamp.graph.font.Font;

import processing.core.PConstants;

public class Menu {

    MyVisuals x;


    Menu(MyVisuals x) {
        this.x = x;
    }

    public void setup(){
        x.textAlign(PConstants.CENTER,PConstants.CENTER);
        x.stroke(255);
        
        x.text("| SPACEBAR to Start & Stop |", x.width/2, x.height/2+50);
        x.text("| Cycle through Visuals 0-5 |", x.width/2, x.height/2 +100);
    }
    
}
