package tech.yagi.generativeart.impl;

import processing.core.PApplet;


public class Figure_0210 extends PApplet {


    public void settings() {
        size(500, 300);
    }

    public void setup() {
        background(180);
        strokeWeight(4);
        strokeCap(SQUARE);
        for ( int h = 10; h <= (height - 15); h += 10 ) {
            stroke(0, 255 - h);
            line(10, h, width - 20, h);
            stroke(255, h);
            line(10, h + 4, width -20, h + 4);
        }
    }


}

