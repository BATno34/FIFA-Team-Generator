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
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu {

	public static JFrame frame;

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
		
		JLabel teamOne = new JLabel("");
		JLabel teamTwo = new JLabel("");
		JLabel teamThree = new JLabel("");
		JLabel teamFour = new JLabel("");
		
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
				frame.getContentPane().remove(teamOne);
				frame.getContentPane().remove(teamTwo);
				frame.getContentPane().remove(teamThree);
				frame.getContentPane().remove(teamFour);
				
				int generationNumber = (int) (Math.random()*(11)) + 5;
			}
		});
		start.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		start.setBounds(325, 400, 150, 75);
		frame.getContentPane().add(start);
		//JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setBounds(107, 89, 500, 200);
		//lblNewLabel.setText("");
		
		//ImageIcon ajax = new ImageIcon("ajax.png");
		//Image img = ajax.getImage();
		//Image imgScale = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon scaledIcon = new ImageIcon(imgScale);
		
		//lblNewLabel.setIcon(scaledIcon);
		//frame.getContentPane().add(lblNewLabel);
	}
}
