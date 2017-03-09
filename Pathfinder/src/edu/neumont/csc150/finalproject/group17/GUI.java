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
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JPanel {

	JFrame frame = new JFrame("Pathfinder Character Sheet");

	JPanel container = new JPanel();
	JPanel agePanel = new JPanel();
	JPanel heightPanel = new JPanel();
	JPanel weightPanel = new JPanel();
	JPanel hairPanel = new JPanel();
	JPanel eyePanel = new JPanel();
	JPanel abilityPanel = new JPanel();

	JTextField characterName = new JTextField("Character Name");
	JTextField alignment = new JTextField("Alignment");
	JTextField playerName = new JTextField("Player Name");
	JTextField deity = new JTextField("Deity");
	JTextField homeland = new JTextField("Homeland");
	JTextField ageInput = new JTextField("Age");
	JTextField heightInput = new JTextField("Height");
	JTextField weightInput = new JTextField("Weight");
	JTextField strengthInput = new JTextField();
	JTextField dexterityInput = new JTextField();
	JTextField constitutionInput = new JTextField();
	JTextField intelligenceInput = new JTextField();
	JTextField wisdomInput = new JTextField();
	JTextField charismaInput = new JTextField();
	JTextField temporaryStrengthInput = new JTextField();
	JTextField temporaryDexterityInput = new JTextField();
	JTextField temporaryConstitutionInput = new JTextField();
	JTextField temporaryIntelligenceInput = new JTextField();
	JTextField temporaryWisdomInput = new JTextField();
	JTextField temporaryCharismaInput = new JTextField();

	JComboBox<String> gender = new JComboBox<>(new String[] { "Female", "Male" });
	JComboBox<Enum> race = new JComboBox<>(Races.values());
	JComboBox<Integer> multiClass = new JComboBox<>(new Integer[] { 1, 2, 3, 4 });
	JComboBox<Colors> hairColor = new JComboBox<>(Colors.values());
	JComboBox<Colors> eyeColor = new JComboBox<>(Colors.values());

	JLabel raceLabel = new JLabel("Race: ");
	JLabel size = new JLabel("Size: " + getCharacterSize());
	JLabel multiClassLabel = new JLabel("<html>Amount of <br>Classes</html>");
	JLabel ageLabel = new JLabel("Age");
	JLabel heightLabel = new JLabel("Height");
	JLabel weightLabel = new JLabel("Weight");
	JLabel genderLabel = new JLabel("Gender");
	JLabel hairLabel = new JLabel("Hair Color");
	JLabel eyeLabel = new JLabel("Eye Color");
	JLabel strengthLabel = new JLabel("<html>Str<br>Strength</html>");
	JLabel dexterityLabel = new JLabel("<html>Dex<br>Dexterity</html>");
	JLabel constitutionLabel = new JLabel("<html>Con<br>Constitution</html>");
	JLabel intelligenceLabel = new JLabel("<html>Int<br>Intelligence</html>");
	JLabel wisdomLabel = new JLabel("<html>Wis<br>Wisdom</html>");
	JLabel charismaLabel = new JLabel("<html>Cha<br>Charisma</html>");
	JLabel fantasyPointsLabel = new JLabel();
	JLabel freePointsLavel = new JLabel();

	JButton ageRoll = new JButton("Age");
	JButton heightRoll = new JButton("Height");
	JButton weightRoll = new JButton("Weight");
	JButton strengthRoll = new JButton("Strength");
	JButton dexterityRoll = new JButton("Dexterity");
	JButton constitutionRoll = new JButton("Constitution");
	JButton intelligenceRoll = new JButton("Intelligence");
	JButton wisdomRoll = new JButton("Wisdom");
	JButton charismaRoll = new JButton("Charisma");

	JRadioButton ageRollSelection = new JRadioButton("Roll Age");
	JRadioButton ageInputSelection = new JRadioButton("Input Age");
	JRadioButton intuitive = new JRadioButton("Intuitive (Young)");
	JRadioButton selfTaught = new JRadioButton("Self-Taught (Middle)");
	JRadioButton trained = new JRadioButton("Trained (Older)");
	JRadioButton heightRollSelection = new JRadioButton("Roll Height");
	JRadioButton heightInputSelection = new JRadioButton("Input Height");
	JRadioButton weightRollSelection = new JRadioButton("Roll Weight");
	JRadioButton weightInputSelection = new JRadioButton("Input Weight");
	JRadioButton abilityInput = new JRadioButton("Input Ability Scores");
	JRadioButton abilityRoll = new JRadioButton("Roll Ability Scores");
	JRadioButton lowFantasy = new JRadioButton("Low Fantasy: 10 points");
	JRadioButton standardFantasy = new JRadioButton("Standard Fantasy: 15 points");
	JRadioButton highFantasy = new JRadioButton("High Fantasy: 20 points");
	JRadioButton epicFantasy = new JRadioButton("Epic Fantasy: 25 points");

	ButtonGroup ageRollOrInput = new ButtonGroup();
	ButtonGroup ageRange = new ButtonGroup();
	ButtonGroup heightRollOrInput = new ButtonGroup();
	ButtonGroup weightRollOrInput = new ButtonGroup();
	ButtonGroup abilitySelection = new ButtonGroup();
	ButtonGroup fantasySelection = new ButtonGroup();

	JSpinner strengthSpinner = new JSpinner();
	JSpinner dexteritySpinner = new JSpinner();
	JSpinner constitutionSpinner = new JSpinner();
	JSpinner intelligenceSpinner = new JSpinner();
	JSpinner wisdomSpinner = new JSpinner();
	JSpinner charismaSpinner = new JSpinner();

	// Classes[] classArray = new Classes[] { new Classes(), new Classes(), new
	// Classes(), new Classes() };
	Integer[] levelRange = new Integer[20];

	JLabel[] classLabel = new JLabel[] { new JLabel("Character Class"), new JLabel("Character Class"), new JLabel("Character Class"),
			new JLabel("Character Class"), };
	JLabel[] levelLabel = new JLabel[] { new JLabel("Character Level"), new JLabel("Character Level"), new JLabel("Character Level"),
			new JLabel("Character Level"), };

	JComboBox[] characterClass = new JComboBox[] { new JComboBox<>(Classes.values()), new JComboBox<>(Classes.values()),
			new JComboBox<>(Classes.values()), new JComboBox<>(Classes.values())};
	JComboBox[] characterLevel;

	Die diceBag = new Die();

	// ScrollBarPanel scrollBar = new ScrollBarPanel();

	Font f = new Font("Times New Roman", Font.BOLD, 40);

	int age;
	int height;
	int weight;
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	int fantasyPoints;
	int freePoints;

	public static void main(String[] args) {
		GUI nonStaticHelper = new GUI();
		nonStaticHelper.createAndShowCharacterSheet();
	}

	public void createAndShowCharacterSheet() {
		
		for (int i = 0; i < levelRange.length; i++) {
			levelRange[i] = i + 1;
		}
		
		characterLevel = new JComboBox[] { new JComboBox<>(levelRange), new JComboBox<>(levelRange),
				new JComboBox<>(levelRange), new JComboBox<>(levelRange)};

		frame.setPreferredSize(new Dimension(3000, 2000));

		JPanel reference = this;

		container.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		container.setPreferredSize(new Dimension(2300, 120));

		agePanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		agePanel.setPreferredSize(new Dimension(2400, 120));

		heightPanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		heightPanel.setPreferredSize(new Dimension(1200, 120));

		weightPanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		weightPanel.setPreferredSize(new Dimension(850, 120));

		hairPanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		hairPanel.setPreferredSize(new Dimension(900, 120));

		eyePanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		eyePanel.setPreferredSize(new Dimension(900, 120));

		abilityPanel.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		abilityPanel.setPreferredSize(new Dimension(2400, 420));

		characterName.setPreferredSize(new Dimension(1050, 100));
		characterName.setFont(f);

		alignment.setPreferredSize(new Dimension(400, 100));
		alignment.setFont(f);

		playerName.setPreferredSize(new Dimension(500, 100));
		playerName.setFont(f);

		multiClassLabel.setPreferredSize(new Dimension(200, 100));
		multiClassLabel
				.setForeground(new Color(Colors.WHITE.getColorR(), Colors.WHITE.getColorG(), Colors.WHITE.getColorB()));
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
		ageRollSelection.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));

		ageInputSelection.setPreferredSize(new Dimension(240, 100));
		ageInputSelection.setFont(f);
		ageInputSelection.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));

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

		weightRollOrInput.add(weightInputSelection);
		weightRollOrInput.add(weightRollSelection);

		weightInputSelection.setPreferredSize(new Dimension(300, 100));
		weightInputSelection.setFont(f);

		weightRollSelection.setPreferredSize(new Dimension(300, 100));
		weightRollSelection.setFont(f);

		weightRoll.setPreferredSize(new Dimension(200, 100));
		weightRoll.setFont(f);

		weightInput.setPreferredSize(new Dimension(150, 100));
		weightInput.setFont(f);

		weightLabel.setPreferredSize(new Dimension(150, 100));
		weightLabel.setFont(f);

		hairLabel.setPreferredSize(new Dimension(200, 100));
		hairLabel.setFont(f);

		hairColor.setPreferredSize(new Dimension(400, 100));
		hairColor.setFont(f);

		eyeLabel.setPreferredSize(new Dimension(200, 100));
		eyeLabel.setFont(f);

		eyeColor.setPreferredSize(new Dimension(400, 100));
		eyeColor.setFont(f);

		strengthSpinner.setValue(10);
		strengthSpinner.setPreferredSize(new Dimension(100, 100));
		strengthSpinner.setFont(f);

		dexteritySpinner.setValue(10);
		dexteritySpinner.setPreferredSize(new Dimension(100, 100));
		dexteritySpinner.setFont(f);

		constitutionSpinner.setValue(10);
		constitutionSpinner.setPreferredSize(new Dimension(100, 100));
		constitutionSpinner.setFont(f);

		intelligenceSpinner.setValue(10);
		intelligenceSpinner.setPreferredSize(new Dimension(100, 100));
		intelligenceSpinner.setFont(f);

		wisdomSpinner.setValue(10);
		wisdomSpinner.setPreferredSize(new Dimension(100, 100));
		wisdomSpinner.setFont(f);

		charismaSpinner.setValue(10);
		charismaSpinner.setPreferredSize(new Dimension(100, 100));
		charismaSpinner.setFont(f);

		strengthLabel.setPreferredSize(new Dimension(200, 200));
		strengthLabel.setFont(f);

		dexterityLabel.setPreferredSize(new Dimension(200, 200));
		dexterityLabel.setFont(f);

		constitutionLabel.setPreferredSize(new Dimension(200, 200));
		constitutionLabel.setFont(f);

		intelligenceLabel.setPreferredSize(new Dimension(200, 200));
		intelligenceLabel.setFont(f);

		wisdomLabel.setPreferredSize(new Dimension(200, 200));
		wisdomLabel.setFont(f);

		charismaLabel.setPreferredSize(new Dimension(200, 200));
		charismaLabel.setFont(f);

		strengthInput.setPreferredSize(new Dimension(100, 100));
		strengthInput.setFont(f);

		dexterityInput.setPreferredSize(new Dimension(100, 100));
		dexterityInput.setFont(f);

		constitutionInput.setPreferredSize(new Dimension(100, 100));
		constitutionInput.setFont(f);

		intelligenceInput.setPreferredSize(new Dimension(100, 100));
		intelligenceInput.setFont(f);

		wisdomInput.setPreferredSize(new Dimension(100, 100));
		wisdomInput.setFont(f);

		charismaInput.setPreferredSize(new Dimension(100, 100));
		charismaInput.setFont(f);

		abilitySelection.add(abilityRoll);
		abilitySelection.add(abilityInput);

		abilityRoll.setPreferredSize(new Dimension(400, 100));
		abilityRoll.setFont(f);

		abilityInput.setPreferredSize(new Dimension(400, 100));
		abilityInput.setFont(f);

		fantasySelection.add(lowFantasy);
		fantasySelection.add(standardFantasy);
		fantasySelection.add(highFantasy);
		fantasySelection.add(epicFantasy);

		lowFantasy.setPreferredSize(new Dimension(300, 100));
		lowFantasy.setFont(f);

		standardFantasy.setPreferredSize(new Dimension(300, 100));
		standardFantasy.setFont(f);

		highFantasy.setPreferredSize(new Dimension(300, 100));
		highFantasy.setFont(f);

		epicFantasy.setPreferredSize(new Dimension(300, 100));
		epicFantasy.setFont(f);

		// scrollBar.setPreferredSize(new Dimension(20, 500));

		frame.add(this);
		this.add(container);
		// this.add(scrollBar, BorderLayout.EAST);
		container.add(characterName);
		container.add(alignment);
		container.add(playerName);
		container.add(multiClassLabel);
		container.add(multiClass);

		// for (int i = 0; i < classArray.length; i++) {
		// reference.add(classArray[i]);
		// classArray[i].setPreferredSize(new Dimension(1500, 100));
		// if (i > 0) {
		// classArray[i].setVisible(false);
		// }
		// classArray[i].setBackground(new Color(Colors.LIGHTGRAY.getColorR(),
		// Colors.LIGHTGRAY.getColorG(),
		// Colors.LIGHTGRAY.getColorB()));
		// }

		multiClass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = 4;
				// for (int i = 0; i < (int) multiClass.getSelectedItem(); i++)
				// {
				//
				// classArray[i].setVisible(true);
				//
				// while ((int) multiClass.getSelectedItem() != amount
				// && amount > (int) multiClass.getSelectedItem()) {
				// amount--;
				// classArray[amount].setVisible(false);
				// }
				// reference.validate();
				// }
				Integer multiClasses = (Integer) multiClass.getSelectedItem();
				for (int i = 0; i < multiClasses; i++) {
					
					characterClass[i].setPreferredSize(new Dimension(1000, 100));
					characterClass[i].setFont(f);
					
					characterLevel[i].setPreferredSize(new Dimension(500, 100));
					characterLevel[i].setFont(f);
					
					classLabel[i].setPreferredSize(new Dimension(300, 100));
					classLabel[i].setFont(f);
					
					levelLabel[i].setPreferredSize(new Dimension(300, 100));
					levelLabel[i].setFont(f);
					
					container.add(classLabel[i]);
					container.add(characterClass[i]);
					container.add(levelLabel[i]);
					container.add(characterLevel[i]);
				}

				while (multiClasses != amount && amount > multiClasses) {
					amount--;
					container.remove(classLabel[amount]);
					container.remove(characterClass[amount]);
					container.remove(characterLevel[amount]);
					container.remove(levelLabel[amount]);
				}
				container.setPreferredSize(new Dimension(2400, 120 + (100 *amount)));
				reference.validate();
				reference.repaint();
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
		this.add(weightPanel);
		this.add(hairPanel);
		this.add(eyePanel);
		this.add(abilityPanel);
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
						agePanel.setPreferredSize(new Dimension(2400, 120));
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
				ageInput.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						agePanel.add(ageLabel);
						agePanel.remove(ageInputSelection);
						agePanel.remove(ageRollSelection);
						reference.validate();
						reference.repaint();
					}
				});
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
						heightInput.setText(String.valueOf(height / 12 + "'" + height % 12));
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

		weightPanel.add(weightRollSelection);
		weightPanel.add(weightInputSelection);

		weightRollSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (weightRollSelection.isSelected()) {
					weightPanel.add(weightRoll);
					weightPanel.remove(weightInput);
					reference.validate();
					reference.repaint();
				}
				weightRoll.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						weight = getWeightRoll();
						weightPanel.add(weightLabel);
						weightPanel.add(weightInput);
						weightPanel.remove(weightInputSelection);
						weightPanel.remove(weightRoll);
						weightPanel.remove(weightRollSelection);
						weightInput.setText(String.valueOf(weight));
						reference.validate();
						reference.repaint();
					}
				});
			}
		});

		weightInputSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				weightPanel.add(weightInput);
				weightPanel.remove(weightRoll);
				reference.validate();
				reference.repaint();
			}
		});

		race.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				agePanel.remove(ageInput);
				agePanel.remove(ageLabel);
				agePanel.remove(ageRoll);
				agePanel.remove(intuitive);
				agePanel.remove(selfTaught);
				agePanel.remove(trained);
				agePanel.add(ageRollSelection);
				agePanel.add(ageInputSelection);
				agePanel.setPreferredSize(new Dimension(2400, 120));
				heightPanel.remove(heightRoll);
				heightPanel.remove(heightInput);
				heightPanel.remove(heightLabel);
				heightPanel.add(heightRollSelection);
				heightPanel.add(heightInputSelection);
				weightPanel.remove(weightRoll);
				weightPanel.remove(weightInput);
				weightPanel.remove(weightLabel);
				weightPanel.add(weightRollSelection);
				weightPanel.add(weightInputSelection);
				reference.validate();
				reference.repaint();

			}
		});

		gender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heightPanel.remove(heightRoll);
				heightPanel.remove(heightInput);
				heightPanel.remove(heightLabel);
				heightPanel.add(heightRollSelection);
				heightPanel.add(heightInputSelection);
				weightPanel.remove(weightRoll);
				weightPanel.remove(weightInput);
				weightPanel.remove(weightLabel);
				weightPanel.add(weightRollSelection);
				weightPanel.add(weightInputSelection);
				reference.validate();
				reference.repaint();

			}
		});

		hairPanel.add(hairLabel);
		hairPanel.add(hairColor);

		hairColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Colors currentColor = (Colors) hairColor.getSelectedItem();
				hairPanel.setBackground(
						new Color(currentColor.getColorR(), currentColor.getColorG(), currentColor.getColorB()));
			}
		});

		eyePanel.add(eyeLabel);
		eyePanel.add(eyeColor);

		eyeColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Colors currentColor = (Colors) eyeColor.getSelectedItem();
				eyePanel.setBackground(
						new Color(currentColor.getColorR(), currentColor.getColorG(), currentColor.getColorB()));

			}
		});

		abilityPanel.add(abilityInput);
		abilityPanel.add(abilityRoll);

		reference.setBackground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));
		reference.setForeground(
				new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(), Colors.LIGHTGRAY.getColorB()));

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
				result = setRollResult(Races.HALFLING.getSelfTaughtDiceAmount(),
						Races.HALFLING.getSelfTaughtDiceSides()) + Races.HALFLING.getBaseAge();
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
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getFemaleHeightDiceSides())
						+ Races.DWARF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getMaleHeightDiceSides())
						+ Races.DWARF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.ELF)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.ELF.getHeightDiceAmount(), Races.ELF.getFemaleHeightDiceSides())
						+ Races.ELF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.DWARF.getHeightDiceAmount(), Races.DWARF.getMaleHeightDiceSides())
						+ Races.ELF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.GNOME)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.GNOME.getHeightDiceAmount(), Races.GNOME.getFemaleHeightDiceSides())
						+ Races.GNOME.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.GNOME.getHeightDiceAmount(), Races.GNOME.getMaleHeightDiceSides())
						+ Races.GNOME.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFELF)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFELF.getHeightDiceAmount(), Races.HALFELF.getFemaleHeightDiceSides())
						+ Races.HALFELF.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFELF.getHeightDiceAmount(), Races.HALFELF.getMaleHeightDiceSides())
						+ Races.HALFELF.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFORC)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFORC.getHeightDiceAmount(), Races.HALFORC.getFemaleHeightDiceSides())
						+ Races.HALFORC.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFORC.getHeightDiceAmount(), Races.HALFORC.getMaleHeightDiceSides())
						+ Races.HALFORC.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HALFLING)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HALFLING.getHeightDiceAmount(), Races.HALFLING.getFemaleHeightDiceSides())
						+ Races.HALFLING.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HALFLING.getHeightDiceAmount(), Races.HALFLING.getMaleHeightDiceSides())
						+ Races.HALFLING.getBaseMaleHeight();
			}
		} else if (racesDropDownText.equals(Races.HUMAN)) {
			if (stringDropDownText.equals("Female")) {
				result = setRollResult(Races.HUMAN.getHeightDiceAmount(), Races.HUMAN.getFemaleHeightDiceSides())
						+ Races.HUMAN.getBaseFemaleHeight();
			} else if (stringDropDownText.equals("Male")) {
				result = setRollResult(Races.HUMAN.getHeightDiceAmount(), Races.HUMAN.getMaleHeightDiceSides())
						+ Races.HUMAN.getBaseMaleHeight();
			}
		}

		return result;
	}

	public int getWeightRoll() {
		int result = 0;
		Races racesDropDownText = (Races) race.getSelectedItem();
		String stringDropDownText = (String) gender.getSelectedItem();

		if (racesDropDownText.equals(Races.DWARF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getFemaleWeightDiceSides())
						+ Races.DWARF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getMaleWeightDiceSides())
						+ Races.DWARF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.ELF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.ELF.getWeightDiceAmount(), Races.ELF.getFemaleWeightDiceSides())
						+ Races.ELF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getMaleWeightDiceSides())
						+ Races.ELF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.GNOME)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.GNOME.getWeightDiceAmount(), Races.GNOME.getFemaleWeightDiceSides())
						+ Races.GNOME.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.GNOME.getWeightDiceAmount(), Races.GNOME.getMaleWeightDiceSides())
						+ Races.GNOME.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFELF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFELF.getWeightDiceAmount(), Races.HALFELF.getFemaleWeightDiceSides())
						+ Races.HALFELF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFELF.getWeightDiceAmount(), Races.HALFELF.getMaleWeightDiceSides())
						+ Races.HALFELF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFORC)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFORC.getWeightDiceAmount(), Races.HALFORC.getFemaleWeightDiceSides())
						+ Races.HALFORC.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFORC.getWeightDiceAmount(), Races.HALFORC.getMaleWeightDiceSides())
						+ Races.HALFORC.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFLING)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFLING.getWeightDiceAmount(), Races.HALFLING.getFemaleWeightDiceSides())
						+ Races.HALFLING.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFLING.getWeightDiceAmount(), Races.HALFLING.getMaleWeightDiceSides())
						+ Races.HALFLING.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HUMAN)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HUMAN.getWeightDiceAmount(), Races.HUMAN.getFemaleWeightDiceSides())
						+ Races.HUMAN.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HUMAN.getWeightDiceAmount(), Races.HUMAN.getMaleWeightDiceSides())
						+ Races.HUMAN.getBaseMaleWeight());
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
