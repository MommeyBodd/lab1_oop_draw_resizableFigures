package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static main.Figure.arrayCoordinates;
import static main.Main_class.listFigure;

public class Form extends JFrame implements MouseListener, MouseMotionListener {

    private String[] ComboBoxComponents = {
            "","Line", "Rectagle", "Square", "Oval", "Circle", "Triangle"
    };
    private Figure activeFigure = new nothingChoose();
    private int coordX, coordY;

    private JComboBox<String>
            choiceFigureTypeBox = new JComboBox<>(ComboBoxComponents);

    private void addComponentsToForm(){
        setLayout(null);

        //размещение компонентов
        final int DEFAULT_WIDTH = 120;
        final int DEFAULT_HEIGHT = 30;
        final int DEFAULT_COORDINATE_X = 20;
        final int DEFAULT_COORDINATE_Y = 30;
        int SCALE = 1;

        add(choiceFigureTypeBox).setBounds(DEFAULT_COORDINATE_X, DEFAULT_COORDINATE_Y * SCALE,DEFAULT_WIDTH,DEFAULT_HEIGHT);

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
        switch (choiceFigureTypeBox.getSelectedIndex()){
            case 1: activeFigure = listFigure.get(0);
                    break;
            case 2: activeFigure = listFigure.get(1);
                break;
            case 3: activeFigure = listFigure.get(2);
                break;
            case 4: activeFigure = listFigure.get(3);
                break;
            case 5: activeFigure = listFigure.get(4);
                break;
            case 6: activeFigure = listFigure.get(5);
                break;
            case 0: activeFigure = listFigure.get(6);
                break;
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
