package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static main.Main_class.arrayCoordinates;


public class Form extends JFrame implements MouseListener, MouseMotionListener {

    public static ArrayList<Figure> listOfFigure = new ArrayList<>();

    private String[] ComboBoxComponents = {
            "","Line", "Rectagle", "Square", "Oval", "Circle", "Triangle"
    };
    private Figure activeFigure = new nothingChoose();
    private int coordX, coordY;

    private JButton buttonClear = new JButton("Очистить"),
            buttonSerialize = new JButton("Записать"),
            buttonChange = new JButton("Изменить"),
            buttonLoad = new JButton("Загрузить");

    private JComboBox<String>
            choiceFigureTypeBox = new JComboBox<>(ComboBoxComponents);

    private static int indexToChange = -1;
    private static boolean flag = true;


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
            case 1:
                activeFigure = new Line();
                repaint();
                break;
            case 2:
                activeFigure = new Rectangle();
                repaint();
                break;
            case 3:
                activeFigure = new Square();
                repaint();
                break;
            case 4:
                activeFigure = new Oval();
                repaint();
                break;
            case 5:
                activeFigure = new Circle();
                repaint();
                break;
            case 6:
                activeFigure = new Triangle();
                repaint();
                break;
            case 0:
                activeFigure = new nothingChoose();

                repaint();
                break;
        }

        flag = true;
    }

    public void paint(Graphics g) {
        super.paint(g);
        int index = 0;


        for (Figure temp : listOfFigure){
            if (index == indexToChange) {
                activeFigure = temp;
                Figure.xStart = temp.getX();
                Figure.yStart = temp.getY();
                flag = false;
            }
            else {
                temp.paintFigure(g, temp.getX1(), temp.getY1(), temp.getX(), temp.getY());
            }
            index++;
        }

        activeFigure.paintFigure(g, coordX, coordY, Figure.xStart, Figure.yStart);
    }

    public void mousePressed(MouseEvent me) {
        Figure.xStart = me.getX();
        Figure.yStart = me.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent me) {
        activeFigure = new nothingChoose();
        super.repaint();
    }


    public void mouseReleased(MouseEvent me) {
        activeFigure.setX(Figure.xStart);
        activeFigure.setY(Figure.yStart);
        activeFigure.setX1(me.getX());
        activeFigure.setY1(me.getY());

        if (flag){
            listOfFigure.add(activeFigure);
            //comboBoxFigureNumber.addItem("Shape " + (listOfFigure.size()-1));
        }
        indexToChange = -1;

        //activeFigure = new NonChooseFigure();

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
