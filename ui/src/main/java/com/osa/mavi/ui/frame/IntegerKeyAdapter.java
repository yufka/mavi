package com.osa.mavi.ui.frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Adapter to ensure integer values in input fields.
 * 
 * @author oleksii
 * @since Oct 14, 2022
 */
public class IntegerKeyAdapter extends KeyAdapter {
    
    @Override
    public void keyTyped(KeyEvent ke) {
        char c = ke.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            ke.consume();
        }
    }
}
