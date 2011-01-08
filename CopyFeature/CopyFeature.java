/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CopyFeature;

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
public class CopyFeature {
        Notepad n;
        CopyActions copyActions;

    public CopyFeature(Notepad n)
    {
        this.n = n;
        copyActions = new CopyActions(n);
        buildCopyButton();
    }
    public CopyFeature(Notepad n, boolean hasToolBarIcon)
    {
        this.n = n;
        copyActions = new CopyActions(n);
        buildCopyButton();
        addCopyToToolBar();

    }
    protected void buildCopyButton()
    {
                JMenu editMenu   = n.getEditMenu();
               if (editMenu.getItemCount() > 0) editMenu.addSeparator();
    		JMenuItem copyMenuItem = new JMenuItem("Copy", new ImageIcon(this.getClass().getResource("images/copy.gif")));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				copyActions.copy();
			}
		});
		editMenu.add(copyMenuItem);
    }
    protected void addCopyToToolBar()
    {
                JToolBar toolBar = n.getNotepadToolBar();
                if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton copyButton  = new JButton(new ImageIcon(this.getClass().getResource("images/copy.gif")));
		copyButton.setToolTipText("Copy");
		copyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				copyActions.copy();
			}
		});
		toolBar.add(copyButton);
    }
}
