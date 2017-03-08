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
	JPanel container2 = new JPanel();

	JTextField characterName = new JTextField("Character Name");
	JTextField alignment = new JTextField("Alignment");
	JTextField playerName = new JTextField("Player Name");
	JTextField deity = new JTextField("Deity");
	JTextField homeland = new JTextField("Homeland");
	JTextField gender = new JTextField("Gender");
	JTextField ageInput = new JTextField("Age");

	JComboBox<Enum> race = new JComboBox<>(Races.values());
	JComboBox<Integer> multiClass = new JComboBox<>(new Integer[] { 1, 2, 3, 4 });

	JLabel raceLabel = new JLabel("Race: ");
	JLabel size = new JLabel("Size: " + getCharacterSize());
	JLabel multiClassLabel = new JLabel("<html>Amount of <br>Classes</html>");
	JLabel ageLabel = new JLabel("Age");

	JButton ageRoll = new JButton("Age");

	JRadioButton roll = new JRadioButton("Roll");
	JRadioButton input = new JRadioButton("Input");
	JRadioButton intuitive = new JRadioButton("Intuitive (Young)");
	JRadioButton selfTaught = new JRadioButton("Self-Taught (Middle)");
	JRadioButton trained = new JRadioButton("Trained (Older)");

	ButtonGroup rollOrInput = new ButtonGroup();
	ButtonGroup ageRange = new ButtonGroup();

	Classes[] classArray = new Classes[] { new Classes(), new Classes(), new Classes(), new Classes() };

	Die diceBag = new Die();

	// ScrollBarPanel scrollBar = new ScrollBarPanel();

	Font f = new Font("Times New Roman", Font.BOLD, 40);

	int age;

	public static void main(String[] args) {
		GUI nonStaticHelper = new GUI();
		nonStaticHelper.createAndShowCharacterSheet();
	}

	public void createAndShowCharacterSheet() {

		frame.setPreferredSize(new Dimension(3000, 2000));

		JPanel reference = this;

		container.setBackground(Color.LIGHT_GRAY);
		container.setPreferredSize(new Dimension(2400, 150));

		container2.setBackground(Color.LIGHT_GRAY);
		container2.setPreferredSize(new Dimension(2400, 1000));

		characterName.setPreferredSize(new Dimension(1050, 100));
		characterName.setFont(f);
		// characterName.setHorizontalAlignment();

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

		gender.setPreferredSize(new Dimension(150, 100));
		gender.setFont(f);

		rollOrInput.add(roll);
		rollOrInput.add(input);

		roll.setPreferredSize(new Dimension(100, 100));
		roll.setFont(f);
		roll.setBackground(Color.LIGHT_GRAY);

		input.setPreferredSize(new Dimension(140, 100));
		input.setFont(f);
		input.setBackground(Color.LIGHT_GRAY);

		ageRoll.setPreferredSize(new Dimension(150, 100));
		ageRoll.setFont(f);

		ageInput.setPreferredSize(new Dimension(200, 100));
		ageInput.setFont(f);

		ageRange.add(intuitive);
		ageRange.add(selfTaught);
		ageRange.add(trained);
		
		ageLabel.setPreferredSize(new Dimension(100, 100));
		ageLabel.setFont(f);

		intuitive.setPreferredSize(new Dimension(350, 100));
		intuitive.setFont(f);

		selfTaught.setPreferredSize(new Dimension(400, 100));
		selfTaught.setFont(f);

		trained.setPreferredSize(new Dimension(350, 100));
		trained.setFont(f);

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

		this.add(container2);
		container2.add(raceLabel);
		container2.add(race);
		container2.add(size);
		container2.add(gender);
		container2.add(roll);
		container2.add(input);

		//Checks to see if the roll JRadioButton has been selected
		roll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (roll.isSelected()) {
					container2.remove(ageInput);
					container2.add(intuitive);
					container2.add(selfTaught);
					container2.add(trained);
					container2.add(ageRoll);
					reference.validate();
					reference.repaint();
				}
				//Checks if the Age JButton has been pressed
				ageRoll.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						age = getAgeRoll(intuitive.isSelected(), selfTaught.isSelected(), trained.isSelected());
						container2.add(ageLabel);
						container2.add(ageInput);
						container2.remove(roll);
						container2.remove(input);
						container2.remove(intuitive);
						container2.remove(selfTaught);
						container2.remove(trained);
						container2.remove(ageRoll);
						ageInput.setText(String.valueOf(age));
						reference.validate();
						reference.repaint();
					}

				});

			}
		});

		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (input.isSelected()) {
					container2.remove(intuitive);
					container2.remove(selfTaught);
					container2.remove(trained);
					container2.remove(ageRoll);
					container2.add(ageInput);
					reference.validate();
					reference.repaint();
				}
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
				result = setAgeResult(Races.DWARF.getIntuitiveDiceAmount(), Races.DWARF.getIntuitiveDiceSides())
						+ Races.DWARF.getBaseAge();
				System.out.println(result);
			} else if (selfTaught) {
				result = setAgeResult(Races.DWARF.getSelfTaughtDiceAmount(), Races.DWARF.getSelfTaughtDiceSides())
						+ Races.DWARF.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.DWARF.getTrainedDiceAmount(), Races.DWARF.getTrainedDiceSides())
						+ Races.DWARF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.ELF)) {
			if (intuitive) {
				result = setAgeResult(Races.ELF.getIntuitiveDiceAmount(), Races.ELF.getIntuitiveDiceSides())
						+ Races.ELF.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.ELF.getSelfTaughtDiceAmount(), Races.ELF.getSelfTaughtDiceSides())
						+ Races.ELF.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.ELF.getTrainedDiceAmount(), Races.ELF.getTrainedDiceSides())
						+ Races.ELF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.GNOME)) {
			if (intuitive) {
				result = setAgeResult(Races.GNOME.getIntuitiveDiceAmount(), Races.GNOME.getIntuitiveDiceSides())
						+ Races.GNOME.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.GNOME.getSelfTaughtDiceAmount(), Races.GNOME.getSelfTaughtDiceSides())
						+ Races.GNOME.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.GNOME.getTrainedDiceAmount(), Races.GNOME.getTrainedDiceSides())
						+ Races.GNOME.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFELF)) {
			if (intuitive) {
				result = setAgeResult(Races.HALFELF.getIntuitiveDiceAmount(), Races.HALFELF.getIntuitiveDiceSides())
						+ Races.HALFELF.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.HALFELF.getSelfTaughtDiceAmount(), Races.HALFELF.getSelfTaughtDiceSides())
						+ Races.HALFELF.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.HALFELF.getTrainedDiceAmount(), Races.HALFELF.getTrainedDiceSides())
						+ Races.HALFELF.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFORC)) {
			if (intuitive) {
				result = setAgeResult(Races.HALFORC.getIntuitiveDiceAmount(), Races.HALFORC.getIntuitiveDiceSides())
						+ Races.HALFORC.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.HALFORC.getSelfTaughtDiceAmount(), Races.HALFORC.getSelfTaughtDiceSides())
						+ Races.HALFORC.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.HALFORC.getTrainedDiceAmount(), Races.HALFORC.getTrainedDiceSides())
						+ Races.HALFORC.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HALFLING)) {
			if (intuitive) {
				result = setAgeResult(Races.HALFLING.getIntuitiveDiceAmount(), Races.HALFLING.getIntuitiveDiceSides())
						+ Races.HALFLING.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.HALFLING.getSelfTaughtDiceAmount(), Races.HALFLING.getSelfTaughtDiceSides())
						+ Races.HALFLING.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.HALFLING.getTrainedDiceAmount(), Races.HALFLING.getTrainedDiceSides())
						+ Races.HALFLING.getBaseAge();
			}
		} else if (dropDownText.equals(Races.HUMAN)) {
			if (intuitive) {
				result = setAgeResult(Races.HUMAN.getIntuitiveDiceAmount(), Races.HUMAN.getIntuitiveDiceSides())
						+ Races.HUMAN.getBaseAge();
			} else if (selfTaught) {
				result = setAgeResult(Races.HUMAN.getSelfTaughtDiceAmount(), Races.HUMAN.getSelfTaughtDiceSides())
						+ Races.HUMAN.getBaseAge();
			} else if (trained) {
				result = setAgeResult(Races.HUMAN.getTrainedDiceAmount(), Races.HUMAN.getTrainedDiceSides())
						+ Races.HUMAN.getBaseAge();
			}
		}

		return result;
	}

	public int setAgeResult(int diceAmount, int diceSides) {
		int result = 0;
		for (int i = 0; i < diceAmount; i++) {
			result += diceBag.rollDice(diceSides);
		}
		return result;
	}

}
