package Project;

public class Stair extends Actor {
	
	public Stair(String name) {
		super(name);
		super.setAttack(-1);
		super.setmaxHp(-1);
		super.setCritPercentage(-1);
		
	}
	
	@Override
	public String toString() {
		return "STAIRS";
	}

}
