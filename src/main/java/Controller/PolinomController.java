package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolinomController {
    private PolinomView theView;
    private PolinomModel theModel;

    public PolinomController(PolinomView theView, PolinomModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        this.theView.plusLisener(new CalculatePlusLisener());

        this.theView.minusLisener(new CalculateMinusLisener());

        this.theView.resetLisener(new CreateResetLisener());

        this.theView.derivareLisener(new CalculateDerivataLisener());

        //    this.theModel.setMonoms1(this.theModel.descompunerePolinom(this.theModel.getP1()));
        //    this.theModel.setMonoms2(this.theModel.descompunerePolinom(this.theModel.getP2()));
    }
    class CalculatePlusLisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom firsPolinom = new Polinom(theView.getFirstPolinom());
            Polinom secondPolinom = new Polinom(theView.getSecondPolinom());
            firsPolinom.setMonoame(theModel.descompunerePolinom(firsPolinom));
            secondPolinom.setMonoame(theModel.descompunerePolinom(secondPolinom));
            theModel.adunareImplementare(firsPolinom, secondPolinom);
            Polinom rez = new Polinom();
            rez = theModel.construirePolinim(theModel.getRezultat());
            theView.setSolutie(rez.getValoarePolinom());
        }
    }

    class CalculateMinusLisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom firsPolinom = new Polinom(theView.getFirstPolinom());
            Polinom secondPolinom = new Polinom(theView.getSecondPolinom());
            firsPolinom.setMonoame(theModel.descompunerePolinom(firsPolinom));
            secondPolinom.setMonoame(theModel.descompunerePolinom(secondPolinom));
            secondPolinom.setMonoame(theModel.schimbareSemn(secondPolinom.getMonoame()));//schimb semnele coeficentiilor monoamelor celui de al doilea polinom
            //dupa ce am schimbat semnele operatiile sunt la fel ca la adunare
            //theModel.adunareImplementare(theModel.descompunerePolinom(firsPolinom), theModel.schimbareSemn(theModel.descompunerePolinom(secondPolinom)));
            theModel.adunareImplementare(firsPolinom, secondPolinom);
            Polinom rez = new Polinom();
            rez = theModel.construirePolinim(theModel.getRezultat());
            theView.setSolutie(rez.getValoarePolinom());
        }
    }

    class CreateResetLisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.reset();
            theModel.resetRezultat();

        }
    }
    class CalculateDerivataLisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom firsPolinom = new Polinom(theView.getFirstPolinom());
            firsPolinom.setMonoame(theModel.descompunerePolinom(firsPolinom));

            Polinom rez = new Polinom();
            rez = theModel.derivare(firsPolinom);
            rez = theModel.construirePolinim(rez.getMonoame());
            System.out.println(rez.getValoarePolinom());
            theView.setSolutie(rez.getValoarePolinom());
            System.out.println(1);
        }
    }

}
