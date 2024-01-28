package Project;

public class Battle {
	Actor attacker;
	Actor defender;
	
	public Battle(Actor attacker, Actor defender) {
		this.attacker = attacker;
		this.defender = defender; 
	}
	
	//getters 
	public Actor getAttacker() {
		return this.attacker;
	}
	
	public Actor getDefender() {
		return this.defender;
	}
	
	//setters 
	public void setAttacker(Actor attacker) {
		this.attacker = attacker;
	}
	
	public void setDefender(Actor defender) {
		this.defender = defender;
	}
	
	//methods
	public Actor checkForWinner() {
		long atkHP = attacker.getcurrHp();
		long defHP = defender.getcurrHp();
		Actor winner = null;
		
		if (atkHP > 0 && defHP > 0) {
			winner = null;
		}
		
		else if (defHP == 0) {
			winner = attacker;
		}
	
		else if (atkHP == 0) {
			winner = defender;
		}
		
		return winner;
	}
	
	public Actor startBattle(Character attacker, Character defender) {
		int battleTurns = 1;
		while (attacker.getcurrHp() > 0 && defender.getcurrHp() > 0) {
			
			System.out.println("Round " + battleTurns + " of the battle has started!");
			System.out.println("The protagonist has " + attacker.getcurrHp() + " HP with " + attacker.getAttack() + " attack");
			System.out.println("The " + defender.getName() + " has " + defender.getcurrHp() + " HP with " + defender.getAttack() + " attack");
			System.out.println(attacker.getName() + " attacks with "
								+ attacker.calculateAttackDamage() + " damage!");
			defender.setcurrHp(Math.max(0, defender.getcurrHp() - attacker.calculateAttackDamage()));
			System.out.println(defender.getName() + "'s remaining HP is " + defender.getcurrHp()); 
			System.out.println("Your remaining HP is " + attacker.getcurrHp());
			checkForWinner();
			if (checkForWinner() == null) {
				System.out.println(defender.getName() + " attacks with " + defender.calculateAttackDamage() +
									" damage!");
				attacker.setcurrHp(Math.max(0, attacker.getcurrHp() - defender.calculateAttackDamage()));
				System.out.println(attacker.getName() + "'s remaining HP is " + attacker.getcurrHp());
				checkForWinner();
				battleTurns++;
			}
		}
		
		System.out.println("The winner of the battle is: " + checkForWinner().getName() + "!" + "\n");
		
			if (checkForWinner() == attacker) {
				attacker.setExpPercentage(attacker.getExpPercentage() + Math.floor(defender.getLevel()/attacker.getLevel() + 5) * 10);
				attacker.levelUp();
			}
			
			else if (checkForWinner() == defender) {
				defender.setExpPercentage(defender.getExpPercentage() + Math.floor(attacker.getLevel()/defender.getLevel() + 5) * 10);
				defender.levelUp();
				System.out.println("You have died... Please try again");
				System.exit(0);
			}
		
		return checkForWinner();
	}
}
