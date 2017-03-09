package edu.neumont.csc150.finalproject.group17;

public enum Races {

	/*
	 * strength, dexterity, constitution, intelligence, wisdom, charisma, 
	 * baseSpeed, size, languages,
	 * intuitiveDiceAmount, selfTaughtDiceAmount, trainedDiceAmount,
	 * intuitiveDiceSides, selfTaughtDiceSides, trainedDiceSides, base age,
	 * base male height, base female height, 
	 * heightDiceAmount, male height dice sides, female height dice sides,
	 * weight roll, male weight dice sides, female weight dice sides, weightMultiplier
	 * base male weight, base female weight
	 */
	DWARF(0, 0, 2, 0, 2, -2, 
			20, "Medium", new String[] { "Common", "Dwarven" }, 
			3, 5, 7, 
			6, 6, 6, 40, 
			45, 43, 
			2, 4, 4,
			2, 4, 4, 7,
			150, 120), 
	ELF(0, 2, -2, 2, 0, 0, 
			30,	"Medium", new String[] { "Common", "Elven" },
			4, 6, 10, 
			6, 6, 6, 110,
			64, 64, 
			2, 8, 6, 
			2, 8, 6, 3,
			110, 90), 
	GNOME(-2, 0, 2, 0, 0, 2, 
			20, "Small", new String[] { "Common", "Gnome", "Sylvan" },
			3, 6, 9, 
			6, 6, 6, 40,
			36, 34, 
			2, 4, 4, 
			2, 4, 4, 1,
			35, 30), 
	HALFELF(0, 0, 0, 0, 0, 0, 
			30, "Medium", new String[] { "Common", "Elven" },
			1, 2, 3, 
			6, 6, 6, 20,
			62, 60, 
			2, 8, 8, 
			2, 8, 8, 5,
			100, 90), 
	HALFORC(0, 0, 0, 0, 0, 0, 
			30, "Medium",	new String[] { "Common", "Orc" },
			1, 1, 2, 
			4, 6, 6, 14,
			58, 53, 
			2, 12, 12,
			2, 12, 12, 7,
			150, 110), 
	HALFLING(-2, 2, 0, 0, 0, 2, 
			20, "Small", new String[] { "Common", "Halfling" },
			2, 3, 4, 
			4, 6, 6, 20,
			32, 30,
			2, 4, 4, 
			2, 4, 4, 1,
			30, 25), 
	HUMAN(0, 0, 0, 0, 0, 0, 
			30, "Medium", new String[] { "Common" },
			1, 1, 2, 
			4, 6, 6, 15,
			58, 53, 
			2, 10, 10,
			2, 10, 10, 5,
			120, 85);

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public String getSize() {
		return size;
	}

	public String[] getLanguages() {
		return languages;
	}

	public int getIntuitiveDiceAmount() {
		return intuitiveDiceAmount;
	}

	public int getSelfTaughtDiceAmount() {
		return selfTaughtDiceAmount;
	}

	public int getTrainedDiceAmount() {
		return trainedDiceAmount;
	}
	
	public int getIntuitiveDiceSides() {
		return intuitiveDiceSides;
	}

	public int getSelfTaughtDiceSides() {
		return selfTaughtDiceSides;
	}

	public int getTrainedDiceSides() {
		return trainedDiceSides;
	}

	public int getBaseAge() {
		return baseAge;
	}

	public int getBaseMaleHeight() {
		return baseMaleHeight;
	}

	public int getBaseFemaleHeight() {
		return baseFemaleHeight;
	}

	public int getHeightDiceAmount() {
		return heightDiceAmount;
	}
	
	public int getMaleHeightDiceSides() {
		return maleHeightDiceSides;
	}

	public int getFemaleHeightDiceSides() {
		return femaleHeightDiceSides;
	}

	public int getWeightDiceAmount() {
		return weightDiceAmount;
	}
	
	public int getMaleWeightDiceSides() {
		return maleWeightDiceSides;
	}

	public int getFemaleWeightDiceSides() {
		return femaleWeightDiceSides;
	}
	
	public int getWeightMultiplier() {
		return weightMultiplier;
	}

	public int getBaseMaleWeight() {
		return baseMaleWeight;
	}

	public int getBaseFemaleWeight() {
		return baseFemaleWeight;
	}

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private int baseSpeed;
	private String size;
	private String[] languages;
	private int intuitiveDiceAmount;
	private int selfTaughtDiceAmount;
	private int trainedDiceAmount;
	private int intuitiveDiceSides;
	private int selfTaughtDiceSides;
	private int trainedDiceSides;
	private int baseAge;
	private int baseMaleHeight;
	private int baseFemaleHeight;
	private int heightDiceAmount;
	private int maleHeightDiceSides;
	private int femaleHeightDiceSides;
	private int weightDiceAmount;
	private int maleWeightDiceSides;
	private int femaleWeightDiceSides;
	private int weightMultiplier;
	private int baseMaleWeight;
	private int baseFemaleWeight;

	private Races(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
			int baseSpeed, String size, String[] languages, 
			int intuitiveDiceAmount, int selfTaughtDiceAmount, int trainedDiceAmount, 
			int intuitiveDiceSides, int selfTaughtDiceSides, int trainedDiceSides, int baseAge, 
			int baseMaleHeight, int baseFemaleHeight, 
			int heightDiceAmount, int maleHeightDiceSides, int femaleHeightDiceSides,
			int weightDiceAmount, int maleWeightDiceSides, int femaleWeightDiceSides, int weightMultiplier,
			int baseMaleWeight, int baseFemaleWeight) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.baseSpeed = baseSpeed;
		this.size = size;
		this.languages = languages;
		this.intuitiveDiceAmount = intuitiveDiceAmount;
		this.selfTaughtDiceAmount = selfTaughtDiceAmount;
		this.trainedDiceAmount = trainedDiceAmount;
		this.intuitiveDiceSides = intuitiveDiceSides;
		this.selfTaughtDiceSides = selfTaughtDiceSides;
		this.trainedDiceSides = trainedDiceSides;
		this.baseAge = baseAge;
		this.baseMaleHeight = baseMaleHeight;
		this.baseFemaleHeight = baseFemaleHeight;
		this.heightDiceAmount = heightDiceAmount;
		this.maleHeightDiceSides = maleHeightDiceSides;
		this.femaleHeightDiceSides = femaleHeightDiceSides;
		this.weightDiceAmount = weightDiceAmount;
		this.maleWeightDiceSides = maleWeightDiceSides;
		this.femaleWeightDiceSides = femaleWeightDiceSides;
		this.weightMultiplier = weightMultiplier;
		this.baseMaleWeight = baseMaleWeight;
		this.baseFemaleWeight = baseFemaleWeight;
	}

}
