/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CopyFeature;

import Notepad.Notepad;

/**
 *
 * @author carlos
 */
public class CopyActions {
    Notepad n;
    public CopyActions(Notepad n)
    {
       this.n = n;
    }
    	//to copy the selected text
	public void copy(){
		n.getTextComponent().copy();
	}

}
