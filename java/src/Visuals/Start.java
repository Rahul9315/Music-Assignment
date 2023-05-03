package Visuals;

import ie.tudublin.Visual;

public class Start extends Visual{
    int menu = 0;
    double duration = 0;

    Second Sec;
    Third Thir;
    Fifth fif;
    Fourth four;
    First fir;
    
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

        Sec = new Second(this);
        Thir = new Third(this);
        fif = new Fifth(this);
        four = new Fourth(this);
        fir = new First(this);  
    }

    // Draw that keeps getting run.
    public void draw()
    {
        calculateAverageAmplitude();
        calculateFrequencyBands();

        // How visuals get displayed.
        switch(menu) {
            case 0:
                
                fir.render();
                break;
            case 1:
                Sec.render();
                break;
            case 2:
                Thir.render();
                break;
            case 3:
                four.render();
                break;
            case 4:
            fif.render();
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
    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }       
    }
}
