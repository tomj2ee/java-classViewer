package com.nts.jvm.util;

import com.nts.jvm.gui.CloseButton;

import javax.swing.*;
import java.awt.*;

public class UUtil {

    public  static JButton makeCloseButton(){
        JButton close = new CloseButton();
        close.setToolTipText("Close this class panel");
        close.setPreferredSize(new Dimension(16,16));
        return close;
    }

}
