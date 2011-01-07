/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package saveAs;

import Notepad.Notepad;
import input.InputActions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author carlos
 */
public class SaveAsFeature {

     Notepad n;
    static JMenu fileMenu;
    private InputActions inputActions;


    public SaveAsFeature(Notepad n)
    {
        this.n = n;
        fileMenu = n.getNotepadMenuBar().getMenu(0);
        inputActions = new InputActions(n);

        buildFileMenu();
    }

    protected JMenu buildFileMenu()
    {
        if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		saveAsMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.saveAs();
			}
		});
		fileMenu.add(saveAsMenuItem);
		return fileMenu;

    }
}
