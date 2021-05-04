package example;

import c19383843.YinY;
import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    MyVisual mv;
    YinY Yy;

    public AudioBandsVisual(MyVisual mv)
    {
        this.mv = mv; 
    }

    public AudioBandsVisual(YinY Yy) {
        this.Yy = Yy;
    }

    public void render()
    {
        float gap = Yy.width / (float) Yy.getBands().length;
        Yy.noStroke();
        for(int i = 0 ; i < Yy.getBands().length ; i ++)
        {
            Yy.fill(PApplet.map(i, 0, Yy.getBands().length, 255, 0), 255, 255);
            Yy.rect(i * gap, Yy.height, gap,-Yy.getSmoothedBands()[i] * 0.2f); 
        }
    }
}