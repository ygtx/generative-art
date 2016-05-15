package tech.yagi.generativeart.impl;

import processing.core.PApplet;


public class Figure_0303 extends PApplet {

    int step = 10;
    float lastX = -999;
    float lastY = -999;
    float y = 50;
    int borderX = 20;
    int borderY = 10;

    public void settings() {
        size(500, 300);
    }

    public void setup() {

        for ( int x = borderX; x <= width - borderX; x +=step ) {
            y = borderY + random(height - 2* borderY);
            if ( lastX > -999 ) {
                line(x, y, lastX, lastY);
            }
            lastX = x;
            lastY = y;
        }

    }


}

