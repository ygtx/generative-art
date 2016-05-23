package tech.yagi.generativeart.impl.section6;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;


public class Figure_0605 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    int _num = 20;
    List<Circle> _circleList = new ArrayList<Circle>();

    public void setup () {
        background(255);
        smooth();
        strokeWeight(1);
        fill(150, 50);
        drawCircles();
    }

    public void draw() {

        background(255);

        for (Circle circle : _circleList) {
            circle.updateMe();
        }

    }


    void drawCircles() {

        for (int i = 0; i < _num; i++) {

            Circle thisCircle = new Circle();
            thisCircle.drawMe();
            _circleList.add(thisCircle);
        }

    }

    class Circle {
        float x, y;
        float radius;
        float linecol, fillcol;
        float alpha;
        float moveX, moveY;

        Circle() {
            x = random(width);
            y = random(height);

            radius = random(100) + 10;
            linecol = color(random(255), random(255), random(255));
            fillcol = color(random(255), random(255), random(255));
            alpha = random(255);

            moveX = random(10) - 5;
            moveY = random(10) - 5;

        }

        void drawMe() {
            noStroke();
            fill(this.fillcol, this.alpha);
            ellipse(x, y, radius * 2, radius * 2);
            stroke(linecol, 150);
            noFill();
            ellipse(x, y , 10, 10);
        }

        void updateMe() {
            this.x += this.moveX;
            this.y += this.moveY;

            if (x > (width + this.radius))  { x = 0 - this.radius; }
            if (x < (0 - this.radius))      { x = width + this.radius; }
            if (y > (height + this.radius)) { y = 0 - this.radius; }
            if (y < (0 - this.radius))      { y = height + this.radius; }

            for (Circle circle : _circleList) {
                if (circle != this) {
                    float distance = dist(this.x, this.y, circle.x, circle.y);

                    float overlap = distance - radius - circle.radius;

                    if (overlap < 0) {
                        float midX, midY;
                        midX = ( x + circle.x ) / 2;
                        midY = ( y + circle.y ) / 2;

                        stroke(0, 100);
                        noFill();
                        overlap += -1;
                        ellipse(midX, midY, overlap, overlap);

                    }
                }
            }

//            drawMe();
        }
    }


    public void mousePressed() {
        drawCircles();
        println(_circleList.size());
    }
    public void sysout(int i) {
        System.out.println(String.valueOf(i));
    }
    public void sysout(float f) {
        System.out.println(String.valueOf(f));
    }

}

