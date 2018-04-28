package main;

import javax.swing.*;
import java.awt.*;

public abstract class Figure extends JPanel {

    public abstract void paintFigure(Graphics g, int x, int y);
    static int x0,y0;
    static int[] arrayCoordinates = new int[4];

    public static void setX0(int x0) {
        Figure.x0 = x0;
    }

    public static void setY0(int y0) {
        Figure.y0 = y0;
    }

}
