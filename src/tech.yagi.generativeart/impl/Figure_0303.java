package tech.yagi.generativeart.impl;

import processing.core.PApplet;


public class Figure_0303 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    public void setup() {
        noLoop();

    }

    public void draw() {

        background(255);
        float lastX = 20;
        float lastY = 50;
        float stepX = 10;
        float stepY;

        int y = 50;

        for ( int x = 20; x <= width; x +=stepX ) {

            stepY = random(20) - 10;
            y += stepY;

            line(x, y, lastX, lastY);
            lastX = x;
            lastY = y;
        }

    }

    public void mousePressed() {
        redraw();
    }


}

