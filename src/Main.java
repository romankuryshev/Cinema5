
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void showInfoFilm(JComponent component){
        WindowInfoFilm window = new WindowInfoFilm(component);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow frame = new MainWindow();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });
    }
}
