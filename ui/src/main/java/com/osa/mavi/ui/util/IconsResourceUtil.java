package com.osa.mavi.ui.util;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class contains methods to access icons for menu from resources.
 * 
 * @author oleksii
 * @since Sep 29, 2022
 */
public class IconsResourceUtil {
    
    private static Icon getIcon(final String resourcePath) {
        ImageIcon icon = new ImageIcon(IconsResourceUtil.class.getClassLoader().getResource(resourcePath));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        icon.setImage(image);
        return icon;
    }
    
    private static final String OPEN_IMG_PNG = "icons/open.png";
    
    public static Icon getOpenIcon() {
        return getIcon(OPEN_IMG_PNG);
    }
    
    private static final String CLOSE_IMG_PNG = "icons/close.png";
    
    public static Icon getCloseIcon() {
        return getIcon(CLOSE_IMG_PNG);
    }
    
    private static final String ABOUT_IMG_PNG = "icons/abount.png";
    
    public static Icon getAboutIcon() {
        return getIcon(ABOUT_IMG_PNG);
    }
}
