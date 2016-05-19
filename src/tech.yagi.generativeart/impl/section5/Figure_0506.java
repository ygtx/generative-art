package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0506 extends PApplet {

    public void settings() {
        size(500, 300, P3D);
    }

    float startX, noiseX;
    float startY, noiseY;

    public void setup () {
        sphereDetail(8);
        background(0);
        noStroke();

        startX = random(10);
        startY = random(10);
    }

    public void draw() {
        background(0);

        startX += 0.01;
        startY += 0.01;

        noiseX = startX;
        noiseY = startY;

        // 雲はまる（Sphere）をいっぱい書いて表現している。
        // 一個のまるがどんな感じかわかりたかったら以下のforに書き換えて試す
//        for (int y = height / 2; y <= height / 2 + 4; y += 5) {

        for (int y = 0; y <= height; y += 5) {
            noiseY += 0.1;

            noiseX = startX;
            // 左にガンガン動かしたい場合はこちら
//            noiseX += startX;

            // 1個のまるがどんな感じかわかりたかったら以下ののforに書き換えて試す
//            for (int x = width / 2; x <= width / 2 + 4; x += 5) {
            for (int x = 0; x <= width; x += 5) {
                noiseX += 0.1;
                drawPoint(x, y, noise(noiseX, noiseY));
            }
        }
    }

    void drawPoint(float x, float y, float noiseFactor) {

        pushMatrix();

        // zの正負で始点が雲の上か下かが変わる
        translate(x, 250 - y, -y);
        float sphereSize = noiseFactor * 35;
        float gray = 150 + (noiseFactor * 120);
        float alpha = 150 + (noiseFactor * 120);
        fill(gray, alpha);
        sphere(sphereSize);


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

