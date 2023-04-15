import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(-300, 0, 1800, 320);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which number logically follows this series 4, 6, 9, 6, 14, 6,? ";
        questions[0][1] = "1";
        questions[0][2] = "2";
        questions[0][3] = "3";
        questions[0][4] = "4";

        questions[1][0] = "Number of milli-seconds in 1 Hour";
        questions[1][1] = "3600";
        questions[1][2] = "36";
        questions[1][3] = "LPU";
        questions[1][4] = "None of these";

        questions[2][0] = "There are 5 machines that make 5 parts in 5 minutes. How long does it take to make 100 parts on 100 machines?";
        questions[2][1] = "5";
        questions[2][2] = "10";
        questions[2][3] = "15";
        questions[2][4] = "30";

        questions[3][0] = "MUSIC: COMPOSE   DEVICE:?";
        questions[3][1] = "use";
        questions[3][2] = "Create";
        questions[3][3] = "Construct";
        questions[3][4] = "Invent";

        questions[4][0] = "Mary is 16 years old. She is 4 times older than her brother. How old will Mary be when she is twice his age?";
        questions[4][1] = "Impossible";
        questions[4][2] = "20";
        questions[4][3] = "30";
        questions[4][4] = "24";

        questions[5][0] = "Which fraction is the biggest?";
        questions[5][1] = "3/5";
        questions[5][2] = "5/8";
        questions[5][3] = "1/2";
        questions[5][4] = "4/7";

        questions[6][0] = "The store reduces the price of one product by 20 percent. How many percent do you need to raise to the percentage to get the original price?";
        questions[6][1] = "25";
        questions[6][2] = "27";
        questions[6][3] = "30";
        questions[6][4] = "35";

        questions[7][0] = "The store reduces the price of one product by 20 percent. How many percent do you need to raise to the percentage to get the original price?";
        questions[7][1] = "25";
        questions[7][2] = "27";
        questions[7][3] = "30";
        questions[7][4] = "35";

        questions[8][0] = "The store reduces the price of one product by 20 percent. How many percent do you need to raise to the percentage to get the original price?";
        questions[8][1] = "25";
        questions[8][2] = "27";
        questions[8][3] = "30";
        questions[8][4] = "35";

        questions[9][0] = "The store reduces the price of one product by 20 percent. How many percent do you need to raise to the percentage to get the original price?";
        questions[9][1] = "25";
        questions[9][2] = "27";
        questions[9][3] = "30";
        questions[9][4] = "35";

        answers[0][1] = "JDB";
        answers[1][1] = "None of these";
        answers[2][1] = "5";
        answers[3][1] = "Invent";
        answers[4][1] = "24";
        answers[5][1] = "5/8";
        answers[6][1] = "25";
        answers[7][1] = "25";
        answers[8][1] = "25";
        answers[9][1] = "25";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}