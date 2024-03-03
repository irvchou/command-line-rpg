package Project;


public class Grid {
	
	private Actor[][] grid;
	private int numRows;
	private int numCols;  
		
	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numCols = columns;
		this.grid = new Actor[this.numRows][this.numCols];
		
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
					grid[i][j] = null;
				}
			}
		}
	
	
	//getters
	
	public int getRows() {
		return this.numRows;
	}
	
	public int getCols() {
		return this.numCols;
	}

	public Actor[][] getGrid() {
		return this.grid;
	}

	
	//setters
	
	public void setRows(int rows) {
		this.numRows = rows;
	}
	
	public void setCols(int columns) {
		this.numCols = columns;
	}
	
	//methods
	public void display() {
	for (int i = 0; i < this.numRows; i++) {
		for (int j = 0; j < this.numCols; j++) {
			System.out.print("[" + grid[i][j] + "] ");
		}
	System.out.println("\n");
		}
	}
	
	
	public void place(Actor actor, int row, int col) {
		grid[row][col] = actor;
		actor.setRow(row);
		actor.setCol(col);
		
	}
	
	
	
}
