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
				redoAction.update();
			}
		});

                buildEditMenu();
    }
    public UndoFeature(Notepad n, boolean hasToolBarIcon)
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

        buildEditMenu();
        buildToolBar();
    }


	protected JMenu buildEditMenu() {
		JMenu editMenu   = n.getEditMenu();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		editMenu.add(undoAction);
		editMenu.add(redoAction);
		return editMenu;
	}
	protected JToolBar buildToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		toolBar.add(undoAction);
		toolBar.add(redoAction);
		return toolBar;
	}
}
