package example;

import processing.core.*;

// This is an example of a visual that renders the waveform
public class WaveForm
{
    MyVisual mv;
    YinY Yy;
    float cy = 0;

    public WaveForm(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }

    public WaveForm(YinY Yy) {
        this.Yy = Yy;
        cy = this.Yy.height / 2;
    }

    public void render()
    {
        Yy.colorMode(PApplet.HSB);
        for(int i = 0 ; i < Yy.getAudioBuffer().size() ; i ++)
        {
            Yy.stroke(
                PApplet.map(i, 0, Yy.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            Yy.line(i, cy, i, cy + cy * Yy.getAudioBuffer().get(i));
        }
    }
}