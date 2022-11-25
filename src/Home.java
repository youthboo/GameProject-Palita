import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Home extends JPanel{
    private ImageIcon feild     = new ImageIcon(this.getClass().getResource("Home.png"));
	private ImageIcon exit      = new ImageIcon(this.getClass().getResource("ext.png"));
	private ImageIcon starts    = new ImageIcon(this.getClass().getResource("sta.png"));
	public JButton BStart  = new JButton(starts);
	public JButton BExit1  = new JButton(exit);

	Home(){
            setLayout(null);
            BExit1.setBounds(400,290,290,90);
            add(BExit1);
            add(BStart);
            BStart.setBounds(90,290,290,90);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,800,600,this);
	}
}
