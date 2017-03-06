package edu.neumont.csc150.finalproject.group17;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	
	Font f = new Font("Times New Roman", Font.BOLD, 40); 
	
	int amount = 0;

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
		
		frame.add(this);
		this.add(container);
		container.add(characterName);
		container.add(alignment);
		container.add(playerName);
		container.add(multiClassLabel);
		container.add(multiClass);
		
//		Classes classPanel = new Classes();
//		classPanel.setPreferredSize(new Dimension(2400, 500));
		
		reference.setBackground(Color.LIGHT_GRAY);
		
		multiClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Classes classPanel = null;
				for (int i = 0; i < (int)multiClass.getSelectedItem(); i++) {
					classPanel = new Classes();
					classPanel.setPreferredSize(new Dimension(2400, 100));
					reference.add(classPanel);
					amount++;
//					container.add(new JLabel("Test"));
//					System.out.println("Testing");
					reference.validate();
				}				
				while ((int)multiClass.getSelectedItem() < amount) {
					reference.remove(classPanel);
					reference.remove(classPanel);
					amount--;
				}
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
