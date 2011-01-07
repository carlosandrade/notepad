/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package input;

import Notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author carlos
 */
public class InputFeature {

    Notepad n;
    static JMenu fileMenu;
    private InputActions inputActions;

    public InputFeature(Notepad n)
    {
        this.n = n;
        fileMenu = n.getNotepadMenuBar().getMenu(0);
        inputActions = new InputActions(n);

        buildFileMenu();
    }


    protected JMenu buildFileMenu() {
		
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
		JMenuItem newFileMenuItem    = new JMenuItem("New");
		newFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newFileMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.newFile();
			}
		});
		fileMenu.add(newFileMenuItem);
		JMenuItem openMenuItem   = new JMenuItem("Open");
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.open();
			}
		});
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem   = new JMenuItem("Save");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.save();
			}
		});
		fileMenu.add(saveMenuItem);
	
		return fileMenu;
	}
}
