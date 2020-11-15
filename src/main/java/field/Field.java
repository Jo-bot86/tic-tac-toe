package field;

/**
 * encapsulates all information about a field within the grid. Since the row and
 * column index of a field should not be changed within the grid, they are
 * declared as final. But the value of a field can be changed.
 * 
 * @author Josef Weldemariam
 *
 */
public class Field {

	private final int rowIndex;
	private final int colIndex;
	private int value; // 0 empty field, 1 for player X and 2 for player O

	/**
	 * 
	 * @param rowIndex row index of the field within the grid
	 * @param colIndex column index of the field within the grid
	 * @param value    value of the field
	 */
	public Field(int rowIndex, int colIndex, int value) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.value = value;
	}

	/**
	 * 
	 * @return the row index of a field within the grid
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * 
	 * @return the row index of a field within the grid
	 */
	public int getColIndex() {
		return colIndex;
	}

	/**
	 * sets the value for the field
	 * 
	 * @param value value between 0 and 2
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * get the value of the field
	 * 
	 * @return value between 0 and 2
	 */
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

}
