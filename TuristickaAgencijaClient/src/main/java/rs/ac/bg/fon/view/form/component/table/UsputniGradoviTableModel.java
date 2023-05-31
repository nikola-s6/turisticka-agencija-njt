package rs.ac.bg.fon.view.form.component.table;

import rs.ac.bg.fon.domain.Grad;
import rs.ac.bg.fon.domain.Usputni;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsputniGradoviTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Grad", "Drzava"};
    private Class[] classes = new Class[]{Object.class, Object.class};
    private final List<Usputni> usputni;
    private boolean editable;

    public UsputniGradoviTableModel(List<Usputni> usputni, boolean editable) {
        this.usputni = usputni;
        this.editable = editable;
    }

    @Override
    public int getRowCount() {
        if (usputni == null) {
            return 0;
        }
        return usputni.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return false;
        }
        return editable;
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usputni u = usputni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (u.getGrad() == null) {
                    return "";
                }
                return u.getGrad().getNaziv();
            case 1:
                if (u.getGrad() == null) {
                    return "";
                }
                return u.getGrad().getDrzava();
            default:
                return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usputni u = usputni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                u.setGrad((Grad) aValue);
                fireTableRowsUpdated(rowIndex, rowIndex);
                break;
        }
    }

    public List<Usputni> getListUsputni() {
        return usputni;
    }

    public Usputni getUsputni(int row) {
        return usputni.get(row);
    }

    public void dodajUsputni(Usputni u) {
        usputni.add(u);
        fireTableRowsInserted(usputni.size() - 1, usputni.size() - 1);
    }

    public void obrisiUsputni(int row) {
        usputni.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void setEditable(boolean b) {
        editable = b;
    }

}
