/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FontFeature;

import Notepad.Notepad;
import javax.swing.JTextPane;

/**
 *
 * @author carlos
 */
public class FontActions {
Notepad n;
JTextPane textPane;

    public FontActions(Notepad n, JTextPane textPane)
    {
        this.n = n;
        this.textPane = textPane;
    }

    //for wraping the line & wraping the style word
	public void setStyle(String style) {
		textPane.setCharacterAttributes(
			textPane.getStyledDocument().getStyle(style), true);
	}
}

