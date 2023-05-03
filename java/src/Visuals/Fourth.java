package Visuals;

import processing.core.PApplet;

public class Fourth {
    Start mv;

    public Fourth(Start mv) {
        this.mv = mv;
    }

    int duration = 0;
    float smoothedBoxSize = 0;

    public void render() {
        float angle = mv.random(360);
        
        mv.background(40);
        mv.noFill();
        mv.lights();
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        mv.translate(0, 0, -250);
        float boxSize = mv.random(100) + (mv.getAmplitude() * 500);
        smoothedBoxSize = PApplet.lerp(smoothedBoxSize, boxSize, 0.2f);

        // If time is >= 200 display four cubes to each corner with a sphere in the middle.
        if (duration >= 200)
        {
            mv.pushMatrix();
            mv.translate(-100+mv.random(25), 100-mv.random(25), 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5);
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(100-mv.random(25), -100+mv.random(25), 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(-100+mv.random(25), -100+mv.random(25), 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(100-mv.random(25), 100-mv.random(25), 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(mv.getAmplitude() * 300, mv.getAmplitude() * 300, -250);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.sphere(smoothedBoxSize);
            mv.popMatrix(); 
        }
        else    // A single cube at the middle of the screen.
        {
            mv.rotateY(angle);
            mv.rotateX(angle);         
            mv.strokeWeight(5);
            mv.box(smoothedBoxSize);
        }
        angle += 0.02f;
        duration++;

    }

    public void draw(){
         
    }
}