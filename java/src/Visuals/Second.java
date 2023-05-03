package Visuals;

import processing.core.*;

public class Second {
    Start mv;
    float v;
    // circle rotation speed, line movement speed, line offset, and line amplitude
    int numOfLines = 40;
    float circleRadius = 400; // radius of the circles
    float lineLength = 20; // length of each line
    int numLines = 60; // number of lines in each circle
    int lineWeight = 10; // weight of each line
    float rotationSpeed = 0.05f; // speed of circle rotation
    float lineSpeed = 2; // speed of line movement
    float lineOffset = 0; // offset for line movement
    float lineAmplitude = 20; // amplitude of line movement

    public Second(Start mv) {
        this.mv = mv;
    }

    public void render() {
        // Set the color mode and the background color
        mv.colorMode(PApplet.HSB, 360, 100, 100, 100);
        mv.background(0);

        // Draw rotating circles with swirly lines
        drawSwirlyCircle(mv.width / 4, mv.height / 4, v * 8 % 360, 90);
        drawSwirlyCircle(mv.width / 4, mv.height * 3 / 4, -v * 10 % 360, 120);
        drawSwirlyCircle(mv.width * 3 / 4, mv.height / 4, v * 12 % 360, 150);
        drawSwirlyCircle(mv.width * 3 / 4, mv.height * 3 / 4, -v * 14 % 360, 180);
        drawSwirlyCircle(mv.width / 2, mv.height / 2, v * 16 % 360, 210);

        // Increment the rotation speed
        v += rotationSpeed;
    }

    // Draws a swirly circle with colorful lines
    private void drawSwirlyCircle(float cx, float cy, float offset, float hue) {
        // Calculate the angle step between the lines
        float angleStep = 360.0f / numLines;
        float angle = 0.0f;
        
        // Translate and rotate the canvas to draw the circle
        mv.pushMatrix();
        mv.translate(cx, cy);
        mv.rotate(PApplet.radians(offset));

        // Draw the lines in the circle
        for (int i = 0; i < numLines; i++) {
            mv.pushMatrix();
            mv.rotate(PApplet.radians(angle));
            mv.strokeWeight(lineWeight);
            mv.stroke((hue + angle * 2) % 360, 90, 100, 100);
            
            // Calculate the x and y coordinates of the endpoints of the line
            float x1 = -lineLength / 2;
            float y1 = circleRadius + lineOffset + lineAmplitude * PApplet.sin(v * lineSpeed + angle);
            float x2 = lineLength / 2;
            float y2 = circleRadius + lineOffset + lineAmplitude * PApplet.sin(v * lineSpeed + angle);
            
            // Draw the line
            mv.line(x1, y1, x2, y2);
            mv.popMatrix();

            // Increment the angle
            angle += angleStep;
        }
        
        // Restore the canvas to its previous state
        mv.popMatrix();
    }
}