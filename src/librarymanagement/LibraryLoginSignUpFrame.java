package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibraryLoginSignUpFrame {
	LibraryLoginSignUpFrame(Library library) {
		// Frame for logging in and signing in 
		JFrame frame = new JFrame("Library Management System");
		frame.setSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorth = new JPanel();
		JLabel labelSystemName = new JLabel("Library Management system");
		JPanel panelCenter = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JLabel labelLibName = new JLabel("Library Name");
		
		JButton adminLogin = new JButton("Admin login");
		adminLogin.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		// These panels dimensions are used to squash the components into place because
		// I don't know any other way with the default Java Swing layouts
		panelNorth.setPreferredSize(new Dimension(400,100));
		
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.add(Box.createVerticalGlue());
		panelCenter.add(Box.createHorizontalGlue());
		panelSouth.setPreferredSize(new Dimension(400,100));
		panelWest.setPreferredSize(new Dimension(100,400));
		panelEast.setPreferredSize(new Dimension(100,400));
				
		// Uncomment to see what the center panel covers
//		panelCenter.setBackground(Color.red);

		// makes font big and chooses font
		labelSystemName.setFont(new Font("Arial", Font.PLAIN, 20));;
		panelNorth.add(labelSystemName);
		labelLibName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		labelLibName.setFont(new Font("Arial", Font.PLAIN, 20));
		panelCenter.add(labelLibName);
		
		panelSouth.add(adminLogin);
		
		
		
		JButton signUp = new JButton("Sign up");
		signUp.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JButton login = new JButton("  Login ");	
		login.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		
		
		// Creates a login window when the user presses the button
		
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EnterInformationFrame loginFrame = new EnterLoginFrame("Login", library, frame);
				
				if(loginFrame.login) {
					
					frame.dispose();
				}
			}
			
		});
		
		// signUp creates a new JFrame for the user to
		// enter their information
		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterSignUpFrame("Sign up", library, frame);
			}
			
		});
		
		
		adminLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		panelNorth.add(Box.createRigidArea(new Dimension(0,150)));
		
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(login);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(signUp);
		panelCenter.add(Box.createVerticalGlue());
		panelCenter.add(Box.createHorizontalGlue());
		
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelEast, BorderLayout.EAST);
		frame.setVisible(true);
	}
}
