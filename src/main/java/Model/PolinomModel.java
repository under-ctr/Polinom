package Model;

import Controller.*;
import View.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PolinomModel {

    private Polinom p1 = new Polinom();
    private Polinom p2 = new Polinom();
    private List<Monom> monoms1 =  new ArrayList<Monom>();
    private List<Monom> monoms2 =  new ArrayList<Monom>();
    //private List<Monom> rezultat = new ArrayList<Monom>();
    private Polinom rezultat = new Polinom();

    public Polinom getP1() {
        return p1;
    }

    public Polinom getP2() {
        return p2;
    }

    public List<Monom> getMonoms1() {
        return monoms1;
    }

    public List<Monom> getMonoms2() {
        return monoms2;
    }

    public void setP1(Polinom p1) {
        this.p1 = p1;
    }

    public void setP2(Polinom p2) {
        this.p2 = p2;
    }

    public List<Monom> getRezultat() {
        return rezultat.getMonoame();
    }

    public void setMonoms1(List<Monom> monoms1) {
        this.monoms1 = monoms1;
    }

    public void setMonoms2(List<Monom> monoms2) {
        this.monoms2 = monoms2;
    }
    public void resetRezultat(){
        rezultat.curata();
    }

    public List<Monom> descompunerePolinom(Polinom p) {
        List<Monom> monoame = new ArrayList<Monom>();
        Pattern p1 = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher mach = p1.matcher( p.getValoarePolinom());

        while (mach.find()) {
            String match = mach.group(1);
            match = match.replace(" ", "");
            if (match.matches(".*\\^.*")) {
                String[] a = match.split("\\^");
                String[] b = a[0].split("x");
                Monom m = new Monom(Integer.parseInt(b[0]) ,  Integer.parseInt(a[1]));
               // monoame.add(m);
                p.monomAdd(m);
            }
            else{                                                                               //2x^2+2x+2
                if (match.indexOf('x') == 1) {
                    //System.out.println(match.indexOf('x'));
                    match = match.replace("+", "1");
                    match = match.replace("-", "-1");
                    String[] a = match.split("x");


                    Monom m = new Monom(Integer.parseInt(a[0]) , 1);
                    //monoame.add(m);
                    p.monomAdd(m);
                }
                else if(match.indexOf('x') > 1 ){
                    String[] a = match.split("x");

                    Monom m = new Monom(Integer.parseInt(a[0]) , 1);
                    p.monomAdd(m);
                    //monoame.add(m);
                }
                else{

                    String a = mach.group();
                    Monom m = new Monom(Integer.parseInt(a) , 0);
                    //monoame.add(m);
                    p.monomAdd(m);
                }
            }
        }
        return p.getMonoame();
    }

    public void adunareImplementare( Polinom pol1 , Polinom pol2){
        int i1 = 0;
        int i2 = 0;

        while(i1 < pol1.getMonoame().size() && i2 < pol2.getMonoame().size()){

            if(pol1.getMonoame().get(i1).getPutere() > pol2.getMonoame().get(i2).getPutere()){
                //primul are puterea mai mare
                rezultat.getMonoame().add(pol1.getMonoame().get(i1));
                i1++;
            }
            else if(pol1.getMonoame().get(i1).getPutere() < pol2.getMonoame().get(i2).getPutere()){
                rezultat.getMonoame().add(pol2.getMonoame().get(i2));
                i2++;
            }
            else{

                Monom a = new Monom(pol1.getMonoame().get(i1).getCoeficent() + pol2.getMonoame().get(i2).getCoeficent() , pol1.getMonoame().get(i1).getPutere());
//                    System.out.println("coef1: "+ mon1.get(i1).getCoeficent() + " coef2 :" + mon2.get(i2).getCoeficent());
//                    System.out.println("puterea1 :" + mon1.get(i1).getPutere());
                rezultat.getMonoame().add(a);
                i1++;
                i2++;
            }
        }
        while(i1 <pol1.getMonoame().size()){
            rezultat.getMonoame().add(pol1.getMonoame().get(i1));
            i1++;
        }

        while(i2 < pol2.getMonoame().size()){
            rezultat.getMonoame().add(pol2.getMonoame().get(i2));
            i2++;
        }

    }

    public Polinom derivare (Polinom p1 ){
        Polinom rez = new Polinom();
        for(Monom m : p1.getMonoame()) {
            int c = m.getCoeficent();
            int p = m.getPutere();

            if (p > 0) {
                m.setCoeficent(p * c);
                m.setPutere(p - 1);
                rez.monomAdd(m);
            }

        }
        p1.setMonoame(rez.getMonoame());
        return p1;
    }


    public List<Monom> schimbareSemn(List<Monom> monom){
        for(Monom m: monom){
            m.setCoeficent(m.getCoeficent() * (-1));
        }
        return monom;
    }

    public Polinom construirePolinim(List<Monom> mon){

        String rezultat = "";
        for(Monom m: mon){
            rezultat += "+" + m.getCoeficent() + "x^" + m.getPutere();
        }
        rezultat = rezultat.replace("+-", "-");
        rezultat = rezultat.replace("++", "+");
        rezultat = rezultat.replace("--", "-");
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }


}