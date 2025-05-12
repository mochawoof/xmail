import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.*;

class Window extends JFrame {
    private JSplitPane split;

    private JTable table;
    private DefaultTableModel model;
    private FastScrollPane scrollPane;

    private JPanel rightPanel;
    private FastScrollPane rightPanelScrollPane;
    private JTextArea emailArea;
    private GridBagConstraints c;

    private JMenuBar menu;
    private JMenu account;
        private JMenuItem status;
        private JMenuItem withGoogle;

    public Window() {
        setTitle("XMail");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLaf("com.formdev.flatlaf.FlatLightLaf");

        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
        split.setDividerLocation(500);
        add(split, BorderLayout.CENTER);

        model = new DefaultTableModel();
        model.addColumn("Sender");
        model.addColumn("Subject");
        model.addColumn("Date");

        model.addRow(new String[] {"Hi", "Hello", "5/12/2025, 1:52 PM"});
        model.addRow(new String[] {"Hi", "Hello", "5/12/2025, 1:52 PM"});

        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.alternateRowColor", UIManager.getColor("Button.shadow"));
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new FastScrollPane(table);
        split.setLeftComponent(scrollPane);

        rightPanel = new JPanel(new GridBagLayout());
        rightPanelScrollPane = new FastScrollPane(rightPanel);
        split.setRightComponent(rightPanelScrollPane);

        c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0;
        c.gridwidth = 4; c.gridheight = 4;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0; c.weighty = 1.0;

        emailArea = new JTextArea();
        rightPanel.add(emailArea, c);

        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu account = new JMenu("Account");
        menu.add(account);
            status = new JMenuItem("Not Signed In");
            status.setEnabled(false);
            account.add(status);

            withGoogle = new JMenuItem("Sign In With Google");
            account.add(withGoogle);

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