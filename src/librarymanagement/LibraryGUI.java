package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibraryGUI {
	
	
	public static void main(String[] args) {
	// The Window for displaying content
		JFrame frame = new JFrame("Library Management System");
		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelNorth = new JPanel();
		
		
		
		JLabel labelSystemName = new JLabel("Library Management system");
		
		
		JPanel panelCenter = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JLabel labelLibName = new JLabel("Library Name");
		
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
		JButton login = new JButton("Login");	
		login.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		panelCenter.add(login);
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
