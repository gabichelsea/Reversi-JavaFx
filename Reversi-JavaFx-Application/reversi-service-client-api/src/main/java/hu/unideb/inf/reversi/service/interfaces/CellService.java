package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.Node;

/**
 * Cellákhoz kapcsolódó legfontosabb müveletek.
 */
public interface CellService {

	/**
	 * Megvizsgáljuk hogy a paraméterként szereplő cella érvényes-e.
	 * 
	 * @param cellPosition
	 *            A vizsgálandó cella pozíció.
	 * @return Érvényes-e a cella
	 */
	public Boolean isValidCellPosition(CellPosition cellPosition);

	/**
	 * Beállítjuk az adott cella pozícióra az adott cella értéket.
	 * 
	 * @param cellPosition
	 *            A beállítandó cella helyzete.
	 * @param value
	 *            A beállítandó cella "értéke".
	 */
	public void setCell(CellPosition cellPosition, CellType value);

	/**
	 * Cella frissítése cella pozíció által.
	 * 
	 * @param cellPosition
	 *            A frissítendő cella pozíciója.
	 */
	public void updateCell(CellPosition cellPosition);

	/**
	 * Cellák kitöltése az adott érték alapján.
	 * 
	 * @param value
	 *            A cellákat kitöltendő érték.
	 */
	public void fillCells(CellType value);

	/**
	 * Az összes rács kitöltése.
	 * 
	 * @param value
	 *            Azon érték, amellyel kitöltjük az összes rácsot.
	 */
	public void fillAllGrid(CellType value);

	/**
	 * Visszaadja az adott cellát, a cella pozíció által.
	 * 
	 * @param cellPosition
	 *            Az a cella pozíció, amelyhez tartozó cellát visszaadjuk.
	 * @return A cellapozícióhoz tartozó cella.
	 */
	public CellType getCellByPosition(CellPosition cellPosition);

	/**
	 * Visszaadja a cella helyzetét 1 dimenziós tömbben számítva.
	 * 
	 * @param cellPosition
	 *            A cella pozíciója két dimenziósan modellezve.
	 * @return Visszadja a cella helyzetét egy dimenziósan modellezve.
	 */
	public Integer getCellPositionNumber(CellPosition cellPosition);


	/**
	 * Cella elfogadásáért felelős metódus.
	 * @param cellApplyService A cella elfogadását definiáló interfész.
	 * @param child A gyermek csomópont.
	 * @return T típus, amelyet az interfész definiál.
	 */

	public <T> T applyCell(CellApplyService<T> cellApplyService, Node child);
}
