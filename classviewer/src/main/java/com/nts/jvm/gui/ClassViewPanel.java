package com.nts.jvm.gui;


import com.nts.jvm.classfile.ClassFile;
import com.nts.jvm.classfile.ClassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;

public class ClassViewPanel extends DropTargetComponent  {

    private final MethodPanel methodPanel;
    private final ClassCodePanel classInfoPanel;
    private final HexPanel hexPanel;
    private  final  SourcePanel sourcePanel;


    public  ClassViewPanel() {
        JSplitPane mainPanel = new JSplitPane();
        mainPanel.setDividerLocation(260);
        mainPanel.setLeftComponent(methodPanel = new MethodPanel());
        mainPanel.setRightComponent(classInfoPanel = new ClassCodePanel());
        sourcePanel=new SourcePanel();

        JTabbedPane tabPanel = new JTabbedPane();
        hexPanel = new HexPanel();
        tabPanel.addTab("class", mainPanel);
        tabPanel.addTab("hex", hexPanel);
        tabPanel.addTab("source", sourcePanel);
        this.setLayout(new BorderLayout());
        this.add(tabPanel, BorderLayout.CENTER);

        new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this, true);
        new DropTarget(classInfoPanel.getArea(), DnDConstants.ACTION_COPY_OR_MOVE, this, true);
        new DropTarget(hexPanel.getArea(), DnDConstants.ACTION_COPY_OR_MOVE, this, true);

    }

    public void update(String classPath) {
        ClassReader reader = new ClassReader();
        try {
            ClassFile classFile = reader.readClassFile(classPath);
            classInfoPanel.update(classFile);
            methodPanel.update(classFile);
            methodPanel.updateTree(classInfoPanel);
            hexPanel.update(classPath);
            sourcePanel.update(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateView(byte[] in,String code) {
        ClassReader reader = new ClassReader();
        try {
            ClassFile classFile = reader.readClassFile(in);
            classInfoPanel.update(classFile);
            methodPanel.update(classFile);
            methodPanel.updateTree(classInfoPanel);
            hexPanel.update(classFile,code);
            sourcePanel.update(classFile,in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
