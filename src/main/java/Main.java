import Controller.*;
import View.*;
import Model.*;

public class Main {
    public static void main(String[] args) {
        PolinomView v = new PolinomView();
        PolinomModel m = new PolinomModel();
        PolinomController control = new PolinomController(v, m);

        v.setVisible(true);
    }
}
