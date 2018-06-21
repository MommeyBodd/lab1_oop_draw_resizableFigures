package main;

import javax.swing.*;

import java.util.ArrayList;

import static create_gui_form.SwingConsole.run;


public class Main_class extends JFrame {
    static int[] arrayCoordinates = new int[4];

    public static void main(String[] args) {
        JFrame window = run(new Form(),900,700);
    }
}

