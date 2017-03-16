package edu.neumont.csc150.finalproject.group17;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JPanel {

	JFrame frame = new JFrame("Pathfinder Character Sheet");

	JPanel container = new JPanel();
	JPanel agePanel = new JPanel();
	JPanel heightPanel = new JPanel();
	JPanel weightPanel = new JPanel();
	JPanel hairPanel = new JPanel();
	JPanel eyePanel = new JPanel();
	JPanel abilitySelectionPanel = new JPanel();
	JPanel physicalAbilityPanel = new JPanel();
	JPanel mentalAbilityPanel = new JPanel();
	JPanel reference = this;

	JTextField characterName = new JTextField("Character Name");
	JTextField alignment = new JTextField("Alignment");
	JTextField playerName = new JTextField("Player Name");
	JTextField deity = new JTextField("Deity");
	JTextField homeland = new JTextField("Homeland");
	JTextField ageInput = new JTextField("Age");
	JTextField heightInput = new JTextField("Height");
	JTextField weightInput = new JTextField("Weight");
	JTextField strengthInput = new JTextField(String.valueOf(10));
	JTextField dexterityInput = new JTextField(String.valueOf(10));
	JTextField constitutionInput = new JTextField(String.valueOf(10));
	JTextField intelligenceInput = new JTextField(String.valueOf(10));
	JTextField wisdomInput = new JTextField(String.valueOf(10));
	JTextField charismaInput = new JTextField(String.valueOf(10));
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
	JLabel strengthLabel = new JLabel("<html><span style=\"font-size: 60px;\">Str</span><br>Strength</html>");
	JLabel dexterityLabel = new JLabel("<html><span style=\"font-size: 60px;\">Dex</span><br>Dexterity</html>");
	JLabel constitutionLabel = new JLabel("<html><span style=\"font-size: 60px;\">Con</span><br>Constitution</html>");
	JLabel intelligenceLabel = new JLabel("<html><span style=\"font-size: 60px;\">Int</span><br>Intelligence</html>");
	JLabel wisdomLabel = new JLabel("<html><span style=\"font-size: 60px;\">Wis</span><br>Wisdom</html>");
	JLabel charismaLabel = new JLabel("<html><span style=\"font-size: 60px;\">Cha</span><br>Charisma</html>");
	JLabel temporaryStrengthLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel temporaryDexterityLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel temporaryConstitutionLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel temporaryIntelligenceLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel temporaryWisdomLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel temporaryCharismaLabel = new JLabel("<html>Temporary<br>Score</html>");
	JLabel fantasyPointsLabel = new JLabel("");
	JLabel strengthModifierLabel = new JLabel("");
	JLabel dexterityModifierLabel = new JLabel("");
	JLabel constitutionModifierLabel = new JLabel("");
	JLabel intelligenceModifierLabel = new JLabel("");
	JLabel wisdomModifierLabel = new JLabel("");
	JLabel charismaModifierLabel = new JLabel("");
	JLabel temporaryStrengthModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");
	JLabel temporaryDexterityModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");
	JLabel temporaryConstitutionModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");
	JLabel temporaryIntelligenceModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");
	JLabel temporaryWisdomModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");
	JLabel temporaryCharismaModifierLabel = new JLabel("<html>Temporary modifier:<br>0</html>");

	JButton ageRoll = new JButton("Age");
	JButton heightRoll = new JButton("Height");
	JButton weightRoll = new JButton("Weight");
	JButton strengthRoll = new JButton("Strength");
	JButton dexterityRoll = new JButton("Dexterity");
	JButton constitutionRoll = new JButton("Constitution");
	JButton intelligenceRoll = new JButton("Intelligence");
	JButton wisdomRoll = new JButton("Wisdom");
	JButton charismaRoll = new JButton("Charisma");
	JButton saveProgress = new JButton("Save");
	JButton saveAbility = new JButton("Save Scores");

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

	Integer[] levelRange = new Integer[20];

	JLabel[] classLabel = new JLabel[] { new JLabel("Character Class"), new JLabel("Character Class"),
			new JLabel("Character Class"), new JLabel("Character Class"), };
	JLabel[] levelLabel = new JLabel[] { new JLabel("Character Level"), new JLabel("Character Level"),
			new JLabel("Character Level"), new JLabel("Character Level"), };

	JComboBox[] characterClass = new JComboBox[] { new JComboBox<>(Classes.values()), new JComboBox<>(Classes.values()),
			new JComboBox<>(Classes.values()), new JComboBox<>(Classes.values()) };
	JComboBox[] classLevel;

	JScrollPane scrollBar;

	Die diceBag = new Die();

	Font f = new Font("Times New Roman", Font.BOLD, 40);

	Color lightGray = new Color(Colors.LIGHTGRAY.getColorR(), Colors.LIGHTGRAY.getColorG(),
			Colors.LIGHTGRAY.getColorB());
	Color black = new Color(Colors.BLACK.getColorR(), Colors.BLACK.getColorG(), Colors.BLACK.getColorB());
	Color white = new Color(Colors.WHITE.getColorR(), Colors.WHITE.getColorG(), Colors.WHITE.getColorB());

	int[] abilityScore = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
	int[] abilityCost = new int[] { -4, -2, -1, 0, 1, 2, 3, 5, 7, 10, 13, 17 };

	int age;
	int height;
	int weight;
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	int strengthModifier;
	int dexterityModifier;
	int constitutionModifier;
	int intelligenceModifier;
	int wisdomModifier;
	int charismaModifier;
	int temporaryStrengthModifier;
	int temporaryDexterityModifier;
	int temporaryConstitutionModifier;
	int temporaryIntelligenceModifier;
	int temporaryWisdomModifier;
	int temporaryCharismaModifier;
	int fantasyPoints;
	int characterLevel;
	int strengthRollValue;
	int dexterityRollValue;
	int constitutionRollValue;
	int intelligenceRollValue;
	int wisdomRollValue;
	int charismaRollValue;
	int strengthPoints;
	int dexterityPoints;
	int constitutionPoints;
	int intelligencePoints;
	int wisdomPoints;
	int charismaPoints;
	int totalPoints;
	final int abilityScoreBaseValue = 10;

	boolean isRolling;
	boolean isInputting;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		GUI nonStaticHelper = new GUI();
		// @@@@ File reading
		FileInputStream fileIn = new FileInputStream("characterSheet.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		in.close();
		fileIn.close();
		nonStaticHelper.createAndShowCharacterSheet();
	}

	// @@@@ Javadoc style documentation on an entire class (class and all its
	// methods).

	/**
	 * Holds the method calls to create and show the character sheet
	 */
	public void createAndShowCharacterSheet() {

		for (int i = 0; i < levelRange.length; i++) {
			levelRange[i] = i + 1;
		}

		setPanels();

		classLevel = new JComboBox[] { new JComboBox<>(levelRange), new JComboBox<>(levelRange),
				new JComboBox<>(levelRange), new JComboBox<>(levelRange) };

		setSwingCharacteristics();

		scrollBar = new JScrollPane(this);
		scrollBar.getVerticalScrollBar().setUnitIncrement(20);
		frame.add(scrollBar);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(container);
		container.add(characterName);
		container.add(alignment);
		container.add(playerName);
		container.add(multiClassLabel);
		container.add(multiClass);

		multiClass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				multiClassActionPerform();
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
		this.add(abilitySelectionPanel);
		this.add(physicalAbilityPanel);
		this.add(mentalAbilityPanel);
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
				ageRollSelectionActionPerform();

			}
		});

		ageInputSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ageInputSelectionActionPerform();
			}
		});

		heightPanel.add(heightRollSelection);
		heightPanel.add(heightInputSelection);

		heightRollSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heightRollSelectionActionPerform();
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
				weightRollSelectionActionPerform();
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
				raceActionPerform();
			}
		});

		gender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				genderActionPerform();
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

		abilitySelectionPanel.add(abilityInput);
		abilitySelectionPanel.add(abilityRoll);

		abilitySelection();

		abilitySpinnerListener();

		saveAbilityListener();

		reference.setBackground(lightGray);
		reference.setForeground(lightGray);

		this.add(saveProgress);

		saveProgress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveCharacterInformation();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void saveAbilityListener() {
		saveAbility.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reference.remove(abilitySelectionPanel);
				physicalAbilityPanel.removeAll();
				mentalAbilityPanel.removeAll();
				reference.remove(saveAbility);

				physicalAbilityPanel.add(strengthLabel);
				physicalAbilityPanel.add(strengthInput);
				physicalAbilityPanel.add(strengthModifierLabel);
				physicalAbilityPanel.add(temporaryStrengthLabel);
				physicalAbilityPanel.add(temporaryStrengthInput);
				physicalAbilityPanel.add(temporaryStrengthModifierLabel);

				physicalAbilityPanel.add(dexterityLabel);
				physicalAbilityPanel.add(dexterityInput);
				physicalAbilityPanel.add(dexterityModifierLabel);
				physicalAbilityPanel.add(temporaryDexterityLabel);
				physicalAbilityPanel.add(temporaryDexterityInput);
				physicalAbilityPanel.add(temporaryDexterityModifierLabel);

				physicalAbilityPanel.add(constitutionLabel);
				physicalAbilityPanel.add(constitutionInput);
				physicalAbilityPanel.add(constitutionModifierLabel);
				physicalAbilityPanel.add(temporaryConstitutionLabel);
				physicalAbilityPanel.add(temporaryConstitutionInput);
				physicalAbilityPanel.add(temporaryConstitutionModifierLabel);

				mentalAbilityPanel.add(intelligenceLabel);
				mentalAbilityPanel.add(intelligenceInput);
				mentalAbilityPanel.add(intelligenceModifierLabel);
				mentalAbilityPanel.add(temporaryIntelligenceLabel);
				mentalAbilityPanel.add(temporaryIntelligenceInput);
				mentalAbilityPanel.add(temporaryIntelligenceModifierLabel);

				mentalAbilityPanel.add(wisdomLabel);
				mentalAbilityPanel.add(wisdomInput);
				mentalAbilityPanel.add(wisdomModifierLabel);
				mentalAbilityPanel.add(temporaryWisdomLabel);
				mentalAbilityPanel.add(temporaryWisdomInput);
				mentalAbilityPanel.add(temporaryWisdomModifierLabel);

				mentalAbilityPanel.add(charismaLabel);
				mentalAbilityPanel.add(charismaInput);
				mentalAbilityPanel.add(charismaModifierLabel);
				mentalAbilityPanel.add(temporaryCharismaLabel);
				mentalAbilityPanel.add(temporaryCharismaInput);
				mentalAbilityPanel.add(temporaryCharismaModifierLabel);

				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();

			}

		});

	}

	private void setRacialAbilityScores(boolean isRolling, boolean isInputting) {
		Races dropDownText = (Races) race.getSelectedItem();
		strength = 0;
		dexterity = 0;
		constitution = 0;
		intelligence = 0;
		wisdom = 0;
		charisma = 0;
		if (isRolling) {
			strength = strengthRollValue;
			dexterity = dexterityRollValue;
			constitution = constitutionRollValue;
			intelligence = intelligenceRollValue;
			wisdom = wisdomRollValue;
			charisma = charismaRollValue;
			if (dropDownText.equals(Races.DWARF)) {
				strength += Races.DWARF.getStrength();
				dexterity += Races.DWARF.getDexterity();
				constitution += Races.DWARF.getConstitution();
				intelligence += Races.DWARF.getIntelligence();
				wisdom += Races.DWARF.getWisdom();
				charisma += Races.DWARF.getCharisma();
			} else if (dropDownText.equals(Races.ELF)) {
				strength += Races.ELF.getStrength();
				dexterity += Races.ELF.getDexterity();
				constitution += Races.ELF.getConstitution();
				intelligence += Races.ELF.getIntelligence();
				wisdom += Races.ELF.getWisdom();
				charisma += Races.ELF.getCharisma();
			} else if (dropDownText.equals(Races.GNOME)) {
				strength += Races.GNOME.getStrength();
				dexterity += Races.GNOME.getDexterity();
				constitution += Races.GNOME.getConstitution();
				intelligence += Races.GNOME.getIntelligence();
				wisdom += Races.GNOME.getWisdom();
				charisma += Races.GNOME.getCharisma();
			} else if (dropDownText.equals(Races.HALFELF)) {
				strength += Races.HALFELF.getStrength();
				dexterity += Races.HALFELF.getDexterity();
				constitution += Races.HALFELF.getConstitution();
				intelligence += Races.HALFELF.getIntelligence();
				wisdom += Races.HALFELF.getWisdom();
				charisma += Races.HALFELF.getCharisma();
			} else if (dropDownText.equals(Races.HALFORC)) {
				strength += Races.HALFORC.getStrength();
				dexterity += Races.HALFORC.getDexterity();
				constitution += Races.HALFORC.getConstitution();
				intelligence += Races.HALFORC.getIntelligence();
				wisdom += Races.HALFORC.getWisdom();
				charisma += Races.HALFORC.getCharisma();
			} else if (dropDownText.equals(Races.HALFLING)) {
				strength += Races.HALFLING.getStrength();
				dexterity += Races.HALFLING.getDexterity();
				constitution += Races.HALFLING.getConstitution();
				intelligence += Races.HALFLING.getIntelligence();
				wisdom += Races.HALFLING.getWisdom();
				charisma += Races.HALFLING.getCharisma();
			} else if (dropDownText.equals(Races.HUMAN)) {
				strength += Races.HUMAN.getStrength();
				dexterity += Races.HUMAN.getDexterity();
				constitution += Races.HUMAN.getConstitution();
				intelligence += Races.HUMAN.getIntelligence();
				wisdom += Races.HUMAN.getWisdom();
				charisma += Races.HUMAN.getCharisma();
			}
		} else if (isInputting) {
			strength += (Integer) strengthSpinner.getValue();
			dexterity += (Integer) dexteritySpinner.getValue();
			constitution += (Integer) constitutionSpinner.getValue();
			intelligence += (Integer) intelligenceSpinner.getValue();
			wisdom += (Integer) wisdomSpinner.getValue();
			charisma += (Integer) charismaSpinner.getValue();
			if (dropDownText.equals(Races.DWARF)) {
				strength += Races.DWARF.getStrength();
				dexterity += Races.DWARF.getDexterity();
				constitution += Races.DWARF.getConstitution();
				intelligence += Races.DWARF.getIntelligence();
				wisdom += Races.DWARF.getWisdom();
				charisma += Races.DWARF.getCharisma();
			} else if (dropDownText.equals(Races.ELF)) {
				strength += Races.ELF.getStrength();
				dexterity += Races.ELF.getDexterity();
				constitution += Races.ELF.getConstitution();
				intelligence += Races.ELF.getIntelligence();
				wisdom += Races.ELF.getWisdom();
				charisma += Races.ELF.getCharisma();
			} else if (dropDownText.equals(Races.GNOME)) {
				strength += Races.GNOME.getStrength();
				dexterity += Races.GNOME.getDexterity();
				constitution += Races.GNOME.getConstitution();
				intelligence += Races.GNOME.getIntelligence();
				wisdom += Races.GNOME.getWisdom();
				charisma += Races.GNOME.getCharisma();
			} else if (dropDownText.equals(Races.HALFELF)) {
				strength += Races.HALFELF.getStrength();
				dexterity += Races.HALFELF.getDexterity();
				constitution += Races.HALFELF.getConstitution();
				intelligence += Races.HALFELF.getIntelligence();
				wisdom += Races.HALFELF.getWisdom();
				charisma += Races.HALFELF.getCharisma();
			} else if (dropDownText.equals(Races.HALFORC)) {
				strength += Races.HALFORC.getStrength();
				dexterity += Races.HALFORC.getDexterity();
				constitution += Races.HALFORC.getConstitution();
				intelligence += Races.HALFORC.getIntelligence();
				wisdom += Races.HALFORC.getWisdom();
				charisma += Races.HALFORC.getCharisma();
			} else if (dropDownText.equals(Races.HALFLING)) {
				strength += Races.HALFLING.getStrength();
				dexterity += Races.HALFLING.getDexterity();
				constitution += Races.HALFLING.getConstitution();
				intelligence += Races.HALFLING.getIntelligence();
				wisdom += Races.HALFLING.getWisdom();
				charisma += Races.HALFLING.getCharisma();
			} else if (dropDownText.equals(Races.HUMAN)) {
				strength += Races.HUMAN.getStrength();
				dexterity += Races.HUMAN.getDexterity();
				constitution += Races.HUMAN.getConstitution();
				intelligence += Races.HUMAN.getIntelligence();
				wisdom += Races.HUMAN.getWisdom();
				charisma += Races.HUMAN.getCharisma();
			}
		}
		strengthInput.setText(String.valueOf(strength));
		dexterityInput.setText(String.valueOf(dexterity));
		constitutionInput.setText(String.valueOf(constitution));
		intelligenceInput.setText(String.valueOf(intelligence));
		wisdomInput.setText(String.valueOf(wisdom));
		charismaInput.setText(String.valueOf(charisma));
		
		if (strength < abilityScoreBaseValue) {	
			strengthModifier = ((strength -abilityScoreBaseValue - 1)/2);
		} else {
			strengthModifier = (strength - abilityScoreBaseValue)/2;
		}
		if (dexterity < abilityScoreBaseValue) {			
			dexterityModifier = ((dexterity - abilityScoreBaseValue - 1)/2);
		} else {
			dexterityModifier = (dexterity - abilityScoreBaseValue)/2;
		}
		if (constitution < abilityScoreBaseValue) {
			constitutionModifier = ((constitution - abilityScoreBaseValue - 1)/2);
		} else {
			constitutionModifier = (constitution - abilityScoreBaseValue)/2;
		}
		if (intelligence < abilityScoreBaseValue) {
			intelligenceModifier = ((intelligence - abilityScoreBaseValue - 1)/2);
		} else {
			intelligenceModifier = (intelligence - abilityScoreBaseValue)/2;			
		}
		if (wisdom < abilityScoreBaseValue) {			
			wisdomModifier = ((wisdom - abilityScoreBaseValue - 1)/2);
		} else {
			wisdomModifier = (wisdom - abilityScoreBaseValue)/2;
		}
		if (charisma < abilityScoreBaseValue) {
			charismaModifier = ((charisma - abilityScoreBaseValue - 1)/2);
		} else {
			charismaModifier = (charisma - 10)/2;			
		}
		
		
		strengthModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(strengthModifier) + "</html>");
		dexterityModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(dexterityModifier) + "</html>");
		constitutionModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(constitutionModifier) + "</html>");
		intelligenceModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(intelligenceModifier) + "</html>");
		wisdomModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(wisdomModifier) + "</html>");
		charismaModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(charismaModifier) + "</html>");
		
		reference.validate();
		reference.repaint();
	}

	/**
	 * Handles the adding and removing of objects from the ability, physical,
	 * and mental panels. Determines what to add and remove based on if roll or
	 * input is selected.
	 */
	private void abilitySelection() {
		abilityInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				physicalAbilityPanel.removeAll();

				mentalAbilityPanel.removeAll();

				abilitySelectionPanel.add(lowFantasy);
				abilitySelectionPanel.add(standardFantasy);
				abilitySelectionPanel.add(highFantasy);
				abilitySelectionPanel.add(epicFantasy);
				abilitySelectionPanel.add(fantasyPointsLabel);
				isInputting = true;
				isRolling = false;
				abilitySelectionPanel.setPreferredSize(new Dimension(2400, 220));

				fantasySelection();

				physicalAbilityPanel.add(strengthLabel);
				physicalAbilityPanel.add(strengthSpinner);
				physicalAbilityPanel.add(strengthModifierLabel);
				physicalAbilityPanel.add(temporaryStrengthLabel);
				physicalAbilityPanel.add(temporaryStrengthInput);
				physicalAbilityPanel.add(temporaryStrengthModifierLabel);

				physicalAbilityPanel.add(dexterityLabel);
				physicalAbilityPanel.add(dexteritySpinner);
				physicalAbilityPanel.add(dexterityModifierLabel);
				physicalAbilityPanel.add(temporaryDexterityLabel);
				physicalAbilityPanel.add(temporaryDexterityInput);
				physicalAbilityPanel.add(temporaryDexterityModifierLabel);

				physicalAbilityPanel.add(constitutionLabel);
				physicalAbilityPanel.add(constitutionSpinner);
				physicalAbilityPanel.add(constitutionModifierLabel);
				physicalAbilityPanel.add(temporaryConstitutionLabel);
				physicalAbilityPanel.add(temporaryConstitutionInput);
				physicalAbilityPanel.add(temporaryConstitutionModifierLabel);

				mentalAbilityPanel.add(intelligenceLabel);
				mentalAbilityPanel.add(intelligenceSpinner);
				mentalAbilityPanel.add(intelligenceModifierLabel);
				mentalAbilityPanel.add(temporaryIntelligenceLabel);
				mentalAbilityPanel.add(temporaryIntelligenceInput);
				mentalAbilityPanel.add(temporaryIntelligenceModifierLabel);

				mentalAbilityPanel.add(wisdomLabel);
				mentalAbilityPanel.add(wisdomSpinner);
				mentalAbilityPanel.add(wisdomModifierLabel);
				mentalAbilityPanel.add(temporaryWisdomLabel);
				mentalAbilityPanel.add(temporaryWisdomInput);
				mentalAbilityPanel.add(temporaryWisdomModifierLabel);

				mentalAbilityPanel.add(charismaLabel);
				mentalAbilityPanel.add(charismaSpinner);
				mentalAbilityPanel.add(charismaModifierLabel);
				mentalAbilityPanel.add(temporaryCharismaLabel);
				mentalAbilityPanel.add(temporaryCharismaInput);
				mentalAbilityPanel.add(temporaryCharismaModifierLabel);

				reference.add(saveAbility);

				reference.validate();
				reference.repaint();
			}
		});

		abilityRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abilitySelectionPanel.remove(lowFantasy);
				abilitySelectionPanel.remove(standardFantasy);
				abilitySelectionPanel.remove(highFantasy);
				abilitySelectionPanel.remove(epicFantasy);
				abilitySelectionPanel.remove(fantasyPointsLabel);
				reference.remove(saveAbility);
				isInputting = false;
				isRolling = true;
				abilitySelectionPanel.setPreferredSize(new Dimension(2400, 120));

				physicalAbilityPanel.removeAll();
				mentalAbilityPanel.removeAll();

				physicalAbilityPanel.add(strengthLabel);
				physicalAbilityPanel.add(strengthRoll);
				physicalAbilityPanel.add(strengthModifierLabel);
				physicalAbilityPanel.add(temporaryStrengthLabel);
				physicalAbilityPanel.add(temporaryStrengthInput);
				physicalAbilityPanel.add(temporaryStrengthModifierLabel);

				physicalAbilityPanel.add(dexterityLabel);
				physicalAbilityPanel.add(dexterityRoll);
				physicalAbilityPanel.add(dexterityModifierLabel);
				physicalAbilityPanel.add(temporaryDexterityLabel);
				physicalAbilityPanel.add(temporaryDexterityInput);
				physicalAbilityPanel.add(temporaryDexterityModifierLabel);

				physicalAbilityPanel.add(constitutionLabel);
				physicalAbilityPanel.add(constitutionRoll);
				physicalAbilityPanel.add(constitutionModifierLabel);
				physicalAbilityPanel.add(temporaryConstitutionLabel);
				physicalAbilityPanel.add(temporaryConstitutionInput);
				physicalAbilityPanel.add(temporaryConstitutionModifierLabel);

				mentalAbilityPanel.add(intelligenceLabel);
				mentalAbilityPanel.add(intelligenceRoll);
				mentalAbilityPanel.add(intelligenceModifierLabel);
				mentalAbilityPanel.add(temporaryIntelligenceLabel);
				mentalAbilityPanel.add(temporaryIntelligenceInput);
				mentalAbilityPanel.add(temporaryIntelligenceModifierLabel);

				mentalAbilityPanel.add(wisdomLabel);
				mentalAbilityPanel.add(wisdomRoll);
				mentalAbilityPanel.add(wisdomModifierLabel);
				mentalAbilityPanel.add(temporaryWisdomLabel);
				mentalAbilityPanel.add(temporaryWisdomInput);
				mentalAbilityPanel.add(temporaryWisdomModifierLabel);

				mentalAbilityPanel.add(charismaLabel);
				mentalAbilityPanel.add(charismaRoll);
				mentalAbilityPanel.add(charismaModifierLabel);
				mentalAbilityPanel.add(temporaryCharismaLabel);
				mentalAbilityPanel.add(temporaryCharismaInput);
				mentalAbilityPanel.add(temporaryCharismaModifierLabel);

				abilityRoll();

				reference.validate();
				reference.repaint();
			}
		});

	}

	private void abilityRoll() {
		strengthRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				physicalAbilityPanel.remove(strengthLabel);
				physicalAbilityPanel.remove(strengthRoll);
				physicalAbilityPanel.remove(strengthModifierLabel);
				physicalAbilityPanel.remove(temporaryStrengthLabel);
				physicalAbilityPanel.remove(temporaryStrengthInput);
				physicalAbilityPanel.remove(temporaryStrengthModifierLabel);

				physicalAbilityPanel.add(strengthLabel);
				physicalAbilityPanel.add(strengthInput);
				physicalAbilityPanel.add(strengthModifierLabel);
				physicalAbilityPanel.add(temporaryStrengthLabel);
				physicalAbilityPanel.add(temporaryStrengthInput);
				physicalAbilityPanel.add(temporaryStrengthModifierLabel);

				strengthRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();
			}
		});
		dexterityRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				physicalAbilityPanel.remove(dexterityLabel);
				physicalAbilityPanel.remove(dexterityRoll);
				physicalAbilityPanel.remove(dexterityModifierLabel);
				physicalAbilityPanel.remove(temporaryDexterityLabel);
				physicalAbilityPanel.remove(temporaryDexterityInput);
				physicalAbilityPanel.remove(temporaryDexterityModifierLabel);

				physicalAbilityPanel.add(dexterityLabel);
				physicalAbilityPanel.add(dexterityInput);
				physicalAbilityPanel.add(dexterityModifierLabel);
				physicalAbilityPanel.add(temporaryDexterityLabel);
				physicalAbilityPanel.add(temporaryDexterityInput);
				physicalAbilityPanel.add(temporaryDexterityModifierLabel);

				dexterityRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();
			}
		});
		constitutionRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				physicalAbilityPanel.remove(constitutionLabel);
				physicalAbilityPanel.remove(constitutionRoll);
				physicalAbilityPanel.remove(constitutionModifierLabel);
				physicalAbilityPanel.remove(temporaryConstitutionLabel);
				physicalAbilityPanel.remove(temporaryConstitutionInput);
				physicalAbilityPanel.remove(temporaryConstitutionModifierLabel);

				physicalAbilityPanel.add(constitutionLabel);
				physicalAbilityPanel.add(constitutionInput);
				physicalAbilityPanel.add(constitutionModifierLabel);
				physicalAbilityPanel.add(temporaryConstitutionLabel);
				physicalAbilityPanel.add(temporaryConstitutionInput);
				physicalAbilityPanel.add(temporaryConstitutionModifierLabel);

				constitutionRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();

			}
		});
		intelligenceRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentalAbilityPanel.remove(intelligenceLabel);
				mentalAbilityPanel.remove(intelligenceRoll);
				mentalAbilityPanel.remove(intelligenceModifierLabel);
				mentalAbilityPanel.remove(temporaryIntelligenceLabel);
				mentalAbilityPanel.remove(temporaryIntelligenceInput);
				mentalAbilityPanel.remove(temporaryIntelligenceModifierLabel);

				mentalAbilityPanel.add(intelligenceLabel);
				mentalAbilityPanel.add(intelligenceInput);
				mentalAbilityPanel.add(intelligenceModifierLabel);
				mentalAbilityPanel.add(temporaryIntelligenceLabel);
				mentalAbilityPanel.add(temporaryIntelligenceInput);
				mentalAbilityPanel.add(temporaryIntelligenceModifierLabel);

				intelligenceRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();

			}
		});
		wisdomRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentalAbilityPanel.remove(wisdomLabel);
				mentalAbilityPanel.remove(wisdomRoll);
				mentalAbilityPanel.remove(wisdomModifierLabel);
				mentalAbilityPanel.remove(temporaryWisdomLabel);
				mentalAbilityPanel.remove(temporaryWisdomInput);
				mentalAbilityPanel.remove(temporaryWisdomModifierLabel);

				mentalAbilityPanel.add(wisdomLabel);
				mentalAbilityPanel.add(wisdomInput);
				mentalAbilityPanel.add(wisdomModifierLabel);
				mentalAbilityPanel.add(temporaryWisdomLabel);
				mentalAbilityPanel.add(temporaryWisdomInput);
				mentalAbilityPanel.add(temporaryWisdomModifierLabel);

				wisdomRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();

			}
		});
		charismaRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentalAbilityPanel.remove(charismaLabel);
				mentalAbilityPanel.remove(charismaRoll);
				mentalAbilityPanel.remove(charismaModifierLabel);
				mentalAbilityPanel.remove(temporaryCharismaLabel);
				mentalAbilityPanel.remove(temporaryCharismaInput);
				mentalAbilityPanel.remove(temporaryCharismaModifierLabel);

				mentalAbilityPanel.add(charismaLabel);
				mentalAbilityPanel.add(charismaInput);
				mentalAbilityPanel.add(charismaModifierLabel);
				mentalAbilityPanel.add(temporaryCharismaLabel);
				mentalAbilityPanel.add(temporaryCharismaInput);
				mentalAbilityPanel.add(temporaryCharismaModifierLabel);

				charismaRollValue = rollScores(4, 6);
				
				setRacialAbilityScores(isRolling, isInputting);

				reference.validate();
				reference.repaint();

			}
		});
	}

	private int rollScores(int diceAmount, int diceSides) {
		int result = 0;
		int[] diceRoll = new int[4];
		for (int i = 0; i < diceAmount; i++) {
			diceRoll[i] = diceBag.rollDice(diceSides);
			result += diceRoll[i];
		}
		if (diceRoll[0] < diceRoll[1] && diceRoll[0] < diceRoll[2] && diceRoll[0] < diceRoll[3]) {
			result -= diceRoll[0];
		} else if (diceRoll[0] > diceRoll[1] && diceRoll[1] < diceRoll[2] && diceRoll[1] < diceRoll[3]) {
			result -= diceRoll[1];
		} else if (diceRoll[0] > diceRoll[2] && diceRoll[1] > diceRoll[2] && diceRoll[2] < diceRoll[3]) {
			result -= diceRoll[2];
		} else if (diceRoll[0] > diceRoll[3] && diceRoll[1] > diceRoll[3] && diceRoll[2] > diceRoll[3]) {
			result -= diceRoll[3];
		}
		return result;
	}

	/**
	 * Handles how many points the player has left depending on which option
	 * they choose. Resets the ability scores if the fantasy is changed.
	 */
	private void fantasySelection() {
		lowFantasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fantasyPoints = 10;
				totalPoints = 0;
				fantasyPointsLabel.setText("<html>" + String.valueOf(fantasyPoints) + "points<br>remaining</html>");
				strengthSpinner.setValue(10);
				dexteritySpinner.setValue(10);
				constitutionSpinner.setValue(10);
				intelligenceSpinner.setValue(10);
				wisdomSpinner.setValue(10);
				charismaSpinner.setValue(10);
			}
		});

		standardFantasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fantasyPoints = 15;
				totalPoints = 0;
				fantasyPointsLabel.setText("<html>" + String.valueOf(fantasyPoints) + "points<br>remaining</html>");
				strengthSpinner.setValue(10);
				dexteritySpinner.setValue(10);
				constitutionSpinner.setValue(10);
				intelligenceSpinner.setValue(10);
				wisdomSpinner.setValue(10);
				charismaSpinner.setValue(10);
			}
		});

		highFantasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fantasyPoints = 20;
				totalPoints = 0;
				fantasyPointsLabel.setText("<html>" + String.valueOf(fantasyPoints) + "points<br>remaining</html>");
				strengthSpinner.setValue(10);
				dexteritySpinner.setValue(10);
				constitutionSpinner.setValue(10);
				intelligenceSpinner.setValue(10);
				wisdomSpinner.setValue(10);
				charismaSpinner.setValue(10);
			}
		});

		epicFantasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fantasyPoints = 25;
				totalPoints = 0;
				fantasyPointsLabel.setText("<html>" + String.valueOf(fantasyPoints) + "points<br>remaining</html>");
				strengthSpinner.setValue(10);
				dexteritySpinner.setValue(10);
				constitutionSpinner.setValue(10);
				intelligenceSpinner.setValue(10);
				wisdomSpinner.setValue(10);
				charismaSpinner.setValue(10);
			}
		});

	}

	/**
	 * Handles the code for the ability spinners. Keeps the score from going
	 * below 7 and above 18. Keeps the player from using more points than they
	 * have available.
	 */
	private void abilitySpinnerListener() {
		strengthSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) strengthSpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						strengthPoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					strengthSpinner.setValue(7);
				}
				if (holder > 18) {
					strengthSpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					strengthSpinner.setValue(holder - 1);
					strengthPoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				if (holder < abilityScoreBaseValue) {	
					strengthModifier = (holder - abilityScoreBaseValue - 1)/2;
				} else {
					strengthModifier = (holder - abilityScoreBaseValue)/2;
				}
				
				strengthModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(strengthModifier) + "</html>");
				
				reference.validate();
				reference.repaint();
			}
		});

		dexteritySpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) dexteritySpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						dexterityPoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					dexteritySpinner.setValue(7);
				}
				if (holder > 18) {
					dexteritySpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					dexteritySpinner.setValue(holder - 1);
					dexterityPoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				
				if (holder < abilityScoreBaseValue) {			
					dexterityModifier = ((holder - abilityScoreBaseValue - 1)/2);
				} else {
					dexterityModifier = (holder - abilityScoreBaseValue)/2;
				}
				
				dexterityModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(dexterityModifier) + "</html>");
				
				reference.validate();
				reference.repaint();
			}
		});

		constitutionSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) constitutionSpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						constitutionPoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					constitutionSpinner.setValue(7);
				}
				if (holder > 18) {
					constitutionSpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					constitutionSpinner.setValue(holder - 1);
					constitutionPoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				
				if (holder < abilityScoreBaseValue) {
					constitutionModifier = ((holder - abilityScoreBaseValue - 1)/2);
				} else {
					constitutionModifier = (holder - abilityScoreBaseValue)/2;
				}
				
				constitutionModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(constitutionModifier) + "</html>");
				
				reference.validate();
				reference.repaint();
			}
		});

		intelligenceSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) intelligenceSpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						intelligencePoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					intelligenceSpinner.setValue(7);
				}
				if (holder > 18) {
					intelligenceSpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					intelligenceSpinner.setValue(holder - 1);
					intelligencePoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				
				if (holder < abilityScoreBaseValue) {
					intelligenceModifier = ((holder - abilityScoreBaseValue - 1)/2);
				} else {
					intelligenceModifier = (holder - abilityScoreBaseValue)/2;			
				}
				
				intelligenceModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(intelligenceModifier) + "</html>");
				
				reference.validate();
				reference.repaint();
			}
		});

		wisdomSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) wisdomSpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						wisdomPoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					wisdomSpinner.setValue(7);
				}
				if (holder > 18) {
					wisdomSpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					wisdomSpinner.setValue(holder - 1);
					wisdomPoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				
				if (holder < abilityScoreBaseValue) {			
					wisdomModifier = ((holder - abilityScoreBaseValue - 1)/2);
				} else {
					wisdomModifier = (holder - abilityScoreBaseValue)/2;
				}
				
				wisdomModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(wisdomModifier) + "</html>");
				
				reference.validate();
				reference.repaint();

			}
		});

		charismaSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int holder = (Integer) charismaSpinner.getValue();
				int saveI = 0;
				for (int i = 0; i < abilityScore.length; i++) {
					if (holder == abilityScore[i]) {
						charismaPoints = abilityCost[i];
						saveI = i - 1;
					}
				}
				if (holder < 7) {
					charismaSpinner.setValue(7);
				}
				if (holder > 18) {
					charismaSpinner.setValue(18);
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				if (fantasyPoints - totalPoints < 0) {
					charismaSpinner.setValue(holder - 1);
					charismaPoints = abilityCost[saveI];
				}
				totalPoints = strengthPoints + dexterityPoints + constitutionPoints + intelligencePoints + wisdomPoints
						+ charismaPoints;
				fantasyPointsLabel
						.setText("<html>" + String.valueOf(fantasyPoints - totalPoints) + "points<br>remaining</html>");
				
				if (holder < abilityScoreBaseValue) {
					charismaModifier = ((holder - abilityScoreBaseValue - 1)/2);
				} else {
					charismaModifier = (holder - 10)/2;			
				}
				
				charismaModifierLabel.setText("<html>Modifier:<br>" + String.valueOf(charismaModifier) + "</html>");
				
				reference.validate();
				reference.repaint();
			}
		});

	}

	/**
	 * Holds the code for if the character gender is changed. If the gender is
	 * changed, it resets the character's height and weight.
	 */
	private void genderActionPerform() {
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

	/**
	 * Holds the code for changing character race. If the race is changed, it
	 * resets the character's age, height and weight. Prevents the player from
	 * creating a 6'0" dwarf.
	 */
	private void raceActionPerform() {
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
		setRacialAbilityScores(isRolling, isInputting);
		reference.validate();
		reference.repaint();

	}

	/**
	 * Holds the code for randomizing weight. If the gender or race is changed,
	 * the player must reroll their weight.
	 */
	private void weightRollSelectionActionPerform() {
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

	/**
	 * Holds the code for randomizing height. If the gender or race is changed,
	 * the player must reroll their height.
	 */
	private void heightRollSelectionActionPerform() {
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

	/**
	 * Holds the code for if the player wants to input a character age. Removes
	 * age roll button and adds age text field.
	 */
	private void ageInputSelectionActionPerform() {
		if (ageInputSelection.isSelected()) {
			agePanel.remove(intuitive);
			agePanel.remove(selfTaught);
			agePanel.remove(trained);
			agePanel.remove(ageRoll);
			agePanel.add(ageInput);
			agePanel.setPreferredSize(new Dimension(2400, 120));
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

	/**
	 * Holds the code for if the player wants a random age. Removes the age
	 * input and adds an age roll button. The player is given three choices of
	 * ages to choose from. Based on player selection, the appropriate "dice"
	 * are "rolled" accordingly.
	 */
	private void ageRollSelectionActionPerform() {
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

	/**
	 * Holds the code for how many classes the player wants their character to
	 * have. Creates class and level labels and drop boxes based on what the
	 * player chooses. Removes labels and drop boxes if there are more than
	 * what's selected.
	 */
	private void multiClassActionPerform() {
		int amount = 4;

		Integer multiClasses = (Integer) multiClass.getSelectedItem();
		for (int i = 0; i < multiClasses; i++) {

			characterClass[i].setPreferredSize(new Dimension(1000, 100));
			characterClass[i].setFont(f);

			classLevel[i].setPreferredSize(new Dimension(500, 100));
			classLevel[i].setFont(f);

			classLabel[i].setPreferredSize(new Dimension(400, 100));
			classLabel[i].setFont(f);

			levelLabel[i].setPreferredSize(new Dimension(400, 100));
			levelLabel[i].setFont(f);

			container.add(classLabel[i]);
			container.add(characterClass[i]);
			container.add(levelLabel[i]);
			container.add(classLevel[i]);
			characterLevel += (Integer) classLevel[i].getSelectedItem();
		}

		while (multiClasses != amount && amount > multiClasses) {
			amount--;
			container.remove(classLabel[amount]);
			container.remove(characterClass[amount]);
			container.remove(classLevel[amount]);
			container.remove(levelLabel[amount]);
		}
		container.setPreferredSize(new Dimension(2400, 120 + (100 * amount)));
		reference.validate();
		reference.repaint();
		reference.revalidate();

	}

	/**
	 * Holds the code for setting the size, font, and other characteristics of
	 * swing objects. This is excluding panels.
	 */
	public void setSwingCharacteristics() {
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
		ageRollSelection.setBackground(lightGray);

		ageInputSelection.setPreferredSize(new Dimension(240, 100));
		ageInputSelection.setFont(f);
		ageInputSelection.setBackground(lightGray);

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
		strengthSpinner.setPreferredSize(new Dimension(200, 150));
		strengthSpinner.setFont(f);

		dexteritySpinner.setValue(10);
		dexteritySpinner.setPreferredSize(new Dimension(200, 150));
		dexteritySpinner.setFont(f);

		constitutionSpinner.setValue(10);
		constitutionSpinner.setPreferredSize(new Dimension(200, 150));
		constitutionSpinner.setFont(f);

		intelligenceSpinner.setValue(10);
		intelligenceSpinner.setPreferredSize(new Dimension(200, 150));
		intelligenceSpinner.setFont(f);

		wisdomSpinner.setValue(10);
		wisdomSpinner.setPreferredSize(new Dimension(200, 150));
		wisdomSpinner.setFont(f);

		charismaSpinner.setValue(10);
		charismaSpinner.setPreferredSize(new Dimension(200, 150));
		charismaSpinner.setFont(f);

		strengthLabel.setPreferredSize(new Dimension(200, 150));
		strengthLabel.setFont(f);
		strengthLabel.setOpaque(true);
		strengthLabel.setBackground(black);
		strengthLabel.setForeground(white);

		dexterityLabel.setPreferredSize(new Dimension(200, 150));
		dexterityLabel.setFont(f);
		dexterityLabel.setOpaque(true);
		dexterityLabel.setBackground(black);
		dexterityLabel.setForeground(white);

		constitutionLabel.setPreferredSize(new Dimension(220, 150));
		constitutionLabel.setFont(f);
		constitutionLabel.setOpaque(true);
		constitutionLabel.setBackground(black);
		constitutionLabel.setForeground(white);

		intelligenceLabel.setPreferredSize(new Dimension(200, 150));
		intelligenceLabel.setFont(f);
		intelligenceLabel.setOpaque(true);
		intelligenceLabel.setBackground(black);
		intelligenceLabel.setForeground(white);

		wisdomLabel.setPreferredSize(new Dimension(200, 150));
		wisdomLabel.setFont(f);
		wisdomLabel.setOpaque(true);
		wisdomLabel.setBackground(black);
		wisdomLabel.setForeground(white);

		charismaLabel.setPreferredSize(new Dimension(200, 150));
		charismaLabel.setFont(f);
		charismaLabel.setOpaque(true);
		charismaLabel.setBackground(black);
		charismaLabel.setForeground(white);

		strengthInput.setPreferredSize(new Dimension(200, 150));
		strengthInput.setFont(f);

		dexterityInput.setPreferredSize(new Dimension(200, 150));
		dexterityInput.setFont(f);

		constitutionInput.setPreferredSize(new Dimension(200, 150));
		constitutionInput.setFont(f);

		intelligenceInput.setPreferredSize(new Dimension(200, 150));
		intelligenceInput.setFont(f);

		wisdomInput.setPreferredSize(new Dimension(200, 150));
		wisdomInput.setFont(f);

		charismaInput.setPreferredSize(new Dimension(200, 150));
		charismaInput.setFont(f);

		strengthRoll.setPreferredSize(new Dimension(200, 150));
		strengthRoll.setFont(f);

		dexterityRoll.setPreferredSize(new Dimension(200, 150));
		dexterityRoll.setFont(f);

		constitutionRoll.setPreferredSize(new Dimension(250, 150));
		constitutionRoll.setFont(f);

		intelligenceRoll.setPreferredSize(new Dimension(240, 150));
		intelligenceRoll.setFont(f);

		wisdomRoll.setPreferredSize(new Dimension(180, 150));
		wisdomRoll.setFont(f);

		charismaRoll.setPreferredSize(new Dimension(220, 150));
		charismaRoll.setFont(f);

		temporaryStrengthInput.setPreferredSize(new Dimension(150, 150));
		temporaryStrengthInput.setFont(f);

		temporaryDexterityInput.setPreferredSize(new Dimension(150, 150));
		temporaryDexterityInput.setFont(f);

		temporaryConstitutionInput.setPreferredSize(new Dimension(150, 150));
		temporaryConstitutionInput.setFont(f);

		temporaryIntelligenceInput.setPreferredSize(new Dimension(150, 150));
		temporaryIntelligenceInput.setFont(f);

		temporaryWisdomInput.setPreferredSize(new Dimension(150, 150));
		temporaryWisdomInput.setFont(f);

		temporaryCharismaInput.setPreferredSize(new Dimension(150, 150));
		temporaryCharismaInput.setFont(f);

		temporaryStrengthLabel.setPreferredSize(new Dimension(200, 150));
		temporaryStrengthLabel.setFont(f);

		temporaryDexterityLabel.setPreferredSize(new Dimension(200, 150));
		temporaryDexterityLabel.setFont(f);

		temporaryConstitutionLabel.setPreferredSize(new Dimension(200, 150));
		temporaryConstitutionLabel.setFont(f);

		temporaryIntelligenceLabel.setPreferredSize(new Dimension(200, 150));
		temporaryIntelligenceLabel.setFont(f);

		temporaryWisdomLabel.setPreferredSize(new Dimension(200, 150));
		temporaryWisdomLabel.setFont(f);

		temporaryCharismaLabel.setPreferredSize(new Dimension(200, 150));
		temporaryCharismaLabel.setFont(f);

		strengthModifierLabel.setPreferredSize(new Dimension(200, 200));
		strengthModifierLabel.setFont(f);
		strengthModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(strengthInput.getText()) - abilityScoreBaseValue) / 2) + "</html>");

		dexterityModifierLabel.setPreferredSize(new Dimension(200, 200));
		dexterityModifierLabel.setFont(f);
		dexterityModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(dexterityInput.getText()) - abilityScoreBaseValue) / 2) + "</html>");

		constitutionModifierLabel.setPreferredSize(new Dimension(200, 200));
		constitutionModifierLabel.setFont(f);
		constitutionModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(constitutionInput.getText()) - abilityScoreBaseValue) / 2)
				+ "</html>");

		intelligenceModifierLabel.setPreferredSize(new Dimension(200, 200));
		intelligenceModifierLabel.setFont(f);
		intelligenceModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(intelligenceInput.getText()) - abilityScoreBaseValue) / 2)
				+ "</html>");

		wisdomModifierLabel.setPreferredSize(new Dimension(200, 200));
		wisdomModifierLabel.setFont(f);
		wisdomModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(wisdomInput.getText()) - abilityScoreBaseValue) / 2) + "</html>");

		charismaModifierLabel.setPreferredSize(new Dimension(200, 200));
		charismaModifierLabel.setFont(f);
		charismaModifierLabel.setText("<html>Modifier: " + "<br>"
				+ String.valueOf((Integer.parseInt(charismaInput.getText()) - abilityScoreBaseValue) / 2) + "</html>");

		temporaryStrengthModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryStrengthModifierLabel.setFont(f);

		temporaryDexterityModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryDexterityModifierLabel.setFont(f);

		temporaryConstitutionModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryConstitutionModifierLabel.setFont(f);

		temporaryIntelligenceModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryIntelligenceModifierLabel.setFont(f);

		temporaryWisdomModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryWisdomModifierLabel.setFont(f);

		temporaryCharismaModifierLabel.setPreferredSize(new Dimension(200, 150));
		temporaryCharismaModifierLabel.setFont(f);

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

		lowFantasy.setPreferredSize(new Dimension(450, 100));
		lowFantasy.setFont(f);

		standardFantasy.setPreferredSize(new Dimension(550, 100));
		standardFantasy.setFont(f);

		highFantasy.setPreferredSize(new Dimension(450, 100));
		highFantasy.setFont(f);

		epicFantasy.setPreferredSize(new Dimension(450, 100));
		epicFantasy.setFont(f);

		fantasyPointsLabel.setPreferredSize(new Dimension(400, 100));
		fantasyPointsLabel.setFont(f);

		saveProgress.setPreferredSize(new Dimension(700, 100));
		saveProgress.setFont(f);

		saveAbility.setPreferredSize(new Dimension(300, 100));
		saveAbility.setFont(f);

	}

	/**
	 * Holds the code for setting the size, font, and other characteristics of
	 * panels.
	 */
	public void setPanels() {
		frame.setPreferredSize(new Dimension(3000, 2000));

		container.setBackground(lightGray);
		container.setPreferredSize(new Dimension(2300, 120));
		container.setBorder(BorderFactory.createLineBorder(black));

		agePanel.setBackground(lightGray);
		agePanel.setPreferredSize(new Dimension(2400, 120));
		agePanel.setBorder(BorderFactory.createLineBorder(black));

		heightPanel.setBackground(lightGray);
		heightPanel.setPreferredSize(new Dimension(1200, 120));
		heightPanel.setBorder(BorderFactory.createLineBorder(black));

		weightPanel.setBackground(lightGray);
		weightPanel.setPreferredSize(new Dimension(850, 120));
		weightPanel.setBorder(BorderFactory.createLineBorder(black));

		hairPanel.setBackground(lightGray);
		hairPanel.setPreferredSize(new Dimension(900, 120));
		hairPanel.setBorder(BorderFactory.createLineBorder(black));

		eyePanel.setBackground(lightGray);
		eyePanel.setPreferredSize(new Dimension(900, 120));
		eyePanel.setBorder(BorderFactory.createLineBorder(black));

		abilitySelectionPanel.setBackground(lightGray);
		abilitySelectionPanel.setPreferredSize(new Dimension(2400, 120));
		abilitySelectionPanel.setBorder(BorderFactory.createLineBorder(black));

		physicalAbilityPanel.setBackground(lightGray);
		physicalAbilityPanel.setPreferredSize(new Dimension(2400, 400));
		physicalAbilityPanel.setBorder(BorderFactory.createLineBorder(black));

		mentalAbilityPanel.setBackground(lightGray);
		mentalAbilityPanel.setPreferredSize(new Dimension(2400, 400));
		mentalAbilityPanel.setBorder(BorderFactory.createLineBorder(black));
	}

	/**
	 * Checks the player race selection and returns the proper size accordingly.
	 * Method is called upon race changing.
	 * 
	 * @return
	 */
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

	/**
	 * Checks which of the three ages are selected. Calculates the characters
	 * age accordingly based on age rolled and base race age. Resets upon race
	 * change.
	 * 
	 * @param intuitive
	 * @param selfTaught
	 * @param trained
	 * @return
	 */
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

	/**
	 * Checks the player race and gender and rolls the according dice.
	 * Calculates height based on dice roll plus the race's base height. Resets
	 * upon gender or race change.
	 * 
	 * @return
	 */
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

	/**
	 * Checks the player race and gender and rolls the according dice.
	 * 
	 * @return
	 */
	public int getWeightRoll() {
		int result = 0;
		Races racesDropDownText = (Races) race.getSelectedItem();
		String stringDropDownText = (String) gender.getSelectedItem();

		if (racesDropDownText.equals(Races.DWARF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getFemaleWeightDiceSides())
						* Races.DWARF.getWeightMultiplier() + Races.DWARF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getMaleWeightDiceSides())
						* Races.DWARF.getWeightMultiplier() + Races.DWARF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.ELF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.ELF.getWeightDiceAmount(), Races.ELF.getFemaleWeightDiceSides())
						* Races.ELF.getWeightMultiplier() + Races.ELF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.DWARF.getWeightDiceAmount(), Races.DWARF.getMaleWeightDiceSides())
						* Races.ELF.getWeightMultiplier() + Races.ELF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.GNOME)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.GNOME.getWeightDiceAmount(), Races.GNOME.getFemaleWeightDiceSides())
						* Races.GNOME.getWeightMultiplier() + Races.GNOME.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.GNOME.getWeightDiceAmount(), Races.GNOME.getMaleWeightDiceSides())
						* Races.GNOME.getWeightMultiplier() + Races.GNOME.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFELF)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFELF.getWeightDiceAmount(), Races.HALFELF.getFemaleWeightDiceSides())
						* Races.HALFELF.getWeightMultiplier() + Races.HALFELF.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFELF.getWeightDiceAmount(), Races.HALFELF.getMaleWeightDiceSides())
						* Races.HALFELF.getWeightMultiplier() + Races.HALFELF.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFORC)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFORC.getWeightDiceAmount(), Races.HALFORC.getFemaleWeightDiceSides())
						* Races.HALFORC.getWeightMultiplier() + Races.HALFORC.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFORC.getWeightDiceAmount(), Races.HALFORC.getMaleWeightDiceSides())
						* Races.HALFORC.getWeightMultiplier() + Races.HALFORC.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HALFLING)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HALFLING.getWeightDiceAmount(), Races.HALFLING.getFemaleWeightDiceSides())
						* Races.HALFLING.getWeightMultiplier() + Races.HALFLING.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HALFLING.getWeightDiceAmount(), Races.HALFLING.getMaleWeightDiceSides())
						* Races.HALFLING.getWeightMultiplier() + Races.HALFLING.getBaseMaleWeight());
			}
		} else if (racesDropDownText.equals(Races.HUMAN)) {
			if (stringDropDownText.equals("Female")) {
				result = (setRollResult(Races.HUMAN.getWeightDiceAmount(), Races.HUMAN.getFemaleWeightDiceSides())
						* Races.HUMAN.getWeightMultiplier() + Races.HUMAN.getBaseFemaleWeight());
			} else if (stringDropDownText.equals("Male")) {
				result = (setRollResult(Races.HUMAN.getWeightDiceAmount(), Races.HUMAN.getMaleWeightDiceSides())
						* Races.HUMAN.getWeightMultiplier() + Races.HUMAN.getBaseMaleWeight());
			}
		}

		return result;
	}

	/**
	 * Takes in the amount of dice that need to be rolled and how many sides the
	 * dice have. Rolls the corresponding dice and returns the result.
	 * 
	 * @param diceAmount
	 * @param diceSides
	 * @return
	 */
	public int setRollResult(int diceAmount, int diceSides) {
		int result = 0;
		for (int i = 0; i < diceAmount; i++) {
			result += diceBag.rollDice(diceSides);
		}
		return result;
	}

	/**
	 * Writes to the file characterSheet.ser. Called when the save button is
	 * pressed.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void saveCharacterInformation() throws IOException, ClassNotFoundException {
		// @@@@ File writing
		FileOutputStream fileOut = new FileOutputStream("characterSheet.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(characterName);
		out.writeObject(alignment);
		out.writeObject(playerName);
		out.writeObject(deity);
		out.writeObject(homeland);
		out.writeObject(ageInput);
		out.writeObject(heightInput);
		out.writeObject(weightInput);
		out.close();
		fileOut.close();
		System.out.printf("Serialization finished");
	}

}
