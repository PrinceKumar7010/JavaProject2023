import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(new Color(0, 160, 198));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);
        int p = score * 25;
        if (p == 0) {
            JLabel heading = new JLabel(
                    "Thankyou " + name + " for giving IQ Test " + "Are you Trying To Fool The Computer ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 25) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 8-10 "
                    + "feeble-mindedness or low IQ ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 50) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 10-15 "
                    + " Extremely poor  intelligence. ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 75) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 50-65 "
                    + "At Par intelligence. ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 100) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 22-30 "
                    + "Average IQ ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 125) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 30-35 "
                    + "Above Average IQ ");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        if (p == 150) {
            JLabel heading = new JLabel("Thankyou " + name + " for giving IQ Test " + "Your Mental Age : 35+ "
                    + "Man ! Your At Einstein Level");
            heading.setBounds(45, 30, 1200, 30);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(heading);
        }
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(17, 20, 92));
        submit.setForeground(new Color(255, 255, 0));
        submit.addActionListener(this);
        add(submit);

        setVisible(true);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileWriter fw = new FileWriter("login.txt", true);
                    fw.write(score + "\t");
                    fw.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Saved Sucessfully ");
                    dispose();
                } catch (Exception e) {
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}