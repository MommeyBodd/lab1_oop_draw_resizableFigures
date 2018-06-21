package main;

import java.awt.*;

public class Line extends Figure {
    public void paintFigure(Graphics g, int x, int y, int x0, int y0){
        g.drawLine(x0,y0,x,y);
        repaint();
    }
}
