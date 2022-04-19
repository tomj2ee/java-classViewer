package com.nts.jvm.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class IconFactory {

    public static ImageIcon methodIcon;
    public static ImageIcon fieldIcon;
    public static ImageIcon class2XIcon;
    public static ImageIcon classIcon;

    public static BufferedImage titleIcon;


    public static ImageIcon hexICon;
    public static ImageIcon cIcon;
    public static ImageIcon dIcon;

    public static ImageIcon fIcon;

    public static ImageIcon closeIcon;
    public static ImageIcon closeHoverIcon;

    public static ImageIcon javaIcon;

    static {

        try {
            BufferedImage class2XImg = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/class@2x.png")));

            BufferedImage classImg = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/class.png")));

            BufferedImage methodImg = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/method.png")));

            BufferedImage fieldImg = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/field.png")));


            titleIcon = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/classViewer.png")));


            BufferedImage hex = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/hex.png")));

            BufferedImage c = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/c.png")));
            BufferedImage d = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/d.png")));


            BufferedImage f = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/folder.png")));


            BufferedImage close = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/close.png")));


            BufferedImage closeHover = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/closeHover.png")));


            BufferedImage   javaImg = ImageIO.read(Objects.requireNonNull(IconRenderer.class.getResourceAsStream(
                    "/icon/java.jpeg")));

            class2XIcon = new ImageIcon(class2XImg);
            classIcon = new ImageIcon(classImg);
            fieldIcon = new ImageIcon(fieldImg);
            methodIcon = new ImageIcon(methodImg);


            hexICon = new ImageIcon(hex);
            cIcon = new ImageIcon(c);
            dIcon = new ImageIcon(d);
            fIcon = new ImageIcon(f);

            closeIcon = new ImageIcon(close);
            closeHoverIcon = new ImageIcon(closeHover);
            javaIcon=new ImageIcon(javaImg);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
