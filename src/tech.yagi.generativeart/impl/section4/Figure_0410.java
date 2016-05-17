package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0410 extends PApplet {

    public void settings() {
        size(500, 300);
    }


    float radius = 100;
    int centX = 250;
    int centY = 150;
    float startNoise, noiseStep;

    float eyeRootx, eyeRooty, eyeXnoise, eyeYnoise;
    float eyeDistRootX, eyeDistRootY, eyeDistXnoise, eyeDistYnoise;

    public void setup () {
        size(500,300);
        background(255);
        strokeWeight(5);
        smooth();
        frameRate(12);

        stroke(0, 30);
        noFill();
        ellipse(centX,centY,radius*2,radius*2);

        startNoise = random(10);
        noiseStep = 0.1f;

        // めんたま用
        eyeRootx = (width/2) - 50;
        eyeRooty = height/2;
        eyeXnoise = random(10);
        eyeYnoise = random(10);
        eyeDistRootX = 30;
        eyeDistRootY = 0;
        eyeDistXnoise = random(10);
        eyeDistYnoise = random(10);

        strokeWeight(1);
    }

    float stepStep = 0.01f;

    public void draw() {

        /**
         *
         *  背景色を薄い青にし、ゆるく点滅させる。
         *
         */

        // 下記、白と青の合わせ技であたたかみのあるゆるい点滅を表現
        noStroke();
        // 白。alphaで体の残像を残す
        fill(255, random(10));
        rect(0,0,width,height);
        // 青。alphaで体の残像を残す
        fill(20, 50, 70, random(50));
        rect(0,0,width,height);

        /**
         *
         * 体を描く
         *
         */

        // startNoiseのインクリメントは、コメントアウトしても大差なし
        startNoise += 0.01;

        // noiseのseedの大きさのコントロール
        noiseStep += stepStep;
        // 絶対値で5を超えると、方向が逆になる（* -1）
        if (noiseStep > 5) {
            stepStep *= -1;
        } else if (noiseStep < -5) {
            stepStep *= -1;
        }

        // declaration
        float x, y;
        float noiseval = startNoise;
        fill(255, 150);
        stroke(20, 50, 70);

        beginShape();
        // 最初の頂点を決める
        vertex((width/2)-20, height);
        // 90度から初めて、430 = （360 + 70）度まで、15度刻みで、輪郭のうねうねを書く
        for (float ang = 90; ang <= 430; ang += 15) {

            // noiseを使って輪郭のうねりの半径を決めていく
            noiseval += noiseStep;
            // customNoise = 1 ~ 1 なので、-40 ~ 40。ここでうねりの山谷を決める
            float radVariance = 40 * customNoise(noiseval);
            // radius = 100 なので、最低100
            float thisRadius = radius + radVariance;

            // 単位角ごとに書いていく
            float rad = radians(ang);
            // 決めた半径に対してsinとcosでx,yを決める
            x = centX + (thisRadius * cos(rad));
            y = centY + (thisRadius * sin(rad));

            // カーブ系のうねりを次の（この）x,yに向けて書く
            curveVertex(x,y);
        }


        // TODO: 何故か２回これやらないと輪郭の一番下がとんがってしまう
        curveVertex((width/2)+20, height);
        curveVertex((width/2)+20, height);

        // 最初の頂点まで引く。もし最初の頂点に達しない場合は、うねうねが裂ける
        vertex((width/2)-20, height);
        // もし最初の頂点に達しない場合は、うねうねが裂ける
//        vertex((width/2)-20, height - 100);
        endShape();


        /**
         *
         * 目ん玉を描く
         *
         */

        eyeXnoise += 0.01;
        eyeYnoise += 0.01;

        // 目の位置
        float eye1x = eyeRootx + (noise(eyeXnoise) * 40) - 20;
        float eye1y = eyeRooty + (noise(eyeYnoise) * 20) - 10;
        // 目の間隔
        float eyeDistX = eyeDistRootX + (noise(eyeXnoise) * 20) - 10;
        float eyeDistY = eyeDistRootY + (noise(eyeYnoise) * 40) - 20;

        // 白目
        stroke(0);
        fill(255);
        ellipse(eye1x, eye1y, 20, 20);
        ellipse(eye1x+eyeDistX, eye1y+eyeDistY, 20, 20);

        // 黒目
        fill(0);
        ellipse(eye1x, eye1y, 5, 5);
        ellipse(eye1x+eyeDistX, eye1y+eyeDistY, 5, 5);


    }

    float customNoise(float value) {   // returns value -1 to +1
        float retValue = sin(value);
        int count = (int)(value % 10);
        for (int i = 0; i < count; i++) {
            retValue *= sin(value);
        }
        return retValue;
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

