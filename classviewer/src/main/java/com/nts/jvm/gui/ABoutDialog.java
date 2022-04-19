package com.nts.jvm.gui;

import javax.swing.*;
import java.awt.*;


public class ABoutDialog extends JDialog {



 private String toHref(String url){
  return  "<A href=\""+ url+"\">" +url+"</A>";
 }
 public ABoutDialog(JFrame frame, String s) {

  super(frame, s);
  JLabel label = new JLabel(IconFactory.javaIcon);
  JPanel ctPanel=new JPanel();
  String html="author: tomjnefu@163.com";
  html+="<br/>gitee:  "+toHref("https://gitee.com/venus-suite/java-classViewer");
  html+="<br/>github: "+toHref("https://github.com/tomj2ee/java-classViewer");
  JEditorPane us=new JEditorPane("text/html",html);
  ctPanel.add(us);

  int w = IconFactory.javaIcon.getIconWidth();
  int h = IconFactory.javaIcon.getIconHeight();
  setLayout(new BorderLayout());
  add(label, BorderLayout.CENTER);
  add(ctPanel,BorderLayout.SOUTH);
  setModal(true);
  setBounds(0, 0, w, h);
  setDefaultCloseOperation(DISPOSE_ON_CLOSE);

 }

}

