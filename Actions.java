
//import the packages for using the classes in them into this class
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *A PUBLIC CLASS FOR ACTIONS.JAVA
 *
 * Actions should be aware only of general Notepad actions, other feature related about actions should be
 * encapsulated on their on classes. 
 */
public class Actions {
	Notepad n; //for using the object in the Notepad.java

	public Actions(Notepad n){
		this.n = n;
	}
	public void exit(){
		System.exit(0);
	}
}
