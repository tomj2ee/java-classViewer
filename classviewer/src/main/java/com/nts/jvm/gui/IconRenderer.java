package com.nts.jvm.gui;

import com.nts.jvm.tree.MethodTreeInfo;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class IconRenderer   extends DefaultTreeCellRenderer {


    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component component = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node != null) {
            Object o = node.getUserObject();
            if (o instanceof MethodTreeInfo) {
                MethodTreeInfo userObject = (MethodTreeInfo) o;
                if (userObject.getType() == 0) {
                    setIcon(IconFactory.classIcon);
                } else if (userObject.getType() == 1) {
                    setIcon(IconFactory.fieldIcon);
                } else if (userObject.getType() == 2) {
                    setIcon(IconFactory.methodIcon);
                }else if (userObject.getType() == 4) {
                    setIcon(IconFactory.hexICon);
                }else if (userObject.getType() == 5) {
                    setIcon(IconFactory.cIcon);
                }else if (userObject.getType() == 6) {
                    setIcon(IconFactory.dIcon);
                }else if (userObject.getType() == 7) {
                    setIcon(IconFactory.fIcon);
                } else {
                    setIcon(IconFactory.methodIcon);
                }

            }
        }

        return component;
    }

}
