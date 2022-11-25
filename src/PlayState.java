import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class PlayState extends JPanel implements ActionListener {

	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("c1.png"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("c2.png"));
	private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("c3.png"));

	//*****************************
	private final ImageIcon imgplayer = new ImageIcon(this.getClass().getResource("1.png"));
	private final ImageIcon re = new ImageIcon(this.getClass().getResource("playag.png"));

	Player m = new Player();
	Home h = new Home();

	ImageIcon feildover = new ImageIcon(this.getClass().getResource("GameOver.png"));
	ImageIcon img_paralyze = new ImageIcon(this.getClass().getResource("8.png"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("ext.png"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("Sta.png"));
	JButton BStartover = new JButton(restart);
	JButton BExitover = new JButton(exitover);


	private JLabel score = new JLabel();
	public JButton Bre = new JButton(re);

	public ArrayList<Bomb> Bomb = new ArrayList<Bomb>();
	public ArrayList<Rock> Rock = new ArrayList<Rock>();
	public ArrayList<Cherry> Cherry = new ArrayList<Cherry>();
	public ArrayList<Apple> Apple = new ArrayList<Apple>();
	public ArrayList<Orange> Orange = new ArrayList<Orange>();
	public ArrayList<Grape> Grape = new ArrayList<Grape>();
	public ArrayList<Watermelon> Watermelon = new ArrayList<Watermelon>();
	public ArrayList<Strawberry> Strawberry = new ArrayList<Strawberry>();

	public int Times = 120;
	public int lv1 = 1;
	public int lv2 = 2;
	public int lv3 = 3;
	boolean timet = true;
	boolean fall = false;

	private GameOver gover = new GameOver();
	public int sc = 0;

	boolean paralyze1 = false;
	int time_paralyze = 5;

	Thread time = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}

				if (timet == false) {
					repaint();
				}
			}
		}
	});

	Thread actor = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
				} catch (Exception e) {
				}
				repaint();
			}
		}
	});

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Thread Rock1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Rock.add(new Rock());
				}
			}
		}
	});

	Thread Bomb1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Bomb.add(new Bomb());
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
					repaint();
					Bomb.add(new Bomb());
				}
			}
		}
	});

	Thread Cherry1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Cherry.add(new Cherry());

				}
			}
		}
	});


	Thread Apple1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Apple.add(new Apple());
				}
			}
		}
	});

	Thread Orange1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Orange.add(new Orange());

				}
			}
		}
	});

	Thread Grape1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Grape.add(new Grape());

				}
			}
		}
	});

	Thread Watermelon1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Watermelon.add(new Watermelon());

				}
			}
		}
	});

	Thread Strawberry1 = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					if (fall == false) {
						Thread.sleep((long) (Math.random() * 10000) + 2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (fall == false) {
					Strawberry.add(new Strawberry());

				}
			}
		}
	});

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	Thread paralyze = new Thread(new Runnable() {
		public void run() {
			while (true) {
				if (time_paralyze < 1) {
					paralyze1 = false;
					time_paralyze = 5;
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	Thread thp = new Thread(new Runnable() {
		public void run() {
			while (true) {
				if (timet == false) {
					Times = (Times - 1);
					if (paralyze1) {
						time_paralyze--;
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});


	PlayState() {
		this.setFocusable(true);
		this.setLayout(null);
		this.add(score);
		Bre.addActionListener(this);
		this.add(Bre);

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int a = e.getKeyCode();
				if (!paralyze1) {
					if (a == KeyEvent.VK_A) {
						m.x -= 10;
						m.count = 0;
					} else if (a == KeyEvent.VK_D) {
						m.x += 10;
						m.count = 1;
					} else if (a == KeyEvent.VK_LEFT) {
						m.x -= 10;
						m.count = 1;
					} else if (a == KeyEvent.VK_RIGHT) {
						m.x += 10;
						m.count = 1;
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				m.count = 0;
			}
		});

		m.x = 350;
		m.y = 400;

		time.start();
		actor.start();
		thp.start();
		Bomb1.start();
		Rock1.start();
		Cherry1.start();
		Apple1.start();
		paralyze.start();
		Orange1.start();
		Grape1.start();
		Watermelon1.start();
		Strawberry1.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Times <= 0) {
			Bre.setBounds(260, 405, 300, 100);
			this.setLayout(null);
			g.drawImage(feildover.getImage(), 0, 0, 800, 600, this);
		}

		else if (sc >= 300) {
			g.drawImage(imgstate3.getImage(), 0, 0, 800, 600, this);
			if (paralyze1) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Tahoma", Font.BOLD, 50));
				g.drawImage(img_paralyze.getImage(), m.x, 550, 100, 150, this);

			} else {
				g.drawImage(m.im[m.count].getImage(), m.x, 400, 200, 160, this);
			}

			//*********************************************************************************************************************


			for (int i = 0; i < Bomb.size(); i++) {
				g.drawImage(Bomb.get(i).getImage(), Bomb.get(i).getX(), Bomb.get(i).getY(), 60, 60, this);
			}
			for (int j = 0; j < Bomb.size(); j++) {
				if (Intersect(m.getbound(), Bomb.get(j).getbound())) {
					Bomb.remove(j);

					sc -= 30;
					Times = Times - 30;

					g.drawString("-30 Times", m.x + 100, 580);
					g.drawString("-30", m.x + 100, 650);
				}
			}

			//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
			for (int i = 0; i < Rock.size(); i++) {
				g.drawImage(Rock.get(i).getImage(), Rock.get(i).getX(), Rock.get(i).getY(), 70, 70, this);
			}
			for (int j = 0; j < Rock.size(); j++) {
				if (Intersect(m.getbound(), Rock.get(j).getbound())) {
					Rock.remove(j);

					sc -= 20;
					Times = Times - 20;

					g.drawString("-20 Times", m.x + 100, 580);
					g.drawString("-20", m.x + 100, 650);
				}
			}


			for (int i = 0; i < Cherry.size(); i++) {
				g.drawImage(Cherry.get(i).getImage(), Cherry.get(i).getX(), Cherry.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Cherry.size(); j++) {
				if (Intersect(m.getbound(), Cherry.get(j).getbound())) {
					Cherry.remove(j);

					sc += 30;
					Times = Times + 10;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+10 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Apple.size(); i++) {
				g.drawImage(Apple.get(i).getImage(), Apple.get(i).getX(), Apple.get(i).getY(), 50, 50, this);
			}

			for (int j = 0; j < Apple.size(); j++) {
				if (Intersect(m.getbound(), Apple.get(j).getbound())) {
					Apple.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Orange.size(); i++) {
				g.drawImage(Orange.get(i).getImage(), Orange.get(i).getX(), Orange.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Orange.size(); j++) {
				if (Intersect(m.getbound(), Orange.get(j).getbound())) {
					Orange.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Grape.size(); i++) {
				g.drawImage(Grape.get(i).getImage(), Grape.get(i).getX(), Grape.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Grape.size(); j++) {
				if (Intersect(m.getbound(), Grape.get(j).getbound())) {
					Grape.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Watermelon.size(); i++) {
				g.drawImage(Watermelon.get(i).getImage(), Watermelon.get(i).getX(), Watermelon.get(i).getY(),
						50, 50, this);
			}

			for (int j = 0; j < Watermelon.size(); j++) {
				if (Intersect(m.getbound(), Watermelon.get(j).getbound())) {
					Watermelon.remove(j);
					sc += 30;
					Times = Times + 5;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Strawberry.size(); i++) {
				g.drawImage(Strawberry.get(i).getImage(), Strawberry.get(i).getX(), Strawberry.get(i).getY(),
						80, 80, this);
			}

			for (int j = 0; j < Strawberry.size(); j++) {
				if (Intersect(m.getbound(), Strawberry.get(j).getbound())) {
					Strawberry.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			//-------------------------[ l e v e l 3 ]---------------------------------------------------

			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.drawString("SCORE =  " + sc, 590, 100);
			g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 60));
			g.setColor(Color.WHITE);
			g.drawString("LEVEL " + lv3, 50, 80);
			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.RED);
			g.drawString("Times  " + Times, 590, 150);

		}
		else if (sc >= 150) {
			g.drawImage(imgstate2.getImage(), 0, 0, 800, 600, this);
			if (paralyze1) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Tahoma", Font.BOLD, 50));
				g.drawImage(img_paralyze.getImage(), m.x, 550, 100, 150, this);

			} else {
				g.drawImage(m.im[m.count].getImage(), m.x, 400, 200, 160, this);
			}

			//*********************************************************************************************************************


			for (int i = 0; i < Bomb.size(); i++) {
				g.drawImage(Bomb.get(i).getImage(), Bomb.get(i).getX(), Bomb.get(i).getY(), 60, 60, this);
			}
			for (int j = 0; j < Bomb.size(); j++) {
				if (Intersect(m.getbound(), Bomb.get(j).getbound())) {
					Bomb.remove(j);

					sc -= 30;
					Times = Times - 20;

					g.drawString("-20 Times", m.x + 100, 580);
					g.drawString("-30", m.x + 100, 650);
				}
			}

			//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
			for (int i = 0; i < Rock.size(); i++) {
				g.drawImage(Rock.get(i).getImage(), Rock.get(i).getX(), Rock.get(i).getY(), 70, 70, this);
			}

			for (int j = 0; j < Rock.size(); j++) {
				if (Intersect(m.getbound(), Rock.get(j).getbound())) {
					Rock.remove(j);

					sc -= 20;
					Times = Times - 15;

					g.drawString("-15 Times", m.x + 100, 580);
					g.drawString("-20", m.x + 100, 650);
				}
			}


			for (int i = 0; i < Cherry.size(); i++) {
				g.drawImage(Cherry.get(i).getImage(), Cherry.get(i).getX(), Cherry.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Cherry.size(); j++) {
				if (Intersect(m.getbound(), Cherry.get(j).getbound())) {
					Cherry.remove(j);

					sc += 30;
					Times = Times + 10;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+10 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Apple.size(); i++) {
				g.drawImage(Apple.get(i).getImage(), Apple.get(i).getX(), Apple.get(i).getY(), 50, 50, this);
			}

			for (int j = 0; j < Apple.size(); j++) {
				if (Intersect(m.getbound(), Apple.get(j).getbound())) {
					Apple.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Orange.size(); i++) {
				g.drawImage(Orange.get(i).getImage(), Orange.get(i).getX(), Orange.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Orange.size(); j++) {
				if (Intersect(m.getbound(), Orange.get(j).getbound())) {
					Orange.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Grape.size(); i++) {
				g.drawImage(Grape.get(i).getImage(), Grape.get(i).getX(), Grape.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Grape.size(); j++) {
				if (Intersect(m.getbound(), Grape.get(j).getbound())) {
					Grape.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Watermelon.size(); i++) {
				g.drawImage(Watermelon.get(i).getImage(), Watermelon.get(i).getX(), Watermelon.get(i).getY(), 50, 50, this);
			}

			for (int j = 0; j < Watermelon.size(); j++) {
				if (Intersect(m.getbound(), Watermelon.get(j).getbound())) {
					Watermelon.remove(j);
					sc += 30;
					Times = Times + 5;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Strawberry.size(); i++) {
				g.drawImage(Strawberry.get(i).getImage(), Strawberry.get(i).getX(), Strawberry.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Strawberry.size(); j++) {
				if (Intersect(m.getbound(), Strawberry.get(j).getbound())) {
					Strawberry.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			//-------------------------[ l e v e l 2 ]---------------------------------------------------

			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.drawString("SCORE =  " + sc, 590, 100);
			g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 60));
			g.setColor(Color.WHITE);
			g.drawString("LEVEL " + lv2, 50, 80);
			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.RED);
			g.drawString("Times  " + Times, 590, 150);


			//----------[ L E V E L 1 ]-----------------------------------------------

		}
		else {
			g.drawImage(imgstate1.getImage(), 0, 0, 800, 600, this);
			if (paralyze1) {
				g.setColor(Color.RED);
				g.setFont(new Font("Tahoma", Font.BOLD, 50));
				g.drawImage(img_paralyze.getImage(), m.x, 550, 100, 150, this);

			} else {
				g.drawImage(m.im[m.count].getImage(), m.x, 400, 200, 160, this);
			}

			for (int i = 0; i < Bomb.size(); i++) {
				g.drawImage(Bomb.get(i).getImage(), Bomb.get(i).getX(), Bomb.get(i).getY(), 60, 60, this);
			}
			for (int j = 0; j < Bomb.size(); j++) {
				if (Intersect(m.getbound(), Bomb.get(j).getbound())) {
					Bomb.remove(j);
					sc -= 30;
					Times = Times - 10;


					g.drawString("-10 Times", m.x + 100, 580);
					g.drawString("-30", m.x + 100, 650);

				}
			}


			for (int i = 0; i < Rock.size(); i++) {
				g.drawImage(Rock.get(i).getImage(), Rock.get(i).getX(), Rock.get(i).getY(), 70, 70, this);
			}

			for (int j = 0; j < Rock.size(); j++) {
				if (Intersect(m.getbound(), Rock.get(j).getbound())) {
					Rock.remove(j);

					sc -= 20;
					Times = Times - 10;


					g.drawString("-10 Times", m.x + 100, 580);
					g.drawString("-20", m.x + 100, 650);
				}
			}


			for (int i = 0; i < Cherry.size(); i++) {
				g.drawImage(Cherry.get(i).getImage(), Cherry.get(i).getX(), Cherry.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Cherry.size(); j++) {
				if (Intersect(m.getbound(), Cherry.get(j).getbound())) {
					Cherry.remove(j);
					sc += 30;
					Times = Times + 5;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Apple.size(); i++) {
				g.drawImage(Apple.get(i).getImage(), Apple.get(i).getX(), Apple.get(i).getY(), 50, 50, this);
			}

			for (int j = 0; j < Apple.size(); j++) {
				if (Intersect(m.getbound(), Apple.get(j).getbound())) {
					Apple.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Orange.size(); i++) {
				g.drawImage(Orange.get(i).getImage(), Orange.get(i).getX(), Orange.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Orange.size(); j++) {
				if (Intersect(m.getbound(), Orange.get(j).getbound())) {
					Orange.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Grape.size(); i++) {
				g.drawImage(Grape.get(i).getImage(), Grape.get(i).getX(), Grape.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Grape.size(); j++) {
				if (Intersect(m.getbound(), Grape.get(j).getbound())) {
					Grape.remove(j);
					sc += 20;
					Times = Times + 5;
					g.drawString("+20", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Watermelon.size(); i++) {
				g.drawImage(Watermelon.get(i).getImage(), Watermelon.get(i).getX(), Watermelon.get(i).getY(), 50, 50, this);
			}

			for (int j = 0; j < Watermelon.size(); j++) {
				if (Intersect(m.getbound(), Watermelon.get(j).getbound())) {
					Watermelon.remove(j);
					sc += 30;
					Times = Times + 5;
					g.drawString("+30", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			for (int i = 0; i < Strawberry.size(); i++) {
				g.drawImage(Strawberry.get(i).getImage(), Strawberry.get(i).getX(), Strawberry.get(i).getY(), 80, 80, this);
			}

			for (int j = 0; j < Strawberry.size(); j++) {
				if (Intersect(m.getbound(), Strawberry.get(j).getbound())) {
					Strawberry.remove(j);
					sc += 10;
					Times = Times + 5;
					g.drawString("+10", m.x + 100, 650);
					g.drawString("+5 Times", m.x + 100, 700);
				}
			}

			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.drawString("SCORE =  " + sc, 580, 100);
			g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 60));
			g.setColor(Color.WHITE);
			g.drawString("LEVEL " + lv1, 50, 80);
			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.setColor(Color.RED);
			g.drawString("Times  " + Times, 580, 150);

		}

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b) {
		return (a.intersects(b));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BStartover) {
			this.setSize(800, 600);
			this.add(h);
			this.setLocation(null);
			timet = true;
			fall = true;
		} else if (e.getSource() == BExitover) {
			System.exit(0);
		}
	}


}