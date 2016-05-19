package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0507 extends PApplet {

    public void settings() {
        size(500, 300, P3D);
    }

    float startX, startY, startZ;
    float noiseX, noiseY, noiseZ;

    int sideLength = 200;
    int spacing = 5;

    public void setup () {
        background(0);
        noStroke();

        startX = random(10);
        startY = random(10);
        startZ = random(10);
    }

    public void draw() {
        background(0);

        startX += 0.01;
        startY += 0.01;
        startZ += 0.01;

        noiseX = startX;
        noiseY = startY;
        noiseZ = startZ;

        translate(150, 40, -150);
        rotateZ(frameCount * 0.1f);
        rotateY(frameCount * 0.1f);

        for (int z = 0; z < sideLength; z += spacing) {
            noiseZ += 0.1;
            noiseY = startY;

            for (int y = 0; y <= sideLength; y += spacing) {
                noiseY += 0.1;
                noiseX = startX;

                for (int x = 0; x <= sideLength; x += spacing) {
                    noiseX += 0.1;
                    drawPoint(x, y, z, noise(noiseX, noiseY, noiseZ));
                }
            }
        }


    }

    void drawPoint(float x, float y, float z, float noiseFactor) {

        pushMatrix();

        translate(x, y, z);

        float grey = noiseFactor * 255;
        fill(grey, 10);
        box(spacing, spacing, spacing);

        popMatrix();

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

