/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SelectAllFeature;

import Notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author carlos
 */
public class SelectAllFeature {
 Notepad n;
    SelectAllActions selectAllActions;

    public SelectAllFeature(Notepad n)
    {

        this.n = n;
        selectAllActions = new SelectAllActions(n);
        buildSelectAllButton();
    }
    protected void buildSelectAllButton()
    {
            JMenu editMenu = n.getEditMenu();
             if (editMenu.getItemCount() > 0) editMenu.addSeparator();


		JMenuItem selectAllMenuItem= new JMenuItem("Select All");
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectAllMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				selectAllActions.selectAll();
			}
		});
		editMenu.add(selectAllMenuItem);
    }
}
