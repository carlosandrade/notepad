package Notepad;


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
import AboutFeature.*;
import InputFeature.InputFeature;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
import SaveAsFeature.*;
import ToolBarFeature.ToolBarFeature;

/**
 *A PUBLIC CLASS FOR NOTEPAD.JAVA
 */
public class Notepad extends JFrame{
	//for using the methods in these classes
	private Actions actions = new Actions(this);

        //Create a new menubar - Mandatory Feature
        static private JMenuBar Menubar = new JMenuBar();

        //Create a new textArea - Mandatory Feature
        static private JTextArea textArea;

        //Create a toolbar for the Notepad
        static private JToolBar toolBar = new JToolBar("Tool Bar");

        //Features
        InputFeature f1;
        AboutFeature f2 ;
        SaveAsFeature f3;
        ToolBarFeature f4 = new ToolBarFeature(this);

        public JToolBar getNotepadToolBar()
        {
            return toolBar;
        }
        public  JMenuBar getNotepadMenuBar()
        {
            return Menubar;
        }
	protected JMenuBar buildMenuBar() {
        
             
                //Create file menu
		JMenu fileMenu = buildFileMenu();
                
                //Add the Sub-menu of File to the main Menubar
		Menubar.add(fileMenu);

                

                /********Input Feature should be put here**********/
               

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
                            //Instantiate and modify to InputActions to warn unsaved files on top right close icon- requires Input and saveAs
				actions.exit();
			}
		});

                //Add exit menu item to the file sub-menu at MenuBar
      
		fileMenu.add(exitMenuItem); //, new ImageIcon(this.getClass().getResource("images/exit.gif"))));  -- exit.gif missing
                 f1 = new InputFeature(this);
                  f3 = new SaveAsFeature(this);
              
               
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

                /********About Feature should be put here**********/
		
                  f2 = new AboutFeature(this);
                
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
	/*
         * Optional Feature ToolBar
         * Toolbar is now an atribute, see Rationale to find out why.
         */
        

        /*
         * Mandatory Feature Method
         */
        public JTextArea getTextArea() {
		return textArea;
	}
        /*
         * Mandatory Feature Method
         */
	public JTextComponent getTextComponent() {
		return textArea;
	}
	//Constructor of Notepad
	public Notepad() {
		super();
                
                setJMenuBar(buildMenuBar());
		//set the title for Notepad and set the size for it.
		setTitle("Untitled - JAVA Notepad");
		setSize(800,600);

                //Text Area - Mandatory Feature
                Container cp = getContentPane();
		textArea = new JTextArea();
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(false);
		cp.add(textArea);
		cp.add(new JScrollPane(textArea));
                //End of TextArea - Mandatory Feature


		/**
		 *setting the default close operation to false and
		 *using own action (exitMenuItem action @Actions.java)
		 */
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
                                //Instantiate and modify to InputActions to warn unsaved files on top right close icon - requires input and saveAs features
				actions.exit();
			}
		});

	}
	//Main Method
	public static void main(String[] args){
		new Notepad().show();
	}
}
