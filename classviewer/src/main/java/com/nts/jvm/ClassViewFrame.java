package com.nts.jvm;

import com.nts.jvm.conf.ConfFileList;
import com.nts.jvm.gui.ABoutDialog;
import com.nts.jvm.gui.FrameViewPanel;
import com.nts.jvm.gui.IconFactory;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.io.File;

public class ClassViewFrame extends JFrame {

    /**
     * ClassViewFrame
     */


    public ClassViewFrame() {
        setTitle("Class Viewer");
        FrameViewPanel contentPanel = new FrameViewPanel();
        new DropTarget(contentPanel, DnDConstants.ACTION_COPY_OR_MOVE, contentPanel, true);
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mainBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        JMenuItem openItem = new JMenuItem("Open...");
        file.add(openItem);
        mainBar.add(file);
        mainBar.add(help);
        JMenuItem aboutItem = new JMenuItem("about");
        help.add(aboutItem);
        openItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            java.util.List<String> classPath = ConfFileList.getConfFileList();
            if (!chooser.equals("")) {
                if (classPath.size() > 0) {
                    File curFile = new File(classPath.get(0));
                    chooser.setCurrentDirectory(curFile.getParentFile());
                }
            }

            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().endsWith("class")
                            || f.getName().endsWith("jar")
                            ;
                }

                @Override
                public String getDescription() {
                    return "(*.class)|Class File |jar";
                }
            });

            int r = chooser.showOpenDialog(ClassViewFrame.this);
            if (JFileChooser.APPROVE_OPTION == r) {
                contentPanel.update(chooser.getSelectedFile().getAbsolutePath());
                ConfFileList.saveConf(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        aboutItem.addActionListener(e -> {
            ABoutDialog aBoutDialog=     new ABoutDialog(this,"about us");
            aBoutDialog.setLocationRelativeTo(null);
            aBoutDialog.setVisible(true);
        });

        JMenuItem exitItem = new JMenuItem("exit");
        exitItem.addActionListener(e -> System.exit(0));
        file.add(exitItem);

        this.setJMenuBar(mainBar);
        this.setLocationRelativeTo(null);
        this.setIconImage(IconFactory.titleIcon);

        this.setVisible(true);

        try {
            java.util.List<String> classPath = ConfFileList.getConfFileList();
            if (classPath.size() > 0) {
                for (String f : classPath) {
                    contentPanel.update(f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ClassViewFrame();
    }
}
