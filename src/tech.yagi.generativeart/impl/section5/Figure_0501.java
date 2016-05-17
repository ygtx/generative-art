package tech.yagi.generativeart.impl.section5;

import processing.core.PApplet;


public class Figure_0501 extends PApplet {

    public void settings() {
        size(1000, 600);
    }

    float _angnoise, _radiusnoise;
    float _xnoise, _ynoise;
    float _angle = -PI/2;
    float _radius;
    float _strokeCol = 254;
    int _strokeChange = -1;

    public void setup () {
        background(255);
        smooth();
        frameRate(30);
        noFill();
//        noLoop();

        _angnoise = random(10);
        _radiusnoise = random(10);
        _xnoise = random(10);
        _ynoise = random(10);
    }

    public void draw() {

        _radiusnoise += 0.005f;
        _radius = (noise(_radiusnoise) * (width + 50)) + 1;

        // アングルも完全インクリメンタルではなく、ノイズ混じりで微妙にずらしてく
        _angnoise += 0.005f;
        _angle += (noise(_angnoise) * 6) - 3;
        if (_angle > 360) { _angle -= 360; }
        if (_angle < 0) { _angle += 360; }

        // センターも微妙にずらしていく
        _xnoise += 0.01f;
        _ynoise += 0.01f;
        float centerX = width / 2 + (noise(_xnoise) * 100) - 50;
        float centerY = height / 2 + (noise(_ynoise) * 100) - 50;

        // 始点
        float rad = radians(_angle);
        float x1 = centerX + (_radius * cos(rad));
        float y1 = centerY + (_radius * sin(rad));
        // 終点。始点の180度反対側
        float opprad = rad  + PI; // ここで180度反対側を指定
        float x2 = centerX + (_radius * cos(opprad));
        float y2 = centerY + (_radius * sin(opprad));

        // 濃い255から0に向かって薄くなり、0になったら255を目指して濃くなる
        _strokeCol += _strokeChange;
        if (_strokeCol > 254) { _strokeChange = -1; }
        if (_strokeCol < 0) { _strokeChange = 1; }
        stroke(_strokeCol, 60);
        strokeWeight(1);

        // x1, y1はセンターではない。中心点から180度線上に線を引く
        line(x1, y1, x2, y2);

    }




    float customNoise(float value) {   // returns value -1 to +1

//        float noise = noise(random(10));


        float retValue = sin(value);
        int count = (int)(value % 10);
        for (int i = 0; i < count; i++) {
            retValue *= sin(value);
        }
        return abs(retValue);
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

