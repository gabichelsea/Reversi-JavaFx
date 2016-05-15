package hu.unideb.inf.reversi.service.board;

import javafx.scene.layout.GridPane;

/**
 * Játéktábla, amely tartalmazza a tábla méretét, sor és oszlop szám szerint
 * 
 * @param <T>
 *            Amely egy általános típust jelöl
 */
public abstract class GameBoard<T> extends GridPane {

	/**
	 * A tábla sorainak száma
	 */
	protected Integer rows;

	/**
	 * A tábla oszlopainak száma
	 */
	protected Integer columns;

	/**
	 * Beállítja a sorok és oszlopok számát 0-ra
	 */
	public GameBoard() {
		this.rows = 0;
		this.columns = 0;
	}

	/**
	 * Lista, esetleg mátrix méretét meghatározó metódus, amit felül kell
	 * definiálni a kiterjesztő osztályoknak
	 * 
	 * @param columns
	 * @param rows
	 */
	protected abstract void setDimensions(Integer columns, Integer rows);

	/**
	 * Visszaadja a sorok számát
	 * 
	 * @return rows A sorok száma
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * Visszaadja az oszlopok számát
	 * 
	 * @return columns Az oszlopok száma
	 */
	public Integer getColumns() {
		return columns;
	}

	/**
	 * Beállítja a sorok számát, illetve inicializálva az őt kiterjesztő
	 * osztályban a lista, esetleg mátrix méretét
	 * 
	 * @param rows
	 *            A paraméterként szereplő sorok száma
	 */
	public final void setRows(Integer rows) {
		this.rows = rows;
		setDimensions(columns, rows);
	}

	/**
	 * Beállítja a oszlopok számát, illetve inicializálva az őt kiterjesztő
	 * osztályban a lista, esetleg mátrix méretét
	 * 
	 * @param columns
	 *            A paraméterként szereplő oszlopok száma
	 */
	public final void setColumns(Integer columns) {
		this.columns = columns;
		setDimensions(columns, rows);
	}

}
