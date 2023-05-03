package Visuals;

import ie.tudublin.Visual;

public class Start extends Visual{
    int menu = 0;
    double duration = 0;

    Second lm;
    Third CandS;
    Fifth circScr;
    Fourth cubandSphr;
    First wv;
    
    // Settings of window
    public void settings()
    {
        size(1000 , 1000, P3D);
    }

    // Setup that gets ran once.
    public void setup()
    {
        colorMode(HSB);
        noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("Animals.mp3");

        lm = new Second(this);
        CandS = new Third(this);
        circScr = new Fifth(this);
        cubandSphr = new Fourth(this);
        wv = new First(this); 
    }

    // Draw that keeps getting run.
    public void draw()
    {
        calculateAverageAmplitude();
        calculateFrequencyBands();

        // How visuals get displayed.
        switch(menu) {
            case 0:
                
                wv.render();
                break;
            case 1:
                lm.render();
                break;
            case 2:
                CandS.render();
                break;
            case 3:
                cubandSphr.render();
                break;
            case 4:
            circScr.render();
                break;
        }

        // Timer to switch between visuals.
        duration++;

        // The amount of time each visual gets allocated.
        if (duration < 400)
        {
            menu = 0;
        }
        else if (duration < 800)
        {
            menu = 1;
        }
        else if (duration < 1200)
        {
            menu = 2;
        }
        else if (duration < 1600)
        {
            menu = 3;
        }
        else if (duration < 2000)
        {
            // Camera reset : Is needed when CubesAndSphere.java gets played.
            camera();
            menu = 4;
        }
        else if (duration == 2400)
        {
            duration = 0;
        }

    }

    // If spacebar is pressed play sound.
    // If 'p' is pressed stop sound.
    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }       
    
        if (key == 'p')
        {
            getAudioPlayer().pause();
        }  
    }
}
