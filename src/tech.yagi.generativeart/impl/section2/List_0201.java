package tech.yagi.generativeart.impl.section2;

import processing.core.PApplet;


public class List_0201 extends PApplet {

    int diam = 10;
    float centX, centY;

    public void settings() {
        size(500, 300);
    }

    public void setup() {
        frameRate(24);
        smooth();
        // ウインドウの背景の色を設定します。デフォルトは灰色です。http://www.musashinodenpa.com/p5/index.php?pos=899
        background(180);
        centX = width/2;
        centY = height/2;
        stroke(0);
        strokeWeight(5);
        fill(255, 50);
    }

    public void draw() {
        if (diam <= 400) {
            // この関数はdraw()の先頭でウインドウをクリアする目的でも使われます。 http://www.musashinodenpa.com/p5/index.php?pos=899
            background(180);
            ellipse(centX, centY, diam, diam);
            diam += 10;
        }
    }



}

