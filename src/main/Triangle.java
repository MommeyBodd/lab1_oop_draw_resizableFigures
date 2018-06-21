package main;

import java.awt.*;

public class Triangle extends Figure {
    public void paintFigure(Graphics g, int x, int y, int x0, int y0){
        g.drawLine(x0,y0,x0,y);
        g.drawLine(x0,y0,x,y0);
        g.drawLine(x0,y,x,y0);
        repaint();
    }
}
