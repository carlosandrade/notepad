package UndoRedoFeature;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;

class RedoAction extends AbstractAction{
	UndoFeature undoFeature;

	public RedoAction(UndoFeature undoFeature){
		super("Redo");
		putValue( Action.SMALL_ICON, 
			new ImageIcon(this.getClass().getResource("images/redo.gif")));
		setEnabled(false);
		this.undoFeature = undoFeature;
	}
	public void actionPerformed(ActionEvent e){
		try{
			undoFeature.undo.redo();
		} catch (CannotRedoException ex){
			System.out.println("Unable to redo: " + ex);
			ex.printStackTrace();
		}
		update();
		undoFeature.undoAction.update();
	}
	protected void update(){
		if(undoFeature.undo.canRedo()){
			setEnabled(true);
			putValue("Redo", undoFeature.undo.getRedoPresentationName());
		} else{
			setEnabled(false);
			putValue(Action.NAME, "Redo");
		}
	}
}
