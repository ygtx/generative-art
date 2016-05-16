package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0402 extends PApplet {

    public void settings() {
        size(300, 300);
    }

    public void setup() {
        noLoop();

        background(255);
        strokeWeight(5);
        smooth();

    }

    public void draw() {

        int centerX = width / 2;
        int centerY = height / 2;

        int radius = 100;



        for (float angle = PI / 10f; angle <= TWO_PI + PI / 10f; angle += PI/10f) {
            float x = centerX + radius * sin(angle);
            float y = centerY + radius * cos(angle);
            point(x, y);
        }



    }

    public void mousePressed() {
        redraw();
    }


}

