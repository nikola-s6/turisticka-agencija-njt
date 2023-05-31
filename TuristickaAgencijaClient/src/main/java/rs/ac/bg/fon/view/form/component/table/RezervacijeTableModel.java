package rs.ac.bg.fon.view.form.component.table;

import rs.ac.bg.fon.domain.Rezervacija;
import rs.ac.bg.fon.domain.util.StatusRezervacije;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RezervacijeTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Putnik", "Broj rezervacije", "Status rezervacije", "Datum polaska", "Datum povratka"};
    private Class[] classes = new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class};
    private boolean editable;
    private List<Rezervacija> rezervacije;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RezervacijeTableModel(List<Rezervacija> rezervacije, boolean editable) {
        this.rezervacije = rezervacije;
        this.editable = editable;
    }

    @Override
    public int getRowCount() {
        if (rezervacije == null) {
            return 0;
        }
        return rezervacije.size();
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
        Rezervacija rezervacija = rezervacije.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return "(" + rezervacija.getPutnik().getPutnikID() + ") " + rezervacija.getPutnik().getIme() + " " + rezervacija.getPutnik().getPrezime();
            case 1:
                return Integer.toString(rezervacija.getBrojRezervacije());
            case 2:
                return rezervacija.getStatus().toString();
            case 3:
                return dateFormat.format(rezervacija.getTermin().getDatumPolaska());
            case 4:
                return dateFormat.format(rezervacija.getTermin().getDatumPovratka());
            default:
                return "n/a";
        }
    }

    public Rezervacija getRezervacija(int row) {
        return rezervacije.get(row);
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void storniraj(int row) {
        rezervacije.get(row).setStatus(StatusRezervacije.NEAKTIVAN);
        fireTableRowsUpdated(row, row);
    }

    public void obradi(int row) {
        rezervacije.get(row).setStatus(StatusRezervacije.AKTIVAN);
        fireTableRowsUpdated(row, row);
    }

}
