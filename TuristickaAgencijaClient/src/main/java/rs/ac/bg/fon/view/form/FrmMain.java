package rs.ac.bg.fon.view.form;

public class FrmMain extends javax.swing.JFrame {

    public FrmMain() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblPutnik = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        mMeni = new javax.swing.JMenuBar();
        mmPutnik = new javax.swing.JMenu();
        miKreiranjePutnika = new javax.swing.JMenuItem();
        miPretrazivanjePutnika = new javax.swing.JMenuItem();
        mmPutovanje = new javax.swing.JMenu();
        miKreiranjePutovanja = new javax.swing.JMenuItem();
        miPretrazivanjePutovanja = new javax.swing.JMenuItem();
        mmRezervacija = new javax.swing.JMenu();
        miKreiranjeRezervacije = new javax.swing.JMenuItem();
        miPretrazivanjeRezervacije = new javax.swing.JMenuItem();
        mmProfil = new javax.swing.JMenu();
        miPodaci = new javax.swing.JMenuItem();
        miLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPutnik.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPutnik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPutnik.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dobrodosli");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Turisticka agencija");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plane.jpg"))); // NOI18N
        image.setText("jLabel1");

        mmPutnik.setText("Putnik");

        miKreiranjePutnika.setText("Kreiranje");
        mmPutnik.add(miKreiranjePutnika);

        miPretrazivanjePutnika.setText("Pretrazivanje");
        mmPutnik.add(miPretrazivanjePutnika);

        mMeni.add(mmPutnik);

        mmPutovanje.setText("Putovanje");

        miKreiranjePutovanja.setText("Kreiranje");
        mmPutovanje.add(miKreiranjePutovanja);

        miPretrazivanjePutovanja.setText("Pretrazivanje");
        mmPutovanje.add(miPretrazivanjePutovanja);

        mMeni.add(mmPutovanje);

        mmRezervacija.setText("Rezervacija");

        miKreiranjeRezervacije.setText("Kreiranje");
        mmRezervacija.add(miKreiranjeRezervacije);

        miPretrazivanjeRezervacije.setText("Pretrazivanje");
        mmRezervacija.add(miPretrazivanjeRezervacije);

        mMeni.add(mmRezervacija);

        mmProfil.setText("Profil");

        miPodaci.setText("Podaci");
        mmProfil.add(miPodaci);

        miLogout.setText("Logout");
        mmProfil.add(miLogout);

        mMeni.add(mmProfil);

        setJMenuBar(mMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPutnik)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblPutnik;
    private javax.swing.JMenuBar mMeni;
    private javax.swing.JMenuItem miKreiranjePutnika;
    private javax.swing.JMenuItem miKreiranjePutovanja;
    private javax.swing.JMenuItem miKreiranjeRezervacije;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miPodaci;
    private javax.swing.JMenuItem miPretrazivanjePutnika;
    private javax.swing.JMenuItem miPretrazivanjePutovanja;
    private javax.swing.JMenuItem miPretrazivanjeRezervacije;
    private javax.swing.JMenu mmProfil;
    private javax.swing.JMenu mmPutnik;
    private javax.swing.JMenu mmPutovanje;
    private javax.swing.JMenu mmRezervacija;
    // End of variables declaration

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

    public javax.swing.JMenuItem getMiKreiranjePutovanja() {
        return miKreiranjePutovanja;
    }

    public void setMiKreiranjePutovanja(javax.swing.JMenuItem miKreiranjePutovanja) {
        this.miKreiranjePutovanja = miKreiranjePutovanja;
    }

    public javax.swing.JLabel getLblPutnik() {
        return lblPutnik;
    }

    public void setLblPutnik(javax.swing.JLabel lblPutnik) {
        this.lblPutnik = lblPutnik;
    }

    public javax.swing.JMenuBar getmMeni() {
        return mMeni;
    }

    public void setmMeni(javax.swing.JMenuBar mMeni) {
        this.mMeni = mMeni;
    }

    public javax.swing.JMenuItem getMiKreiranjePutnika() {
        return miKreiranjePutnika;
    }

    public void setMiKreiranjePutnika(javax.swing.JMenuItem miKreiranjePutnika) {
        this.miKreiranjePutnika = miKreiranjePutnika;
    }

    public javax.swing.JMenuItem getMiPretrazivanjePutovanja() {
        return miPretrazivanjePutovanja;
    }

    public void setMiPretrazivanjePutovanja(javax.swing.JMenuItem miPretrazivanjePutovanja) {
        this.miPretrazivanjePutovanja = miPretrazivanjePutovanja;
    }

    public javax.swing.JMenuItem getMiKreiranjeRezervacije() {
        return miKreiranjeRezervacije;
    }

    public void setMiKreiranjeRezervacije(javax.swing.JMenuItem miKreiranjeRezervacije) {
        this.miKreiranjeRezervacije = miKreiranjeRezervacije;
    }

    public javax.swing.JMenuItem getMiPretrazivanjePutnika() {
        return miPretrazivanjePutnika;
    }

    public void setMiPretrazivanjePutnika(javax.swing.JMenuItem miPretrazivanjePutnika) {
        this.miPretrazivanjePutnika = miPretrazivanjePutnika;
    }

    public javax.swing.JMenuItem getMiPretrazivanjeRezervacije() {
        return miPretrazivanjeRezervacije;
    }

    public void setMiPretrazivanjeRezervacije(javax.swing.JMenuItem miPretrazivanjeRezervacije) {
        this.miPretrazivanjeRezervacije = miPretrazivanjeRezervacije;
    }

    public javax.swing.JMenu getMmPutnik() {
        return mmPutnik;
    }

    public void setMmPutnik(javax.swing.JMenu mmPutnik) {
        this.mmPutnik = mmPutnik;
    }

    public javax.swing.JMenu getMmPutovanje() {
        return mmPutovanje;
    }

    public void setMmPutovanje(javax.swing.JMenu mmPutovanje) {
        this.mmPutovanje = mmPutovanje;
    }

    public javax.swing.JMenu getMmRezervacija() {
        return mmRezervacija;
    }

    public void setMmRezervacija(javax.swing.JMenu mmRezervacija) {
        this.mmRezervacija = mmRezervacija;
    }

    public javax.swing.JMenuItem getMiPodaci() {
        return miPodaci;
    }

    public void setMiPodaci(javax.swing.JMenuItem jMenuItem2) {
        this.miPodaci = jMenuItem2;
    }

    public javax.swing.JMenuItem getMiLogout() {
        return miLogout;
    }

    public void setMiLogout(javax.swing.JMenuItem miLogout) {
        this.miLogout = miLogout;
    }

    public javax.swing.JMenu getMmProfil() {
        return mmProfil;
    }

    public void setMmProfil(javax.swing.JMenu mmProfil) {
        this.mmProfil = mmProfil;
    }

    public javax.swing.JLabel getImage() {
        return image;
    }

    public void setImage(javax.swing.JLabel image) {
        this.image = image;
    }
}
