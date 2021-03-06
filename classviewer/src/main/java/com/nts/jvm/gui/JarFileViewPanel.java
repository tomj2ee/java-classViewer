package com.nts.jvm.gui;

import com.nts.jvm.classfile.HexReader;
import com.nts.jvm.conf.ConfFileList;
import com.nts.jvm.tree.MethodTreeInfo;
import com.nts.jvm.util.FileNameUtil;
import com.nts.jvm.util.UUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



public class JarFileViewPanel extends DropTargetComponent {

    private final JTabbedPane tabbedPane;

    private final JTree tree;
    private final DefaultMutableTreeNode root;
    private final DefaultTreeModel dt;

    public JarFileViewPanel() {
        JSplitPane mainPanel = new JSplitPane();
        tabbedPane = new JTabbedPane();
        root = new DefaultMutableTreeNode(new MethodTreeInfo("jar", -1, -1, 4));

        dt = new DefaultTreeModel(root);
        tree = new JTree();
        tree.setModel(dt);
        tree.setCellRenderer(new IconRenderer());
        tree.setBorder(new EmptyBorder(10,10,10,10));

        mainPanel.setDividerLocation(300);
        mainPanel.setLeftComponent(new JScrollPane(tree));
        mainPanel.setRightComponent(tabbedPane);
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }
            Object userObj = node.getUserObject();
            if (userObj instanceof MethodTreeInfo) {
                MethodTreeInfo methodTreeInfo = (MethodTreeInfo) node.getUserObject();
                if (methodTreeInfo != null && methodTreeInfo.getType() == 8) {
                    String classPath = methodTreeInfo.getCode();
                    SwingUtilities.invokeLater(() -> updateClass(classPath));
                }
            }
        });

        this.setVisible(true);

    }

    private String getParent(String fileName) {
        if (fileName.endsWith("/")) {
            fileName = fileName.substring(0, fileName.length() - 1);
        }
        return FileNameUtil.getCurrent(fileName);
    }

    private final Map<String, DefaultMutableTreeNode> defNodeMap = new HashMap<>();
    private String jarFileName;

    public void update(String jarFileName) {
        this.jarFileName = jarFileName;
        SwingUtilities.invokeLater(() -> {
            try {
                root.removeAllChildren();
                ZipFile zipFile = new ZipFile(jarFileName);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    if (entry != null) {
                        String fileName = entry.getName();
                        //System.out.println(fileName);
                        String parentName = getParent(fileName);
                        if (!entry.isDirectory()) {
                            int type = 1;

                            if (fileName.endsWith(".class")) {
                                type = 8;
                            }
                            MethodTreeInfo me = new MethodTreeInfo(FileNameUtil.getName(fileName), -1, -1, type);
                            me.setCode(fileName);
                            DefaultMutableTreeNode node = new DefaultMutableTreeNode(me);
                            DefaultMutableTreeNode parentNode = defNodeMap.get(parentName);
                            if (parentNode == null) {
                                parentNode = createOrGetParent(parentName);
                            }
                            parentNode.add(node);

                        } else {
                           createOrGetParent(fileName);
                        }
                    }
                }
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tree.expandRow(0);
            dt.reload();
        });
    }


    private  DefaultMutableTreeNode newNode(String currentKey,String nodeName) {
        if (defNodeMap.get(currentKey) == null) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(new MethodTreeInfo(nodeName, -1, -1, 7));
            defNodeMap.put(currentKey, node);
        }
        return defNodeMap.get(currentKey);

    }

    private DefaultMutableTreeNode createOrGetParent(String strParent) {
        String strNode = strParent;
        int level = -1;
        int pos = 0;
        String strP = "";
        for (; ; ) {
            int idx = strNode.indexOf("/", pos);
            if (idx != -1) {
                strP = strNode.substring(0, idx);
            } else {
                strP = strNode;
            }
            level++;
            String currentKey = strP;
            String currentName = FileNameUtil.getName(strP);
            if (level == 0) {
                if(defNodeMap.get(currentKey)==null) {
                    root.add(newNode(currentKey, currentName));
                }
            } else {
                String currentParent = getParent(strP);
                DefaultMutableTreeNode parentNode = defNodeMap.get(currentParent);
                if(defNodeMap.get(currentKey)==null) {
                    parentNode.add(newNode(currentKey, currentName));
                }
            }
            if (idx == -1) {
                break;
            }
            pos = idx + 1;
        }
        return defNodeMap.get(strParent);

    }


    private final Map<String, ClassViewPanel> tabMap = new HashMap<>();

    private void updateClass(String clsFileName) {
        ZipFile zipFile = null;
        try {
            if (tabMap.get(clsFileName) == null) {
                zipFile = new ZipFile(jarFileName);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                HexReader reader = new HexReader();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    if (entry != null) {
                        if (!entry.isDirectory()) {
                            String fileName = entry.getName();
                            if (fileName.equals(clsFileName)) {
                                InputStream in = zipFile.getInputStream(entry);
                                byte[] codes = reader.readBytes(in);
                                String hexCode = reader.getString(codes);
                                ClassViewPanel panel = new ClassViewPanel();
                                panel.updateView(codes, hexCode);

                                JPanel titlePanel = new JPanel();
                                titlePanel.setOpaque(false);

                                JLabel title = new JLabel(FileNameUtil.getExtName(fileName));
                                titlePanel.add(title);

                                JButton close = UUtil.makeCloseButton();
                                titlePanel.add(close);
                                panel.setClassFileName(clsFileName);

                                tabbedPane.addTab(FileNameUtil.getExtName(fileName), panel);
                                tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel), titlePanel);
                                int sz = tabbedPane.getTabCount();
                                tabMap.put(clsFileName, panel);
                                tabbedPane.setSelectedIndex(sz - 1);
                                tabbedPane.setToolTipTextAt(sz-1,fileName);

                                close.addActionListener(e -> {
                                    DropTargetComponent idx =(DropTargetComponent) tabbedPane.getSelectedComponent();
                                    tabbedPane.remove(idx);
                                    tabMap.remove(idx.getClassFileName());
                                });

                                return;
                            }

                        }
                    }
                }
            } else {
                ClassViewPanel sz = tabMap.get(clsFileName);
                int idx = tabbedPane.indexOfComponent(sz);
                if (idx >= 0) {
                    tabbedPane.setSelectedIndex(idx);
                }
            }


        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (Exception ex) {
                //do nothing
            }
        }

    }

}
