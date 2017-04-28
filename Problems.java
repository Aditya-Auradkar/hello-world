package solution;

/**
 * A class that contains, for test purpose, the setters for different
 * Sudoku problems
 */
public class Problems {

	/*
	 * private method called by the others to load a problem
	 */
	private static void load(Grid grid, int[][] val) {
		// clear grid because if it already contains something
		// the setOriginalProblemValue might reject to set a cell to a value already there
		for(int i = 0; i < val.length; i++) {
			for(int j = 0; j < val[i].length; j++) {
				grid.setCellValue(i, j, 0);	
			}
		}
		// load with new problem
		for(int i = 0; i < val.length; i++) {
			for(int j = 0; j < val[i].length; j++) {
				grid.setOriginalProblemValue(i, j, val[i][j]);	
			}
		}
	}
	// preregistered problem 1	
	public static void setProblem1(Grid grid) {
		int[][] val = {
				{0, 0, 0, 0, 0, 7, 0, 0, 0},
				{3, 0, 0, 0, 6, 0, 0, 5, 0},
				{7, 0, 0, 9, 2, 0, 0, 1, 0},
				{0, 8, 0, 0, 3, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 5, 0, 6},
				{9, 0, 0, 6, 0, 8, 0, 0, 0},
				{0, 0, 0, 0, 1, 3, 6, 0, 0},
				{0, 0, 0, 5, 0, 0, 1, 2, 0},
				{0, 9, 0, 0, 0, 0, 7, 0, 3}
		};
		// loat it with my values
		load(grid, val);
	}

	/*
	 * preregisterd problem 2
	 * this is kind of worst case for brute force
	 * no clue on top row where the only solution is 987654321 
	 * so a huge amount of iterations will be required
	 * this a good problem to test in the brute force with reverse in BruteForceGui.java
	 * (may be not with the GUI version it would take a while :-))
	 */
	public static void setProblem2(Grid grid) {
		int[][] val = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 8, 5},
				{0, 0, 1, 0, 2, 0, 0, 0, 0},
				{0, 0, 0, 5, 0, 7, 0, 0, 0},
				{0, 0, 4, 0, 0, 0, 1, 0, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 0},
				{5, 0, 0, 0, 0, 0, 0, 7, 3},
				{0, 0, 2, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 4, 0, 0, 0, 0, 9}
		};
		// loat it with my values
		load(grid, val);
	}
	
	/*
	 * and almost done Sudoku problem to see the BruteForce GUI in action
	 * the top part if almost done so the reversed method should be slower 
	 * on that one
	 */
	public static void setProblem3(Grid grid) {
		int[][] val = {
				{6, 1, 9, 2, 8, 4, 5, 7, 3},
				{3, 7, 0, 5, 1, 6, 4, 0, 9},
				{4, 5, 2, 0, 7, 0, 8, 0, 0},
				{7, 4, 5, 9, 0, 3, 1, 0, 0},
				{2, 0, 0, 8, 5, 1, 7, 9, 0},
				{8, 9, 1, 0, 2, 0, 3, 6, 0},
				{5, 0, 0, 6, 3, 0, 9, 0, 1},
				{0, 0, 3, 0, 0, 2, 6, 0, 7},
				{1, 0, 4, 0, 9, 0, 0, 0, 0}
		};
		// loat it with my values
		load(grid, val);
	}

	/*
	 * And invalid Sudoku (more than one solution)
	 * to test the static method in BruteForce that check if a sudoku is valid
	 * The row #4 with makes the Sudoku problem valid has been commented out
	 * removing the 5 in the last column makes this Sudoku a non valid
	 * Sudoku problem
	 */
	public static void setValidProblem1(Grid grid) {
		int[][] val = {
				{6, 0, 0, 0, 0, 0, 1, 4, 0},
				{3, 0, 8, 0, 0, 4, 0, 0, 6},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 5},  // <--- requires the 5 here to be valid
				{0, 2, 1, 0, 3, 6, 0, 0, 4},
				{0, 0, 0, 0, 0, 0, 7, 0, 0},
				{0, 0, 7, 0, 5, 0, 3, 9, 1},
				{5, 0, 6, 0, 0, 1, 0, 0, 7},
				{0, 9, 0, 7, 4, 2, 0, 0, 0}
		};
		// loat it with my values
		load(grid, val);		
	}
	public static void setInvalidProblem1(Grid grid) {
		int[][] val = {
				{6, 0, 0, 0, 0, 0, 1, 4, 0},
				{3, 0, 8, 0, 0, 4, 0, 0, 6},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},  // <--- invalid with this row 
// valid row	{0, 0, 0, 2, 0, 0, 0, 0, 5},  // <--- requires the 5 here to be valid
				{0, 2, 1, 0, 3, 6, 0, 0, 4},
				{0, 0, 0, 0, 0, 0, 7, 0, 0},
				{0, 0, 7, 0, 5, 0, 3, 9, 1},
				{5, 0, 6, 0, 0, 1, 0, 0, 7},
				{0, 9, 0, 7, 4, 2, 0, 0, 0}
		};
		// loat it with my values
		load(grid, val);		
	}
	/*
	 * To unit test the whole thing
	 */
	public static void main(String[] args) {
		// create a Grid
		Grid grid = new Grid(9);
		// fill and print it
		setProblem1(grid);
		grid.printGrid();
		// fill and print it
		setProblem2(grid);
		grid.printGrid();
		// fill and print it
		setProblem3(grid);
		grid.printGrid();
	}
}

