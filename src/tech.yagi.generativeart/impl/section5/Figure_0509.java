package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0509 extends PApplet {

    public void settings() {
        size(500, 300, P3D);
    }

    int radius = 100;

    public void setup () {
        background(0);
        stroke(0);
    }

    public void draw() {
        background(255);

        translate(width / 2, height / 2, 0);
        rotateY(frameCount * 0.03f);
        rotateY(frameCount * 0.04f);

        float s = 0;
        float t = 0;
        float lastX = 0;
        float lastY = 0;
        float lastZ = 0;

        while(t < 180) {
            s += 18;
            t += 1;

            float radianS = radians(s);
            float radianT = radians(t);

            float thisX = 0 + (radius * cos(radianS) * sin(radianT));
            float thisY = 0 + (radius * sin(radianS) * sin(radianT));
            float thisZ = 0 + (radius * cos(radianT));

            if (lastX != 0) {
                line(thisX, thisY, thisZ, lastX, lastY, lastZ);
            }

            lastX = thisX;
            lastY = thisY;
            lastZ = thisZ;
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

