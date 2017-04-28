package solution;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Use the following already posted classes:
 * - Grid the center call
 * - SudokuGenerator to create a new Grid
 * - BruteForce to validate that the Sudoku solution os unique
 * - GridGuiOne the standard Sudoku JPanel
 * Sudoku generator that can be edited by the user to remove (restore) cells
 * The program will also verify, when cells are cleared, that the Sudoku
 * is still valid meaning that is still has a single solution
 */
public class SudokuGeneratorGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// to remember the cells values if the user decides to fall back
	private int[][] cellValue;
	// the Grid object
	private Grid grid;
	// it's size
	private int size;
	// My generator
	private SudokuGenerator generator;
	
	// the JButton to perform reload with a new Grid
	private JButton btnReload = new JButton("Reload with a new Grid");
	// a JLabel for the status at the bottom (init with with a \n so it will be showed)
	private JLabel statusLabel = new JLabel("\n");
	
	
	/*
	 * Constructors
	 */
	SudokuGeneratorGui(Grid grid) {
		super("Sudoku generator");
		this.grid = grid;
		
		// the generator
		generator = new SudokuGenerator(grid);
		// create the array to save the cell values
		size = grid.getSize();
		cellValue = new int[size][size];
		
		// get the cells to inform them that I will be their MouseListener
		Cell[][] cell = grid.getCells();
		// loop throutg them
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				// add as mouseListener my own inner class passing the coords as parameter
				cell[i][j].addMouseListener(new Listener(i,j));
			}
		}
		// put the JButton in the North region
		btnReload.setForeground(Color.RED);
		btnReload.addActionListener(this);
		add(btnReload, BorderLayout.NORTH);
		
		// use a standard GuiGridOne as Panel in the center
		add(new GridGuiOne(grid), BorderLayout.CENTER);
		
		// add the status label at the bottom
		statusLabel.setOpaque(true);
		statusLabel.setBackground(new Color(255, 255, 125)); // light yellow
		add(statusLabel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// erase previous message
		statusLabel.setText("\n");
		// a reload was requested
		generator.resetGrid();
		// save the cells values
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cellValue[i][j] = grid.getValue(i, j);
			}
		}
	}

	/*
	 * an inner class to receive the mouse click and process them
	 */
	class Listener implements MouseListener {
		
		// coords in the Grid of the Cell that has been clicked
		private int x, y;
		/*
		 * Constructor
		 */
		Listener(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// erase previous message
			statusLabel.setText("\n");
			// if no problem loaded yet the cell value will be 0
			if(cellValue[x][y] == 0) {
				statusLabel.setText("Load a Grid first using the \"Reload with a new Grid\" button");
				statusLabel.setForeground(Color.BLACK);
				return;
			}
			// test if the Grid value is 0 in that case it is a reload
			// or if it is a cell that we want to clear
			if(grid.getValue(x, y) == 0) {
				// restore the old value
				grid.setCellValue(x, y, cellValue[x][y]);
			}
			else {
				// ok set the Grid value to 0
				grid.setCellValue(x, y, 0);
				// and verify if the Sudoku grid is still valid
				boolean status = BruteForce.isValidSudoku(grid);
				// ok Sudoku grid still we can exit
				if(status)
					return;
				// sorry invalid try
				// send message to the user
				statusLabel.setText("Sorry clearing this cell would make the Sudoku invalid");
				statusLabel.setForeground(Color.RED);
				// restore the Cell value
				grid.setCellValue(x, y, cellValue[x][y]);
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		
	}
	
	/*
	 * To start the GUI
	 */
	public static void main(String[] args) {
		// create a Sudoku Grid 9x9
		Grid grid = new Grid(9);
		JFrame frame = new SudokuGeneratorGui(grid);
		frame.setVisible(true);
		frame.pack();
		// the packed frame will only be good to display "" blank labels when
		// number will pe put it wont resize so we will have to make it a little bit bigger
		Dimension d = frame.getSize();
		d.height *= 7;
		d.width *= 7;
		d.height /= 6;
		d.width /= 6;
		frame.setSize(d);

	}
}
