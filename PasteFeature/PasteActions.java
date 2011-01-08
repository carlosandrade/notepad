/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PasteFeature;

import Notepad.Notepad;

/**
 *
 * @author carlos
 */
public class PasteActions {
    Notepad n;
    public PasteActions(Notepad n)
    {
       this.n = n;
    }

	//to paste the selected text
	public void paste(){
		n.getTextComponent().paste();
	}
}
