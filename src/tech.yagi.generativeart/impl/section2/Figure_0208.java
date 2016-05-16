package tech.yagi.generativeart.impl.section2;

import processing.core.PApplet;


public class Figure_0208 extends PApplet {

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
        stroke(120, 0, 0);
//        strokeWeight(5);
//        fill(255, 50);
    }

    public void draw() {
        if (diam <= 400) {
            // この関数はdraw()の先頭でウインドウをクリアする目的でも使われます。 http://www.musashinodenpa.com/p5/index.php?pos=899
            background(180);

            strokeWeight(0);
            noFill();
            int tempdiagram = diam;

            // backgroundで全部消して、毎回全◯を書き直してるってこと。一つずつ広がっていく表現
            while (tempdiagram > 10) {
                ellipse(centX, centY, tempdiagram, tempdiagram);
                tempdiagram -= 10;
            }
            diam += 10;

        }
    }



}

