package rs.ac.bg.fon.view.coordinator;

import rs.ac.bg.fon.view.controller.*;
import rs.ac.bg.fon.view.form.*;
import rs.ac.bg.fon.view.form.util.FormMode;

public class Coordinator {
    private static Coordinator instance;
    private final MainController mainController;

    private Coordinator() {
        this.mainController = new MainController(new FrmMain());
    }

    public static Coordinator getInstance() {
        if (instance == null) {
            instance = new Coordinator();
        }
        return instance;
    }

    public void openMainForm() {
        mainController.openFonm();
    }

    public void openLoginForm() {
        instance = new Coordinator();
        LoginController loginController = new LoginController(new FrmLogin());
        loginController.openForm();
    }

    public void openKreiranjePutnika() {
        PrikazPutnikaController ppc = new PrikazPutnikaController(new FrmPrikazPutnika(mainController.getFrmMain(), true));
        ppc.openForm(FormMode.FORM_ADD);
    }

    public void openPretrazivanjePutnika() {
        PretragaPutnikaController ppc = new PretragaPutnikaController(new FrmPretragaPutnika(mainController.getFrmMain(), true));
        ppc.openForm();
    }

    public void openPrikazPutnika() {
        PrikazPutnikaController pp = new PrikazPutnikaController(new FrmPrikazPutnika(mainController.getFrmMain(), true));
        pp.openForm(FormMode.FORM_SEARCH);
    }

    public void openKreiranjePutovanja(){
        KreiranjePutovanjaController kp = new KreiranjePutovanjaController(new FrmKreiranjePutovanja(mainController.getFrmMain(), true));
        kp.openForm();
    }

    public void openPretrazivanjePutovanja(){
        PutovanjeController pk = new PutovanjeController(new FrmPutovanje(mainController.getFrmMain(), true));
        pk.openForm();
    }

    public void openRezervisanje(){
        RezervacijeController rc = new RezervacijeController(new FrmRezervacije(mainController.getFrmMain(), true));
        rc.openForm(FormMode.FORM_ADD);
    }
}
