package tech.yagi.generativeart.impl.section8;

import processing.core.PApplet;

import java.util.ArrayList;


public class Figure_0804 extends PApplet {

    public void settings() {
        size(500, 500);
    }

    int _numChildren = 3;
    int _maxLevels = 3;

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
        ArrayList<Branch> children = new ArrayList<>();

        Branch( float level, float index, float ex, float why ) {
            this.level = level;
            this.index = index;
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
            this.endX = x + (level * (random(100) - 50));
            this.endY = y + 50 + (level * random(50));
        }

        void drawMe() {
            strokeWeight(_maxLevels - level + 1);
            line(x, y, endX, endY);
            ellipse(x, y, 5, 5);
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

