package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0502 extends PApplet {

    public void settings() {
        size(300, 300);
    }

    public void setup () {
        smooth();
        background(255);


//        noLoop();

        float xstart = random(10);
        float xnoise = xstart;
        float ynoise = random(10);

        for (int y = 0; y <= height; y += 5) {

            ynoise += 0.1f;
            xnoise = xstart;

            for (int x = 0; x <= width; x += 5) {
                xnoise += 0.1;
                drawPoint(x, y, noise(xnoise, ynoise));
            }

        }


    }

    void drawPoint(float x, float y, float noiseFactor) {
//        strokeWeight(1.5f);
        sysout(noiseFactor);
//        float len = constrain(10 * noiseFactor, 0.0f, 4.0f);
        float len = 10 * noiseFactor;
//        float len = 8.5f;
        sysout(len);
        rect(x, y, len, len);
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

