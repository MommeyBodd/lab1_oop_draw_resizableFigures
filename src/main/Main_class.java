package main;

import javax.swing.*;

import java.util.ArrayList;

import static create_gui_form.SwingConsole.run;


public class Main_class extends JFrame {
    public static ArrayList<Figure> listFigure;

    public static void main(String[] args) {
        JFrame window = run(new Form(),900,700);

        makeFiguresList();

    }

    public static void makeFiguresList(){
        //создание списка Фигур
        listFigure = new ArrayList<>();
        listFigure.add(new Line());
        listFigure.add(new Rectangle());
        listFigure.add(new Square());
        listFigure.add(new Oval());
        listFigure.add(new Circle());
        listFigure.add(new Triangle());
        listFigure.add(new nothingChoose());
    }

}

