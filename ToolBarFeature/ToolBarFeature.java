/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ToolBarFeature;

import Notepad.Notepad;
import javax.swing.JToolBar;

/**
 *
 * @author carlos
 */
public class ToolBarFeature {
    Notepad n;

    public ToolBarFeature(Notepad n)
    {
        this.n = n;
        
		
			n.getContentPane().add("North", n.getNotepadToolBar());
		
    }


    


}
