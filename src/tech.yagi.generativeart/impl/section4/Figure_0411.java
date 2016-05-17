package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0411 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    public void setup () {
        background(255);
//        strokeWeight(5);
        smooth();
        frameRate(12);


        strokeWeight(0.01f);

        noLoop();
    }



    public void draw() {

        float centerX = width / 2;
        float centerY = height / 2;

        float radius = 100;

        for (float angle = 0; angle < 360; angle += 0.5f) {

            float radian = radians(angle);

            if (angle < 180) {
                stroke(0, (PI - radian) * 100);
            } else {
                stroke(0, (TWO_PI - radian) * 100);
            }

            float distX = radius * cos(radian);
            float distY = radius * sin(radian);

            line(centerX, centerY, centerX + distX, centerY + distY);
        }



    }




    float customNoise(float value) {   // returns value -1 to +1
        float retValue = sin(value);
        int count = (int)(value % 10);
        for (int i = 0; i < count; i++) {
            retValue *= sin(value);
        }
        return retValue;
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

