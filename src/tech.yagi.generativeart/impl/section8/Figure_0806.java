package tech.yagi.generativeart.impl.section8;

import processing.core.PApplet;

import java.util.ArrayList;


public class Figure_0806 extends PApplet {

    public void settings() {
        size(800, 800);
    }

    int _numChildren = 4;
    int _maxLevels = 7;

    Branch _trunk;

    public void setup() {
        background(255);
        noFill();
        smooth();
        newTree();
    }

    public void draw() {
        background(255);
        _trunk.updateMe(width / 2, height / 2);
        _trunk.drawMe();
    }


    void newTree() {
        _trunk = new Branch(1, 0, width / 2, 50);
        _trunk.drawMe();
    }

    class Branch {
        float level, index;
        float x, y;
        float endX, endY;

        float strokeWeight, alpha;
        float length, lengthChange;
        float rot, rotChange;

        ArrayList<Branch> children = new ArrayList<>();

        Branch( float level, float index, float ex, float why ) {
            this.level = level;
            this.index = index;

            this.strokeWeight = (1 / level) * 100;
            this.alpha = 255 / level;
            this.length = (1 / level) * random(200);
            this.rot = random(360);
            this.lengthChange = random(10) - 5;
            this.rotChange = random(10) - 5;

            updateMe(ex, why);

            if (level < _maxLevels) {
                for (int x = 0; x < _numChildren; x++) {
                    children.add(new Branch(level + 1, x, endX, endY));
                }
            }
        }

        void updateMe(float ex, float why) {
            this.x = ex;
            this.y = why;

            this.rot += rotChange;
            if (this.rot > 360) {
                this.rot = 0;
            } else if (this.rot < 0) {
                this.rot = 360;
            }

            this.length -= lengthChange;
            if (this.length < 0) {
                lengthChange *= -1;
            } else if (this.length > 200) {
                lengthChange *= -1;
            }

            float radian = radians(rot);
            this.endX = x + (length * cos(radian));
            this.endY = y + (length * sin(radian));

            for (Branch child : children) {
                child.updateMe(endX, endY);
            }
        }

        void drawMe() {
            strokeWeight(this.strokeWeight);
            stroke(0, alpha);
            fill(255, alpha);

            line(x, y, endX, endY);
            ellipse(endX, endY, length / 12, length / 12);

            for (Branch child : children) {
                child.drawMe();
            }
        }
    }


    public void sysout(int i) {
        System.out.println(String.valueOf(i));
    }
    public void sysout(float f) {
        System.out.println(String.valueOf(f));
    }

}

