package com.nts.jvm.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CloseButton  extends JButton {
    private ImageIcon   bgIcon;
    private  Color fgColor=Color.WHITE;
    public CloseButton() {
        bgIcon=IconFactory.closeIcon;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBorder(new EmptyBorder(1,1,1,1));
        setIcon(bgIcon);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bgIcon=IconFactory.closeIcon;
                fgColor=Color.LIGHT_GRAY;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                bgIcon=IconFactory.closeIcon;
                fgColor=Color.WHITE;
                repaint();
            }


        });
    }

    @Override
    public void paint(Graphics g) {
        doPaint(g);
    }

    private  void doPaint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);
        int w = getWidth();
        int h = getHeight();
        if(fgColor!=Color.WHITE) {
            g.setColor(fgColor);
            g.fillOval(0, 0, w, h);
        }
        g.drawImage(bgIcon.getImage(),0,0,w,h,null);
    }
}
