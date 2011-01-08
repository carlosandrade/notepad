package UndoRedoFeature;


import Notepad.Notepad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;

class UndoAction extends AbstractAction {
	UndoFeature undoFeature;

	public UndoAction(UndoFeature undoFeature){
		super( "Undo" );
		putValue( Action.SMALL_ICON,
			new ImageIcon( this.getClass().getResource( "images/undo.gif" ) ) );
		setEnabled( false );
		this.undoFeature = undoFeature;
	}
	public void actionPerformed( ActionEvent e ) {
		try {
			undoFeature.undo.undo();
		} catch ( CannotUndoException ex ) {
			System.out.println( "Unable to undo: " + ex );
			ex.printStackTrace();
		}
		update();
		undoFeature.redoAction.update();
	}
	protected void update() {
		if( undoFeature.undo.canUndo() ) {
			setEnabled( true );
			putValue( "Undo", undoFeature.undo.getUndoPresentationName() );
		} else {
			setEnabled( false );
			putValue( Action.NAME, "Undo" );
		}
	}
}
