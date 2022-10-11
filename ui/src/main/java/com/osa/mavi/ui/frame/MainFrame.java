package com.osa.mavi.ui.frame;

import com.osa.mavi.controller.MaviControler;
import com.osa.mavi.core.processor.strategy.StrategyName;
import com.osa.mavi.ui.util.IconsResourceUtil;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oleksii
 * @since Sep 29, 2022
 */
public class MainFrame extends JFrame {
    
    private final JFrame mainFrame;
    
    protected MaviControler controller;
    
    private JLabel imagePreview = new JLabel("Here will be preview");
    
    private final JLabel colLabel;
    
    private final JLabel rowLabel;
    
    private final JLabel nonzerosLabel;
    
    private final JButton exportButton;
    
    private final JComboBox strategyComboBox;
    
    private final JComboBox paletteComboBox;
    
    public MainFrame() {
        
        // attach i18n
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("i18n/uistrings", locale);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        controller = new MaviControler();
        
        imagePreview = new JLabel("Here will be preview");
        imagePreview.setOpaque(true);
        colLabel = new JLabel(rb.getString("com.osa.mavi.ui.matrix.cols"));
        rowLabel = new JLabel(rb.getString("com.osa.mavi.ui.matrix.rows"));
        nonzerosLabel = new JLabel(rb.getString("com.osa.mavi.ui.matrix.nnz"));
        strategyComboBox = crateStrategyComboBox(rb);
        paletteComboBox = createPaletteComboBox(rb);
        exportButton = createExportButton(rb);
        
        mainFrame = new JFrame(rb.getString("com.osa.mavi.ui.mavi"));
        mainFrame.setJMenuBar(createMenuBar(rb));
        
        JPanel panel = createLayoutForMainFrame();
        // info panel
        
        mainFrame.add(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 500);
        mainFrame.setVisible(true);
    }
    
    private JPanel createLayoutForMainFrame() {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;        
        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 2;
//        gbc.ipadx = 200;
//        gbc.ipady = 200;
        panel.add(imagePreview, gbc);
        
        // reset
//        gbc.ipadx = 0;
//        gbc.ipady = 0;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(paletteComboBox, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
//        gbc.weighty = 1.0;
        panel.add(strategyComboBox, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(exportButton, gbc);
        return panel;
    }
    
//    private JPanel createLayoutForMainFrame() {
//        JPanel panel = new JPanel();
//        GridBagLayout layout = new GridBagLayout();
//        panel.setLayout(layout);
//        GridBagConstraints gbc = new GridBagConstraints();
//        
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;        
//        gbc.gridy = 0;
//        gbc.gridwidth = 3;
//        gbc.gridheight = 3;
//        gbc.ipadx = 200;
//        gbc.ipady = 200;
//        panel.add(imagePreview, gbc);
//        gbc.ipadx = 0;
//        gbc.ipady = 0;
//        
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        panel.add(colLabel, gbc);
//        
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panel.add(rowLabel, gbc);
//        
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        panel.add(nonzerosLabel, gbc);
//        
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        panel.add(strategyComboBox);
//        
//        gbc.gridx = 2;
//        gbc.gridy = 2;
//        panel.add(exportButton);
//        return panel;
//    }
    
    private JComboBox createPaletteComboBox(final ResourceBundle rb) {
        final String[] paletteValues = {"grey", "color"};
        return new JComboBox(paletteValues);
    }
    
    private JComboBox crateStrategyComboBox(final ResourceBundle rb) {
        final String[] comboBoxValues = {
            rb.getString("com.osa.mavi.ui.strategy.max"),
            rb.getString("com.osa.mavi.ui.strategy.max.abs"),
            rb.getString("com.osa.mavi.ui.strategy.mid"),
            rb.getString("com.osa.mavi.ui.strategy.mid.avg"),
        };
        return new JComboBox(comboBoxValues);
    }
    
    private JMenuBar createMenuBar(final ResourceBundle rb) {
        JMenuBar applicationMenuBar = new JMenuBar();
        applicationMenuBar.add(createFileMenu(rb));
        applicationMenuBar.add(createHelpMenu(rb));
        return applicationMenuBar;
    }
    
    private JMenu createFileMenu(ResourceBundle rb) {
        JMenuItem openMenuItem = createOpenMenuItem(rb);
        JMenuItem closeMenuItem = createCloseMenuItem(rb);        
        return getLabeledMenuGroup(rb, "com.osa.mavi.ui.menu.file", Arrays.asList(openMenuItem, closeMenuItem));
    }
    
    private JMenu createHelpMenu(ResourceBundle rb) {
        JMenuItem aboutMenuItem = createAboutMenuItem(rb);
        return getLabeledMenuGroup(rb, "com.osa.mavi.ui.menu.help", Arrays.asList(aboutMenuItem));
    }
    
    private JMenuItem createAboutMenuItem(final ResourceBundle rb) {
        JMenuItem item = new JMenuItem(rb.getString("com.osa.mavi.ui.menu.item.about"));
        item.addActionListener(
                (event)->{JOptionPane.showMessageDialog(this, rb.getString("com.osa.mavi.ui.about"));});
        return item;
    }
    
    private JMenuItem createCloseMenuItem(final ResourceBundle rb) {
        JMenuItem item = new JMenuItem(rb.getString("com.osa.mavi.ui.menu.item.close"));
        item.addActionListener((event)->System.exit(0));
        return item;
    }
    
    private JButton createExportButton(final ResourceBundle rb) {
        JButton button = new JButton(rb.getString("com.osa.mavi.ui.button.export"));
        button.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle(rb.getString("com.osa.mavi.ui.dialog.save.title"));
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showSaveDialog(mainFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file to save to: " + selectedFile.getAbsolutePath());
                controller.saveMatrixPortraitFile(selectedFile.getAbsolutePath(),
                        320, 320, StrategyName.MAX_ABS_VAL);
            }
        });
        return button;
    }
    
    private JMenuItem createOpenMenuItem(final ResourceBundle rb) {
        JMenuItem item = new JMenuItem(rb.getString("com.osa.mavi.ui.menu.item.open"));
        item.setIcon(IconsResourceUtil.getOpenIcon());
        item.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle(rb.getString("com.osa.mavi.ui.dialog.open.title"));
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                controller.setMatrixFilePath(selectedFile.getAbsolutePath());
                imagePreview.setIcon(new ImageIcon(controller.getPreviewStats().getImage()));
            }
        });
        return item;
    }
    
    /**
     * Create instance of {@link JMenu} with requested text and set items
     * @param rb resource bundle
     * @param label i18n key for text that has to be set
     * @param items
     * @return 
     */
    private JMenu getLabeledMenuGroup(final ResourceBundle rb, final String label, List<JMenuItem> items) {
        JMenu menu = new JMenu(rb.getString(label));
        for (JMenuItem item : items) {
            menu.add(item);
        }
        return menu;
    }
}
