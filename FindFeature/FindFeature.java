/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FindFeature;

import Notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author carlos
 */
public class FindFeature {

    Notepad n;
    FindActions findActions;
    
        public FindFeature(Notepad n)
        {
            this.n = n;
            findActions = new FindActions(n);

            buildEditMenu();
            buildToolBar();
        }
    	protected JMenu buildEditMenu() {
		JMenu editMenu   = n.getEditMenu();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		JMenuItem findMenuItem = new JMenuItem("Find", new ImageIcon(this.getClass().getResource("images/find.gif")));
		findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		findMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				findActions.find();
			}
		});
		editMenu.add(findMenuItem);
		JMenuItem findNextMenuItem = new JMenuItem("Find Next");
		findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		findNextMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				findActions.findNext();
			}
		});
		editMenu.add(findNextMenuItem);
		return editMenu;
	}
	protected JToolBar buildToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton findButton  = new JButton(new ImageIcon(this.getClass().getResource("images/find.gif")));
		findButton.setToolTipText("Find");
		findButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				findActions.find();
			}
		});
		toolBar.add(findButton);
		return toolBar;
	}
}
