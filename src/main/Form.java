package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static main.Figure.arrayCoordinates;
import static main.Main_class.listFigure;

public class Form extends JFrame implements MouseListener, MouseMotionListener {

    private Figure activeFigure = new nothingChoose();
    private int coordX, coordY;

    private JRadioButton
            Line = new JRadioButton("Line", false),
            Rectangle = new JRadioButton("Rectagle", false),
            Square = new JRadioButton("Square", false),
            Oval = new JRadioButton("Oval", false),
            Circle = new JRadioButton("Circle",false),
            Triangle = new JRadioButton("Triangle", false);

    private void addComponentsToForm(){
        setLayout(null);

        //выбор фигуры
        ButtonGroup typeFigure = new ButtonGroup();

        typeFigure.add(Line);
        typeFigure.add(Rectangle);
        typeFigure.add(Square);
        typeFigure.add(Oval);
        typeFigure.add(Circle);
        typeFigure.add(Triangle);

        //размещение компонентов
        int DEFAULT_WIDTH = 120;
        int DEFAULT_HEIGHT = 30;
        int DEFAULT_COORDINATE_X = 20;
        int DEFAULT_COORDINATE_Y = 30;
        int SCALE = 1;


        add(Line).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE++, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(Rectangle).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE++, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(Square).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE++, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(Oval).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE++, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(Circle).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE++, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(Triangle).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    Form() {
        addComponentsToForm();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseDragged(MouseEvent me) {
        // сохранить координаты
        coordX = me.getX();
        coordY = me.getY();
        if (Line.isSelected()){
            activeFigure = listFigure.get(0);
        } else if (Rectangle.isSelected()) {
            activeFigure = listFigure.get(1);
        } else if (Square.isSelected()) {
            activeFigure = listFigure.get(2);
        } else if (Oval.isSelected()) {
            activeFigure = listFigure.get(3);
        } else if (Circle.isSelected()) {
            activeFigure = listFigure.get(4);
        } else if (Triangle.isSelected()) {
            activeFigure = listFigure.get(5);
        } else {
            activeFigure = listFigure.get(6);
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        activeFigure.paintFigure(g, coordX, coordY);
    }

    public void mousePressed(MouseEvent me) {
        Figure.setX0(me.getX());
        Figure.setY0(me.getY());
        repaint();
    }

    public void mouseClicked(MouseEvent me) {
        activeFigure = new nothingChoose();
        super.repaint();
    }


    public void mouseReleased(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void mouseMoved(MouseEvent me) {

    }

    static void normalizeCoord(int x0, int y0, int x1, int y1) {
        if (x0 <= x1) {
            if (y0 <= y1) {
                arrayCoordinates[0] = x0;
                arrayCoordinates[1] = y0;
                arrayCoordinates[2] = x1;
                arrayCoordinates[3] = y1;
            } else {
                arrayCoordinates[0] = x0;
                arrayCoordinates[1] = y1;
                arrayCoordinates[2] = x1;
                arrayCoordinates[3] = y0;
            }
        } else {
            if (y0 <= y1) {
                arrayCoordinates[0] = x1;
                arrayCoordinates[1] = y0;
                arrayCoordinates[2] = x0;
                arrayCoordinates[3] = y1;
            } else {
                arrayCoordinates[0] = x1;
                arrayCoordinates[1] = y1;
                arrayCoordinates[2] = x0;
                arrayCoordinates[3] = y0;
            }
        }
    }
}
