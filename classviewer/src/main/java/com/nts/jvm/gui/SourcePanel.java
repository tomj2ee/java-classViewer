package com.nts.jvm.gui;

import com.nts.jvm.classfile.ClassFile;
import com.nts.jvm.util.JadUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

public class SourcePanel extends JPanel {

    private final RSyntaxTextArea code;

    public SourcePanel() {
        code = new RSyntaxTextArea();
        code.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        code.setAutoIndentEnabled(true);
        code.setEditable(false);

        this.setLayout(new BorderLayout());
        this.add(new RTextScrollPane(code, true), BorderLayout.CENTER);
    }


    public void update(String classPath) {
        String content = JadUtil.doDecompiler(classPath);
        code.setText(content);
    }


    public void update(ClassFile classFile, byte[] byteCode) {
        String content = JadUtil.doDecompiler(byteCode);
        code.setText(content);
    }
}
