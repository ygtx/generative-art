package tech.yagi.generativeart.impl.section3;

import processing.core.PApplet;


public class Figure_0306 extends PApplet {

    public void settings() {
        size(500, 100);
    }

    public void setup() {
        noLoop();

        background(255);
        strokeWeight(5);
        smooth();

    }

    public void draw() {

        background(255);

        stroke(0, 30);
        line(20, 50, 480, 50);

        stroke(20, 50, 70);
        int step = 1;

        float lastX = -999;
        float lastY = -999;

        float noiseY = random(10);
        float y;

        for (int x = 2; x < 480; x += step) {
            y = 10 + noise(noiseY) * 80;
            if (lastX > -999) {
                line(x, y, lastX, lastY);
            }
            lastX = x;
            lastY = y;

            noiseY += 0.01;
        }


    }

    public void mousePressed() {
        redraw();
    }


}

