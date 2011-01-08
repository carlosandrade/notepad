/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CutFeature;

import Notepad.Notepad;

/**
 *
 * @author carlos
 */
public class CutActions {
    Notepad n;
    public CutActions(Notepad n)
    {
       this.n = n;
    }

    public void cut(){
		n.getTextComponent().cut();
	}
}
