
import javax.swing.*;
import java.awt.*;

public class WindowInfoFilm extends JFrame {
    public WindowInfoFilm(JComponent component){
        super();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension scrSize = kit.getScreenSize();
        setBounds(scrSize.width / 2 - 500, scrSize.height / 2 - 350, 1000, 700);
        add(component);
    }
}
