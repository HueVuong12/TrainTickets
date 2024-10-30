package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entity.Ve;

public class ButtonEditor extends DefaultCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
    private JTable table;
    public ButtonEditor(JCheckBox checkBox, ArrayList<Ve> dsVeDatTam) {
    	super(checkBox);
    	button = new JButton();
    	button.setOpaque(true);
    	button.setBackground(Color.WHITE);
    	button.setHorizontalAlignment(SwingConstants.CENTER); // căn giữa
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			fireEditingStopped();
    			int row = table.getSelectedRow();
    			if (row != -1) {
    				((DefaultTableModel) table.getModel()).removeRow(row);
    			}
    		}
    	});
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
