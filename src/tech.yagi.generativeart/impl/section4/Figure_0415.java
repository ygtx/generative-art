package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0415 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    public void setup () {
        background(255);
        smooth();
        strokeWeight(0.01f);
        noLoop();
    }



    public void draw() {

        float centerX = width / 2;
        float centerY = height / 2;

        float radius = 100;
        float radiusNoiseStep = 50;

        for (float angle = 0; angle < 360; angle += 0.01f) {

            float radian = radians(angle);
            float noise = customNoise(angle);

            if (angle < 180) {
                stroke(0, (PI - radian) * 100);
            } else {
                stroke(0, (TWO_PI - radian) * 100);
            }

            float distX = radius * cos(radian) + radiusNoiseStep * noise;
            float distY = radius * sin(radian) + radiusNoiseStep * noise;

            line(centerX, centerY, centerX + distX, centerY + distY);
        }



    }




    float customNoise(float value) {   // returns value -1 to +1

//        float noise = noise(random(10));


        float retValue = sin(value);
        int count = (int)(value % 10);
        for (int i = 0; i < count; i++) {
            retValue *= sin(value);
        }
        return abs(retValue);
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

