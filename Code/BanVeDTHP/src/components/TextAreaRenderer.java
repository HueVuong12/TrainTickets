package components;


import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

		public TextAreaRenderer() {
            setLineWrap(true);           // Cho phép xuống dòng
            setWrapStyleWord(true);      // Xuống dòng theo từ
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "");
            setFont(table.getFont());

            // Điều chỉnh màu khi chọn ô
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
            }

            return this;
        }
    }