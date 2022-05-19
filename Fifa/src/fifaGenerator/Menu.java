package fifaGenerator;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	/**
	 * adds frame components to the screen, makes them resizable
	 */
	public static void addComponent() {
		
		ImageIcon ajax = new ImageIcon("ajax.png");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(107, 89, 500, 400);
		lblNewLabel.setText("");
		lblNewLabel.setIcon(ajax);
		frame.getContentPane().add(lblNewLabel);
	}
}
