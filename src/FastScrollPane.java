import javax.swing.*;
class FastScrollPane extends JScrollPane {
    public FastScrollPane(JComponent component) {
        super(component);
        getVerticalScrollBar().setUnitIncrement(20);
    }
}