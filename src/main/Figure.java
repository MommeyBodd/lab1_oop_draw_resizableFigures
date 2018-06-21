package main;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Figure extends JPanel{

    public abstract void paintFigure(Graphics g, int x, int y, int x0, int y0);
    public static int yStart,xStart;
    private int x,y,x1,y1;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

}
