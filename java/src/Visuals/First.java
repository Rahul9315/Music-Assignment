package Visuals;

import processing.core.PApplet;

public class First {
    Start mv;
    float cy = 0;
    float bh = 0;

    public First(Start mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        bh = this.mv.height / 4;
    }

    // Renders visual.
    public void render()
    {
        mv.colorMode(PApplet.HSB);
        mv.background(255, 255, 0); // change background color to yellow
        mv.strokeWeight(1);

        // Wave form.
        for(int i = 0 ; i < mv.getAudioBuffer().size(); i ++)
        {
            float hue = 110; // Set hue to green
            //float saturation = PApplet.map(mv.getAudioBuffer().get(i), -1, 1, 0, 255);
            float brightness = PApplet.map(mv.getAudioBuffer().get(i), -1, 1, 255, 0);
            mv.stroke(hue,0 /*saturation*/, brightness);

            mv.line(i * 4,bh *3 , i * 4, cy + cy * mv.getAudioBuffer().get(i));
        }

        // Flashy Horizontal dots that are displayed at the top and bottom of the screen.
        mv.strokeWeight(15); // increase dot size
        for(int i = 0 ; i < 20 ; i++ ) // increase number of dots and randomize position
        {
            mv.stroke(120, mv.random(0,20), mv.random(255));
            float x = mv.random(mv.width);
            mv.point(x, mv.height * 0.1f);
            mv.point(x, mv.height * 0.9f);
        }
    }
}
