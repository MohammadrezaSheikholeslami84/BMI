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
        page1.setSize(700, 900);
        page1.setBackground(Color.WHITE);
        page1.setLayout(null);

        // Page 2:
        JPanel page2 = new JPanel();
        page2.setSize(700, 900);
        page2.setBackground(Color.gray);
        page2.setLayout(null);
        page2.setVisible(false);

        // Page 3:
        JPanel page3 = new JPanel();
        page3.setSize(700, 900);

        page3.setBackground(Color.gray);
        page3.setLayout(null);
        page3.setVisible(false);

        // InfoText in page 1 :
        JLabel InfoText = new JLabel();
        InfoText.setBounds(200, 20, 150, 100);
        InfoText.setForeground(Color.black);
        InfoText.setText("BMI Calculator");
        InfoText.setFont(new Font("Arial",Font.BOLD,20));

        // Button Start in page 1 :
        JButton StartButton = new JButton("Start ");
        StartButton.setBounds(360, 40, 100, 50);
        StartButton.setFont(new Font("Arial", Font.BOLD, 12));
        StartButton.setFocusable(false);
        StartButton.setForeground(Color.WHITE);
        StartButton.setBackground(new Color(43, 34, 186));
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(700, 900);
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);
            }
        });

        // Information Label in page 1 :
        JLabel information = new JLabel();
        information.setBounds(150, 550, 500, 100);
        information.setForeground(Color.black);
        information.setText("This App Calculate Body Mass Index");
        information.setFont(new Font("Arial",Font.BOLD,20));

        // BMI Label in page 2 :
        JLabel BMILabel = new JLabel();
        BMILabel.setBounds(20, 250, 150, 20);
        BMILabel.setText("BMI : ");
        BMILabel.setForeground(new Color(86, 5, 15));
        BMILabel.setFont(new Font("Arial", Font.BOLD, 20));

        // BMI Number in page 2 :
        JLabel BMI_number = new JLabel();
        BMI_number.setBounds(100, 250, 150, 20);
        BMI_number.setForeground(Color.WHITE);
        BMI_number.setFont(new Font("Arial", Font.BOLD, 20));

        // Category Label in page 2 :
        JLabel CategoryLabel = new JLabel();
        CategoryLabel.setBounds(20, 280, 200, 80);
        CategoryLabel.setText("Category : ");
        CategoryLabel.setForeground(new Color(86, 5, 15));
        CategoryLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Category Number in page 2 :
        JLabel Category_number = new JLabel();
        Category_number.setBounds(150, 280, 200, 80);
        Category_number.setForeground(Color.WHITE);
        Category_number.setFont(new Font("Arial", Font.BOLD, 20));

        // Height label in page 2 :
        JLabel Height_label = new JLabel();
        Height_label.setBounds(20, 20, 200, 80);
        Height_label.setForeground(Color.black);
        Height_label.setText("Enter Height (cm) : ");
        Height_label.setFont(new Font("Arial", Font.BOLD, 15));

        // Weight label in page 2 :
        JLabel Weight_label = new JLabel();
        Weight_label.setBounds(20, 70, 200, 80);
        Weight_label.setForeground(Color.black);
        Weight_label.setText("Enter Weight (Kg) : ");
        Weight_label.setFont(new Font("Arial", Font.BOLD, 15));

        // Height textfield in page 2 :
        JTextField Height_text_field = new JTextField();
        Height_text_field.setBounds(170, 45, 150, 30);

        // Weight textfield in page 2 :
        JTextField Weight_text_field = new JTextField();
        Weight_text_field.setBounds(170, 95, 150, 30);

        // Button Calculate in page 2 :
        JButton calculate = new JButton("Calculate !");
        calculate.setBounds(100, 150, 100, 50);
        calculate.setFont(new Font("Arial", Font.BOLD, 12));
        calculate.setFocusable(false);
        calculate.setBackground(Color.cyan);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String height_str = Height_text_field.getText();
                String weight_str = Weight_text_field.getText();
                float height = Float.valueOf(height_str);
                float weight = Float.valueOf(weight_str);
                float answer = 0;
                if (e.getSource() == calculate) {
                    height /= 100;
                    answer = (float) (weight / Math.pow(height, 2));
                    answer = Float.parseFloat(decfor.format(answer));
                }
                String result = String.valueOf(answer);

                BMI_number.setText(result);

                if (answer < 18.5)  {
                    Category_number.setText("Under Weight");
                    Category_number.setForeground(new Color(6, 119, 159));
                }

                else if (answer >= 18.5 && answer <= 24.9) {
                    Category_number.setText("Normal Weight");
                    Category_number.setForeground(new Color(6, 180, 121));
                }
                else if (answer >= 25 && answer <= 29.9) {

                    Category_number.setText("Over Weight");
                    Category_number.setForeground(new Color(255, 206, 96));
                }
                else if (answer >= 30 && answer <= 34.9) {
                    Category_number.setText("Class 1");
                    Category_number.setForeground(new Color(236, 165, 17));
                }
                else if (answer >= 35 && answer <= 39.9) {
                    Category_number.setText("Class 2");
                    Category_number.setForeground(new Color(232, 121, 6));
                }
                else {
                    Category_number.setText("Class 3");
                    Category_number.setForeground(new Color(208, 5, 90));
                }
            }
        });

        // Back Button in page 2 :
        JButton back1 = new JButton("Back");
        back1.setBounds(200, 150, 100, 50);
        back1.setFont(new Font("Arial", Font.BOLD, 12));
        back1.setFocusable(false);
        back1.setBackground(new Color(51, 131, 156));
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(700, 900);
                page1.setVisible(true);
                page2.setVisible(false);
                page3.setVisible(false);

            }
        });

        //  Next Page Button in page 2 :
        Button nextpage = new Button("Next Page");
        nextpage.setBounds(300, 150, 100, 50);
        nextpage.setFont(new Font("Arial", Font.BOLD, 12));
        nextpage.setFocusable(false);
        nextpage.setBackground(new Color(51, 131, 156));
        nextpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(700, 900);
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(true);

            }
        });


        // Age label in page 3 :
        JLabel AgeLabel = new JLabel();
        AgeLabel.setBounds(20, 20, 200, 80);
        AgeLabel.setForeground(Color.black);
        AgeLabel.setText("Enter Age : ");
        AgeLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Age text field in page 3 :
        JTextField Age_text_field = new JTextField();
        Age_text_field.setBounds(120, 45, 150, 30);

        // Gender Label in page 3 :
        JLabel Gender_label = new JLabel();
        Gender_label.setBounds(20, 100, 200, 80);
        Gender_label.setForeground(Color.black);
        Gender_label.setText("Enter Gender :");
        Gender_label.setFont(new Font("Arial", Font.BOLD, 15));

        // Gender Radio Button in page 3 :
        JRadioButton male = new JRadioButton("A) Male");
        male.setBounds(150, 100, 100, 30);
        male.setFocusable(false);

        JRadioButton female = new JRadioButton("B) Female");
        female.setFocusable(false);
        female.setBounds(150, 150, 100, 30);

        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(male);
        buttongroup.add(female);

        // Fat Percent Label in page 3 :
        JLabel Fat_percent_label = new JLabel();
        Fat_percent_label.setBounds(20, 350, 150, 20);
        Fat_percent_label.setText("Fat Percent : ");
        Fat_percent_label.setForeground(new Color(86, 5, 15));
        Fat_percent_label.setFont(new Font("Arial", Font.BOLD, 20));

        // Fat Percent Number in page 3 :
        JLabel Fat_percent_number = new JLabel();
        Fat_percent_number.setBounds(150, 350, 150, 20);
        Fat_percent_number.setForeground(Color.white);
        Fat_percent_number.setFont(new Font("Arial", Font.BOLD, 20));

        // Button Calculate in page 3 :
        JButton calculate2 = new JButton("Calculate !");
        calculate2.setBounds(100, 250, 100, 50);
        calculate2.setFont(new Font("Arial", Font.BOLD, 12));
        calculate2.setFocusable(false);
        calculate2.setBackground(Color.cyan);
        calculate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String agestr = Age_text_field.getText();
                String bmistr = BMI_number.getText();
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

                Fat_percent_number.setText(result);

            }
        });

        // Back Button in page 3 :
        JButton back2 = new JButton("Back");
        back2.setBounds(200, 250, 100, 50);
        back2.setFont(new Font("Arial", Font.BOLD, 12));
        back2.setBackground(new Color(51, 131, 156));
        back2.setFocusable(false);
        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setSize(700, 900);
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);

            }
        });

//        JLabel new_label = new JLabel(" BYE");
//        new_label.setBounds(100, 100, 100, 100);
//        new_label.setFont(new Font("Arial",Font.BOLD,16));
//        new_label.setForeground(Color.white);

        ImageIcon imagebmi = new ImageIcon("bmi.jpg");
        JLabel BackGroundimagebmi  = new JLabel("", imagebmi, JLabel.CENTER);
        BackGroundimagebmi.setBounds(20, 20, 700, 500);

        page1.add(InfoText);
        page1.add(StartButton);
        page1.add(information);
        page1.add(BackGroundimagebmi);
//        page1.add(jfield);
        //  page1.add(jbutton);


        ImageIcon categoryimage = new ImageIcon("bmi.jpeg");
        JLabel BackGroundcategoryimage  = new JLabel("", categoryimage, JLabel.CENTER);
        BackGroundcategoryimage.setBounds(0, 0, 675, 1100);

        page2.add(Height_label);
        page2.add(Height_text_field);
        page2.add(Weight_label);
        page2.add(Weight_text_field);

        page2.add(BMILabel);
        page2.add(BMI_number);
        page2.add(CategoryLabel);
        page2.add(Category_number);
        page2.add(calculate);
        page2.add(back1);
        page2.add(nextpage);
        page2.add(BackGroundcategoryimage);

        page3.add(male);
        page3.add(female);
        page3.add(back2);
        page3.add(calculate2);
        page3.add(Age_text_field);
        page3.add(AgeLabel);
        page3.add(Fat_percent_number);
        page3.add(Fat_percent_label);
        page3.add(Gender_label);
//        page3.add(new_label);

        f.add(page1);
        f.add(page2);
        f.add(page3);

        f.setSize(700, 900);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
