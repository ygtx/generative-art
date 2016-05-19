package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class List_0504 extends PApplet {

    public void settings() {
        size(300, 300);
    }

    float startX, startY;
    float noiseX, noiseY;
    float startNoiseX, startNoiseY;


    public void setup () {
        smooth();
        background(255);
        frameRate(24);

        startNoiseX = random(20);
        startNoiseY = random(20);

        startX = random(10);
        startY = random(10);
    }

    public void draw() {
        background(255);

//        startNoiseX += 0.01;
//        startNoiseY += 0.01;
//
//        startX += (noise(startNoiseX) * 0.5) - 0.25;
//        startY += (noise(startNoiseY) * 0.5) - 0.25;

        startX -= 0.01;
        startY -= 0.01;

        noiseX = startX;
        noiseY = startY;

        for (int y = 0; y <= height; y += 5) {

//            sysout("noiseY : " + noiseY);
//            sysout("noiseX : " + noiseX);

            // noiseYはy軸ごとにインクリメント
            noiseY += 0.1f;

            noiseX = startX;
            for (int x = 0; x <= width; x += 5) {
                // noiseXはx軸上に描画していくピクセル毎にインクリメント
                noiseX += 0.1;
                // noise関数は0~1の間のfloatの値を返す
                // 進んでいるように見えるのは、noise関数がある程度関連のある値を返しているため。
                // パーリンノイズは理解しないとなー
                drawPoint(x, y, noise(noiseX, noiseY));
            }
        }
    }


    void drawPoint(float x, float y, float noiseFactor) {
        pushMatrix();
        translate(x, y);
        rotate(noiseFactor * radians(540));

        stroke(0, 150);
        line(0, 0, 20, 0);

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
    public void sysout(String str) {
        System.out.println(str);
    }

}

