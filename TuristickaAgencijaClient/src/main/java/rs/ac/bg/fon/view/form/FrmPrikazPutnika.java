package rs.ac.bg.fon.view.form;

public class FrmPrikazPutnika extends javax.swing.JDialog {

    public FrmPrikazPutnika(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbPol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrojTelefona = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();
        btnOmoguciIzmenu = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        lblGreskaIme = new javax.swing.JLabel();
        lblGreskaPrezime = new javax.swing.JLabel();
        lblGreskaPol = new javax.swing.JLabel();
        lblGreskaEmail = new javax.swing.JLabel();
        lblGreskaBrojTelefona = new javax.swing.JLabel();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        lblGreskaSifra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podaci putnika");
        setResizable(false);

        lblId.setText("ID:");

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        jLabel1.setText("Pol:");

        cbPol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Email:");

        jLabel3.setText("Broj telefona:");

        btnObrisi.setText("Obrisi");

        btnOmoguciIzmenu.setText("Omoguci izmenu");

        btnSacuvaj.setText("Sacuvaj");

        lblGreskaIme.setForeground(new java.awt.Color(255, 0, 0));

        lblGreskaPrezime.setForeground(new java.awt.Color(255, 0, 0));

        lblGreskaPol.setForeground(new java.awt.Color(255, 0, 0));

        lblGreskaEmail.setForeground(new java.awt.Color(255, 0, 0));

        lblGreskaBrojTelefona.setForeground(new java.awt.Color(255, 0, 0));

        lblSifra.setText("Sifra:");

        lblGreskaSifra.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(lblId)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnOmoguciIzmenu)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblIme)
                                                                        .addComponent(lblPrezime)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(lblSifra))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblGreskaSifra)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(lblGreskaIme)
                                                                                .addComponent(lblGreskaPrezime)
                                                                                .addComponent(lblGreskaPol)
                                                                                .addComponent(lblGreskaEmail)
                                                                                .addComponent(lblGreskaBrojTelefona)
                                                                                .addComponent(txtPrezime)
                                                                                .addComponent(cbPol, 0, 328, Short.MAX_VALUE)
                                                                                .addComponent(txtEmail)
                                                                                .addComponent(txtBrojTelefona)
                                                                                .addComponent(txtIme)
                                                                                .addComponent(txtSifra, javax.swing.GroupLayout.Alignment.TRAILING)))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIme)
                                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaIme)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPrezime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaPrezime)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaPol)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaEmail)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaBrojTelefona)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSifra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGreskaSifra)
                                .addGap(0, 130, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOmoguciIzmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOmoguciIzmenu;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<String> cbPol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblGreskaBrojTelefona;
    private javax.swing.JLabel lblGreskaEmail;
    private javax.swing.JLabel lblGreskaIme;
    private javax.swing.JLabel lblGreskaPol;
    private javax.swing.JLabel lblGreskaPrezime;
    private javax.swing.JLabel lblGreskaSifra;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration

    public javax.swing.JButton getBtnObrisi() {
        return btnObrisi;
    }

    public void setBtnObrisi(javax.swing.JButton btnObrisi) {
        this.btnObrisi = btnObrisi;
    }

    public javax.swing.JButton getBtnOmoguciIzmenu() {
        return btnOmoguciIzmenu;
    }

    public void setBtnOmoguciIzmenu(javax.swing.JButton btnOmoguciIzmenu) {
        this.btnOmoguciIzmenu = btnOmoguciIzmenu;
    }

    public javax.swing.JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public void setBtnSacuvaj(javax.swing.JButton btnSacuvaj) {
        this.btnSacuvaj = btnSacuvaj;
    }

    public javax.swing.JComboBox<String> getCbPol() {
        return cbPol;
    }

    public void setCbPol(javax.swing.JComboBox<String> cbPol) {
        this.cbPol = cbPol;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public javax.swing.JLabel getLblGreskaBrojTelefona() {
        return lblGreskaBrojTelefona;
    }

    public void setLblGreskaBrojTelefona(javax.swing.JLabel lblGreskaBrojTelefona) {
        this.lblGreskaBrojTelefona = lblGreskaBrojTelefona;
    }

    public javax.swing.JLabel getLblGreskaEmail() {
        return lblGreskaEmail;
    }

    public void setLblGreskaEmail(javax.swing.JLabel lblGreskaEmail) {
        this.lblGreskaEmail = lblGreskaEmail;
    }

    public javax.swing.JLabel getLblGreskaIme() {
        return lblGreskaIme;
    }

    public void setLblGreskaIme(javax.swing.JLabel lblGreskaIme) {
        this.lblGreskaIme = lblGreskaIme;
    }

    public javax.swing.JLabel getLblGreskaPol() {
        return lblGreskaPol;
    }

    public void setLblGreskaPol(javax.swing.JLabel lblGreskaPol) {
        this.lblGreskaPol = lblGreskaPol;
    }

    public javax.swing.JLabel getLblGreskaPrezime() {
        return lblGreskaPrezime;
    }

    public void setLblGreskaPrezime(javax.swing.JLabel lblGreskaPrezime) {
        this.lblGreskaPrezime = lblGreskaPrezime;
    }

    public javax.swing.JLabel getLblId() {
        return lblId;
    }

    public void setLblId(javax.swing.JLabel lblId) {
        this.lblId = lblId;
    }

    public javax.swing.JLabel getLblIme() {
        return lblIme;
    }

    public void setLblIme(javax.swing.JLabel lblIme) {
        this.lblIme = lblIme;
    }

    public javax.swing.JLabel getLblPrezime() {
        return lblPrezime;
    }

    public void setLblPrezime(javax.swing.JLabel lblPrezime) {
        this.lblPrezime = lblPrezime;
    }

    public javax.swing.JTextField getTxtBrojTelefona() {
        return txtBrojTelefona;
    }

    public void setTxtBrojTelefona(javax.swing.JTextField txtBrojTelefona) {
        this.txtBrojTelefona = txtBrojTelefona;
    }

    public javax.swing.JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(javax.swing.JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public javax.swing.JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(javax.swing.JTextField txtId) {
        this.txtId = txtId;
    }

    public javax.swing.JTextField getTxtIme() {
        return txtIme;
    }

    public void setTxtIme(javax.swing.JTextField txtIme) {
        this.txtIme = txtIme;
    }

    public javax.swing.JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public void setTxtPrezime(javax.swing.JTextField txtPrezime) {
        this.txtPrezime = txtPrezime;
    }

    public javax.swing.JLabel getLblSifra() {
        return lblSifra;
    }

    public void setLblSifra(javax.swing.JLabel lblSifra) {
        this.lblSifra = lblSifra;
    }

    public javax.swing.JPasswordField getTxtSifra() {
        return txtSifra;
    }

    public void setTxtSifra(javax.swing.JPasswordField txtSifra) {
        this.txtSifra = txtSifra;
    }

    public javax.swing.JLabel getLblGreskaSifra() {
        return lblGreskaSifra;
    }

    public void setLblGreskaSifra(javax.swing.JLabel lblGreskaSifra) {
        this.lblGreskaSifra = lblGreskaSifra;
    }
}
