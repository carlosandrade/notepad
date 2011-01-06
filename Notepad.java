
/**
 *This is a JAVA program for writing, opening, saving, editing the documents,
 *has the ability to copy, cut, paste & select all text in the JTextArea,
 *has @see ExampleFileFilter class (From SUN -http://java.sun.com-) for filter the file
 *has a print class (from AarbTeam2000 -http://wwww.arabteam2000.com-) for printing the documents
 */

/**
 *@King Fahd University of Petroleum and Minerals (KFUPM)
 *@auther: Al-Thubaiti Salah
 *@ICS201 PROJECT
 *@JAVA Notepad (JNotepad)
 *@version# 2.0
 */

/**
 *
 */

//import the packages for using the classes in them into the program
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *A PUBLIC CLASS FOR NOTEPAD.JAVA
 */
public class Notepad extends JFrame{
	//for using the methods in these classes
	public Actions actions = new Actions(this);
        public AboutActions aboutActions = new AboutActions();

	protected JMenuBar buildMenuBar() {

                //Create a new menubar
		JMenuBar Menubar = new JMenuBar();
                //Create file menu
		JMenu fileMenu = buildFileMenu();

                /*
                 * Operations related to the FILE SUB-MENU
                 */

                //If the file menu has at least one sub-item, add a separator to the end of the sub-itens list
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();

                //Create exit sub-item to be added on the File Menu
		JMenuItem exitMenuItem   = new JMenuItem("Exit");

                //Add ctrl+f4 shortcut to the Exit Item
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));

                //Uses Inner Anonymous class to add the exit action of a Notepad located at the Actions class in this package
		exitMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.exit();
			}
		});

                //Add exit menu item to the file sub-menu at MenuBar

		fileMenu.add(exitMenuItem); //, new ImageIcon(this.getClass().getResource("images/exit.gif"))));  -- exit.gif missing

                //Add the Sub-menu of File to the main Menubar
		Menubar.add(fileMenu);

                 /*
                 * Operations related to the EDIT SUB-MENU
                 */

		JMenu editMenu = buildEditMenu();

                //Add the editMenu to the main MenuBar if it has at least one item
		if (editMenu.getItemCount() > 0) Menubar.add(editMenu);

                 /*
                 * Operations related to the FORMAT SUB-MENU
                 */


		JMenu formatMenu = buildFormatMenu();

                //Add the formatMenu to the main MenuBar if it has at least one item
		if (formatMenu.getItemCount() > 0) Menubar.add(formatMenu);

                 /*
                 * Operations related to the HELP SUB-MENU
                 */
		Menubar.add(buildHelpMenu());

                
		return Menubar;
	}
        /*
         * Creates a File menu on the menubar named 'File' with a shortcut 'f'
         */
	protected JMenu buildFileMenu() {
		JMenu fileMenu   = new JMenu("File");
		fileMenu.setMnemonic('f');
		return fileMenu;
	}
	protected JMenu buildEditMenu() {
		JMenu editMenu   = new JMenu("Edit");
		editMenu.setMnemonic('e');
		return editMenu;
	}
	protected JMenu buildFormatMenu() {
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('o');
		return formatMenu;
	}
	protected JMenu buildHelpMenu() {
		JMenu helpMenu   = new JMenu("Help");
		helpMenu.setMnemonic('h');

                /*About Feature */
		JMenuItem aboutMenuItem = new JMenuItem("About Notepad", new ImageIcon(this.getClass().getResource("images/about.gif")));
		aboutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				aboutActions.about();
			}
		});
		helpMenu.add(aboutMenuItem);
                
                /* End of About Feature */

		return helpMenu;
	}
	protected JToolBar buildToolBar() {
		JToolBar toolBar = new JToolBar("Tool Bar");
		return toolBar;
	}
	//Constructor of Notepad
	public Notepad() {
		super();
		//set the title for Notepad and set the size for it.
		setTitle("Untitled - JAVA Notepad");
		setSize(800,600);

		/**
		 *setting the default close operation to false and
		 *using own action (exitMenuItem action @Actions.java)
		 */
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				actions.exit();
			}
		});
	}
	//Main Method
	public static void main(String[] args){
		new Notepad().show();
	}
}
