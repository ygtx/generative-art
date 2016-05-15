package tech.yagi.generativeart.impl;

import processing.core.PApplet;


public class Figure_0307 extends PApplet {

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


        float stepX = 1;
        float lastX = -999;
        float lastY = -999;
        float angle = 0;
        float y = 50;

        for (int x = 20; x <= 480; x += stepX ) {

            float rad = radians(angle);

            // sin curve with random
//            y = 50 + (pow(cos(rad), 3) * noise(rad * 2) * 30);

            y = 20 + (customRandom() * 60);

            if (lastX > -999) {
                line(x, y, lastX, lastY);
            }

            lastX = x;
            lastY = y;

            angle++;

        }
    }

    float customRandom() {
        return 1 - pow(random(1), 0.299999f);
    }


    public void mousePressed() {
        redraw();
    }


}

