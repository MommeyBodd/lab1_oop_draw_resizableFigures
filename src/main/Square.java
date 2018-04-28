package main;

import java.awt.*;

public class Square extends Figure {

    public void paintFigure(Graphics g, int x, int y){
        int width;
        if (x0 < x){
            width = x - x0;
            if(y0 < y){
                g.drawRect(x0,y0,width,width);
            }
            else {
                g.drawRect(x0,y0-width,width,width);
            }
        }
        else {
            width = x0 - x;
            if(y0 < y){
                g.drawRect(x,y0,width,width);
            }
            else {
                g.drawRect(x,y0-width,width,width);
            }
        }
        repaint();
    }
}
