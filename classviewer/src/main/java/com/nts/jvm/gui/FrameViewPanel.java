package com.nts.jvm.gui;

import com.nts.jvm.conf.ConfFileList;
import com.nts.jvm.util.FileNameUtil;
import com.nts.jvm.util.UUtil;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FrameViewPanel  extends DropTargetComponent {

    private final JTabbedPane tabPanel=new JTabbedPane();
    public FrameViewPanel(){
        this.setLayout(new BorderLayout());
        this.add(tabPanel);
    }

    private final Map<String, DropTargetComponent> tabMap = new HashMap<>();
    public void update(String classFileName) {
        try {
            if (tabMap.get(classFileName) == null) {
                DropTargetComponent clsPanel = null;
                boolean isOK = false;
                if (classFileName.endsWith(".jar")) {
                    clsPanel = new JarFileViewPanel();
                    clsPanel.update(classFileName);
                    clsPanel.setClassFileName(classFileName);
                    isOK = true;
                } else if (classFileName.endsWith(".class")) {
                    clsPanel = new ClassViewPanel();
                    clsPanel.update(classFileName);
                    clsPanel.setClassFileName(classFileName);
                    isOK = true;
                }
                if (isOK) {
                    String fsName = classFileName;
                    fsName = fsName.replace("\\", "/");
                    int idx = fsName.lastIndexOf("/");
                    if (idx >= 0) {
                        fsName = fsName.substring(idx + 1);
                    }
                    JButton close = UUtil.makeCloseButton();
                    JPanel titlePanel = new JPanel();
                    titlePanel.setOpaque(false);
                    JLabel title = new JLabel(FileNameUtil.getExtName(fsName));
                    titlePanel.add(title);
                    titlePanel.add(close);
                    tabPanel.addTab(fsName, clsPanel);
                    tabPanel.setTabComponentAt(tabPanel.indexOfComponent(clsPanel), titlePanel);
                    int sz = tabPanel.getTabCount();
                    tabPanel.setToolTipTextAt(sz - 1, classFileName);
                    tabPanel.setSelectedIndex(sz - 1);
                    tabMap.put(classFileName, clsPanel);
                    close.addActionListener(e -> {
                        DropTargetComponent idxComponent =(DropTargetComponent) tabPanel.getSelectedComponent();
                        tabPanel.remove(idxComponent);
                        tabMap.remove(idxComponent.getClassFileName());
                        ConfFileList.removeFile(idxComponent.getClassFileName());
                    });
                }
            } else {
                DropTargetComponent panel = tabMap.get(classFileName);
                int idx = tabPanel.indexOfComponent(panel);
                if (idx >= 0) {
                    tabPanel.setSelectedIndex(idx);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
