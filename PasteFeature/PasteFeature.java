/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PasteFeature;

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
public class PasteFeature {
    Notepad n;
    PasteActions pasteActions;

    public PasteFeature(Notepad n)
    {
        this.n = n;
        pasteActions = new PasteActions(n);
        buildPasteButton();
    }
    public PasteFeature(Notepad n, boolean hasToolBarIcon)
    {
        this.n = n;
        pasteActions = new PasteActions(n);
        buildPasteButton();
        addPasteToToolBar();
    }
    protected void buildPasteButton()
    {
            JMenu editMenu = n.getEditMenu();
             if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		JMenuItem pasteMenuItem= new JMenuItem("Paste",new ImageIcon(this.getClass().getResource("images/paste.gif")));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				pasteActions.paste();
			}
		});
		editMenu.add(pasteMenuItem);
    }
   protected void addPasteToToolBar()
   {
        JToolBar toolBar = n.getNotepadToolBar();
        if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton pasteButton = new JButton(new ImageIcon(this.getClass().getResource("images/paste.gif")));
		pasteButton.setToolTipText("Paste");
		pasteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				pasteActions.paste();
			}
		});
		toolBar.add(pasteButton);
   }
}
