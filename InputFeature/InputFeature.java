/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InputFeature;

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
        buildToolBar();
    }


    protected void buildFileMenu() {
		
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
		JMenuItem newFileMenuItem    = new JMenuItem("New", new ImageIcon(this.getClass().getResource("images/new.gif")));
		newFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newFileMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.newFile();
			}
		});
		fileMenu.add(newFileMenuItem);
		JMenuItem openMenuItem   = new JMenuItem("Open", new ImageIcon(this.getClass().getResource("images/open.gif")));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.open();
			}
		});
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem   = new JMenuItem("Save", new ImageIcon(this.getClass().getResource("images/save.gif")));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				inputActions.save();
			}
		});
		fileMenu.add(saveMenuItem);
	
	}
    
    protected void buildToolBar()
    {

        JToolBar toolBar = n.getNotepadToolBar();
            
                    if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
                    JButton newButton   = new JButton(new ImageIcon(this.getClass().getResource("images/new.gif")));
                    newButton.setToolTipText("New");
                    newButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                    inputActions.newFile();
                            }
                    });
                    toolBar.add(newButton);
                    JButton openButton  = new JButton(new ImageIcon(this.getClass().getResource("images/open.gif")));
                    openButton.setToolTipText("Open");
                    openButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                    inputActions.open();
                            }
                    });
                    toolBar.add(openButton);
                    JButton saveButton  = new JButton(new ImageIcon(this.getClass().getResource("images/save.gif")));
                    saveButton.setToolTipText("Save");
                    saveButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                    inputActions.save();
                            }
                    });
                    toolBar.add(saveButton);
    }
}
