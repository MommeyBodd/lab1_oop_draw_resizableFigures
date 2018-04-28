package create_gui_form;

import javax.swing.*;
import java.awt.*;

public class SwingConsole {
    public static JFrame run(final JFrame f, final int width, final int height) {
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        int location_X = (screen_size.width - width) / 2;
        int location_Y = (screen_size.height - height) / 2;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setBounds(location_X,location_Y,width,height);
                f.setVisible(true);
            }
        });
        return f;
    }
}



