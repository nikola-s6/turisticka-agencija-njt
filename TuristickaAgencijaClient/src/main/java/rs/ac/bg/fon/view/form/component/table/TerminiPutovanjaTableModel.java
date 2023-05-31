package rs.ac.bg.fon.view.form.component.table;

import rs.ac.bg.fon.domain.Termin;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TerminiPutovanjaTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Datum polaska", "Datum povratka", "cena"};
    private Class[] classes = new Class[]{Object.class, Object.class, Object.class};
    private boolean editable;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<Termin> termini;

    public TerminiPutovanjaTableModel(List<Termin> termini, boolean editable) {
        this.termini = termini;
        this.editable = editable;
    }

    @Override
    public int getRowCount() {
        if (termini == null) {
            return 0;
        }
        return termini.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
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
        Termin termin = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (termin.getDatumPolaska() == null) {
                    return "";
                }
                return dateFormat.format(termin.getDatumPolaska());
            case 1:
                if (termin.getDatumPovratka() == null) {
                    return "";
                }
                return dateFormat.format(termin.getDatumPovratka());
            case 2:
                if(termin.getCena() == null){
                    return "";
                }
                return termin.getCena() + " rsd";
            default:
                return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Termin termin = termini.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    termin.setDatumPolaska(dateFormat.parse((String) aValue));
                    break;
                case 1:
                    termin.setDatumPovratka(dateFormat.parse((String) aValue));
                    break;
                case 2:
                    termin.setCena(Double.valueOf((String) aValue));
//                    System.out.println(termin.getCena());
                    fireTableCellUpdated(rowIndex, 2);
                    break;
            }
        } catch (ParseException ex) {
//            Logger.getLogger(TerminiKreiranjePutovanjaTableModel.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Datumi moraju biti upisani u formatu yyyy-MM-dd");
            JOptionPane.showMessageDialog(null, "Datumi moraju biti upisani u formatu yyyy-MM-dd", "Greska upisa datuma termina", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Termin> getListaTermina() {
        return termini;
    }

    public Termin getTermin(int row) {
        return termini.get(row);
    }

    public void dodajTermin(Termin termin) {
        termini.add(termin);
        fireTableRowsInserted(termini.size() - 1, termini.size() - 1);
    }

    public void obrisiTermin(int row) {
        termini.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void setEditable(boolean b) {
        editable = b;
    }
}
