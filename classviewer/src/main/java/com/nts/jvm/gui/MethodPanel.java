package com.nts.jvm.gui;

import com.nts.jvm.classfile.ClassFile;
import com.nts.jvm.tree.MethodTreeInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.List;


public class MethodPanel extends JPanel implements ClassListener {

	/**
	 * MethodPanel
	 */
	private static final long serialVersionUID = 1765832792106182251L;
	private final JTree tree;
	private final DefaultMutableTreeNode root;
	private ClassCodePanel classInfoPanel;
	private final DefaultTreeModel dt;

	public MethodPanel() {

		JScrollPane mainPanel = new JScrollPane();
		root = new DefaultMutableTreeNode(
				new MethodTreeInfo("",-1,-1,0));

		dt=new DefaultTreeModel(root);
		tree = new JTree();

		tree.setCellRenderer(new IconRenderer());
		tree.setModel(dt);
		this.setLayout(new BorderLayout());
		tree.setBorder(new EmptyBorder(10, 10, 10, 0));
		mainPanel.getViewport().add(tree);
		this.add(mainPanel, BorderLayout.CENTER);

		tree.addTreeSelectionListener(e -> {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)
					tree.getLastSelectedPathComponent();
			if(node==null){
				return;
			}
			Object userObj=node.getUserObject();
			if (  userObj instanceof MethodTreeInfo) {
				MethodTreeInfo methodTreeInfo = (MethodTreeInfo) node.getUserObject();
				if (methodTreeInfo != null) {
					if(classInfoPanel!=null){
						if(methodTreeInfo.getStartIndex()>0) {
							classInfoPanel.doIndex(methodTreeInfo.getStartIndex()
                            );
						}
					}
				}
			}
		});

	}

	public void updateTree(ClassCodePanel classInfoPanel) {
		this.classInfoPanel = classInfoPanel;
	}

	public void update(ClassFile file) {

		SwingUtilities.invokeLater(() -> {
			root.removeAllChildren();
			List<MethodTreeInfo> methodList = file.getMethodTree();
			root.setUserObject(new MethodTreeInfo(file.getCLassName(),-1,-1,0));
			for (MethodTreeInfo info : methodList) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(info);
				root.add(node);
			}
			dt.reload();
			tree.expandRow(0);
		});


	}
}
