package Controller;

public class Monom {

    private int coeficent;
    private int putere;

    public Monom(){};
    public Monom(int coeficent, int putere){
        this.putere = putere;
        this.coeficent = coeficent;
    }

    public int getCoeficent() {
        return coeficent;
    }

    public int getPutere() {
        return putere;
    }

    public void setCoeficent(int coeficent) {
        this.coeficent = coeficent;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }
}
