/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SelectAllFeature;

import Notepad.Notepad;

/**
 *
 * @author carlos
 */
public class SelectAllActions {
    Notepad n;
    public SelectAllActions(Notepad n)
    {
       this.n = n;
    }
	//to select all the text
	public void selectAll(){
		n.getTextComponent().selectAll();
	}

}
