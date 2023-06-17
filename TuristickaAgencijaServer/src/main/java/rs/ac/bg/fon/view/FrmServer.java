package rs.ac.bg.fon.view;

public class FrmServer extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton btnPokreniServer;
    private javax.swing.JButton btnZaustaviServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojKonektovanihKlijenata;
    private javax.swing.JLabel lblStatusServera;
    private javax.swing.JTable tableKonektovaniKorisnici;
    public FrmServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblStatusServera = new javax.swing.JLabel();
        btnPokreniServer = new javax.swing.JButton();
        btnZaustaviServer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblBrojKonektovanihKlijenata = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKonektovaniKorisnici = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Status servera:");

        lblStatusServera.setText("STATUS");

        btnPokreniServer.setText("Pokreni server");

        btnZaustaviServer.setText("Zaustavi server");

        jLabel2.setText("Broj konektovanih klijenata:");

        lblBrojKonektovanihKlijenata.setText("BROJ");

        tableKonektovaniKorisnici.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tableKonektovaniKorisnici);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblStatusServera))
                                                        .addComponent(btnPokreniServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblBrojKonektovanihKlijenata)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 13, Short.MAX_VALUE)
                                                                .addComponent(btnZaustaviServer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(lblStatusServera))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnZaustaviServer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblBrojKonektovanihKlijenata))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    // End of variables declaration

    public javax.swing.JButton getBtnPokreniServer() {
        return btnPokreniServer;
    }

    public void setBtnPokreniServer(javax.swing.JButton btnPokreniServer) {
        this.btnPokreniServer = btnPokreniServer;
    }

    public javax.swing.JButton getBtnZaustaviServer() {
        return btnZaustaviServer;
    }

    public void setBtnZaustaviServer(javax.swing.JButton btnZaustaviServer) {
        this.btnZaustaviServer = btnZaustaviServer;
    }

    public javax.swing.JLabel getLblBrojKonektovanihKlijenata() {
        return lblBrojKonektovanihKlijenata;
    }

    public void setLblBrojKonektovanihKlijenata(javax.swing.JLabel lblBrojKonektovanihKlijenata) {
        this.lblBrojKonektovanihKlijenata = lblBrojKonektovanihKlijenata;
    }

    public javax.swing.JLabel getLblStatusServera() {
        return lblStatusServera;
    }

    public void setLblStatusServera(javax.swing.JLabel lblStatusServera) {
        this.lblStatusServera = lblStatusServera;
    }

    public javax.swing.JTable getTableKonektovaniKorisnici() {
        return tableKonektovaniKorisnici;
    }

    public void setTableKonektovaniKorisnici(javax.swing.JTable tableConnectedClients) {
        this.tableKonektovaniKorisnici = tableConnectedClients;
    }
}