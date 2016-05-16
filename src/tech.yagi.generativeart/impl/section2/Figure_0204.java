package tech.yagi.generativeart.impl.section2;

import processing.core.PApplet;


public class Figure_0204 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    public void setup() {

        smooth();
        background(230, 230, 230);

        float centX = width/2;
        float centY = height/2;
        stroke(130, 0, 0);
        strokeWeight(1);

        fill(0, 40, 0);

        ellipse(centX, centY, 30, 30);
        line(centX - 70, centY - 70, centX + 70, centY + 70);
        line(centX + 70, centY - 70, centX - 70, centY + 70);


    }



}

