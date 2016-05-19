package hu.unideb.inf.reversi.service.board;

import javafx.scene.layout.GridPane;

/**
 * Játéktábla, amely tartalmazza a tábla méretét, sor és oszlop szám szerint.
 * 
 * @param <T>
 *            A tábla típusa.
 */
public abstract class GameBoard<T> extends GridPane {

	/**
	 * A tábla sorainak száma.
	 */
	protected Integer rows;

	/**
	 * A tábla oszlopainak száma.
	 */
	protected Integer columns;

	/**
	 * Inicializáljuk a sorok és oszlopok számát nullára.
	 */
	public GameBoard() {
		this.rows = 0;
		this.columns = 0;
	}

	/**
	 * A sorok és oszlopok számának szorzata lesz az adatszerkezetünk elemszáma.
	 * 
	 * @param columns
	 *            Az oszlopok száma.
	 * @param rows
	 *            A sorok száma.
	 */
	protected abstract void setDimensions(Integer columns, Integer rows);

	/**
	 * Visszaadja a sorok számát.
	 * 
	 * @return A sorok száma.
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * Beállítja a sorok számát majd megpróbálja inicializálni az adatszerkezet
	 * a setDimensions metódusunk meghívása által.
	 * 
	 * @param rows
	 *            A beállítandó sorok száma.
	 */
	public final void setRows(Integer rows) {
		this.rows = rows;
		setDimensions(columns, rows);
	}

	/**
	 * Visszaadja az oszlopok számát.
	 * 
	 * @return Az oszlopok száma.
	 */
	public Integer getColumns() {
		return columns;
	}

	/**
	 * Beállítja az oszlopok számát majd megpróbálja inicializálni az
	 * adatszerkezet a setDimensions metódusunk meghívása által.
	 * 
	 * @param columns
	 *            A beállítandó oszlopok száma.
	 */
	public final void setColumns(Integer columns) {
		this.columns = columns;
		setDimensions(columns, rows);
	}

}
