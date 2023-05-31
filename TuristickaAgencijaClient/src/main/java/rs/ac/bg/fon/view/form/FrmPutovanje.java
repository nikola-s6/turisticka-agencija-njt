package rs.ac.bg.fon.view.form;

public class FrmPutovanje extends javax.swing.JDialog {

    public FrmPutovanje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pPretragaPutovanja = new javax.swing.JPanel();
        txtPretragaPutovanja = new javax.swing.JTextField();
        lblKrajnjaDestinacija = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPretragaPutovanja = new javax.swing.JTable();
        btnUcitajPutovanja = new javax.swing.JButton();
        pTermini = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tTermini = new javax.swing.JTable();
        btnDodajTermin = new javax.swing.JButton();
        btnObrisiTermin = new javax.swing.JButton();
        pPutovanje = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPrevoz = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbSmestaj = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbPonuda = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taKratakOpis = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        cbPocetniGrad = new javax.swing.JComboBox<>();
        pUsputniGradovi = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tUsputniGradovi = new javax.swing.JTable();
        btnDodajUsputni = new javax.swing.JButton();
        btnObrisiUsputni = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbKrajnjiGrad = new javax.swing.JComboBox<>();
        pRezervacije = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tRezervacije = new javax.swing.JTable();
        btnIzmena = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Putovanje");
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(126, 126, 126));

        pPretragaPutovanja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pretraga putovanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        pPretragaPutovanja.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));

        lblKrajnjaDestinacija.setText("Krajnja destinacija");

        tbPretragaPutovanja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPretragaPutovanja);

        btnUcitajPutovanja.setText("Pretrazi");

        javax.swing.GroupLayout pPretragaPutovanjaLayout = new javax.swing.GroupLayout(pPretragaPutovanja);
        pPretragaPutovanja.setLayout(pPretragaPutovanjaLayout);
        pPretragaPutovanjaLayout.setHorizontalGroup(
                pPretragaPutovanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPretragaPutovanjaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPretragaPutovanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(pPretragaPutovanjaLayout.createSequentialGroup()
                                                .addComponent(lblKrajnjaDestinacija)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPretragaPutovanja, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnUcitajPutovanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pPretragaPutovanjaLayout.setVerticalGroup(
                pPretragaPutovanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPretragaPutovanjaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPretragaPutovanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblKrajnjaDestinacija)
                                        .addComponent(txtPretragaPutovanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUcitajPutovanja))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pTermini.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Termini putovanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        pTermini.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));

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
        jScrollPane4.setViewportView(tTermini);

        btnDodajTermin.setText("dodaj");

        btnObrisiTermin.setText("obrisi");

        javax.swing.GroupLayout pTerminiLayout = new javax.swing.GroupLayout(pTermini);
        pTermini.setLayout(pTerminiLayout);
        pTerminiLayout.setHorizontalGroup(
                pTerminiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pTerminiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pTerminiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnObrisiTermin, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(btnDodajTermin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pTerminiLayout.setVerticalGroup(
                pTerminiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pTerminiLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                        .addGroup(pTerminiLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnDodajTermin)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisiTermin)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPutovanje.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Osnovni podaci putovanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        pPutovanje.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));

        lblId.setText("ID:");

        jLabel1.setText("Naziv:");

        jLabel3.setText("Prevoz:");

        cbPrevoz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Smestaj:");

        cbSmestaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Ponuda:");

        cbPonuda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Kratak opis:");

        taKratakOpis.setColumns(20);
        taKratakOpis.setRows(5);
        jScrollPane2.setViewportView(taKratakOpis);

        jLabel11.setText("Pocetni grad:");

        cbPocetniGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pUsputniGradovi.setBorder(javax.swing.BorderFactory.createTitledBorder("Usputni gradovi"));
        pUsputniGradovi.setForeground(java.awt.SystemColor.controlDkShadow);

        tUsputniGradovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tUsputniGradovi);

        btnDodajUsputni.setText("dodaj");

        btnObrisiUsputni.setText("obrisi");

        javax.swing.GroupLayout pUsputniGradoviLayout = new javax.swing.GroupLayout(pUsputniGradovi);
        pUsputniGradovi.setLayout(pUsputniGradoviLayout);
        pUsputniGradoviLayout.setHorizontalGroup(
                pUsputniGradoviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pUsputniGradoviLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pUsputniGradoviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDodajUsputni, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(btnObrisiUsputni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pUsputniGradoviLayout.setVerticalGroup(
                pUsputniGradoviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pUsputniGradoviLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(pUsputniGradoviLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btnDodajUsputni)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisiUsputni)
                                .addContainerGap(119, Short.MAX_VALUE))
        );

        jLabel12.setText("Krajnji grad:");

        cbKrajnjiGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pPutovanjeLayout = new javax.swing.GroupLayout(pPutovanje);
        pPutovanje.setLayout(pPutovanjeLayout);
        pPutovanjeLayout.setHorizontalGroup(
                pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(cbPrevoz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(cbSmestaj, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(cbPonuda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(38, 38, 38)
                                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbPocetniGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbKrajnjiGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(pUsputniGradovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(lblId)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtId)
                                                .addGap(568, 568, 568)))
                                .addGap(19, 19, 19))
        );
        pPutovanjeLayout.setVerticalGroup(
                pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pPutovanjeLayout.createSequentialGroup()
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblId)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(cbPocetniGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pUsputniGradovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(cbKrajnjiGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pPutovanjeLayout.createSequentialGroup()
                                                        .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel3)
                                                                .addComponent(cbPrevoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(40, 40, 40)
                                                        .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5)
                                                                .addComponent(cbSmestaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(40, 40, 40)
                                                        .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel7)
                                                                .addComponent(cbPonuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(40, 40, 40)
                                                        .addGroup(pPutovanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel9)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pRezervacije.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rezervacije putovanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        pRezervacije.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));

        tRezervacije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tRezervacije);

        javax.swing.GroupLayout pRezervacijeLayout = new javax.swing.GroupLayout(pRezervacije);
        pRezervacije.setLayout(pRezervacijeLayout);
        pRezervacijeLayout.setHorizontalGroup(
                pRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pRezervacijeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5)
                                .addContainerGap())
        );
        pRezervacijeLayout.setVerticalGroup(
                pRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pRezervacijeLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addContainerGap())
        );

        btnIzmena.setText("Omoguci izmenu");

        btnSacuvaj.setText("Sacuvaj");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pPretragaPutovanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pPutovanje, javax.swing.GroupLayout.PREFERRED_SIZE, 828, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnIzmena, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(pTermini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pRezervacije, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pPretragaPutovanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pTermini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(pRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnIzmena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(pPutovanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JButton btnDodajTermin;
    private javax.swing.JButton btnDodajUsputni;
    private javax.swing.JButton btnIzmena;
    private javax.swing.JButton btnObrisiTermin;
    private javax.swing.JButton btnObrisiUsputni;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUcitajPutovanja;
    private javax.swing.JComboBox<String> cbKrajnjiGrad;
    private javax.swing.JComboBox<String> cbPocetniGrad;
    private javax.swing.JComboBox<String> cbPonuda;
    private javax.swing.JComboBox<String> cbPrevoz;
    private javax.swing.JComboBox<String> cbSmestaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKrajnjaDestinacija;
    private javax.swing.JPanel pPretragaPutovanja;
    private javax.swing.JPanel pPutovanje;
    private javax.swing.JPanel pRezervacije;
    private javax.swing.JPanel pTermini;
    private javax.swing.JPanel pUsputniGradovi;
    private javax.swing.JTable tRezervacije;
    private javax.swing.JTable tTermini;
    private javax.swing.JTable tUsputniGradovi;
    private javax.swing.JTextArea taKratakOpis;
    private javax.swing.JTable tbPretragaPutovanja;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPretragaPutovanja;
    // End of variables declaration

    public javax.swing.JButton getBtnDodajTermin() {
        return btnDodajTermin;
    }

    public void setBtnDodajTermin(javax.swing.JButton btnDodajTermin) {
        this.btnDodajTermin = btnDodajTermin;
    }

    public javax.swing.JButton getBtnDodajUsputni() {
        return btnDodajUsputni;
    }

    public void setBtnDodajUsputni(javax.swing.JButton btnDodajUsputni) {
        this.btnDodajUsputni = btnDodajUsputni;
    }

    public javax.swing.JButton getBtnObrisiTermin() {
        return btnObrisiTermin;
    }

    public void setBtnObrisiTermin(javax.swing.JButton btnObrisiTermin) {
        this.btnObrisiTermin = btnObrisiTermin;
    }

    public javax.swing.JButton getBtnObrisiUsputni() {
        return btnObrisiUsputni;
    }

    public void setBtnObrisiUsputni(javax.swing.JButton btnObrisiUsputni) {
        this.btnObrisiUsputni = btnObrisiUsputni;
    }

    public javax.swing.JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public void setBtnSacuvaj(javax.swing.JButton btnSacuvaj) {
        this.btnSacuvaj = btnSacuvaj;
    }

    public javax.swing.JComboBox<String> getCbKrajnjiGrad() {
        return cbKrajnjiGrad;
    }

    public void setCbKrajnjiGrad(javax.swing.JComboBox<String> cbKrajnjiGrad) {
        this.cbKrajnjiGrad = cbKrajnjiGrad;
    }

    public javax.swing.JComboBox<String> getCbPocetniGrad() {
        return cbPocetniGrad;
    }

    public void setCbPocetniGrad(javax.swing.JComboBox<String> cbPocetniGrad) {
        this.cbPocetniGrad = cbPocetniGrad;
    }

    public javax.swing.JComboBox<String> getCbPrevoz() {
        return cbPrevoz;
    }

    public void setCbPrevoz(javax.swing.JComboBox<String> cbPrevoz) {
        this.cbPrevoz = cbPrevoz;
    }

    public javax.swing.JComboBox<String> getCbSmestaj() {
        return cbSmestaj;
    }

    public void setCbSmestaj(javax.swing.JComboBox<String> cbSmestaj) {
        this.cbSmestaj = cbSmestaj;
    }

    public javax.swing.JComboBox<String> getCbPonuda() {
        return cbPonuda;
    }

    public void setCbPonuda(javax.swing.JComboBox<String> jComboBox3) {
        this.cbPonuda = jComboBox3;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public javax.swing.JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(javax.swing.JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public javax.swing.JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(javax.swing.JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public javax.swing.JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(javax.swing.JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public javax.swing.JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(javax.swing.JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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

    public javax.swing.JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(javax.swing.JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public javax.swing.JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(javax.swing.JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public javax.swing.JLabel getLblId() {
        return lblId;
    }

    public void setLblId(javax.swing.JLabel lblId) {
        this.lblId = lblId;
    }

    public javax.swing.JLabel getLblKrajnjaDestinacija() {
        return lblKrajnjaDestinacija;
    }

    public void setLblKrajnjaDestinacija(javax.swing.JLabel lblKrajnjaDestinacija) {
        this.lblKrajnjaDestinacija = lblKrajnjaDestinacija;
    }

    public javax.swing.JPanel getpPretragaPutovanja() {
        return pPretragaPutovanja;
    }

    public void setpPretragaPutovanja(javax.swing.JPanel pPretragaPutovanja) {
        this.pPretragaPutovanja = pPretragaPutovanja;
    }

    public javax.swing.JPanel getpPutovanje() {
        return pPutovanje;
    }

    public void setpPutovanje(javax.swing.JPanel pPutovanje) {
        this.pPutovanje = pPutovanje;
    }

    public javax.swing.JPanel getpRezervacije() {
        return pRezervacije;
    }

    public void setpRezervacije(javax.swing.JPanel pRezervacije) {
        this.pRezervacije = pRezervacije;
    }

    public javax.swing.JPanel getpTermini() {
        return pTermini;
    }

    public void setpTermini(javax.swing.JPanel pTermini) {
        this.pTermini = pTermini;
    }

    public javax.swing.JPanel getpUsputniGradovi() {
        return pUsputniGradovi;
    }

    public void setpUsputniGradovi(javax.swing.JPanel pUsputniGradovi) {
        this.pUsputniGradovi = pUsputniGradovi;
    }

    public javax.swing.JTable gettRezervacije() {
        return tRezervacije;
    }

    public void settRezervacije(javax.swing.JTable tRezervacije) {
        this.tRezervacije = tRezervacije;
    }

    public javax.swing.JTable gettTermini() {
        return tTermini;
    }

    public void settTermini(javax.swing.JTable tTermini) {
        this.tTermini = tTermini;
    }

    public javax.swing.JTable gettUsputniGradovi() {
        return tUsputniGradovi;
    }

    public void settUsputniGradovi(javax.swing.JTable tUsputniGradovi) {
        this.tUsputniGradovi = tUsputniGradovi;
    }

    public javax.swing.JTextArea getTaKratakOpis() {
        return taKratakOpis;
    }

    public void setTaKratakOpis(javax.swing.JTextArea taKratakOpis) {
        this.taKratakOpis = taKratakOpis;
    }

    public javax.swing.JTable getTbPretragaPutovanja() {
        return tbPretragaPutovanja;
    }

    public void setTbPretragaPutovanja(javax.swing.JTable tbPretragaPutovanja) {
        this.tbPretragaPutovanja = tbPretragaPutovanja;
    }

    public javax.swing.JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(javax.swing.JTextField txtId) {
        this.txtId = txtId;
    }

    public javax.swing.JTextField getTxtNaziv() {
        return txtNaziv;
    }

    public void setTxtNaziv(javax.swing.JTextField txtNaziv) {
        this.txtNaziv = txtNaziv;
    }

    public javax.swing.JTextField getTxtPretragaPutovanja() {
        return txtPretragaPutovanja;
    }

    public void setTxtPretragaPutovanja(javax.swing.JTextField txtPretragaPutovanja) {
        this.txtPretragaPutovanja = txtPretragaPutovanja;
    }

    public javax.swing.JButton getBtnIzmena() {
        return btnIzmena;
    }

    public void setBtnIzmena(javax.swing.JButton btnIzmena) {
        this.btnIzmena = btnIzmena;
    }

    public javax.swing.JButton getBtnUcitajPutovanja() {
        return btnUcitajPutovanja;
    }

    public void setBtnUcitajPutovanja(javax.swing.JButton btnUcitajPutovanja) {
        this.btnUcitajPutovanja = btnUcitajPutovanja;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

}