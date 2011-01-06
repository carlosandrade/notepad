package about;

import Notepad.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class in charge of adding the About feature to the Notepad
 * @author carlos
 */
public class AboutFeature {

 static public AboutActions aboutActions = new AboutActions();
 static JMenuItem aboutMenuItem = aboutMenuItem = new JMenuItem("About Notepad");

    //Original code did not consider counting the amount of sub-menu itens,
    //thus we did not consider adding any other feature to the help submenu.
    	static public void add() {
		JMenu helpMenu   = new JMenu("Help");
		helpMenu.setMnemonic('h');

                /*About Feature */
	  
		aboutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				aboutActions.about();
			}
		});
		helpMenu.add(aboutMenuItem);

                /* End of About Feature */

		Notepad.getNotepadMenuBar().add(helpMenu);
	}
}
