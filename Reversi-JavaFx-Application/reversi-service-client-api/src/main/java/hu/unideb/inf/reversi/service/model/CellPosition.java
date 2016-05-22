package hu.unideb.inf.reversi.service.model;

/**
 * Cella pozíciót tartalmazó osztály.
 */
public class CellPosition {

	/**
	 * Sor index.
	 */
	private Integer rowIndex;

	/**
	 * Oszlop index.
	 */
	private Integer columnIndex;

	/**
	 * Paraméternélküli üres konstruktor a példányosításhoz.
	 */
	public CellPosition() {
	}

	/**
	 * Kétparaméteres konstruktor amely a sorok indexét és az oszlopok indexét
	 * várja paraméterként.
	 * 
	 * @param rowIndex
	 *            A sorok indexe.
	 * @param columnIndex
	 *            Az oszlopok indexe.
	 */
	public CellPosition(Integer rowIndex, Integer columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	/**
	 * Visszaadja a sorok indexét.
	 * 
	 * @return A sorok indexe.
	 */
	public Integer getRowIndex() {
		return rowIndex;
	}

	/**
	 * Beállítja a sorok indexét.
	 * 
	 * @param rowIndex
	 *            A beállítandó sorok indexe.
	 */
	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	/**
	 * Visszaadja az oszlopok indexét.
	 * 
	 * @return Az oszlopok indexe.
	 */
	public Integer getColumnIndex() {
		return columnIndex;
	}

	/**
	 * Beállítja az oszlopok indexét.
	 * 
	 * @param columnIndex
	 *            A beállítandó oszlopok indexe.
	 */
	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
	}

}
