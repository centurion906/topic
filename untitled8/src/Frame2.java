import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame2 extends JFrame {
    Container cp;
    private JLabel jlb = new JLabel();
    private JLabel jlblank = new JLabel();
    private JLabel jlbP1HP = new JLabel("剩餘生命");
    private JLabel jlbP2HP = new JLabel("剩餘生命");
    private JLabel jlbP1NumberHP = new JLabel("100");
    private JLabel jlbP2NumberHP = new JLabel("100");
    private Timer t1;
    private Timer t2;
    private Timer a1;
    private Timer a2;

    private JPanel jpnN = new JPanel(new GridLayout(1,5,3,3));
    private JPanel jpnC = new JPanel();
    private Timer t3;
    private Timer t4;
    private Timer a3;
    private Timer a4;
    ImageIcon icon = new ImageIcon("bg.JPG");
    ImageIcon iconP11right = new ImageIcon("P1nl.png");
    ImageIcon iconP11left = new ImageIcon("P1nr.png");
    private String moveright [] = {"r1.png","r2.png","r3.png","r4.png","r5.png"};
    ImageIcon iconmoveright [] = new ImageIcon[5];
    private String moveleft [] = {"l1.png","l2.png","l3.png","l4.png","l5.png"};
    ImageIcon iconmoveleft [] = new ImageIcon[5];
    private String attright [] = {"11.png","22.png","33.png","44.png","55.png","66.png","77.png"};
    ImageIcon iconattright [] = new ImageIcon[7];
    private String attleft [] = {"1.png","2.png","3.png","4.png","5.png","6.png","7.png"};
    ImageIcon iconattleft [] = new ImageIcon[7];
    private int dirflog;                                        //攻擊判斷
    public int P1x = 100 , P1y = 300, P2x = 700, P2y = 300 , flagP1, flagP2;
    private int attcheck,m ,a = 0 , c , count = 1;

    private JLabel P1 = new JLabel();
    private JLabel P2 = new JLabel();
    private P1 player1 = new P1(100,300);
    private P2 player2 = new P2(700,300);
    Frame1 frm2;
    public Frame2(Frame1 frm3){
        frm2 = frm3;
        ex();
    }private void ex(){
        cp = this.getContentPane();
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,100,960,630);
        this.add(jlb);

        jpnC.add(player1);
        jpnC.add(player2);

        Thread p1Thread = new Thread(player1);
        Thread p2Thread = new Thread(player2);

        p1Thread.start();
        p2Thread.start();



        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm2.setVisible(true);
            }
        });

        cp.add(jpnN,BorderLayout.NORTH);
        jpnN.add(jlbP1HP);
        jpnN.add(jlbP1NumberHP);
        jpnN.add(jlblank);
        jpnN.add(jlbP2HP);
        jpnN.add(jlbP2NumberHP);

        jlb.setIcon(icon);                                                      //BG
        Image img1 = icon.getImage();
        Image img2 = img1.getScaledInstance(960,600,50);
        icon.setImage(img2);
        jlb.setOpaque(false);
        jlb.setBounds(0,30,960,600);
        jlb.setIcon(icon);


        cp.add(jpnC,BorderLayout.CENTER);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
//---------------------------P1--------------------------------
                    case KeyEvent.VK_W:               //W
                        flagP1 = 1;
                        break;
                    case KeyEvent.VK_S:                //S
                        flagP1 = 2;
                        break;
                    case KeyEvent.VK_A:                //A
                        flagP1 = 3;
                        break;
                    case KeyEvent.VK_D:                //D
                        flagP1 = 4;
                        break;
                    case KeyEvent.VK_SHIFT:                //Shift   P1攻擊
                        flagP1 = 5;
                        break;
                    case KeyEvent.VK_UP :                         //UP
                        flagP2 = 1;
                        break;
                    case KeyEvent.VK_DOWN :                     //DOWN
                        flagP2 = 2;
                        break;
                    case KeyEvent.VK_LEFT :                       //LEFT
                        flagP2 = 3;
                        break;
                    case KeyEvent.VK_RIGHT :                     //RIGHT
                        flagP2 = 4;
                        break;
                    case KeyEvent.VK_CONTROL :                  //CONTROL P2攻擊
                        flagP2 = 5;
                        break;
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_A:
                        flagP1 = 6;
                        break;
                    case KeyEvent.VK_D:
                        flagP1 = 7;
                        break;
                    case KeyEvent.VK_LEFT :
                        flagP2 = 6;
                        break;
                    case KeyEvent.VK_RIGHT :
                        flagP2 = 7;
                        break;
                }
            }
        });

//    private void check(){
//
//        int P2HP = Integer.parseInt(jlbP2NumberHP.getText());
//        int P1HP = Integer.parseInt(jlbP1NumberHP.getText());
//
//        if (P1HP != 0 || P2HP != 0){
//            if (P1x >= P2x+-50 &&P1y >= P2y+-50 &&dirflog == 1){
//                P2HP = P2HP - 5;
//                String P2hp = Integer.toString(P2HP);
//                jlbP2NumberHP.setText(P2hp);
//            }else if(P2x >= P1x+-50 &&P2y >= P1y+-50&&dirflog == 2){
//                P1HP = P1HP - 5;
//                String P1hp = Integer.toString(P1HP);
//                jlbP1NumberHP.setText(P1hp);
//            }
//            dirflog = 0;
//        }else {
//            Frame3 frm4 = new Frame3(Frame2.this);
//            frm4.setVisible(true);
//        }
//    }
    }
    class P1 extends JLabel implements Runnable{
        private Timer t1;
        private Timer t2;
        private Timer a1;
        private Timer a2;

        ImageIcon iconP11right = new ImageIcon("P1nl.png");
        ImageIcon iconP11left = new ImageIcon("P1nr.png");
        private String moveright [] = {"r1.png","r2.png","r3.png","r4.png","r5.png"};
        ImageIcon iconmoveright [] = new ImageIcon[5];
        private String moveleft [] = {"l1.png","l2.png","l3.png","l4.png","l5.png"};
        ImageIcon iconmoveleft [] = new ImageIcon[5];
        private String attright [] = {"11.png","22.png","33.png","44.png","55.png","66.png","77.png"};
        ImageIcon iconattright [] = new ImageIcon[7];
        private String attleft [] = {"1.png","2.png","3.png","4.png","5.png","6.png","7.png"};
        ImageIcon iconattleft [] = new ImageIcon[7];
        private int m ,a = 0 , count = 1;

        public P1(int P1x , int P1y){

            P1.this.setIcon(iconP11right);                                                   //P1 right normal
            Image imgp11 = iconP11right.getImage();
            Image imgp13 = imgp11.getScaledInstance(100,200,50);
            iconP11right.setImage(imgp13);

            P1.this.setIcon(iconP11left);                                                   //P1 left normal
            Image imgp15 = iconP11left.getImage();
            Image imgp17 = imgp15.getScaledInstance(100,200,50);
            iconP11left.setImage(imgp17);

            for (int i = 0;i<5;i++){
                iconmoveright [i] = new ImageIcon(moveright[i]);
                Image img = iconmoveright [i].getImage();
                Image newimg = img.getScaledInstance(100,200,Image.SCALE_SMOOTH);
                iconmoveright[i] = new ImageIcon(newimg);
            }

            for (int i = 0;i<5;i++){
                iconmoveleft [i] = new ImageIcon(moveleft[i]);
                Image img = iconmoveleft [i].getImage();
                Image newimg = img.getScaledInstance(100,200,Image.SCALE_SMOOTH);
                iconmoveleft[i] = new ImageIcon(newimg);
            }

            for (int i = 0;i<7;i++){
                iconattright [i] = new ImageIcon(attright[i]);
                Image img = iconattright [i].getImage();
                Image newimg = img.getScaledInstance(100,200,Image.SCALE_SMOOTH);
                iconattright[i] = new ImageIcon(newimg);
            }

            for (int i = 0;i<7;i++){
                iconattleft [i] = new ImageIcon(attleft[i]);
                Image img = iconattleft [i].getImage();
                Image newimg = img.getScaledInstance(100,200,Image.SCALE_SMOOTH);
                iconattleft[i] = new ImageIcon(newimg);

                this.setLocation(800,100);
                P1.this.setIcon(iconP11right);

            }
        }
        @Override
        public void run() {



            t1 = new Timer(100, new ActionListener() {          //P1向右移動動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    m++;
                    P1.this.setIcon(iconmoveright[m%5]);
                }
            });

            t2 = new Timer(100, new ActionListener() {          //P1向左移動動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    m++;
                    P1.this.setIcon(iconmoveleft[m%5]);
                }
            });

            a1 = new Timer(100, new ActionListener() {          //P1向左攻擊動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count<7){
                        a++;
                        P1.this.setIcon(iconattleft[a%8]);
                    }
                    count++;
                }
            });

            a2 = new Timer(100, new ActionListener() {          //P1向右攻擊動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count<7){
                        a++;
                        P1.this.setIcon(iconattright[a%8]);
                    }
                    count++;
                }
            });
            while (true){
                switch (flagP1){
                    case 1 :                                //W
                        if (P1y - 4 > 50) {
                            P1y -= 4;
                        }
                        P1.this.setLocation(P1x,P1y);
                        count = 0;
                        a1.stop();
                        a2.stop();
                        break;
                    case 2 :                               //S
                        if (P1y + 4 < 300) {
                            P1y += 4;
                        }
                        P1.this.setLocation(P1x,P1y);
                        count = 0;
                        a1.stop();
                        a2.stop();
                        break;
                    case 3 :                            //A
                        t2.start();
                        attcheck = 1;
                        c = 1;
                        if (P1x - 4 > 0) {
                            P1x -= 4;
                        }
                        P1.this.setLocation(P1x,P1y);
                        count = 0;
                        a1.stop();
                        a2.stop();
                        break;
                    case 4 :                            //D
                        t1.start();
                        attcheck = 2;
                        c = 2;
                        if (P1x + 4 < 860) {
                            P1x += 4;
                        }
                        P1.this.setLocation(P1x,P1y);
                        count = 0;
                        a1.stop();
                        a2.stop();
                        break;
                    case 5 :                        //Shift P1 攻擊
                        if (attcheck == 1){
                            a1.start();
                        }else if (attcheck == 2){
                            a2.start();
                        }
                        dirflog = 1;
//                        check();
                        break;
                    case 6 :
                        t2.stop();
                        if (c==1){
                            P1.this.setIcon(iconP11left);
                        }
                        break;
                    case 7 :
                        t1.stop();
                        if (c==2){
                            P1.this.setIcon(iconP11right);
                        }
                        break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class P2 extends JLabel implements Runnable {
        private Timer t3;
        private Timer t4;
        private Timer a3;
        private Timer a4;
        ImageIcon iconP11right = new ImageIcon("P1nl.png");
        ImageIcon iconP11left = new ImageIcon("P1nr.png");
        private String moveright[] = {"r1.png", "r2.png", "r3.png", "r4.png", "r5.png"};
        ImageIcon iconmoveright[] = new ImageIcon[5];
        private String moveleft[] = {"l1.png", "l2.png", "l3.png", "l4.png", "l5.png"};
        ImageIcon iconmoveleft[] = new ImageIcon[5];
        private String attright[] = {"11.png", "22.png", "33.png", "44.png", "55.png", "66.png", "77.png"};
        ImageIcon iconattright[] = new ImageIcon[7];
        private String attleft[] = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png"};
        ImageIcon iconattleft[] = new ImageIcon[7];
        private int attcheck, m, a = 0, c, count = 1;

        public P2(int P2x , int P2y) {
            P2.setIcon(iconP11right);                                                   //P1 right normal
            Image imgp11 = iconP11right.getImage();
            Image imgp13 = imgp11.getScaledInstance(100, 200, 50);
            iconP11right.setImage(imgp13);

            P2.setIcon(iconP11left);                                                   //P1 left normal
            Image imgp15 = iconP11left.getImage();
            Image imgp17 = imgp15.getScaledInstance(100, 200, 50);
            iconP11left.setImage(imgp17);

            for (int i = 0; i < 5; i++) {
                iconmoveright[i] = new ImageIcon(moveright[i]);
                Image img = iconmoveright[i].getImage();
                Image newimg = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
                iconmoveright[i] = new ImageIcon(newimg);
            }

            for (int i = 0; i < 5; i++) {
                iconmoveleft[i] = new ImageIcon(moveleft[i]);
                Image img = iconmoveleft[i].getImage();
                Image newimg = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
                iconmoveleft[i] = new ImageIcon(newimg);
            }

            for (int i = 0; i < 7; i++) {
                iconattright[i] = new ImageIcon(attright[i]);
                Image img = iconattright[i].getImage();
                Image newimg = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
                iconattright[i] = new ImageIcon(newimg);
            }

            for (int i = 0; i < 7; i++) {
                iconattleft[i] = new ImageIcon(attleft[i]);
                Image img = iconattleft[i].getImage();
                Image newimg = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
                iconattleft[i] = new ImageIcon(newimg);
            }

            this.setLocation(100, 100);
            P2.this.setIcon(iconP11left);
        }

        @Override
        public void run() {
            t3 = new Timer(100, new ActionListener() {          //P2向右移動動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    m++;
                    P2.this.setIcon(iconmoveright[m % 5]);
                }
            });

            t4 = new Timer(100, new ActionListener() {          //P2向左移動動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    m++;
                    P2.this.setIcon(iconmoveleft[m % 5]);
                }
            });

            a3 = new Timer(100, new ActionListener() {          //P2向左攻擊動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count < 7) {
                        a++;
                        P2.this.setIcon(iconattleft[a % 8]);
                    }
                    count++;
                }
            });

            a4 = new Timer(100, new ActionListener() {          //P2向右攻擊動畫
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count < 7) {
                        a++;
                        P2.this.setIcon(iconattright[a % 8]);
                    }
                    count++;
                }
            });
            while (true){
                switch (flagP2){
                    case 1 :                                //UP
                        if (P2y - 4 > 50) {
                            P2y -= 4;
                        }
                        P2.this.setLocation(P2x,P2y);
                        count = 0;
                        a3.stop();
                        a4.stop();
                        break;
                    case 2 :                               //DOWN
                        if (P2y + 4 < 300) {
                            P2y += 4;
                        }
                        P2.this.setLocation(P2x,P2y);
                        count = 0;
                        a3.stop();
                        a4.stop();
                        break;
                    case 3 :                            //LEFT
                        t4.start();
                        attcheck = 1;
                        c = 1;
                        if (P2x - 4 > 0) {
                            P2x -= 4;
                        }
                        P2.this.setLocation(P2x,P2y);
                        count = 0;
                        a3.stop();
                        a4.stop();
                        break;
                    case 4 :                            //RIGHT
                        t3.start();
                        attcheck = 2;
                        c = 2;
                        if (P2x + 4 < 860) {
                            P2x += 4;
                        }
                        P2.this.setLocation(P2x,P2y);
                        count = 0;
                        a3.stop();
                        a4.stop();
                        break;
                    case 5 :                        //CONTROL P2 攻擊
                        if (attcheck == 1){
                            a3.start();
                        }else if (attcheck == 2){
                            a4.start();
                        }
                        dirflog = 2;
//                        check();
                        break;
                    case 6 :
                        t4.stop();
                        if (c==1){
                            P2.this.setIcon(iconP11left);
                        }
                        break;
                    case 7 :
                        t3.stop();
                        if (c==2){
                            P2.this.setIcon(iconP11right);
                        }
                        break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}