/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WrapFeature;

import Notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author carlos
 */
public class WrapFeature {
    private Notepad n;
    private WrapActions wrapActions;

    public WrapFeature(Notepad n)
    {
        this.n = n;
        wrapActions = new WrapActions(n);
        buildFormatMenu();
        buildToolBar();
    }
    private JCheckBoxMenuItem lineWrapMenuItem;
	//for using lineWrap & textArea @Actions.java
	public JCheckBoxMenuItem getLineWrap(){
		return lineWrapMenuItem;
	}
	protected void buildFormatMenu() {
		JMenu formatMenu = buildFormatMenuOriginal();
		if (formatMenu.getItemCount() > 0) formatMenu.addSeparator();
		lineWrapMenuItem = new JCheckBoxMenuItem("Line Wrap");
		lineWrapMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				wrapActions.lineWrap(lineWrapMenuItem);
			}
		});
		formatMenu.add(lineWrapMenuItem);
		JMenuItem fontMenuItem = new JMenuItem("Font", new ImageIcon(this.getClass().getResource("images/font.gif")));
		fontMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				wrapActions.font();
			}
		});
		formatMenu.add(fontMenuItem);
		
                n.getNotepadMenuBar().add(formatMenu);
	}
	protected JToolBar buildToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton fontButton  = new JButton(new ImageIcon(this.getClass().getResource("images/font.gif")));
		fontButton.setToolTipText("Font");
		fontButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				wrapActions.font();
			}
		});
		toolBar.add(fontButton);
		return toolBar;
	}


    	protected JMenu buildFormatMenuOriginal() {
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('o');
		return formatMenu;
	}
}
