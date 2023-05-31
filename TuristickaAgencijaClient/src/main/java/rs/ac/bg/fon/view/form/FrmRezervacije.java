package rs.ac.bg.fon.view.form;

public class FrmRezervacije extends javax.swing.JDialog {

    public FrmRezervacije(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pPutnik = new javax.swing.JPanel();
        lblPutnik = new javax.swing.JLabel();
        txtPretragaPutnik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPutnici = new javax.swing.JTable();
        btnPretraziPutnika = new javax.swing.JButton();
        pPutovanje = new javax.swing.JPanel();
        lblPretragaPutovanja = new javax.swing.JLabel();
        txtPretragaPutovanja = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPutovanja = new javax.swing.JTable();
        btnPretraziPutovanja = new javax.swing.JButton();
        pTermin = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tTermini = new javax.swing.JTable();
        btnStorniraj = new javax.swing.JButton();
        btnRRezervisi = new javax.swing.JButton();
        btnObradi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(126, 126, 126));

        pPutnik.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga putnika"));

        lblPutnik.setText("Ime i prezime putnika:");

        tPutnici.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tPutnici);

        btnPretraziPutnika.setText("Pretrazi");

        javax.swing.GroupLayout pPutnikLayout = new javax.swing.GroupLayout(pPutnik);
        pPutnik.setLayout(pPutnikLayout);
        pPutnikLayout.setHorizontalGroup(
                pPutnikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutnikLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPutnikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(pPutnikLayout.createSequentialGroup()
                                                .addComponent(lblPutnik)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPretragaPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnPretraziPutnika, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pPutnikLayout.setVerticalGroup(
                pPutnikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutnikLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPutnikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPutnik)
                                        .addComponent(txtPretragaPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPretraziPutnika))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pPutovanje.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga putovanja"));

        lblPretragaPutovanja.setText("Krajnja destinacija putovanja:");

        tPutovanja.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(tPutovanja);

        btnPretraziPutovanja.setText("Pretrazi");

        javax.swing.GroupLayout pPutovanjeLayout = new javax.swing.GroupLayout(pPutovanje);
        pPutovanje.setLayout(pPutovanjeLayout);
        pPutovanjeLayout.setHorizontalGroup(
                pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                .addComponent(lblPretragaPutovanja)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPretragaPutovanja, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPretraziPutovanja, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pPutovanjeLayout.setVerticalGroup(
                pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPretragaPutovanja)
                                        .addComponent(txtPretragaPutovanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPretraziPutovanja))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pTermin.setBorder(javax.swing.BorderFactory.createTitledBorder("Termini"));

        tTermini.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(tTermini);

        btnStorniraj.setText("Storniraj");

        btnRRezervisi.setText("Rezervisi");

        btnObradi.setText("Obradi");

        javax.swing.GroupLayout pTerminLayout = new javax.swing.GroupLayout(pTermin);
        pTermin.setLayout(pTerminLayout);
        pTerminLayout.setHorizontalGroup(
                pTerminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pTerminLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pTerminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTerminLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(pTerminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnStorniraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnRRezervisi, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                        .addComponent(btnObradi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pTerminLayout.setVerticalGroup(
                pTerminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pTerminLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStorniraj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRRezervisi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(btnObradi))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(pPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pPutovanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(pTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pPutnik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pPutovanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pTermin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JButton btnObradi;
    private javax.swing.JButton btnPretraziPutnika;
    private javax.swing.JButton btnPretraziPutovanja;
    private javax.swing.JButton btnRRezervisi;
    private javax.swing.JButton btnStorniraj;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPretragaPutovanja;
    private javax.swing.JLabel lblPutnik;
    private javax.swing.JPanel pPutnik;
    private javax.swing.JPanel pPutovanje;
    private javax.swing.JPanel pTermin;
    private javax.swing.JTable tPutnici;
    private javax.swing.JTable tPutovanja;
    private javax.swing.JTable tTermini;
    private javax.swing.JTextField txtPretragaPutnik;
    private javax.swing.JTextField txtPretragaPutovanja;
    // End of variables declaration

    public javax.swing.JButton getBtnPretraziPutnika() {
        return btnPretraziPutnika;
    }

    public void setBtnPretraziPutnika(javax.swing.JButton btnPretraziPutnika) {
        this.btnPretraziPutnika = btnPretraziPutnika;
    }

    public javax.swing.JButton getBtnPretraziPutovanja() {
        return btnPretraziPutovanja;
    }

    public void setBtnPretraziPutovanja(javax.swing.JButton btnPretraziPutovanja) {
        this.btnPretraziPutovanja = btnPretraziPutovanja;
    }

    public javax.swing.JButton getBtnRRezervisi() {
        return btnRRezervisi;
    }

    public void setBtnRRezervisi(javax.swing.JButton btnRRezervisi) {
        this.btnRRezervisi = btnRRezervisi;
    }

    public javax.swing.JButton getBtnStorniraj() {
        return btnStorniraj;
    }

    public void setBtnStorniraj(javax.swing.JButton btnStorniraj) {
        this.btnStorniraj = btnStorniraj;
    }

    public javax.swing.JLabel getlblPutnik() {
        return lblPutnik;
    }

    public void setlblPutnik(javax.swing.JLabel jLabel1) {
        this.lblPutnik = jLabel1;
    }

    public javax.swing.JLabel getlblPretragaPutovanja() {
        return lblPretragaPutovanja;
    }

    public void setlblPretragaPutovanja(javax.swing.JLabel jLabel2) {
        this.lblPretragaPutovanja = jLabel2;
    }

    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public javax.swing.JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(javax.swing.JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public javax.swing.JPanel getpPutnik() {
        return pPutnik;
    }

    public void setpPutnik(javax.swing.JPanel pPutnik) {
        this.pPutnik = pPutnik;
    }

    public javax.swing.JPanel getpPutovanje() {
        return pPutovanje;
    }

    public void setpPutovanje(javax.swing.JPanel pPutovanje) {
        this.pPutovanje = pPutovanje;
    }

    public javax.swing.JPanel getpTermin() {
        return pTermin;
    }

    public void setpTermin(javax.swing.JPanel pTermin) {
        this.pTermin = pTermin;
    }

    public javax.swing.JTable gettPutnici() {
        return tPutnici;
    }

    public void settPutnici(javax.swing.JTable tPutnici) {
        this.tPutnici = tPutnici;
    }

    public javax.swing.JTable gettPutovanja() {
        return tPutovanja;
    }

    public void settPutovanja(javax.swing.JTable tPutovanja) {
        this.tPutovanja = tPutovanja;
    }

    public javax.swing.JTable gettTermini() {
        return tTermini;
    }

    public void settTermini(javax.swing.JTable tTermini) {
        this.tTermini = tTermini;
    }

    public javax.swing.JTextField getTxtPretragaPutnik() {
        return txtPretragaPutnik;
    }

    public void setTxtPretragaPutnik(javax.swing.JTextField txtPretragaPutnik) {
        this.txtPretragaPutnik = txtPretragaPutnik;
    }

    public javax.swing.JTextField getTxtPretragaPutovanja() {
        return txtPretragaPutovanja;
    }

    public void setTxtPretragaPutovanja(javax.swing.JTextField txtPretragaPutovanja) {
        this.txtPretragaPutovanja = txtPretragaPutovanja;
    }

    public javax.swing.JButton getBtnObradi() {
        return btnObradi;
    }

    public void setBtnObradi(javax.swing.JButton btnObradi) {
        this.btnObradi = btnObradi;
    }
}