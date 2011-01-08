/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CenterFeature;

import Notepad.Notepad;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author carlos
 */
public class CenterFeature {
	Notepad n; //for using the object in the Notepad.java
	public CenterFeature(Notepad n){
		this.n = n;
                nCenter();
	}
	public void nCenter(){
		//Centering the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		n.setLocation((screenSize.width-n.getWidth())/2,(screenSize.height-n.getHeight())/2);
	}
}