package Project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Project.Character.Class;


public class Game {
	
	private static final int GRID_ROWS = 4;
	private static final int GRID_COLUMNS = 4;
	private static final int NUM_LEVELS = 3;
	
	private static final String BOSS_NAME = "DRAGON";
	private static final int BOSS_LEVEL = 10;
	private static final Class BOSS_CLASS = Class.KNIGHT;
	
	private static Grid currGrid;
	private static Character protagonist;
	private static int numRows;
	private static int numCols;
	private static int currRow;
	private static int currCol;
	private static int currLevel;

	
	
	
	
	public static void main(String[] args) {
		int targetRow = 0;
		int targetCol = 0;
		int i = 0;
		
		Scanner scan = new Scanner(System.in);
		displayMainMenu();
		createLevel(protagonist, 1);
		
		while (currLevel <= NUM_LEVELS) {
			currGrid.display();
			System.out.println("To move, type in W, A, S, D to move your character");
			String moveInput = scan.next().toLowerCase();
			
			switch (moveInput) {
			case "w": 
				targetRow = protagonist.getRow()-1;
				targetCol = protagonist.getCol();
				break;
			case "a": 
				targetRow = protagonist.getRow();
				targetCol = protagonist.getCol()-1;
				
				break;
			case "s": 
				targetRow = protagonist.getRow()+1;
				targetCol = protagonist.getCol();
				break;
			case "d": 
				targetRow = protagonist.getRow();
				targetCol = protagonist.getCol()+1;
				break;
			default: 
				System.out.println("Invalid input, no movement");
				targetRow = protagonist.getRow();
				targetCol = protagonist.getCol();
			}
			
			moveCharacter(currGrid, targetRow, targetCol);
		}
	}
	
	
	
	
		public static int displayMainMenu() { //gives user options for the game. 
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to Object Oriented RPG! Become a HUNTER, ASSASSIN, or KNIGHT"
					+ "\n" + "to slay the evil dragon terrorizing the world! Crawl through numerous levels"
					+ "\n" + "of the dragon's dungeon in order to slay the beast!");
			System.out.println("[1] Start Game" + "\n" + "[2] Tutorial" + "\n" + "[3] EXIT");
	
			int userMainMenu = scan.nextInt();
			List<Integer> mainMenuOptions = Arrays.asList(1, 2, 3);
			
			while (mainMenuOptions.contains(userMainMenu) == false){
				System.out.println("Invalid input, please enter a number for Main Menu selection");
				displayMainMenu();
				
				if (mainMenuOptions.contains(userMainMenu)) {
					break;
				}
			} 
			
			switch (userMainMenu) {
				case 1: 
					displayCharacterCreation();
					break;
				
				case 2: 
					displayTutorial(); 
					break;
				
				case 3:
					System.out.println("The game will now shut down. To restart, please run the game again. Goodbye!");
					System.exit(0);
					
				default:
					System.out.println("An option was not selected");
					displayMainMenu();
			}
			
			return userMainMenu;	
			
		}
		
		
		public static void displayTutorial() { //provide user input in order to move char around grid
			System.out.println("Object Oriented RPG is a grid-based command line game. \n" 
					+ "You will provide user input in order to move the character around the grid.");
			System.out.println("[W] to move up \n" + "[A] to move left \n" + "[S] to move down \n"
								+ "[D] to move right \n");
			System.out.println("You will encounter enemies that are marked with an \"E\". The boss will"
					+ " be marked with \"B\". "
					+ "\nThe stairs to the next level will be marked with \"S\". \n");
			
			displayMainMenu();
		}
		
		
		
		public static Character displayCharacterCreation() {
			System.out.println("You are the protagonist of this world. \n"
								+ "Select a class from the following by typing in the number:");
			System.out.println("1. Hunter - Will have avg hp, high attack, low crit \n"
								+ "2. Assassin - Will have low hp, avg attack, high crit \n"
								+ "3. Knight - Will have high hp, avg attack, low crit");
			Scanner scan = new Scanner(System.in);
			int userCharacterCreate = scan.nextInt();
			String YesOrNo = "";
		
			
			switch (userCharacterCreate) {
				case 1:
					System.out.println("Your name is Protagonist of the HUNTER class. Is this correct (y/n)?);");
					YesOrNo = scan.next();
					
					if (YesOrNo.equals("y")) {
						protagonist = new Character("Protagonist", 1, "HUNTER");
						System.out.println("Your character has been created");
					} else if (YesOrNo.equals("n")) {
						displayCharacterCreation();
					} else {
						System.out.println("Please type in y or n");
						YesOrNo = "";
						displayCharacterCreation();
					}
					break;
					
				case 2: 
					System.out.println("Your name is Protagonist of the ASSASSIN class. Is this correct (y/n)?);");
					YesOrNo = scan.next();
					
					if (YesOrNo.equals("y")) {
						protagonist = new Character("Protagonist", 1, "ASSASSIN");
						System.out.println("Your character has been created");
						
					} else if (YesOrNo.equals("n")) {
						displayCharacterCreation();
					} else {
						System.out.println("Please type in y or n");
						YesOrNo = "";
						displayCharacterCreation();
					}
					break;
					
				case 3:
					System.out.println("Your name is Protagonist of the KNIGHT class. Is this correct (y/n)?);");
					YesOrNo = scan.next();
					
					if (YesOrNo.equals("y")) {
						protagonist = new Character("Protagonist", 1, "KNIGHT");
						System.out.println("Your character has been created");
						
					} else if (YesOrNo.equals("n")) {
						displayCharacterCreation();
					} else {
						System.out.println("Please type in y or n");
						YesOrNo = "";
						displayCharacterCreation();
					}
					break;
			}	//end of switch case
			
			
			return protagonist;
		}
		
		public static Enemy createRandomEnemy() {
			HashMap<String, String> enemyNameAndClass = new HashMap<String, String>();
			enemyNameAndClass.put("Goblin", "KNIGHT");
			enemyNameAndClass.put("Bat", "HUNTER");
			enemyNameAndClass.put("Slime", "KNIGHT");
			enemyNameAndClass.put("Thief", "ASSASSIN");
			
			ArrayList<String> enemyNames = new ArrayList<String>();
			enemyNames.add("Goblin");
			enemyNames.add("Bat");
			enemyNames.add("Slime");
			enemyNames.add("Thief");
			
			Random rand = new Random();
			String enemyName = enemyNames.get(rand.nextInt(4));
			int enemyLevel = rand.nextInt(1, protagonist.getLevel() + 2);
			String enemyClass = enemyNameAndClass.get(enemyName);
			
			Enemy enemy = new Enemy(enemyName, enemyLevel, enemyClass);
			return enemy;
		}
		
		public static void placeRandomly(Actor a) {
			Random rand = new Random();
			currRow = rand.nextInt(1, GRID_ROWS + currLevel);
			currCol = rand.nextInt(1, GRID_COLUMNS + currLevel);

				if (currGrid.getGrid()[currRow][currCol] != null) {
					placeRandomly(a);
					return;
				}
				else if (currGrid.getGrid()[currRow][currCol] == null) {
					if (a instanceof Character) {
						a.setRow(currRow);
						a.setCol(currCol);
						currGrid.place(a, currRow, currCol);
						}
					else {
						currGrid.place(a, currRow, currCol);
					}
				}
				
			}
			

		public static Grid createLevel(Actor protagonist, int level) {
			currLevel = level;
			numRows = GRID_ROWS + level;
			numCols = GRID_COLUMNS + level;
			currGrid = new Grid(numRows, numCols);
			placeRandomly(protagonist);

			//spawn and place enemies
			int enemySpawns = level + 4;
			while (enemySpawns > 0) {
				placeRandomly(createRandomEnemy());
				enemySpawns--;
			}
			
			//spawn and place stairs to next level
			if (currLevel < 3) {
				Stair stairs = new Stair("Stairs");
				placeRandomly(stairs);
			}
	
			
			HealingFountain heal = new HealingFountain("Heal");
			if (currLevel == 1 || currLevel == 2) {
				placeRandomly(heal);
			}
			else if (currLevel == 3) {
				placeRandomly(heal);
				placeRandomly(heal);
			}
			
			
			if (level == NUM_LEVELS) {
				Boss levelBoss = new Boss(BOSS_NAME, BOSS_LEVEL, BOSS_CLASS.toString());
				placeRandomly(levelBoss);
			}
			return currGrid;
		}
		
		
		public static Grid moveCharacter(Grid g, int targetRow, int targetCol) {
			
		if (targetRow >= 0 && targetCol >= 0 && targetRow < numRows && targetCol < numCols) { //if in bounds
			//if nothing is in the space
			if (currGrid.getGrid()[targetRow][targetCol] == null) {
				currGrid.getGrid()[protagonist.getRow()][protagonist.getCol()] = null;
				protagonist.setRow(targetRow);
				protagonist.setCol(targetCol);
				currGrid.place(protagonist, targetRow, targetCol);
				
			}
			//if there is an enemy in the space
			else if (currGrid.getGrid()[targetRow][targetCol] instanceof Enemy) {
				Battle enemyBattle = new Battle(protagonist, currGrid.getGrid()[targetRow][targetCol]);
				enemyBattle.startBattle(protagonist, (Character) currGrid.getGrid()[targetRow][targetCol]);
				if (enemyBattle.checkForWinner() == protagonist) {
					currGrid.getGrid()[protagonist.getRow()][protagonist.getCol()] = null;
					currGrid.place(protagonist, targetRow, targetCol);
				}
				else if (enemyBattle.checkForWinner() == currGrid.getGrid()[targetRow][targetCol]) {
					System.out.println("You lose!");
					System.exit(0);
				}
			}
			//if there are stairs in the space
			else if (currGrid.getGrid()[targetRow][targetCol] instanceof Stair) {
				currLevel++;
				currGrid = createLevel(protagonist, currLevel);
				System.out.println("You are now on level " + currLevel + "\n");
			}
			//if there is a healing fountain
			else if (currGrid.getGrid()[targetRow][targetCol] instanceof HealingFountain) {
				System.out.println("You healed from " + protagonist.getcurrHp() + " hp to " + protagonist.getmaxHp() + " hp" + "\n");
				protagonist.setcurrHp(protagonist.getmaxHp());
				
				currGrid.getGrid()[protagonist.getRow()][protagonist.getCol()] = null;
				currGrid.getGrid()[targetRow][targetCol] = null;
				currGrid.place(protagonist, targetRow, targetCol);
				
			}
			//if there is a boss
			else if (currGrid.getGrid()[targetRow][targetCol] instanceof Boss) {
				Battle enemyBattle = new Battle(protagonist, currGrid.getGrid()[targetRow][targetCol]);
				enemyBattle.startBattle(protagonist, (Character) currGrid.getGrid()[targetRow][targetCol]);
				if (enemyBattle.checkForWinner() == protagonist) {
					System.out.println("You defeated the Boss! Congratulations, you have won the game!");
					currLevel++;
					System.exit(0);
				}
				else if (enemyBattle.checkForWinner() == currGrid.getGrid()[targetRow][targetCol]) {
					System.out.println("You lost to the Boss, better luck next time");
					System.exit(0);
				}
			}
		}
		
		return currGrid;
		
	}
}
