package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0403 extends PApplet {

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        noLoop();

        frameRate(1);

        background(255);
        smooth();


    }

    public void consoleLog(Object str) {
        System.out.println(str != null ? String.valueOf(str) : "");
    }

    public void draw() {
        background(255, 0.1f);

        drawCircleCaos(50f, 244f, 201f, 201f, 0.3f, 100);
        drawCircleCaos(0.5f, 0f, 0f, 0f, 0.5f, 5);


    }

    void drawCircleCaos(float strokeWeight, float r, float g, float b, float a, int angleStep) {

//        consoleLog(String.valueOf(strokeWeight));
//        consoleLog(String.valueOf(r));
//        consoleLog(String.valueOf(g));
//        consoleLog(String.valueOf(b));
//        consoleLog(String.valueOf(a));
//        consoleLog(String.valueOf(angleStep));

        strokeWeight(strokeWeight);
        stroke(r, g, b);


        int centerX = width / 2;
        int centerY = height / 2;
        float radiusNoise = random(10);
        float radius = 10f;
        float lastX = -999;
        float lastY = -999;
        float lastRadius = 0;
        for (float angle = 0; angle <= 360 * 100; angle += angleStep) {
            radiusNoise += 0.05f;
            radius += 0.5f;
            float thisRadius = radius + (noise(radiusNoise) * 200) - 100;
            float rad = radians(angle);

            float rX = ((angle / angleStep) % 3 == 1) ? 1.2f : 1.0f;
            float rY = ((angle / angleStep) % 5 == 1) ? 1.2f : 1.0f;

            float x = centerX + thisRadius * cos(rad) * rX;
            float y = centerY + thisRadius * sin(rad) * rY;
            if (lastX > -999) {
                line(x - lastRadius, y - lastRadius, lastX - lastRadius, lastY - lastRadius);
            }
            lastX = x;
            lastY = y;
        }
    }


    public void mousePressed() {
        redraw();
    }


}

