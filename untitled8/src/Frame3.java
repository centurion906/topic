import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame3 extends JFrame {
    Frame2 frm5;
    public Frame3(Frame2 frm6){
        frm5 = frm6;
        ex();
    }private void ex(){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm5.setVisible(true);
            }
        });
    }
}