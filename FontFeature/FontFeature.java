/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FontFeature;

import Notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author carlos
 */
public class FontFeature {
    JTextPane textPane = new JTextPane();
    Notepad n;
    private FontActions fontActions;
    public FontFeature(Notepad n)
    {
        this.n = n;
        fontActions = new FontActions(n,textPane);

        StyledDocument doc = textPane.getStyledDocument();
		javax.swing.text.Style regular = doc.addStyle("regular",
			StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE));
		javax.swing.text.Style italic = doc.addStyle("italic", regular);
		StyleConstants.setItalic(italic, true);
		javax.swing.text.Style bold = doc.addStyle("bold", regular);
		StyleConstants.setBold(bold, true);
                buildToolBar();
    }
    protected void buildToolBar() {
		JToolBar toolBar = n.getNotepadToolBar();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		String styles[] = {"regular", "bold", "italic"};
		final JComboBox styleBox = new JComboBox(styles);
		styleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fontActions.setStyle(String.valueOf(styleBox.getSelectedItem()));
			}
		});
		toolBar.add(styleBox);

    }
}
