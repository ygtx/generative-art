package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0505 extends PApplet {

    public void settings() {
        size(500, 300, P3D);
    }

    public void setup () {
        sphereDetail(40);
    }

    public void draw() {
        background(255);

        pushMatrix();
        translate(width / 4, height / 2, 10);
        sphere(100);
        popMatrix();

        pushMatrix();
        translate(width / 4 * 3, height / 2, 50);
        sphere(100);
        popMatrix();

        pushMatrix();
        translate(width / 2, height / 2, 150);
        sphere(100);
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

