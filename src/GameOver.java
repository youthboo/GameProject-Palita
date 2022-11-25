import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel {
    private ImageIcon feildover = new ImageIcon("GameOver.png");
    private ImageIcon exitover = new ImageIcon("ext.jpg");
    private ImageIcon restart = new ImageIcon("Sta.jpg");
    public JButton BStartover = new JButton(restart);
    public JButton BExitover = new JButton(exitover);

    GameOver() {
        this.setLayout(null);
        BExitover.setBounds(400, 300, 290, 90);
        add(BExitover);
        add(BStartover);
        BStartover.setBounds(300, 300, 290, 90);
        add(BStartover);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(feildover.getImage(), 0, 0, 800, 600, this);
    }
}
