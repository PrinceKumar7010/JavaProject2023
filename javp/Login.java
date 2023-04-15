import javax.swing.*;//FOR IMPORTING JFRAME
import java.awt.*;//FOR BACKGROUND COLOUR
import java.awt.event.*;
import java.io.FileWriter;

public class Login extends JFrame implements ActionListener {
    // FOR CREATING A FRAME WE NEED JFRAME
    JButton rules, back;
    JTextField tfname, trname, tpname, tename, tppname;

    Login() {

        getContentPane().setBackground(new Color(158, 231, 245));
        setLayout(null);

        JLabel heading = new JLabel(" IQ TEST FOR LPU STUDENTS ");
        heading.setBounds(480, 60, 800, 45);

        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(35, 110, 150));
        add(heading);

        JLabel name = new JLabel("YOUR NAME : ");
        name.setBounds(400, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(239, 62, 91));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(800, 150, 300, 20);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        JLabel no = new JLabel("REGISTRATION NO : ");
        no.setBounds(400, 200, 300, 20);
        no.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        no.setForeground(new Color(239, 62, 91));
        add(no);

        JPasswordField trname = new JPasswordField("Regd No", 20);
        trname.setBounds(800, 200, 300, 20);
        trname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(trname);

        JLabel sec = new JLabel("YOUR SECTION : ");
        sec.setBounds(400, 250, 300, 20);
        sec.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        sec.setForeground(new Color(239, 62, 91));
        add(sec);

        tpname = new JTextField();
        tpname.setBounds(800, 250, 300, 20);
        tpname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tpname);

        JLabel mail = new JLabel("EMAIL : ");
        mail.setBounds(400, 300, 300, 20);
        mail.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        mail.setForeground(new Color(239, 62, 91));
        add(mail);
        tename = new JTextField();
        tename.setBounds(800, 300, 300, 20);
        tename.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tename);

        JLabel ph = new JLabel("YOUR PHONE NO  : ");
        ph.setBounds(400, 350, 300, 20);
        ph.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        ph.setForeground(new Color(239, 62, 91));
        add(ph);

        tppname = new JTextField();
        tppname.setBounds(800, 350, 300, 20);
        tppname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tppname);

        rules = new JButton("Rules");
        rules.setBounds(400, 400, 150, 25);
        rules.setBackground(new Color(0, 144, 0));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileWriter fw = new FileWriter("login.txt", true);
                    fw.write(tfname.getText() + "\t" + trname.getText() + tpname.getText() + "\t" + tename.getText()
                            + "\t" + tppname.getText() + "\t" + "\n");
                    fw.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Saved Sucessfully ");
                    dispose();
                } catch (Exception e) {
                }
            }
        });

        back = new JButton("Exit");
        back.setBounds(850, 400, 150, 25);
        back.setBackground(new Color(200, 0, 0));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(700, 500);
        setLocation(200, 150);
        setVisible(true);// BY DEFAULT VISIBILITY IS HIDDEN
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();// FOR JUST FIRING
    }
}