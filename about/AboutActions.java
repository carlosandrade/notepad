package about;


import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class AboutActions {

  	/**
	 *@see ABOUT.JAVA
	 *it's a Message Dialog to show the information about this program
	 */
	public void about(){
		JOptionPane.showMessageDialog(null, new About(),"About Notepad",JOptionPane.PLAIN_MESSAGE);
	}
}
