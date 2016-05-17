package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.Node;

/**
 * Cella szolgáltatások interfész
 */
public interface CellService {

	/**
	 * Megvizsgáljuk hogy a paraméterként szereplő cella érvényes-e
	 * 
	 * @param cellPosition
	 *            Cell pozíció amelyre vizsgáljuk hogy érvényes cella-e
	 * @return {@link Boolean} Visszaadja hogy érvényes-e a cella
	 */
	public Boolean isValidCellPosition(CellPosition cellPosition);

	/**
	 * Beállítjuk az értéket, az adott cella pozícióra
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amelyre befogjuk állítani az értéket
	 * @param value
	 *            Érték, amelyet beállitunk az adott cella pozícióra
	 */
	public void setCell(CellPosition cellPosition, CellType value);

	/**
	 * Cella frissítése cella pozíció által
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amely alapján frissítsük a cellát
	 */
	public void updateCell(CellPosition cellPosition);

	/**
	 * Cellák kitöltése érték alapján
	 * 
	 * @param value
	 *            Érték, amellyel kitöltjük a cellákat
	 */
	public void fillCells(CellType value);

	/**
	 * Összes rács kitöltése
	 * 
	 * @param value
	 *            Érték, amellyel kitöltjük az összes rácsot
	 */
	public void fillAllGrid(CellType value);

	/**
	 * Visszaadja az adott cellát, cella pozíció által
	 * 
	 * @param cellPosition
	 *            Cella pozíció, amely alapján adjuk vissza a cellát
	 * @return {@link CellType} Cellatípus, amelyet visszaadunk cella pozíció
	 *         által
	 */
	public CellType getCellByPosition(CellPosition cellPosition);

	/**
	 * Visszaadja a cella helyzetét 1 dimenziós tömbben nézve
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amelyből egy értéket állítunk elő, ami ugyanazon
	 *            cella lesz, csak 1 dimenziós eléréssel
	 * @return Visszadja a cella helyzetét 1 dimenziós tömbben nézve
	 */
	public Integer getCellPositionNumber(CellPosition cellPosition);

	/**
	 * Cella elfogadásáért felelős metódus
	 * @param cellApplyService Cella alkalmazás szolgáltatás
	 * @param child Csomópont gyermek
	 * @return Visszaadjuk az átvett cellát
	 */
	public <T> T applyCell(CellApplyService<T> cellApplyService, Node child);
}
