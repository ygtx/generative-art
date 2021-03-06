package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0501 extends PApplet {

    public void settings() {
        size(300, 300);
    }

    public void setup () {
        smooth();
        background(255);

        noLoop();
    }


    public void draw() {
        background(255);
        float xstart = random(10);
        float xnoise = xstart;
        float ynoise = random(10);

        for (int y = 0; y <= height; y += 1) {

            ynoise += 0.01f;
            xnoise = xstart;

            for (int x = 0; x <= width; x += 1) {
                xnoise += 0.01;
                int alpha = (int)(noise(xnoise, ynoise) * 255);
                stroke(0, alpha);
                line(x, y, x + 1, y + 1);
            }

        }


    }


    public void mousePressed() {
        redraw();
    }
    public void sysout(int i) {
        System.out.println(String.valueOf(i));
    }
    public void sysout(float f) {
        System.out.println(String.valueOf(f));
    }

}

