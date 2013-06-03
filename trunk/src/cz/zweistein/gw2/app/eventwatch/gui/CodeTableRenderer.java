package cz.zweistein.gw2.app.eventwatch.gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CodeTableRenderer extends JLabel implements ListCellRenderer {
	private static final long serialVersionUID = 3801116579846646911L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		setOpaque(true);
		
		if (cellHasFocus || isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		
		setText(value.toString());
		return this;
	}

}
