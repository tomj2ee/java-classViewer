package com.nts.jvm.gui;

import com.nts.jvm.conf.ConfFileList;
import com.nts.jvm.util.FileConfUtil;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;

public class DropTargetComponent extends JComponent implements DropTargetListener {

    private String classFileName;

    public String getClassFileName() {
        return classFileName;
    }

    public void setClassFileName(String classFileName) {
        this.classFileName = classFileName;
    }

    public  void update(String classFileName) {

    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }



    @Override
    public void drop(DropTargetDropEvent dtde) {
        boolean isAccept = false;

        try {
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                isAccept = true;
                List<File> files = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                // 把文件路径输出到文本区域
                if (files.size() > 0) {
                    String filePath = files.get(0).getAbsolutePath();
                    update(filePath);
                    ConfFileList.saveConf(filePath);
                }
            }

            if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                isAccept = true;
                String text = dtde.getTransferable().getTransferData(DataFlavor.stringFlavor).toString();
                String filePath = text;
                update(filePath);
                ConfFileList.saveConf(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isAccept) {
            dtde.dropComplete(true);
        }
    }

}
