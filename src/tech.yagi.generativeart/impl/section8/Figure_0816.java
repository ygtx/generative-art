package tech.yagi.generativeart.impl.section8;

import processing.core.PApplet;

import java.util.ArrayList;


public class Figure_0816 extends PApplet {

    public void settings() {
        size(1000, 1000);
    }

    FractalRoot pentagon;
    int _maxLevels = 4;
    float _structFactor = 0.2f;
    float _structNoise;

    // figure 08.16
//    int _numSides = 8;

    // figure 08.17
    int _numSides = 32;


    public void setup() {
        smooth();
        frameRate(5);
    }

    public void draw() {
        background(255);
        _structNoise += 0.01f;
        _structFactor = (noise(_structNoise) * 3) - 1;
        pentagon = new FractalRoot(frameCount);
        pentagon.drawShape();
    }

    class PointObject {
        float x, y;
        PointObject(float ex, float why) {
            x = ex;
            y = why;
        }
    }

    class FractalRoot {
        ArrayList<PointObject> pointList = new ArrayList<>();
        Branch rootBranch;

        FractalRoot(float startAngle) {

            float centerX = width / 2;
            float centerY = height / 2;

            float angleStep = 360.0f / _numSides;

            for (int i = 0; i < 360; i += angleStep) {
                float x = centerX + (400 * cos(radians(startAngle + i)));
                float y = centerY + (400 * sin(radians(startAngle + i)));
                pointList.add(new PointObject(x, y));
            }
            rootBranch = new Branch(0, 0, pointList);
        }

        void drawShape() {
            rootBranch.drawMe();
        }
    }

   class Branch {
       int level, num;
       ArrayList<PointObject> outerPointList = new ArrayList<>();
       ArrayList<PointObject> middlePointList = new ArrayList<>();
       ArrayList<PointObject> projPointList = new ArrayList<>();

       ArrayList<Branch> myBranchList = new ArrayList<>();

       Branch(int level, int num, ArrayList<PointObject> outerPointList) {
           this.level = level;
           this.num = num;
           this.outerPointList = outerPointList;
           this.middlePointList = calcMidPoints();

           projPointList = calcStructPoints();

           if ((level + 1) < _maxLevels) {
               Branch childBranch = new Branch(level + 1, 0, projPointList);
               myBranchList.add(childBranch);

               for (int i = 0; i < outerPointList.size(); i++) {
                   int nexti = i - 1;
                   if (nexti < 0) {
                       nexti += outerPointList.size();
                   }
                   ArrayList<PointObject> newPointList = new ArrayList<>();
                   newPointList.add(projPointList.get(i));
                   newPointList.add(middlePointList.get(i));
                   newPointList.add(outerPointList.get(i));
                   newPointList.add(middlePointList.get(nexti));
                   newPointList.add(projPointList.get(nexti));

                   childBranch = new Branch(level + 1, i + 1, newPointList);
                   myBranchList.add(childBranch);
               }
           }
       }

       void drawMe() {
           strokeWeight(5 - level);
           for (int i = 0; i < outerPointList.size(); i++) {
               int nexti = i + 1;
               if (nexti == outerPointList.size()) {
                   nexti = 0;
               }
               line(outerPointList.get(i).x, outerPointList.get(i).y,
                       outerPointList.get(nexti).x, outerPointList.get(nexti).y);
           }

           strokeWeight(0.5f);
           fill(255, 150);

           for (int i = 0; i < middlePointList.size(); i++) {

               PointObject middlePoint = middlePointList.get(i);
               PointObject projPoint = projPointList.get(i);

               ellipse(middlePoint.x, middlePoint.y, 5, 5);
               line(middlePoint.x, middlePoint.y, projPoint.x, projPoint.y);
               ellipse(projPoint.x, projPoint.y, 5, 5);

           }

           for (Branch myBranch : myBranchList) {
               myBranch.drawMe();
           }
       }

       ArrayList<PointObject> calcMidPoints() {
           ArrayList<PointObject> middlePointArray = new ArrayList<>();
           for (int i = 0; i < outerPointList.size(); i++) {
               int nexti = i + 1;
               if (nexti == outerPointList.size()) {
                   nexti = 0;
               }
               PointObject thisMiddlePoint = calcMidPoint(outerPointList.get(i), outerPointList.get(nexti));
               middlePointArray.add(i, thisMiddlePoint);
           }
           return middlePointArray;
       }

       PointObject calcMidPoint(PointObject end1, PointObject end2) {
           float mx, my;
           if (end1.x > end2.x) {
               mx = end2.x + ((end1.x - end2.x) / 2);
           } else {
               mx = end1.x + ((end2.x - end1.x) / 2);
           }

           if (end1.y > end2.y) {
               my = end2.y + ((end1.y - end2.y) / 2);
           } else {
               my = end1.y + ((end2.y - end1.y) / 2);
           }

           return new PointObject(mx, my);
       }

       ArrayList<PointObject> calcStructPoints() {
           ArrayList<PointObject> structList = new ArrayList<>();
           for (int i = 0; i < middlePointList.size(); i++) {
               int nexti = i + 3;
               if (nexti >= middlePointList.size()) {
                   nexti -= middlePointList.size();
               }
               PointObject thisStructPoint = calcProjPoint(middlePointList.get(i), outerPointList.get(nexti));
               structList.add(i, thisStructPoint);
           }
           return structList;
       }

       PointObject calcProjPoint(PointObject middlePoint, PointObject outerPoint) {

           float px, py;
           float adj, opp;

           if (outerPoint.x > middlePoint.x) {
               opp = outerPoint.x - middlePoint.x;
           } else {
               opp = middlePoint.x - outerPoint.x;
           }

           if (outerPoint.y > middlePoint.y) {
               adj = outerPoint.y - middlePoint.y;
           } else {
               adj = middlePoint.y - outerPoint.y;
           }

           if (outerPoint.x > middlePoint.x) {
               px = middlePoint.x + (opp * _structFactor);
           } else {
               px = middlePoint.x - (opp * _structFactor);
           }

           if (outerPoint.y > middlePoint.y) {
               py = middlePoint.y + (adj * _structFactor);
           } else {
               py = middlePoint.y - (adj * _structFactor);
           }
           return new PointObject(px, py);
       }
   }



    public void sysout(int i) {
        System.out.println(String.valueOf(i));
    }
    public void sysout(float f) {
        System.out.println(String.valueOf(f));
    }

}

