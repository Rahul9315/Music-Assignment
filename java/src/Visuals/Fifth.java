package Visuals;

public class Fifth {
    Start mv;

    public Fifth(Start mv)
    {
        this.mv = mv;
    }

    // Settings for moving circle.
    float speedForX = 100;//30;
    float speedForY = 150;//45;
    float colour = 0;

    // Render moving circle.
    public void render() {
        float sideways = mv.random(1000);
        float UpDown = mv.random(1000);

        mv.noStroke();
        mv.fill(colour, colour, colour);
        colour = (colour += 0.75) % 256;

        //mv.fill(mv.random(255), mv.random(255), mv.random(255));

        // X Axis
        sideways += speedForX;
        if (sideways > mv.width || sideways < 0)
        {
            speedForX *= -1;
        }

        // Y Axis
        UpDown += speedForY;
        if (UpDown > mv.height || UpDown < 0)
        {
            speedForY *= -1;
        }

        mv.circle(sideways, UpDown, 200);
    }

    public void draw(){
         
    }
}