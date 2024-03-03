package Project;

public class HealingFountain extends Actor {

	public HealingFountain(String name) {
		super(name);
		super.setAttack(-1);
		super.setmaxHp(-1);
		super.setCritPercentage(-1);
	}
	
	@Override
	public String toString() {
		return "HEAL";
	}

}
