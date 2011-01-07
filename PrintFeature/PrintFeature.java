/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PrintFeature;

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
public class PrintFeature {
    private Notepad n;
    private JMenu fileMenu;
    private PrintActions printActions;

        public PrintFeature(Notepad n)
        {
            this.n = n;
            fileMenu = n.getNotepadMenuBar().getMenu(0);
            printActions = new PrintActions(n);
            buildFileMenu();
            buildToolBar();

        }

    	protected JMenu buildFileMenu() {
		
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
		JMenuItem printMenuItem  = new JMenuItem("Print", new ImageIcon(this.getClass().getResource("images/print.gif")));
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		printMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				printActions.print();
			}
		});
		fileMenu.add(printMenuItem);
		return fileMenu;
	}
	protected JToolBar buildToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton printButton = new JButton(new ImageIcon(this.getClass().getResource("images/print.gif")));
		printButton.setToolTipText("Print");
		printButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				printActions.print();
			}
		});
		toolBar.add(printButton);
		return toolBar;
	}
}
