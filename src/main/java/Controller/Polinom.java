package Controller;

import java.util.ArrayList;
import java.util.List;

public class Polinom {
    private String valoarePolinom;
    private List<Monom> monoame = new ArrayList<Monom>();
    public Polinom(){
        valoarePolinom = "0";
    };

    public Polinom(String valoare){
        valoarePolinom = valoare;

    }
    public void setPolinom(String valoare){
        valoarePolinom = valoare;
    }

    public void setMonoame(List<Monom> monoame) {
        this.monoame = monoame;
    }
    public void monomAdd(Monom m){
        monoame.add(m);
    }
    public List<Monom> getMonoame() {
        return monoame;
    }
    public void curata(){
        monoame.clear();
    }

    public String getValoarePolinom() {
        return valoarePolinom;
    }
}
