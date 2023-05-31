package rs.ac.bg.fon.view.form;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        btnPrijava = new javax.swing.JButton();
        greskaEmail = new javax.swing.JLabel();
        greskaSifra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prijava korisnika na sistem");

        lblEmail.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblSifra.setText("Sifra:");

        btnPrijava.setText("Prijava na sistem");

        greskaEmail.setForeground(new java.awt.Color(255, 0, 0));

        greskaSifra.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblEmail)
                                                        .addComponent(lblSifra))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(greskaEmail)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtEmail)
                                                                .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                                        .addComponent(greskaSifra)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(btnPrijava)))
                                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmail)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greskaEmail)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSifra)
                                        .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greskaSifra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(btnPrijava)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel greskaEmail;
    private javax.swing.JLabel greskaSifra;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration

    public javax.swing.JButton getBtnPrijava() {
        return btnPrijava;
    }

    public void setBtnPrijava(javax.swing.JButton btnPrijava) {
        this.btnPrijava = btnPrijava;
    }

    public javax.swing.JLabel getGreskaEmail() {
        return greskaEmail;
    }

    public void setGreskaEmail(javax.swing.JLabel greskaEmail) {
        this.greskaEmail = greskaEmail;
    }

    public javax.swing.JLabel getGreskaSifra() {
        return greskaSifra;
    }

    public void setGreskaSifra(javax.swing.JLabel greskaSifra) {
        this.greskaSifra = greskaSifra;
    }

    public javax.swing.JLabel getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(javax.swing.JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public javax.swing.JLabel getLblSifra() {
        return lblSifra;
    }

    public void setLblSifra(javax.swing.JLabel lblSifra) {
        this.lblSifra = lblSifra;
    }

    public javax.swing.JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(javax.swing.JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public javax.swing.JPasswordField getTxtSifra() {
        return txtSifra;
    }

    public void setTxtSifra(javax.swing.JPasswordField txtSifra) {
        this.txtSifra = txtSifra;
    }
}