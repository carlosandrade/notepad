/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SaveAsFeature;

import Notepad.Notepad;
import InputFeature.InputActions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    public SaveAsFeature(Notepad n, boolean hasToolBarIcon)
    {
        this.n = n;
        fileMenu = n.getNotepadMenuBar().getMenu(0);
        inputActions = new InputActions(n);

        buildFileMenu();
        buildToolBar();
    }

    protected JMenu buildFileMenu()
    {
        if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
        JMenuItem saveAsMenuItem = new JMenuItem("Save As", new ImageIcon(this.getClass().getResource("images/saveAs.gif")));
		saveAsMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.saveAs();
			}
		});
		fileMenu.add(saveAsMenuItem);
		return fileMenu;

    }

    protected void buildToolBar()
    {
        if (n.getNotepadToolBar().getComponentCount() > 0) n.getNotepadToolBar().addSeparator();
        		JButton saveAsButton= new JButton(new ImageIcon(this.getClass().getResource("images/saveAs.gif")));
		saveAsButton.setToolTipText("Save As");
		saveAsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.saveAs();
			}
		});
		n.getNotepadToolBar().add(saveAsButton);
    }
}
