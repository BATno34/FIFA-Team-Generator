package fifaGenerator;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.concurrent.TimeUnit;

public class Menu {
	
	public static JFrame frame;
	public static int m;
	public static ImageIcon[] teams = {new ImageIcon("ajax.png"), new ImageIcon("arsenal.png"), new ImageIcon("atalanta.png"),
	new ImageIcon("atletico madrid.png"), new ImageIcon("barcelona.png"), new ImageIcon("bayern.png"), new ImageIcon("benfica.png"),
	new ImageIcon("chelsea.png"), new ImageIcon("dortmund.png"), new ImageIcon("everton.png"), new ImageIcon("frankfurt.png"), new ImageIcon("gladbach.png"),
	new ImageIcon("inter.png"), new ImageIcon("juventus.png"), new ImageIcon("lazio.png"), new ImageIcon("leicester.png"),
	new ImageIcon("leipzig.png"), new ImageIcon("leverkusen.png"), new ImageIcon("lille.png"), new ImageIcon("liverpool.png"),
	new ImageIcon("lyon.png"), new ImageIcon("manchester city.png"), new ImageIcon("manchester united.png"), new ImageIcon("marseille.png"),
	new ImageIcon("milan.png"), new ImageIcon("monaco.png"), new ImageIcon("napoli.png"),
	new ImageIcon("nice.png"), new ImageIcon("porto.png"), new ImageIcon("psg.png"), new ImageIcon("real betis.png"),
	new ImageIcon("real madrid.png"), new ImageIcon("roma.png"), new ImageIcon("sevilla.png"), new ImageIcon("tottenham.png"),
	new ImageIcon("valencia.png"), new ImageIcon("villarreal.png"), new ImageIcon("west ham.png"), new ImageIcon("wolfsburg.png"),
	new ImageIcon("wolves.png")};

	/**
	 *  Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				addComponent();
			}
		});
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(200, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	/**
	 * adds frame components to the screen, makes them resizable
	 */
	public static void addComponent() {
		
		JLabel[] teamLabel = {new JLabel(""), new JLabel(""), new JLabel(""), new JLabel("")};
		
		JLabel numberOne = new JLabel("1");
		numberOne.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		numberOne.setBounds(80, 50, 40, 100);
		frame.getContentPane().add(numberOne);
		
		JLabel numberTwo = new JLabel("2");
		numberTwo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		numberTwo.setBounds(280, 50, 40, 100);
		frame.getContentPane().add(numberTwo);
		
		JLabel numberThree = new JLabel("3");
		numberThree.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		numberThree.setBounds(480, 50, 40, 100);
		frame.getContentPane().add(numberThree);
		
		JLabel numberFour = new JLabel("4");
		numberFour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		numberFour.setBounds(680, 50, 40, 100);
		frame.getContentPane().add(numberFour);
		
		JButton start = new JButton("Start!");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().repaint();
				int genNum = (int) (Math.random()*(11)) + 5;
				int width, height, x;
				int y = 150;
				int teamNum;
				ImageIcon teamPic;
				
				//for (int i = 1; i <= genNum; i++) {
					for (m = 0; m <= 3; m++) {
						teamNum = (int) (Math.random()*(40));
						teamPic = teams[teamNum];
						width = getSize (teamPic.getIconWidth(), teamPic.getIconHeight(), 0);
						height = getSize (teamPic.getIconWidth(), teamPic.getIconHeight(), 1);
						x = (200 * m) + (200 - width)/2;
						teamLabel[m].setBounds(x, y, width, height);
						
						ImageIcon scaledPic = new ImageIcon(teamPic.getImage().getScaledInstance(teamLabel[m].getWidth(), teamLabel[m].getHeight(), Image.SCALE_SMOOTH));
						teamLabel[m].setIcon(scaledPic);
						frame.getContentPane().add(teamLabel[m]);
						Timer timer = new Timer(10000, new ActionListener() {
							public void actionPerformed (ActionEvent evt) {
								teamLabel[m].setVisible(false);
							}
						});
						timer.setRepeats(false);
						timer.start();
						timer.stop();
					}
				//}
			}
		});
		start.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		start.setBounds(325, 400, 150, 75);
		frame.getContentPane().add(start);
	}
	
	public static int getSize (int width, int height, int wOrH) {
		double w, h, prop;
		if (width > height) {
			w = 160.0;
			prop = ((double) height / (double) width);
			h = (double) 160.0 * prop;
		}
		else {
			h = 160.0;
			prop = ((double) width / (double) height);
			w = (double) 160.0 * prop; 
		}
		if (wOrH == 0)
			return (int) (Math.round(w));
		else
			return (int) (Math.round(h));
	}
}
