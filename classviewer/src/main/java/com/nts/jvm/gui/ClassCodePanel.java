package com.nts.jvm.gui;

import com.nts.jvm.classfile.ClassFile;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class ClassCodePanel extends JPanel implements ClassListener {

	/**
	 * ClassInfoPanel
	 */
	private final RSyntaxTextArea area = new RSyntaxTextArea();


	public ClassCodePanel() {
		this.setLayout(new BorderLayout());
		area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		area.setAutoIndentEnabled(true);
		area.setAlignmentX(200);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new RTextScrollPane(area, true), BorderLayout.CENTER);
		this.add(mainPanel, BorderLayout.CENTER);

	}

	public JTextArea getArea() {
		return area;
	}

	@Override
	public void update(ClassFile file) {
		area.setText(file.displayCode());
		area.setEditable(false);
	}

	public void doIndex(int startIndex) {
		area.setCaretPosition(startIndex);
		Rectangle visible = area.getVisibleRect();
		try {
			int l = area.getLineOfOffset(startIndex);
			int y = area.yForLine(l);
			visible.y = y - visible.height / 2;
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		area.scrollRectToVisible(visible);

	}
}
