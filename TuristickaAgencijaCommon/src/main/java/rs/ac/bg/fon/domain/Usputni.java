package rs.ac.bg.fon.domain;

import java.io.Serializable;


public class Usputni implements Serializable {
    private Grad grad;
    private Putovanje putovanje;
    private int redniBroj;

    public Usputni() {
    }

    public Usputni(Grad grad, Putovanje putovanje, int redniBroj) {
        this.grad = grad;
        this.putovanje = putovanje;
        this.redniBroj = redniBroj;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public Putovanje getPutovanje() {
        return putovanje;
    }

    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }
}