package Project;

import java.util.Scanner;

public class Actor {
	private String name;
	private int level;
	private long maxHp;
	private long currHp;
	private int attack;
	private double critPercentage;
	private double expPercentage;
	private int currRow;
	private int currCol;
	
	
	//constructors
	public Actor(String name) {
		this.name = name;
		this.level = 1;
		this.maxHp = 1;
		this.attack = 1;
		this.critPercentage = 1;
		this.expPercentage = 0;
}
	
	public Actor(String name, int level) {
		this.name = name;
		this.level = level;
		this.maxHp = level;
		this.attack = level;
		this.critPercentage = level;
		this.expPercentage = 0;
	}
	
	
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}

	public long getmaxHp() {
		this.maxHp = (this.maxHp < 0) ? 0: this.maxHp;
		return this.maxHp;
	}
	
	public long getcurrHp() {
		this.currHp = (this.maxHp < 0) ? 0: this.currHp;
		return this.currHp;
	}
	public int getAttack() {
		return this.attack;
	}
	
	public double getCritPercentage() {
		return this.critPercentage;
	}
	
	public double getExpPercentage() {
		return this.expPercentage;
	}
	
	public int getRow() {
		return this.currRow;
	}
	
	public int getCol() {
		return this.currCol;
	}
	
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setlevel(int level) {
		this.level = level;
	}
	
	public void setmaxHp(long hp) {
		this.maxHp = hp;
	}
	
	public void setcurrHp(long hp) {
		this.currHp = hp;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public void setCritPercentage(double crit) {
		this.critPercentage = crit;
	}
	
	public void setExpPercentage(double exp) {
		this.expPercentage = exp;
	}
	
	public void setRow(int row) {
		this.currRow = row;
	}
	
	public void setCol(int col) {
		this.currCol = col;
	}
	
	//methods
	public int calculateAttackDamage() {
		int damage = 0;
		int randomValue = ((int)(Math.random() * 100));
		boolean isCritical = randomValue < this.critPercentage; 
		
		if (isCritical == false) {
			damage = this.attack;
		}
		
		else if (isCritical == true) {
			damage = this.attack + ((int) (this.attack/2));
		}
		
		return damage;
	}
	
	public void attack(Actor opponent) {
		int damage = calculateAttackDamage(); 
		opponent.setcurrHp((opponent.getcurrHp()) - damage); 
		if (opponent.getcurrHp() < 0) {
			opponent.setcurrHp(0);
		}
		System.out.println("You've dealt " + damage + " to your opponent!");
		System.out.println("The opponent has " + opponent.getcurrHp() + " HP left!");
		
		if (opponent.getcurrHp() == 0) {
			setExpPercentage(this.expPercentage + opponent.expPercentage);
			System.out.println("You've gained " + opponent.expPercentage + "% experience!");
			System.out.println("Your experience is now at: " + this.expPercentage + "%");
			
			levelUp();
		}
		
		else {
			
		}
		
	}
	
	public void levelUp() {
		while (this.expPercentage >= 100) {
			this.level += 1;
			this.maxHp = (long) ((this.maxHp)*1.1);
			this.attack += 5;
			this.critPercentage = this.critPercentage + 0.03;
			this.expPercentage = this.expPercentage - 100;
			
			System.out.println("Congratulations! You've leveled up!");
			System.out.println("Your stats are now: " + "\n" +
								"Level: " + this.level + "\n" +
								"HP: " + this.maxHp + "\n" +
								"Attack: " + this.attack + "\n" +
								"Crit %: " + this.critPercentage + "\n" +
								"Your experience is now at: " + this.expPercentage + "%");
								
		}
		
		if (this.expPercentage < 100) {
		
		}
	}

	public String toString(Actor protagonist) {
		return null;
	}
	
}