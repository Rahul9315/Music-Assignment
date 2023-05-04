# Music Assignment

Team Members:
1. Paulina Czarnota (C21365726)
2. Prabhjeet Bissora (C21412282)
3. Rahul (D20128756)

# Description of the assignment
In this Assignment we have 5 Visualizations. Second.java and Third.java was done by Paulina, Fifth.java and Fouth.java was done by Prabhjeet and First.java and Start.java was done by Rahul. All these files were stored in Visuals folder and we use Animals.mp3 as an Audio File. There files responds with the change in Amplitude and Frequency of the Music.

# Instructions
In order to use this Repo you can just fork it or either download the code to run it.
After that go to the main.java and press F5 to run the code and soon after press Spacebar to enjoy the music.

# How it works
All visuals are ran through Start.java in the package Visuals.
Every visual that is run is found in this package.

Inside this Start.java we have constuctors for visuals that are called in setup().
These are needed to create the visuals inside Start.java to run perform after every 5 Seconds

```Java
        Sec = new Second(this);
        Thir = new Third(this);
        fif = new Fifth(this);
        four = new Fourth(this);
        fir = new First(this);
```

These visuals are drawn in the draw() method.
```Java
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
```

The visuals will switch automatically after a period of time.
```Java
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
            menu = 4;
        }
        else if (duration == 2400)
        {
            duration = 0;
        }
```

The user is expected to press space to start playing the music

# What I am most proud of in the assignment

1. Knowledge Sharing
2. Code Reviews
3. Specialization 
4. Consistency
5. Learning with others Code

# Video
Check out our video here.
https://youtu.be/MYKTTHacCXw

