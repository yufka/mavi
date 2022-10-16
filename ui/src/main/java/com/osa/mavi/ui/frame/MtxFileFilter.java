package com.osa.mavi.ui.frame;

import java.io.File;

/**
 *
 * @author oleksii
 * @since Oct 12, 2022
 */
public class MtxFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with ".txt" extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".mtx");
    }

    @Override
    public String getDescription() {
        // This description will be displayed in the dialog,
        // hard-coded = ugly, should be done via I18N
        return "Mtx matrix files (*.mtx)";
    }

}
