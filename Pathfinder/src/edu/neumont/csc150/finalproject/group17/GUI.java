package edu.neumont.csc150.finalproject.group17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JPanel {

	String[] races = new String[] {"Dwarf", "Elf", "Gnome", "Half-Elf", "Half-Orc", "Halfling", "Human"};

	JFrame frame = new JFrame("Pathfinder Character Sheet");
	
	JPanel container = new JPanel();
	
	JTextField characterName = new JTextField("Character Name");
	JTextField alignment = new JTextField("Alignment");
	JTextField playerName = new JTextField("Player Name");
	JTextField deity = new JTextField("Deity");
	JTextField homeland = new JTextField("Homeland");
	JTextField gender = new JTextField("Gender");
	JTextField ageInput = new JTextField("Age");
	
	JComboBox<String> race = new JComboBox<>(races);
	JComboBox<Integer> multiClass = new JComboBox<>(new Integer[] {1, 2, 3, 4}); 
	
	JLabel classStatement = new JLabel("Class: ");
	JLabel levelStatement = new JLabel("Level: ");
	JLabel raceStatement = new JLabel("Race: ");
	JLabel size = new JLabel("Size: " + getCharacterSize());
	JLabel multiClassLabel = new JLabel("<html>Amount of <br>Classes</html>");
	
	JButton ageRoll = new JButton("Age");
	
	JRadioButton roll = new JRadioButton("Roll");
	JRadioButton input = new JRadioButton("Input");
	
	ButtonGroup rollOrInput = new ButtonGroup();
	
	JScrollBar vBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0 ,300);
	
	Classes[] classArray = new Classes[]{new Classes(), new Classes(), new Classes(), new Classes()};
	
	Font f = new Font("Times New Roman", Font.BOLD, 40); 

	public static void main(String[] args) {
		GUI nonStaticHelper = new GUI();
		nonStaticHelper.createAndShowCharacterSheet();
	}
	
	public void createAndShowCharacterSheet() {

		frame.setPreferredSize(new Dimension(3000, 2000));
		
		JPanel reference = this;
		
		container.setBackground(Color.LIGHT_GRAY);
		container.setPreferredSize(new Dimension(2400, 150));
		
		characterName.setPreferredSize(new Dimension(1050, 100));
		characterName.setFont(f);
//		characterName.setHorizontalAlignment();
		
		alignment.setPreferredSize(new Dimension(400, 100));
		alignment.setFont(f);
		
		playerName.setPreferredSize(new Dimension(500, 100));
		playerName.setFont(f);
		
		multiClassLabel.setPreferredSize(new Dimension(200, 100));
		multiClassLabel.setForeground(Color.white);
		multiClassLabel.setFont(f);

		multiClass.setPreferredSize(new Dimension(100, 100));
		multiClass.setFont(f);
		
		vBar.setPreferredSize(new Dimension(20, 3000));
		vBar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				repaint();
				
			}
		});
		
		frame.add(this);
		this.add(container);
//		this.add(vBar, BorderLayout.EAST);
		container.add(vBar, BorderLayout.EAST);
		container.add(characterName);
		container.add(alignment);
		container.add(playerName);
		container.add(multiClassLabel);
		container.add(multiClass);
		
//		Classes classPanel = new Classes();
//		classPanel.setPreferredSize(new Dimension(2400, 500));
		
		reference.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < classArray.length; i++) {
			reference.add(classArray[i]);
			classArray[i].setPreferredSize(new Dimension(1500, 100));
			if (i > 0) {
				classArray[i].setVisible(false);
			}
//			classArray[i].setBackground(Color.BLACK);
		}
		
		multiClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = 4;
				for (int i = 0; i < (int)multiClass.getSelectedItem(); i++) {
					
					classArray[i].setVisible(true);
					
					while ((int)multiClass.getSelectedItem() != amount && amount > (int)multiClass.getSelectedItem()) {
//						reference.remove(classPanel);
						amount--;
						classArray[amount].setVisible(false);
					}
//					container.add(new JLabel("Test"));
//					System.out.println("Testing");
					reference.validate();
				}	
//				reference.setLayout(new BoxLayout(reference, BoxLayout.Y_AXIS));
			}
		});
		
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getCharacterSize() {
		String result = null;
		String dropDownText = (String) race.getSelectedItem();
		
		if (dropDownText.equals("Dwarf")) {
			result = "Medium";
		} else if (dropDownText.equals("Elf")) {
			result = "Medium";
		} else if (dropDownText.equals("Gnome")) {
			result = "Small";
		} else if (dropDownText.equals("Half-Elf")) {
			result = "Medium";
		} else if (dropDownText.equals("Half-Orc")) {
			result = "Medium";
		} else if (dropDownText.equals("Halfling")) {
			result = "Small";
		} else if (dropDownText.equals("Human")) {
			result = "Medium";
		}
		
		return result;
	}
	
}
