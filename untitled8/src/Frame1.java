import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame {
    Container cp;
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JPanel jpnC = new JPanel(new GridLayout(2,2,2,2));
    private JPanel jpnS = new JPanel(new GridLayout(1,2,2,2));
    private JPanel jpnN = new JPanel(new GridLayout(1,1,2,2));
    private JLabel jlb = new JLabel("ID");
    private JLabel BG = new JLabel();
    private JLabel jlb2 = new JLabel("PassWord");
    private JTextField jft = new JTextField();
    private JPasswordField jpw = new JPasswordField();
    private JButton jbtn2 = new JButton("Login");
    private JButton jbtn3 = new JButton("Exit");
    private ImageIcon icon = new ImageIcon("bgg.jpg");
    private int screenW = screen.width;
    private int screenH = screen.height;
    private int frmW = 400, frmH = 400;
    public Frame1(){
        ex();
    }private void ex(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100,100,400,600);
        cp = this.getContentPane();
        this.setBounds(screenW/2 - frmW/2,screenH/2 - frmH/2 , frmW, frmH);
        BG.setIcon(icon);
        Image img1 = icon.getImage();
        Image img2 = img1.getScaledInstance(400,240,50);
        icon.setImage(img2);
        cp.add(jpnN,BorderLayout.NORTH);
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnS,BorderLayout.SOUTH);
        jpnN.add(BG);
        jpnC.add(jlb);
        jpnC.add(jft);
        jpnC.add(jlb2);
        jpnC.add(jpw);
        jpnS.add(jbtn2);
        jpnS.add(jbtn3);
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jft.getText().equals("1")&&(new String(jpw.getPassword()).equals("1"))){
                    Frame2 frm2 = new Frame2(Frame1.this);
                    frm2.setVisible(true);
                    Frame1.this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}