/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WrapFeature;

import Notepad.Notepad;
import javax.swing.JCheckBoxMenuItem;

/**
 *
 * @author carlos
 */
public class WrapActions {
        private Notepad n;
	private Fonts fontWindow;
	WrapActions(Notepad n){
		fontWindow = new Fonts(n);
                this.n = n;
	}
	/**
	 *@see FONTS.JAVA
	 *this is a font class which is for changing the font, style & size
	 */
	public void font(){
		fontWindow.setVisible(true); //setting the visible is true
		fontWindow.pack(); //pack the panel
	}
	//for wraping the line & wraping the style word
	public void lineWrap(JCheckBoxMenuItem lineWrapMenuItem){
		if(lineWrapMenuItem.isSelected()){
			/**
			 *make the line wrap & wrap style word is true
			 *when the line wrap is selected
			 */
			n.getTextArea().setLineWrap(true);
			n.getTextArea().setWrapStyleWord(true);
		} else {
			/**
			 *make the line wrap & wrap style word is false
			 *when the line wrap isn't selected
			 */
			n.getTextArea().setLineWrap(false);
			n.getTextArea().setWrapStyleWord(false);
		}
	}
}
