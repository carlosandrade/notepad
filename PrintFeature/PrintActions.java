/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PrintFeature;

import Notepad.Notepad;

/**
 *
 * @author carlos
 */
public class PrintActions {
	/**
	 *THIS FROM SUN WEBSITE (@Print.java)
	 *if we want to print the text, we can do this by print method
     */
    protected Notepad n;

    public PrintActions(Notepad n)
    {
        this.n = n;
    }
	public void print(){
		//import printer class
		Print.printComponent(n.getTextComponent());
	}
}
