import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class BMI {
    public static void main(String[] args) {
        final DecimalFormat decfor = new DecimalFormat("0.0"); // Formating

        JFrame f = new JFrame("BMI Calculator"); // Frame

        // Page 1:
        JPanel page1 = new JPanel();
        page1.setBounds(0, 0, 300, 300);
        page1.setBackground(Color.WHITE);
        page1.setLayout(null);

        // Page 2:
        JPanel page2 = new JPanel();
        page2.setBounds(0, 0, 500, 500);
        page2.setBackground(Color.gray);
        page2.setLayout(null);
        page2.setVisible(false);

        // Page 3:
        JPanel page3 = new JPanel();
        page3.setBounds(0, 0, 500, 500);
        page3.setBackground(Color.gray);
        page3.setLayout(null);
        page3.setVisible(false);

        // InfoText in page 1 :
        JLabel LabelText = new JLabel();
        LabelText.setBounds(20, 20, 100, 50);
        LabelText.setForeground(Color.black);
        LabelText.setText("BMI Calculator");

        // Button Start in page 1 :
        JButton buttonpanel1 = new JButton("Start ");
        buttonpanel1.setBounds(130, 20, 100, 50);
        buttonpanel1.setFont(new Font("Arial", Font.BOLD, 12));
        buttonpanel1.setForeground(Color.WHITE);
        buttonpanel1.setBackground(new Color(43, 34, 186));
        buttonpanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(500, 500);
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);
            }
        });

        // Information Label in page 1 :
        JLabel information = new JLabel();
        information.setBounds(20, 80, 500, 100);
        information.setForeground(Color.black);
        information.setText("This App Calculate Body Mass Index");

        // BMI Label in page 2 :
        JLabel bmilabel = new JLabel();
        bmilabel.setBounds(20, 250, 150, 20);
        bmilabel.setText("BMI : ");
        bmilabel.setForeground(new Color(166, 8, 26));
        bmilabel.setFont(new Font("Arial", Font.BOLD, 20));

        // BMI Number in page 2 :
        JLabel bminumber = new JLabel();
        bminumber.setBounds(100, 250, 150, 20);
        bminumber.setForeground(Color.WHITE);
        bminumber.setFont(new Font("Arial", Font.BOLD, 20));

        // Category Label in page 2 :
        JLabel categorylabel = new JLabel();
        categorylabel.setBounds(20, 280, 200, 80);
        categorylabel.setText("Category : ");
        categorylabel.setForeground(new Color(166, 8, 26));
        categorylabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Category Number in page 2 :
        JLabel categorynumber = new JLabel();
        categorynumber.setBounds(150, 280, 200, 80);
        categorynumber.setForeground(Color.WHITE);
        categorynumber.setFont(new Font("Arial", Font.BOLD, 20));

        // Age label in page 3 :
        JLabel agelabel = new JLabel();
        agelabel.setBounds(20, 20, 200, 80);
        agelabel.setForeground(Color.black);
        agelabel.setText("Enter Age : ");
        agelabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Age textfireld in page 3 :
        JTextField agetextfield = new JTextField();
        agetextfield.setBounds(120, 45, 150, 30);

        // Gender Label in page 3 :
        JLabel genderlabel = new JLabel();
        genderlabel.setBounds(20, 100, 200, 80);
        genderlabel.setForeground(Color.black);
        genderlabel.setText("Enter Gender :");
        genderlabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Gender Radio Button in page 3 :
        JRadioButton male = new JRadioButton("A) Male");
        JRadioButton female = new JRadioButton("B) Female");
        male.setBounds(150, 100, 100, 30);
        female.setBounds(150, 150, 100, 30);

        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(male);
        buttongroup.add(female);

        // FatIndex Label in page 3 :
        JLabel FatIndexLabel = new JLabel();
        FatIndexLabel.setBounds(20, 350, 150, 20);
        FatIndexLabel.setText("Fat Percent : ");
        FatIndexLabel.setForeground(new Color(166, 8, 26));
        FatIndexLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // FatIndex Number in page 3 :
        JLabel FatIndexnumber = new JLabel();
        FatIndexnumber.setBounds(150, 350, 150, 20);
        FatIndexnumber.setForeground(Color.white);
        FatIndexnumber.setFont(new Font("Arial", Font.BOLD, 20));

        // Button Calculate in page 3 :
        JButton calculate2 = new JButton("Calculate !");
        calculate2.setBounds(100, 250, 100, 50);
        calculate2.setFont(new Font("Arial", Font.BOLD, 12));
        calculate2.setBackground(Color.cyan);
        calculate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String agestr = agetextfield.getText();
                String bmistr = bminumber.getText();
                float age = Float.valueOf(agestr);
                float bmi = Float.valueOf(bmistr);
                float ans = 0;
                if (male.isSelected()) {
                    float agenew = (float) ((0.23 * age) - 16.2);
                    ans = (float) ((1.2 * bmi) + agenew);
                    ans = Float.parseFloat(decfor.format(ans));
                }
                if (female.isSelected()) {
                    float agenew = (float) ((0.23 * age) - 5.4);
                    ans = (float) ((1.2 * bmi) + agenew);
                    ans = Float.parseFloat(decfor.format(ans));
                }
                String result = String.valueOf(ans);

                FatIndexnumber.setText(result);

            }
        });

        // Hight label in page 2 :
        JLabel labelhight = new JLabel();
        labelhight.setBounds(20, 20, 200, 80);
        labelhight.setForeground(Color.black);
        labelhight.setText("Enter Height(cm) : ");
        labelhight.setFont(new Font("Arial", Font.BOLD, 15));

        // Weight label in page 2 :
        JLabel labelweight = new JLabel();
        labelweight.setBounds(20, 70, 200, 80);
        labelweight.setForeground(Color.black);
        labelweight.setText("Enter Weight(Kg) : ");
        labelweight.setFont(new Font("Arial", Font.BOLD, 15));

        // Hight textfield in page 2 :
        JTextField hightfield = new JTextField();
        hightfield.setBounds(170, 45, 150, 30);

        // Weight textfield in page 2 :
        JTextField weightfield = new JTextField();
        weightfield.setBounds(170, 95, 150, 30);

        // Button Calculate in page 2 :
        JButton calculate = new JButton("Calculate !");
        calculate.setBounds(100, 150, 100, 50);
        calculate.setFont(new Font("Arial", Font.BOLD, 12));
        calculate.setBackground(Color.cyan);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = hightfield.getText();
                String s2 = weightfield.getText();
                float a = Float.valueOf(s1);
                float b = Float.valueOf(s2);
                float c = 0;
                if (e.getSource() == calculate) {
                    a /= 100;
                    c = (float) (b / Math.pow(a, 2));
                    c = Float.parseFloat(decfor.format(c));
                }
                String result = String.valueOf(c);

                bminumber.setText(result);

                if (c < 16)
                    categorynumber.setText("Severe thinness");
                else if (c >= 16 && c <= 16.9)
                    categorynumber.setText("Moderate thinness");
                else if (c >= 17 && c <= 18.4)
                    categorynumber.setText("Mild thinness");
                else if (c >= 18.5 && c <= 24.9)
                    categorynumber.setText("Normal Range");
                else if (c >= 25 && c <= 29.9)
                    categorynumber.setText("Over Weight");
                else if (c >= 30 && c <= 34.9)
                    categorynumber.setText("Class 1");
                else if (c >= 35 && c <= 39.9)
                    categorynumber.setText("Class 2");
                else if (c >= 40)
                    categorynumber.setText("Class 3");
            }
        });

        // Button Next Page in page 2 :
        JButton back1 = new JButton("Back");
        back1.setBounds(200, 150, 100, 50);
        back1.setFont(new Font("Arial", Font.BOLD, 12));
        back1.setBackground(new Color(51, 131, 156));
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(300, 300);
                page1.setVisible(true);
                page2.setVisible(false);
                page3.setVisible(false);

            }
        });

        // Button Next Page in page 2 :
        Button nextpage = new Button("Next Page");
        nextpage.setBounds(300, 150, 100, 50);
        nextpage.setFont(new Font("Arial", Font.BOLD, 12));
        nextpage.setBackground(new Color(51, 131, 156));
        nextpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(500, 500);
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(true);

            }
        });

        // Button Back in page 3 :
        JButton back2 = new JButton("Back");
        back2.setBounds(200, 250, 100, 50);
        back2.setFont(new Font("Arial", Font.BOLD, 12));
        back2.setBackground(new Color(51, 131, 156));
        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(500, 500);
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);

            }
        });

        page1.add(LabelText);
        page1.add(buttonpanel1);
        page1.add(information);

        page2.add(labelhight);
        page2.add(hightfield);
        page2.add(labelweight);
        page2.add(weightfield);

        page2.add(bmilabel);
        page2.add(bminumber);
        page2.add(categorylabel);
        page2.add(categorynumber);
        page2.add(calculate);
        page2.add(back1);
        page2.add(nextpage);

        page3.add(male);
        page3.add(female);
        page3.add(back2);
        page3.add(calculate2);
        page3.add(agetextfield);
        page3.add(agelabel);
        page3.add(FatIndexnumber);
        page3.add(FatIndexLabel);
        page3.add(genderlabel);

        f.add(page1);
        f.add(page2);
        f.add(page3);

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
