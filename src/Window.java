import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {
    public Window() {
        setTitle("XMail");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLaf("org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel");

        setVisible(true);
    }

    public void setLaf(String lafName) {
        try {
            for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
                if (lafInfo.getName().equals(lafName)) {
                    UIManager.setLookAndFeel(lafInfo.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                    return;
                }
            }

            // Try to set laf directly
            UIManager.setLookAndFeel(lafName);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}