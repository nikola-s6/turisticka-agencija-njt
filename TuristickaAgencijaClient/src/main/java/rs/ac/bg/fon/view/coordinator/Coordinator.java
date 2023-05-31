package rs.ac.bg.fon.view.coordinator;

import rs.ac.bg.fon.view.controller.LoginController;
import rs.ac.bg.fon.view.controller.MainController;
import rs.ac.bg.fon.view.form.FrmLogin;
import rs.ac.bg.fon.view.form.FrmMain;

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
}
