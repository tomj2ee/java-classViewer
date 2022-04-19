package com.nts.jvm.gui;

import com.nts.jvm.attributeinfo.AttributeInfo;
import com.nts.jvm.attributeinfo.Code_attribute;
import com.nts.jvm.buff.Record;
import com.nts.jvm.classfile.ClassFile;
import com.nts.jvm.classfile.ClassReader;
import com.nts.jvm.classfile.HexReader;
import com.nts.jvm.constantpool.CP_info;
import com.nts.jvm.fieldinfo.FieldInfo;
import com.nts.jvm.methodinfo.MethodInfo;
import com.nts.jvm.tree.MethodTreeInfo;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class HexPanel extends JPanel {

    private RSyntaxTextArea area;
    private JTree tree;
    private RSyntaxTextArea code;

    private DefaultMutableTreeNode root;
    private DefaultTreeModel dt;

    public HexPanel() {
        JSplitPane mainPanel = new JSplitPane();
        mainPanel.setDividerLocation(360);

        area = new RSyntaxTextArea();
        code = new RSyntaxTextArea();

        area.setAutoIndentEnabled(true);
        code.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        code.setAutoIndentEnabled(true);
        code.setEditable(false);
        root = new DefaultMutableTreeNode(
                new MethodTreeInfo("Class", -1, -1, 0));
        dt = new DefaultTreeModel(root);
        tree = new JTree(dt);
        tree.setBorder(new EmptyBorder(15, 15, 10, 0)); // 设置边距
        tree.setCellRenderer(new IconRenderer());
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }
            Object userObj = node.getUserObject();
            if (userObj instanceof MethodTreeInfo) {
                MethodTreeInfo methodTreeInfo = (MethodTreeInfo) node.getUserObject();
                if (methodTreeInfo != null) {
                    gotoHex(methodTreeInfo);
                }
            }
        });
        JSplitPane ctPanel = new JSplitPane(VERTICAL_SPLIT);
        ctPanel.setDividerLocation(600);
        ctPanel.setLeftComponent(new RTextScrollPane(area, true));
        ctPanel.setBottomComponent(new RTextScrollPane(code, true));
        mainPanel.setLeftComponent(new JScrollPane(tree));
        mainPanel.setRightComponent(ctPanel);
        area.setEditable(false);
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void gotoHex(MethodTreeInfo methodTreeInfo) {
        int startIndex = methodTreeInfo.getStartIndex();
        int endIndex = methodTreeInfo.getEndIndex();
        if (startIndex >= 0 && endIndex >= 0) {
            int[] ps = findPos(area.getText(), startIndex, endIndex);
            if (ps[0] >= 0 && ps[1] > 0 && ps[1] > ps[0]) {
                area.setFocusable(true);
                doIndex(ps[0], ps[1]-1);
            }
        }
        if (methodTreeInfo.getType() == 2) {
            code.setText(methodTreeInfo.getCode());
        }
    }

    int getFirstLien(String txt) {
        int p = 0;
        for (; ; ) {
            char c = txt.charAt(p);
            p++;
            if (c == '\n') {
                break;
            }
        }
        return p;
    }

    private int find(String txt, int startIdx) {
        int offset = getFirstLien(txt);
        int p1 = offset;
        int p = -1;
        int sz = txt.length();
        while (p1 < sz) {
            char c = txt.charAt(p1);
            if (c == '\r' || c == '\n' || c == ' ' || c == '\t') {
                p1++;
            } else {
                p++;
                if (p == startIdx) {
                    return p1;
                }
                p1 += 2;
            }
        }
        return -1;
    }

    private int[] findPos(String txt, int startIdx, int endIdx) {
        int[] pos = new int[2];
        pos[0] = find(txt, startIdx);
        pos[1] = find(txt, endIdx);
        return pos;
    }

    public void update(String classPath) {
        String content = new HexReader().readClassFile(classPath);
        ClassReader reader = new ClassReader();
        try {
            ClassFile classFile = reader.readClassFile(classPath);
            updateHex(classFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        area.setText(content);
        area.setFocusable(true);
        area.setRequestFocusEnabled(true);
    }


    public void update( ClassFile classFile,String  content) {
        try {
            updateHex(classFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        area.setText(content);
        area.setFocusable(true);
        area.setRequestFocusEnabled(true);
    }

    public RSyntaxTextArea getArea(){
        return  area;
    }
    private void updateHex(ClassFile file) {

        SwingUtilities.invokeLater(() -> {
            root.removeAllChildren();

            int magic = file.getMagic();
            String cafe = Integer.toHexString(magic);
            Map<String, Record> pcRecord = file.getPcRecord();
            Record magicMap = pcRecord.get("magic");
            root.add(new DefaultMutableTreeNode(new MethodTreeInfo("magic:" + cafe,
                    magicMap.startPc, magicMap.endPc, 5)));

            Record minorVersionMap = pcRecord.get("minorVersion");
            root.add(new DefaultMutableTreeNode(new MethodTreeInfo("MinorVersion:" + file.getMinorVersion(),
                    minorVersionMap.startPc, minorVersionMap.endPc, 5)));
            Record majorVersionMap = pcRecord.get("majorVersion");
            root.add(new DefaultMutableTreeNode(new MethodTreeInfo("MajorVersion:" + file.getMajorVersion(),
                    majorVersionMap.startPc, majorVersionMap.endPc, 5)));

            Record constantPoolCount = pcRecord.get("constantPoolCount");
            root.add(new DefaultMutableTreeNode(new MethodTreeInfo("ConstantPoolCount:" + file.getConstantPoolCount(),
                    constantPoolCount.startPc, constantPoolCount.endPc, 5)));

            DefaultMutableTreeNode consNode = new DefaultMutableTreeNode(new MethodTreeInfo("pool",
                    -1, -1, 5));

            HashMap<Integer, CP_info> cpInfo = file.getCpInfo();
            for (int i = 1; i <= file.getConstantPoolCount(); i++) {
                CP_info cp = cpInfo.get(i);
                if (cp != null) {
                    Record pc = pcRecord.get("cp-" + i);
                    consNode.add(new DefaultMutableTreeNode(
                            new MethodTreeInfo("#" + i + " " + cp,
                                    pc.startPc, pc.endPc, 6)));
                }
            }
            root.add(consNode);

            Record accessFlag = pcRecord.get("accessFlags");
            DefaultMutableTreeNode accessFlagNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("accessFlag:" + file.getAccessFlags(),
                            accessFlag.startPc, accessFlag.endPc, 5));

            root.add(accessFlagNode);

            Record thisClass = pcRecord.get("thisClass");
            DefaultMutableTreeNode thisClassNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("thisClass: # (" + file.getThisClass() +
                            file.getPoolString(file.getThisClass()) + ")",
                            thisClass.startPc, thisClass.endPc, 5));
            root.add(thisClassNode);


            Record superClass = pcRecord.get("superClass");
            DefaultMutableTreeNode superClassNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("thisClass: #" + file.getSuperClass() + "(" +
                            file.getPoolString(file.getSuperClass()) + ")",
                            superClass.startPc, superClass.endPc, 5));
            root.add(superClassNode);


            Record interfacesCount = pcRecord.get("interfacesCount");
            DefaultMutableTreeNode interfacesCountNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("interfacesCount:" + file.getInterfacesCount(),
                            interfacesCount.startPc, interfacesCount.endPc, 5));
            root.add(interfacesCountNode);

            DefaultMutableTreeNode interfacesNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("interfaces",
                            -1, -1, 5));
            root.add(interfacesNode);


            for (int i = 0; i < file.getInterfacesCount(); i++) {
                Record r = pcRecord.get("readInterfaces-" + i);
                Integer interFace = file.getInterfaces().get(i);

                DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(
                        new MethodTreeInfo(file.getPoolString(interFace),
                                r.startPc, r.endPc, 5));

                interfacesNode.add(rNode);
            }


            DefaultMutableTreeNode fieldNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("fields",
                            interfacesCount.startPc, interfacesCount.endPc, 5));
            root.add(fieldNode);

            for (int i = 0; i < file.getFieldsCount(); i++) {
                Record r = pcRecord.get("readFields-" + i);
                FieldInfo fieldInfo = file.getFields().get(i);
                DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(
                        new MethodTreeInfo(fieldInfo.getFieldName(), r.startPc, r.endPc, 1));
                fieldNode.add(rNode);
            }

            Record methodCountR = pcRecord.get("readMethodsCount");

            DefaultMutableTreeNode methodCountNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("methodCount: " + file.getMethodsCount(),
                            methodCountR.startPc, methodCountR.endPc, 5));
            root.add(methodCountNode);


            DefaultMutableTreeNode methodNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("method", -1, -1, 5));
            root.add(methodNode);

            for (int i = 0; i < file.getMethodsCount(); i++) {
                Record r = pcRecord.get("readMethods-" + i);
                MethodInfo methodInfo = file.getMethods().get(i);
                MethodTreeInfo methodObj = new MethodTreeInfo(methodInfo.getPrintName(),
                        r.startPc, r.endPc, 2);
                DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(methodObj);
                for (int q = 0; q < methodInfo.getAttributesCount(); q++) {

                    AttributeInfo attr = methodInfo.getAttributes()[q];
                    DefaultMutableTreeNode attNode = new DefaultMutableTreeNode(
                            new MethodTreeInfo(
                                    file.getPoolString(attr.getAttributeNameIndex()),
                                    -1, -1, 5));
                    if (attr instanceof Code_attribute) {
                        Code_attribute codeAttr = (Code_attribute) attr;
                        methodObj.setCode(file.readCode(codeAttr.getCode()));
                    }
                    rNode.add(attNode);
                }
                methodInfo.getAttributes();
                methodNode.add(rNode);
            }


            DefaultMutableTreeNode attributeNode = new DefaultMutableTreeNode(
                    new MethodTreeInfo("attributes",
                            interfacesCount.startPc, interfacesCount.endPc, 5));
            root.add(attributeNode);

            for (int i = 0; i < file.getAttributeCount(); i++) {
                Record r = pcRecord.get("readAttributes-" + i);
                AttributeInfo attributeInfo = file.getAttributes().get(i);
                DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(
                        new MethodTreeInfo(file.getPoolString(
                                attributeInfo.getAttributeNameIndex()),
                                r.startPc, r.endPc, 5));
                attributeNode.add(rNode);
            }
            dt.reload();
            TreePath visiblePath = new TreePath(dt.getPathToRoot(methodNode));
            tree.expandPath(visiblePath);


            visiblePath = new TreePath(dt.getPathToRoot(fieldNode));
            tree.expandPath(visiblePath);

        });
    }


    public void doIndex(int startIndex, int endIndex) {

        SwingUtilities.invokeLater(() -> {
            area.setFocusable(true);
            area.requestFocus();
            area.setSelectionStart(startIndex);
            Rectangle visible = area.getVisibleRect();
            area.setSelectionEnd(endIndex);
            try {
                int l = area.getLineOfOffset(startIndex);
                int y = area.yForLine(l);
                visible.y = y - visible.height / 2;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            area.scrollRectToVisible(visible);
            area.setHighlightCurrentLine(false);
        });

    }
}
