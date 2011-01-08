/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UndoRedoFeature;

import Notepad.Notepad;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author carlos
 */
public class UndoFeature {
    	//for using undo & redo
    Notepad n;
        UndoManager undo = new UndoManager();
	UndoAction undoAction = new UndoAction(this);
	RedoAction redoAction = new RedoAction(this);

    public UndoFeature(Notepad n)
    {
        this.n = n;
	if(n.getTextComponent() == null) System.out.println("Wtf?");
		n.getTextComponent().getDocument().addUndoableEditListener(new UndoableEditListener(){
			public void undoableEditHappened(UndoableEditEvent e){
				//Remember the edit and update the menus
				undo.addEdit(e.getEdit());
				undoAction.update();
				
			}
		});

                buildUndoButton();
    }
    public UndoFeature(Notepad n, boolean hasUndoToolBarIcon)
    {
         this.n = n;

		n.getTextComponent().getDocument().addUndoableEditListener(new UndoableEditListener(){
			public void undoableEditHappened(UndoableEditEvent e){
				//Remember the edit and update the menus
				undo.addEdit(e.getEdit());
				undoAction.update();
			}
		});

                buildUndoButton();
                addUndoToToolBar();
    }
    public UndoFeature(Notepad n, boolean hasUndoToolBarIcon, boolean hasRedoFeature)
    {
         this.n = n;

		n.getTextComponent().getDocument().addUndoableEditListener(new UndoableEditListener(){
			public void undoableEditHappened(UndoableEditEvent e){
				//Remember the edit and update the menus
				undo.addEdit(e.getEdit());
				undoAction.update();
				redoAction.update();
			}
		});

            buildUndoButton();
            addUndoToToolBar();
            buildRedoButton();
    }
    public UndoFeature(Notepad n, boolean hasUndoToolBarIcon, boolean hasRedoFeature, boolean hasRedoToolBarIcon)
    {
         this.n = n;

		n.getTextComponent().getDocument().addUndoableEditListener(new UndoableEditListener(){
			public void undoableEditHappened(UndoableEditEvent e){
				//Remember the edit and update the menus
				undo.addEdit(e.getEdit());
				undoAction.update();
				redoAction.update();
			}
		});

            buildUndoButton();
            addUndoToToolBar();
            buildRedoButton();
            addRedoToToolBar();
    }


	protected void buildUndoButton() {
		JMenu editMenu   = n.getEditMenu();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		editMenu.add(undoAction);
		
	}
        protected void buildRedoButton(){
            	JMenu editMenu   = n.getEditMenu();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		editMenu.add(redoAction);
		
        }

	protected JToolBar addUndoToToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		toolBar.add(undoAction);
		return toolBar;
	}
        protected JToolBar addRedoToToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		toolBar.add(redoAction);
		return toolBar;
	}
}
