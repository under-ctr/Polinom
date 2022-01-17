package View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;



public class PolinomView extends JFrame{

    private  JTextField firstPolinom = new JTextField(20);
    private  JTextField secondPolinom = new JTextField(20);
    private JTextField solutie = new JTextField(20);
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton derivare = new JButton("Derivare");
    private JButton integrare = new JButton("Integrare");
    private JButton reset = new JButton("reset");


  public  PolinomView(){
        JPanel polinomPanel = new JPanel();
        polinomPanel.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);




        secondPolinom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        secondPolinom.setBounds(29, 107, 183, 30);
        polinomPanel.add(secondPolinom);

        plus.setFont(new Font("Tahoma", Font.PLAIN, 13));
        plus.setBounds(222, 45, 85, 41);
        polinomPanel.add(plus);

        firstPolinom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstPolinom.setBounds(29, 56, 183, 30);
        polinomPanel.add(firstPolinom);


        minus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        minus.setBounds(317, 45, 85, 41);
        polinomPanel.add(minus);

        derivare.setFont(new Font("Tahoma", Font.PLAIN, 13));
        derivare.setBounds(222, 96, 85, 41);
        polinomPanel.add(derivare);

        reset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        reset.setBounds(317, 191, 85, 34);
        polinomPanel.add(reset);

        integrare.setFont(new Font("Tahoma", Font.PLAIN, 13));
        integrare.setBounds(317, 96, 85, 41);
        polinomPanel.add(integrare);

        solutie.setFont(new Font("Tahoma", Font.PLAIN, 14));
        solutie.setBounds(103, 196, 204, 26);
        polinomPanel.add(solutie);

        JLabel lblNewLabel = new JLabel("Introduceti Polinoamele");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(10, 20, 150, 26);
        polinomPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Rezultat:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(29, 195, 64, 26);
        polinomPanel.add(lblNewLabel_1);

        solutie.setEditable(false);

        this.add(polinomPanel);

    }


    public String getFirstPolinom(){
        return firstPolinom.getText();
    }

    public String getSecondPolinom(){
        return secondPolinom.getText();
    }

    public void setSolutie(String sol){
        solutie.setText(sol);

    }
    public void reset(){
        solutie.setText("");
    }

    public void plusLisener(ActionListener plusEvent){
        plus.addActionListener(plusEvent);
    }
    public void minusLisener(ActionListener minusEvent){
        minus.addActionListener(minusEvent);
    }
    public void resetLisener(ActionListener resetEvent){reset.addActionListener(resetEvent);}
    public void derivareLisener(ActionListener derivareEvent){derivare.addActionListener(derivareEvent);}

}
