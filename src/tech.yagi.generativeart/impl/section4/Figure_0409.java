package tech.yagi.generativeart.impl.section4;

import processing.core.PApplet;


public class Figure_0409 extends PApplet {

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
        // there's a disco going on in the background
        fill(255, random(10));
        noStroke();
        rect(0,0,width,height);
        fill(20, 50, 70, random(50));
        rect(0,0,width,height);

        startNoise += 0.01;
        noiseStep += stepStep;
        if (noiseStep > 5) {
            stepStep *= -1;
        } else if (noiseStep < -5) {
            stepStep *= -1;
        }

        float x, y;
        float noiseval = startNoise;

        fill(255, 150);
        stroke(20, 50, 70);
        beginShape();
        vertex((width/2)-20, height);

        for (float ang = 90; ang <= 430; ang += 15) {

            noiseval += noiseStep;
            float radVariance = 40 * customNoise(noiseval);

            float thisRadius = radius + radVariance;
            float rad = radians(ang);
            x = centX + (thisRadius * cos(rad));
            y = centY + (thisRadius * sin(rad));

            curveVertex(x,y);
        }

        curveVertex((width/2)+20, height);
        curveVertex((width/2)+20, height);
        vertex((width/2)-20, height);
        endShape();


   eyeXnoise += 0.01;
  eyeYnoise += 0.01;

  float eye1x = eyeRootx + (noise(eyeXnoise) * 40) - 20;
  float eye1y = eyeRooty + (noise(eyeYnoise) * 20) - 10;
  float eyeDistX = eyeDistRootX + (noise(eyeXnoise) * 20) - 10;
  float eyeDistY = eyeDistRootY + (noise(eyeYnoise) * 40) - 20;
  stroke(0);
  fill(255);
  ellipse(eye1x, eye1y, 20, 20);
  ellipse(eye1x+eyeDistX, eye1y+eyeDistY, 20, 20);
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

