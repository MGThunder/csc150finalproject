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

	JFrame frame = new JFrame("Pathfinder Character Sheet");

	JPanel container = new JPanel();
	JPanel agePanel = new JPanel();
	JPanel heightPanel = new JPanel();

	JTextField characterName = new JTextField("Character Name");
	JTextField alignment = new JTextField("Alignment");
	JTextField playerName = new JTextField("Player Name");
	JTextField deity = new JTextField("Deity");
	JTextField homeland = new JTextField("Homeland");
	JTextField ageInput = new JTextField("Age");
	JTextField heightInput = new JTextField("Weight");

	JComboBox<String> gender = new JComboBox<>(new String[] {"Female", "Male"});
	JComboBox<Enum> race = new JComboBox<>(Races.values());
	JComboBox<Integer> multiClass = new JComboBox<>(new Integer[] { 1, 2, 3, 4 });

	JLabel raceLabel = new JLabel("Race: ");
	JLabel size = new JLabel("Size: " + getCharacterSize());
	JLabel multiClassLabel = new JLabel("<html>Amount of <br>Classes</html>");
	JLabel ageLabel = new JLabel("Age");
	JLabel heightLabel = new JLabel("Weight");
	JLabel genderLabel = new JLabel("Gender");

	JButton ageRoll = new JButton("Age");
	JButton heightRoll= new JButton("Height");

	JRadioButton ageRollSelection = new JRadioButton("Roll Age");
	JRadioButton ageInputSelection = new JRadioButton("Input Age");
	JRadioButton intuitive = new JRadioButton("Intuitive (Young)");
	JRadioButton selfTaught = new JRadioButton("Self-Taught (Middle)");
	JRadioButton trained = new JRadioButton("Trained (Older)");
	JRadioButton heightRollSelection = new JRadioButton("Roll Height");
	JRadioButton heightInputSelection = new JRadioButton("Input Height");

	ButtonGroup ageRollOrInput = new ButtonGroup();
	ButtonGroup ageRange = new ButtonGroup();
	ButtonGroup heightRollOrInput = new ButtonGroup();

	Classes[] classArray = new Classes[] { new Classes(), new Classes(), new Classes(), new Classes() };

	Die diceBag = new Die();

	// ScrollBarPanel scrollBar = new ScrollBarPanel();

	Font f = new Font("Times New Roman", Font.BOLD, 40);

	int age;
	int height;

	public static void main(String[] args) {
		GUI nonStaticHelper = new GUI();
		nonStaticHelper.createAndShowCharacterSheet();
	}

	public void createAndShowCharacterSheet() {

		frame.setPreferredSize(new Dimension(3000, 2000));

		JPanel reference = this;

		container.setBackground(Color.LIGHT_GRAY);
		container.setPreferredSize(new Dimension(2400, 120));

		agePanel.setBackground(Color.LIGHT_GRAY);
		agePanel.setPreferredSize(new Dimension(2400, 120));
		
		heightPanel.setBackground(Color.LIGHT_GRAY);
		heightPanel.setPreferredSize(new Dimension(2400, 120));

		characterName.setPreferredSize(new Dimension(1050, 100));
		characterName.setFont(f);

		alignment.setPreferredSize(new Dimension(400, 100));
		alignment.setFont(f);

		playerName.setPreferredSize(new Dimension(500, 100));
		playerName.setFont(f);

		multiClassLabel.setPreferredSize(new Dimension(200, 100));
		multiClassLabel.setForeground(Color.white);
		multiClassLabel.setFont(f);

		multiClass.setPreferredSize(new Dimension(100, 100));
		multiClass.setFont(f);

		raceLabel.setPreferredSize(new Dimension(150, 100));
		raceLabel.setFont(f);

		race.setPreferredSize(new Dimension(300, 100));
		race.setFont(f);

		size.setPreferredSize(new Dimension(250, 100));
		size.setFont(f);

		gender.setPreferredSize(new Dimension(200, 100));
		gender.setFont(f);
		
		genderLabel.setPreferredSize(new Dimension(150, 100));
		genderLabel.setFont(f);

		ageRollOrInput.add(ageRollSelection);
		ageRollOrInput.add(ageInputSelection);

		ageRollSelection.setPreferredSize(new Dimension(200, 100));
		ageRollSelection.setFont(f);
		ageRollSelection.setBackground(Color.LIGHT_GRAY);

		ageInputSelection.setPreferredSize(new Dimension(240, 100));
		ageInputSelection.setFont(f);
		ageInputSelection.setBackground(Color.LIGHT_GRAY);

		ageRoll.setPreferredSize(new Dimension(150, 100));
		ageRoll.setFont(f);

		ageInput.setPreferredSize(new Dimension(200, 100));
		ageInput.setFont(f);

		ageRange.add(intuitive);
		ageRange.add(selfTaught);
		ageRange.add(trained);

		ageLabel.setPreferredSize(new Dimension(75, 100));
		ageLabel.setFont(f);

		intuitive.setPreferredSize(new Dimension(350, 100));
		intuitive.setFont(f);

		selfTaught.setPreferredSize(new Dimension(400, 100));
		selfTaught.setFont(f);

		trained.setPreferredSize(new Dimension(350, 100));
		trained.setFont(f);
		
		heightRollOrInput.add(heightInputSelection);
		heightRollOrInput.add(heightRollSelection);
		
		heightInputSelection.setPreferredSize(new Dimension(300, 100));
		heightInputSelection.setFont(f);
		
		heightRollSelection.setPreferredSize(new Dimension(300, 100));
		heightRollSelection.setFont(f);
		
		heightRoll.setPreferredSize(new Dimension(150, 100));
		heightRoll.setFont(f);
		
		heightInput.setPreferredSize(new Dimension(150, 100));
		heightInput.setFont(f);
		
		heightLabel.setPreferredSize(new Dimension(150, 100));
		heightLabel.setFont(f);

		// scrollBar.setPreferredSize(new Dimension(20, 500));

		frame.add(this);
		this.add(container);
		// this.add(scrollBar, BorderLayout.EAST);
		container.add(characterName);
		container.add(alignment);
		container.add(playerName);
		container.add(multiClassLabel);
		container.add(multiClass);

		// Classes classPanel = new Classes();
		// classPanel.setPreferredSize(new Dimension(2400, 500));

		reference.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < classArray.length; i++) {
			reference.add(classArray[i]);
			classArray[i].setPreferredSize(new Dimension(1500, 100));
			if (i > 0) {
				classArray[i].setVisible(false);
			}
			// classArray[i].setBackground(Color.BLACK);
		}

		multiClass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = 4;
				for (int i = 0; i < (int) multiClass.getSelectedItem(); i++) {

					classArray[i].setVisible(true);

					while ((int) multiClass.getSelectedItem() != amount
							&& amount > (int) multiClass.getSelectedItem()) {
						// reference.remove(classPanel);
						amount--;
						classArray[amount].setVisible(false);
					}
					// container.add(new JLabel("Test"));
					// System.out.println("Testing");
					reference.validate();
				}
				// reference.setLayout(new BoxLayout(reference,
				// BoxLayout.Y_AXIS));
			}
		});

		race.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				size.setText("Size: " + getCharacterSize());

			}
		});

		this.add(agePanel);
		this.add(heightPanel);
		agePanel.add(raceLabel);
		agePanel.add(race);
		agePanel.add(size);
		agePanel.add(genderLabel);
		agePanel.add(gender);
		agePanel.add(ageRollSelection);
		agePanel.add(ageInputSelection);

		// Checks to see if the roll JRadioButton has been selected
		ageRollSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ageRollSelection.isSelected()) {
					agePanel.setPreferredSize(new Dimension(2400, 220));
					agePanel.remove(ageInput);
					agePanel.add(intuitive);
					agePanel.add(selfTaught);
					agePanel.add(trained);
					agePanel.add(ageRoll);
					reference.validate();
					reference.repaint();
				}
				// Checks if the Age JButton has been pressed
				ageRoll.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						age = getAgeRoll(intuitive.isSelected(), selfTaught.isSelected(), trained.isSelected());
						agePanel.add(ageLabel);
						agePanel.add(ageInput);
						agePanel.remove(ageRollSelection);
						agePanel.remove(ageInputSelection);
						agePanel.remove(intuitive);
						agePanel.remove(selfTaught);
						agePanel.remove(trained);
						agePanel.remove(ageRoll);
						ageInput.setText(String.valueOf(age));
						reference.validate();
						reference.repaint();
					}

				});

			}
		});

		ageInputSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ageInputSelection.isSelected()) {
					agePanel.remove(intuitive);
					agePanel.remove(selfTaught);
					agePanel.remove(trained);
					agePanel.remove(ageRoll);
					agePanel.add(ageInput);
					reference.validate();
					reference.repaint();
				}
			}
		});

		heightPanel.add(heightRollSelection);
		heightPanel.add(heightInputSelection);
		
		heightRollSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (heightRollSelection.isSelected()) {
					heightPanel.add(heightRoll);
					heightPanel.remove(heightInput);
					reference.validate();
					reference.repaint();
				}
				heightRoll.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						height = getHeightRoll();
						heightPanel.add(heightLabel);
						heightPanel.add(heightInput);
						heightPanel.remove(heightInputSelection);
						heightPanel.remove(heightRoll);
						heightPanel.remove(heightRollSelection);
						heightInput.setText(String.valueOf(height));
						reference.validate();
						reference.repaint();
					}
				});
			}
		});
		
		heightInputSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				heightPanel.add(heightInput);
				heightPanel.remove(heightRoll);
				reference.validate();
				reference.repaint();
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getCharacterSize() {
		String result = null;
		Races dropDownText = (Races) race.getSelectedItem();

		if (dropDownText.equals(Races.DWARF)) {
			result = Races.DWARF.getSize();
		} else if (dropDownText.equals(Races.ELF)) {
			result = Races.ELF.getSize();
		} else if (dropDownText.equals(Races.GNOME)) {
			result = Races.GNOME.getSize();
		} else if (dropDownText.equals(Races.HALFELF)) {
			result = Races.HALFELF.getSize();
		} else if (dropDownText.equals(Races.HALFORC)) {
			result = Races.HALFORC.getSize();
		} else if (dropDownText.equals(Races.HALFLING)) {
			result = Races.HALFLING.getSize();
		} else if (dropDownText.equals(Races.HUMAN)) {
			result = Races.HUMAN.getSize();
		}

		return result;
	}

	public int getAgeRoll(boolean intuitive, boolean selfTaught, boolean trained) {
		int result = 0;
		Races dropDownText = (Races) race.getSelectedItem();

		if (dropDownText.equals(Races.DWARF)) {
			if (intuitive) {
				result = setRollResult(Races.DWARF.getIntuitiveDiceAmount(), Races.DWARF.getIntuitiveDiceSides())
						+ Races.DWARF.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.DWARF.getSelfTaughtDiceAmount(), Races.DWARF.getSelfTaughtDiceSides())
						+ Races.DWARF.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.DWARF.getTrainedDiceAmount(), Races.DWARF.getTrainedDiceSides())
						+ Races.DWARF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.ELF)) {
			if (intuitive) {
				result = setRollResult(Races.ELF.getIntuitiveDiceAmount(), Races.ELF.getIntuitiveDiceSides())
						+ Races.ELF.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.ELF.getSelfTaughtDiceAmount(), Races.ELF.getSelfTaughtDiceSides())
						+ Races.ELF.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.ELF.getTrainedDiceAmount(), Races.ELF.getTrainedDiceSides())
						+ Races.ELF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.GNOME)) {
			if (intuitive) {
				result = setRollResult(Races.GNOME.getIntuitiveDiceAmount(), Races.GNOME.getIntuitiveDiceSides())
						+ Races.GNOME.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.GNOME.getSelfTaughtDiceAmount(), Races.GNOME.getSelfTaughtDiceSides())
						+ Races.GNOME.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.GNOME.getTrainedDiceAmount(), Races.GNOME.getTrainedDiceSides())
						+ Races.GNOME.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFELF)) {
			if (intuitive) {
				result = setRollResult(Races.HALFELF.getIntuitiveDiceAmount(), Races.HALFELF.getIntuitiveDiceSides())
						+ Races.HALFELF.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.HALFELF.getSelfTaughtDiceAmount(), Races.HALFELF.getSelfTaughtDiceSides())
						+ Races.HALFELF.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.HALFELF.getTrainedDiceAmount(), Races.HALFELF.getTrainedDiceSides())
						+ Races.HALFELF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFORC)) {
			if (intuitive) {
				result = setRollResult(Races.HALFORC.getIntuitiveDiceAmount(), Races.HALFORC.getIntuitiveDiceSides())
						+ Races.HALFORC.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.HALFORC.getSelfTaughtDiceAmount(), Races.HALFORC.getSelfTaughtDiceSides())
						+ Races.HALFORC.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.HALFORC.getTrainedDiceAmount(), Races.HALFORC.getTrainedDiceSides())
						+ Races.HALFORC.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFLING)) {
			if (intuitive) {
				result = setRollResult(Races.HALFLING.getIntuitiveDiceAmount(), Races.HALFLING.getIntuitiveDiceSides())
						+ Races.HALFLING.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.HALFLING.getSelfTaughtDiceAmount(), Races.HALFLING.getSelfTaughtDiceSides())
						+ Races.HALFLING.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.HALFLING.getTrainedDiceAmount(), Races.HALFLING.getTrainedDiceSides())
						+ Races.HALFLING.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HUMAN)) {
			if (intuitive) {
				result = setRollResult(Races.HUMAN.getIntuitiveDiceAmount(), Races.HUMAN.getIntuitiveDiceSides())
						+ Races.HUMAN.getBaseAge();
			} else if (selfTaught) {
				result = setRollResult(Races.HUMAN.getSelfTaughtDiceAmount(), Races.HUMAN.getSelfTaughtDiceSides())
						+ Races.HUMAN.getBaseAge();
			} else if (trained) {
				result = setRollResult(Races.HUMAN.getTrainedDiceAmount(), Races.HUMAN.getTrainedDiceSides())
						+ Races.HUMAN.getBaseAge();
			}
		}
		return result;
	}
	
	public int getHeightRoll() {
		int result = 0;
		Races racesDropDownText = (Races) race.getSelectedItem();
		String stringDropDownText = (String) gender.getSelectedItem();

		if (racesDropDownText.equals(Races.DWARF)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getFemaleHeightDiceSides()) +
						Races.DWARF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getMaleHeightDiceSides()) +
						Races.DWARF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.ELF)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.ELF.getHeightDiceAmount(), Races.ELF.getFemaleHeightDiceSides()) +
						Races.ELF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getMaleHeightDiceSides()) +
						Races.ELF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.GNOME)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.GNOME.getHeightDiceAmount(), Races.GNOME.getFemaleHeightDiceSides()) +
						Races.GNOME.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.GNOME.getHeightDiceAmount(), Races.GNOME.getMaleHeightDiceSides()) +
						Races.GNOME.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFELF)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFELF.getHeightDiceAmount(), Races.HALFELF.getFemaleHeightDiceSides()) +
						Races.HALFELF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFELF.getHeightDiceAmount(), Races.HALFELF.getMaleHeightDiceSides()) +
						Races.HALFELF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFORC)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFORC.getHeightDiceAmount(), Races.HALFORC.getFemaleHeightDiceSides()) +
						Races.HALFORC.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFORC.getHeightDiceAmount(), Races.HALFORC.getMaleHeightDiceSides()) +
						Races.HALFORC.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFLING)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFLING.getHeightDiceAmount(), Races.HALFLING.getFemaleHeightDiceSides()) +
						Races.HALFLING.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFLING.getHeightDiceAmount(), Races.HALFLING.getMaleHeightDiceSides()) +
						Races.HALFLING.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HUMAN)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HUMAN.getHeightDiceAmount(), Races.HUMAN.getFemaleHeightDiceSides()) +
						Races.HUMAN.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HUMAN.getHeightDiceAmount(), Races.HUMAN.getMaleHeightDiceSides()) +
						Races.HUMAN.getBaseMaleHeight();
			}
		}
		
		return result;
	}

	public int setRollResult(int diceAmount, int diceSides) {
		int result = 0;
		for (int i = 0; i < diceAmount; i++) {
			result += diceBag.rollDice(diceSides);
		}
		return result;
	}

}
