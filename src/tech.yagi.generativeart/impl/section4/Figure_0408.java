package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0408 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    public void setup() {
        noLoop();
        background(255);
        strokeWeight(5);
        smooth();

        float radius = 100f;
        int centerX = 250;
        int centerY = 150;

        stroke(0, 30);
        noFill();
        ellipse(centerX, centerY, radius * 2, radius * 2);

        stroke(20, 50, 70);
        strokeWeight(1);

        float x, y;
        float noiseVal = random(10);
        float radVariance, thisRadius, rad;
        beginShape();

        fill(20, 50, 70, 50);
        for (float ang = 0; ang <= 360; ang += 1) {

            noiseVal += 0.1f;
            radVariance = 30 * customNoise(noiseVal);

            thisRadius = radius + radVariance;
            rad = radians(ang);
            x = centerX + (thisRadius * cos(rad));
            y = centerY + (thisRadius * sin(rad));

            curveVertex(x, y);

        }
        endShape();
    }

    float customNoise(float value) {
        int count = (int)(value % 12);
        return pow(sin(value), count);
    }

//
//    public void draw() {
//
//
//
//    }

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

