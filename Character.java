package Project;

public class Character extends Actor {
	
	public enum Class {
		HUNTER,
		ASSASSIN,
		KNIGHT 
	}
	
	private Class charClass;

	
	public Character (String name, int level, String charClass) {
		super(name, level); 
		this.charClass = Class.valueOf(charClass);
		
		switch(this.charClass) {
		case HUNTER:
			super.setmaxHp(level*6);
			super.setcurrHp(level*6);
			super.setAttack(level*4);
			super.setCritPercentage(level*15);
			break;
		
		case ASSASSIN:
			super.setmaxHp(level*5);
			super.setcurrHp(level*5);
			super.setAttack(level*3);
			super.setCritPercentage(level*35);
			break;
		
		case KNIGHT:
			super.setmaxHp(level*8);
			super.setcurrHp(level*8);
			super.setAttack(level*2);
			super.setCritPercentage(level*10);
			break;
		}
	}
	
	//getters
	public Character.Class getcharClass() {
		return this.charClass;
	}
	
	
	
	@Override
	public void levelUp() {
		while (super.getExpPercentage() >= 100) {
			
			switch(this.charClass) {
			case HUNTER:
				super.setlevel(getLevel() + 1);
				super.setmaxHp((long) super.getLevel()*3);
				super.setcurrHp((long) super.getLevel()*3);
				super.setAttack(super.getLevel()*3);
				super.setCritPercentage((double) super.getLevel()*3);
				super.setExpPercentage(getExpPercentage() - 100);
				break;
			
			case ASSASSIN: 
				super.setlevel(getLevel() + 1);
				super.setmaxHp((long) super.getLevel()*2);
				super.setcurrHp((long) super.getLevel()*2);
				super.setAttack(super.getLevel()*2);
				super.setCritPercentage((double) super.getLevel()*5);
				super.setExpPercentage(getExpPercentage() - 100);
				break;
				
			case KNIGHT: 
				super.setlevel(getLevel() + 1);
				super.setmaxHp((long) super.getLevel()*4);
				super.setcurrHp((long) super.getLevel()*4);
				super.setAttack(super.getLevel()*2);
				super.setCritPercentage((double) super.getLevel()*2);
				super.setExpPercentage(getExpPercentage() - 100);
				break;
			
			}
			
			System.out.println("Congratulations! You've leveled up!");
			System.out.println("Your stats are now: " + "\n" +
								"Level: " + super.getLevel() + "\n" +
								"HP: " + super.getcurrHp() + "/" + super.getmaxHp() + "\n" +
								"Attack: " + super.getAttack() + "\n" +
								"Crit %: " + super.getCritPercentage() + "\n" +
								"Your experience is now at: " + super.getExpPercentage() + "%");
			break;
		}
	}
	
	@Override
	public String toString() {
		return "P  ";
	}
}
