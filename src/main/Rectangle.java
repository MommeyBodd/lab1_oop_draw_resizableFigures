package main;

import java.awt.*;

import static main.Form.normalizeCoord;

public class Rectangle extends Figure{
    public void paintFigure(Graphics g, int x, int y){
        normalizeCoord(x0,y0,x,y);
        g.drawRect(arrayCoordinates[0],arrayCoordinates[1],arrayCoordinates[2]-arrayCoordinates[0],arrayCoordinates[3]-arrayCoordinates[1]);
        repaint();
    }
}