package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Enemy extends Character {
	
	public Enemy(String name, int level, String charClass) {
		super(name, level, charClass);
		
	}
	
	public int getEnemyLevel() {
		return this.getLevel();
	}
	
	public String getEnemyName() {
		return this.getName();
	}
	
	public String getEnemyClass() {
		return this.getcharClass().toString();
	}
	
	public int getEnemyAttack() {
		return this.getAttack();
	}
	
	@Override
	public String toString() {
		HashMap<String, String> enemyNameAndClass = new HashMap<String, String>();
		enemyNameAndClass.put("Goblin", "KNIGHT");
		enemyNameAndClass.put("Bat", "HUNTER");
		enemyNameAndClass.put("Slime", "KNIGHT");
		enemyNameAndClass.put("Bandit", "ASSASSIN");
		
		ArrayList<String> enemyNames = new ArrayList<String>();
		enemyNames.add("Goblin");
		enemyNames.add("Bat");
		enemyNames.add("Slime");
		enemyNames.add("Thief");
		String enemyAbbreviation= "";
		
		switch (this.getEnemyName()) {
			case "Goblin":
				enemyAbbreviation = this.getEnemyLevel() + "G";
				break;
			case "Bat":
				enemyAbbreviation = this.getEnemyLevel() + "B";
				break;
			case "Slime":
				enemyAbbreviation = this.getEnemyLevel() + "S";
				break;
			case "Thief":
				enemyAbbreviation = this.getEnemyLevel() + "T";
				break;
		}
		
		return enemyAbbreviation + "  ";
	}
	
	
}
