package solution;
/*
 * A simple class that holds a main() method to unit test the 
 * the method in BruteForce that test if a Sudoku grid is valid
 */
public class TestIfValidGrid {

	/*
	 * The main() method
	 */
	public static void main(String[] args) {
		// Build the Grid
		Grid grid = new Grid(9);
		
		// Load it with an valid problem
		System.out.println("Test with a valid problem");
		Problems.setValidProblem1(grid);
		// call the method that validates asking it to display the grids
		boolean status = BruteForce.isValidSudoku(grid, true);
		System.out.println("Methods returns equals: " + status);
        System.out.println();
        
		// Load it with an invalid problem
		System.out.println("Test with an invalid problem");
		Problems.setInvalidProblem1(grid);
		// call the method that validates asking it to display the grids
		status = BruteForce.isValidSudoku(grid, true);
		System.out.println("Methods returns equals: " + status);
	}
}

