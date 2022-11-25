import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Play extends JFrame implements ActionListener {
    Home h1 = new Home();
    PlayState s1 = new PlayState();
    GameOver gover = new GameOver();

    public Play() {
        this.setSize(800, 600);
        this.add(h1);
        h1.BExit1.addActionListener(this);
        h1.BStart.addActionListener(this);
        s1.Bre.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == h1.BStart) {

            this.setLocationRelativeTo(null);
            this.remove(h1);
            this.setSize(800, 600);
            this.add(s1);
            s1.requestFocusInWindow();
            s1.timet = false;
            s1.sc = 0;
            s1.Times = 100;
            s1.fall = false;
            s1.timet = false;
        } else if (e.getSource() == h1.BExit1) {
            System.exit(0);
        } else if (e.getSource() == s1.Bre) {
            dispose();
            JFrame A = new Play();
            A.setSize(800, 600);
            A.setTitle("Meow's Fruits");
            A.setDefaultCloseOperation(EXIT_ON_CLOSE);
            A.setVisible(true);
            A.setLocationRelativeTo(null);
        }
        this.validate();
        this.repaint();
    }

    public static void main(String[] args) {

        JFrame A = new Play();
        A.setSize(800, 600);
        A.setTitle("Meow's Fruits");
        A.setDefaultCloseOperation(EXIT_ON_CLOSE);
        A.setVisible(true);
        A.setLocationRelativeTo(null);
    }
}
