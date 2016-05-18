package hu.unideb.inf.reversi.service.model;

/**
 * Cella pozíciót tartalmazó osztály
 */
public class CellPosition {

	/**
	 * Azt adja meg hogy hanyadik sorban lévő cellát szeretnénk
	 */
	private Integer rowIndex;
	
	/**
	 * Azt adja meg hogy hanyadik oszlopban lévő cellát szeretnénk
	 */
	private Integer columnIndex;

	/**
	 * Paraméternélküli üres konstruktor a példányosításhoz
	 */
	public CellPosition() {
	}

	/**
	 * Kétparaméteres konstruktor amely a sorok indexét és az oszlopok indexét várja paraméterként
	 * @param rowIndex A sorok indexének beállításra szolgál
	 * @param columnIndex Az oszlopok indexének beállítására szolgál
	 */
	public CellPosition(Integer rowIndex, Integer columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	/**
	 * Visszaadja a sorok indexét
	 * @return rowindex A sorok indexét adja vissza
	 */
	public Integer getRowIndex() {
		return rowIndex;
	}

	/**
	 * Beállítja a sorok indexét
	 * @param rowIndex Beállítja a sorok indexét
	 */
	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	/**
	 * Visszaadja az oszlopok indexét
	 * @return columnIndex Az oszlopok indexét adja vissza
	 */
	public Integer getColumnIndex() {
		return columnIndex;
	}

	/**
	 * Beállítja az oszlopok indexét
	 * @param columnIndex Az oszlopok indexének beállítására szolgáló paraméter
	 */
	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
	}

}
