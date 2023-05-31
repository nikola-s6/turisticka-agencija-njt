package rs.ac.bg.fon.view.controller;

import rs.ac.bg.fon.communication.Communication;
import rs.ac.bg.fon.data.GlobalniPodaci;
import rs.ac.bg.fon.data.type.TipoviPodataka;
import rs.ac.bg.fon.domain.Putnik;
import rs.ac.bg.fon.view.coordinator.Coordinator;
import rs.ac.bg.fon.view.form.FrmMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final FrmMain form;

    public MainController(FrmMain frmMain) {
        this.form = frmMain;
        addActionListener();
    }

    public void openFonm() {
        Putnik putnik = (Putnik) GlobalniPodaci.getInstance().get(TipoviPodataka.ULOGOVANI_KORISNIK);
        if (!(Boolean) GlobalniPodaci.getInstance().get(TipoviPodataka.ADMIN_ACCESS)) {
            hideElements();
            form.getLblPutnik().setText(putnik.getIme() + " " + putnik.getPrezime());
        } else {
            form.getLblPutnik().setText(putnik.getIme());
            hideElementsAdmin();
        }
        form.setVisible(true);
    }

    private void addActionListener() {
        form.getMiKreiranjePutnika().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coordinator.getInstance().openKreiranjePutnika();
            }
        });

        form.getMiPretrazivanjePutnika().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coordinator.getInstance().openPretrazivanjePutnika();
            }
        });

        form.getMiPodaci().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coordinator.getInstance().openPrikazPutnika();
            }
        });

        form.getMiLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GlobalniPodaci.getInstance().reset();
                try {
                    Communication.getInstance().logout();
                    Coordinator.getInstance().openLoginForm();
                    form.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(form, "Neuspesna odjava sa sistema", "Greska odjave", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

//        form.getMiKreiranjePutovanja().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Coordinator.getInstance().openKreiranjePutovanja();
//            }
//        });
//
//        form.getMiPretrazivanjePutovanja().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Coordinator.getInstance().openPretrazivanjePutovanja();
//            }
//        });
//
//        form.getMiKreiranjeRezervacije().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Coordinator.getInstance().openRezervisanje();
//            }
//        });
//
//        form.getMiPretrazivanjeRezervacije().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Coordinator.getInstance().openPretragaRezervacija();
//            }
//        });
    }

    private void hideElements() {
        form.getMmPutnik().setVisible(false);
        form.getMiKreiranjePutovanja().setVisible(false);
        form.getMiKreiranjeRezervacije().setVisible(false);
    }

    private void hideElementsAdmin() {
        form.getMiPodaci().setVisible(false);
    }

    public FrmMain getFrmMain() {
        return form;
    }

}
