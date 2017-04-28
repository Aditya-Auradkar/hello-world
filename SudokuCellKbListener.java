package solution;
import java.awt.event.KeyEvent;

/*
 * An interface that will implement the GUI components that want to be
 * informed when a key is pressed on the GUI
 */
public interface SudokuCellKbListener {

	// the cell will call this method when a character will be pressed 
	// when they have focus
	public void keyPressed(Cell cell, int x, int y, KeyEvent e);
}
