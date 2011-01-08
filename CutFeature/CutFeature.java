/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CutFeature;

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
public class CutFeature {
    Notepad n;
    CutActions cutActions;
    
    public CutFeature(Notepad n)
    {
        this.n = n;
        cutActions = new CutActions(n);
        buildCutButton();
    }
    public CutFeature(Notepad n, boolean hasToolBarIcon)
    {
        this.n = n;
        cutActions = new CutActions(n);
        buildCutButton();
        addCutToToolBar();
    }

    protected void buildCutButton()
    {
        JMenu editMenu = n.getEditMenu();
                    if (editMenu.getItemCount() > 0) editMenu.addSeparator();
                    JMenuItem cutMenuItem  = new JMenuItem("Cut",  new ImageIcon(this.getClass().getResource("images/cut.gif")));
                    cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                    cutMenuItem.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                    cutActions.cut();
                            }
                    });
                    editMenu.add(cutMenuItem);
    }
    protected void addCutToToolBar()
    {
    JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton cutButton   = new JButton(new ImageIcon(this.getClass().getResource("images/cut.gif")));
		cutButton.setToolTipText("Cut");
		cutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				cutActions.cut();
			}
		});
		toolBar.add(cutButton);
    }
}
