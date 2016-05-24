package tech.yagi.generativeart.impl.section7;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;


public class Figure_0708 extends PApplet {

    public void settings() {
        size(500, 300);
    }

    ArrayList<ArrayList<Cell>> _cellList = new ArrayList<>();
    int _cellSize = 2;
    int _numX, _numY;

    public void setup () {
        _numX = floor(width/_cellSize);
        _numY = floor(height/_cellSize);
        restart();
    }

    void restart() {

        _cellList = new ArrayList<>();

        for ( int x = 0; x < _numX; x++ ) {
            _cellList.add(x, new ArrayList<>());
            for ( int y = 0; y < _numY; y++ ) {
                Cell newCell = new Cell(x, y);


                _cellList.get(x).add(y, newCell);
            }
        }
        for ( int x = 0; x < _numX; x++ ) {
            for (int y = 0; y < _numY; y++) {

                int above = y - 1;
                int below = y + 1;
                int left = x - 1;
                int right = x + 1;

                if (above < 0) {
                    above = _numY - 1;
                }
                if (below == _numY) {
                    below = 0;
                }
                if (left < 0) {
                    left = _numX - 1;
                }
                if (right == _numX) {
                    right = 0;
                }

                _cellList.get(x).get(y).addNeighbour(_cellList.get(left).get(above));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(left).get(y));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(left).get(below));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(x).get(below));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(right).get(below));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(right).get(y));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(right).get(above));
                _cellList.get(x).get(y).addNeighbour(_cellList.get(x).get(above));


            }
        }
    }

    public void draw() {
//        background(200);
//        background(255, 0.5f);
        for (ArrayList<Cell> cellListX : _cellList) {
            for (Cell cell : cellListX) {
                cell.calcNextState();
            }
        }

        translate(_cellSize / 2, _cellSize / 2);

        for (ArrayList<Cell> cellListX : _cellList) {
            for (Cell cell : cellListX) {
                cell.drawMe();
            }
        }
    }

    public void mousePressed() {
        restart();
    }

    class Cell {

        float x, y;
        float state;
        float nextState;
        float lastState = 0.0f;
        List<Cell> neighbours = new ArrayList<>();

        Cell(float ex, float why) {
            x = ex * _cellSize;
            y = why * _cellSize;
            nextState = ((x / width) + (y / height)) * 14;
            state = nextState;

            neighbours = new ArrayList<>();
        }

        void addNeighbour(Cell cell) {
            neighbours.add(cell);
        }

        void calcNextState() {

            float total = 0;

            for (Cell neighbour : neighbours) {
                total += neighbour.state;
            }

            int average = (int)total / 8;

            if (average == 0) {
                nextState = 0;
            } else if (average == 0) {
                nextState = 255;
            } else {
                nextState = state + average;
                if (lastState > 0)      { nextState -= lastState; }
                if (nextState > 255)    { nextState = 255; }
                else if (nextState < 0) { nextState = 0; }
            }

            lastState = state;
        }

        void drawMe() {
            state = nextState;
            stroke(0);
            fill(state);
            ellipse(x, y, _cellSize, _cellSize);
        }
    }

    public void sysout(int i) {
        System.out.println(String.valueOf(i));
    }
    public void sysout(float f) {
        System.out.println(String.valueOf(f));
    }

}

