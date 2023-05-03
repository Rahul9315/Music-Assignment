package Visuals;

import processing.core.PApplet;
import processing.core.PConstants;

public class Third {
    Start mv; 
    float position;
    float speed;

    // Constants
    private static final int DISTANCE_BETWEEN_SHAPES = 200;
    private static final float AMPLITUDE_MULTIPLIER = 500;

    // Colors of shapes
    private int squareColor;
    private int circleColor;
    private int triangleColor;

    public Third(Start mv) {
        this.mv = mv;
        this.position = 0;
        this.speed = 20;

        // Set up color mode
        mv.colorMode(PConstants.HSB, 360, 100, 100);

        // Generate random starting colors for the shapes
        squareColor = PApplet.floor(mv.random(0, 360));
        circleColor = PApplet.floor(mv.random(0, 360));
        triangleColor = PApplet.floor(mv.random(0, 360));
    }

    // Renders shapes
    public void render() {
        float distance = mv.width / 4; // distance between each shape
        float amplitude = mv.getAmplitude() * AMPLITUDE_MULTIPLIER;
        mv.background(0);

        // Square
        float squareSize = DISTANCE_BETWEEN_SHAPES + amplitude;
        mv.pushMatrix();
        mv.translate(distance - squareSize / 2, mv.height / 2 - squareSize / 2 + position);
        mv.rotate(mv.frameCount * 0.05f);
        mv.fill(squareColor, 100, 90);
        mv.rect(0, 0, squareSize, squareSize);
        mv.popMatrix();

        // Circle
        float circleSize = DISTANCE_BETWEEN_SHAPES + amplitude;
        mv.pushMatrix();
        mv.translate(2 * distance - circleSize / 2, mv.height / 2 - circleSize / 2 - position);
        mv.rotate(mv.frameCount * 0.1f);
        mv.fill(circleColor, 100, 90);
        mv.circle(0, 0, circleSize);
        mv.popMatrix();

        // Triangle
        float triangleSize = DISTANCE_BETWEEN_SHAPES + amplitude;
        mv.pushMatrix();
        mv.translate(3 * distance - triangleSize / 2, mv.height / 2 - triangleSize / 2 + position);
        mv.rotate(mv.frameCount * 0.15f);
        mv.fill(triangleColor, 100, 90);
        mv.triangle(0, -triangleSize / 2, -100, triangleSize / 2, 100, triangleSize / 2);
        mv.popMatrix();

        // Update color values, position, and speed
        squareColor = (squareColor + 2) % 360;
        circleColor = (circleColor + 3) % 360;
        triangleColor = (triangleColor + 4) % 360;
        position += speed;
        if (position > DISTANCE_BETWEEN_SHAPES) {
            speed = -20;
        } else if (position < -DISTANCE_BETWEEN_SHAPES) {
            speed = 20;
        }

        // Check amplitude value
        if (amplitude > 200) {
            amplitude = 200;
        }
    }
}