package hu.unideb.inf.reversi.service.board;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.CellApplyService;
import hu.unideb.inf.reversi.service.interfaces.CellService;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * A tényleges, Reversi játéktábla
 */
public class ReversiGameBoard extends ImageGameBoard<CellType> implements CellService {

	/**
	 * A cellákat tartalmazó listánk
	 */
	private List<CellType> cellList = new ArrayList<CellType>();

	/**
	 * Paraméter nélküli üres konstruktor
	 */
	public ReversiGameBoard() {
	}

	/**
	 * Megvizsgáljuk hogy a paraméterként szereplő cella érvényes-e
	 * 
	 * @param cellPosition
	 *            Cell pozíció amelyre vizsgáljuk hogy érvényes cella-e
	 * @return {@link Boolean} Visszaadja hogy érvényes-e a cella
	 */
	@Override
	public Boolean isValidCellPosition(CellPosition cellPosition) {
		Integer x = cellPosition.getRowIndex();
		Integer y = cellPosition.getColumnIndex();
		return ((x >= 0 && x < columns) && (y >= 0 && y < rows));
	}

	/**
	 * Beállítjuk az értéket, az adott cella pozícióra
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amelyre befogjuk állítani az értéket
	 * @param value
	 *            Érték, amelyet beállitunk az adott cella pozícióra
	 */
	@Override
	public void setCell(CellPosition cellPosition, CellType value) {
		if (isValidCellPosition(cellPosition)) {
			Integer position = getCellPositionNumber(cellPosition);
			while (cellList.size() <= position) {
				cellList.add(null);
			}
			cellList.set(position, value);
			updateCell(cellPosition);
		}
	}

	/**
	 * Cella frissítése cella pozíció által
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amely alapján frissítsük a cellát
	 */
	@Override
	public void updateCell(CellPosition cellPosition) {
		setImage(getCellByPosition(cellPosition), cellPosition);
	}

	/**
	 * Cellák kitöltése érték alapján
	 * 
	 * @param value
	 *            Érték, amellyel kitöltjük a cellákat
	 */
	@Override
	public void fillCells(CellType value) {
		Integer startX = 0, startY = 0;
		for (int x = startX; (x < columns); ++x) {
			for (int y = startY; (y < rows); ++y) {
				setCell(new CellPosition(x, y), value);
			}
		}
	}

	/**
	 * Visszaadja az adott cellát, cella pozíció által
	 * 
	 * @param cellPosition
	 *            Cella pozíció, amely alapján adjuk vissza a cellát
	 * @return {@link CellType} Cellatípus, amelyet visszaadunk cella pozíció
	 *         által
	 */
	@Override
	public CellType getCellByPosition(CellPosition cellPosition) {
		if (isValidCellPosition(cellPosition)) {
			Integer position = getCellPositionNumber(cellPosition);
			if (position >= 0 && position < cellList.size()) {
				return cellList.get(position);
			}
		}
		return null;
	}

	/**
	 * Visszaadja a cella helyzetét 1 dimenziós tömbben nézve
	 * 
	 * @param cellPosition
	 *            Cellapozíció, amelyből egy értéket állítunk elő, ami ugyanazon
	 *            cella lesz, csak 1 dimenziós eléréssel
	 * @return Visszadja a cella helyzetét 1 dimenziós tömbben nézve
	 */
	@Override
	public Integer getCellPositionNumber(CellPosition cellPosition) {
		return cellPosition.getRowIndex() * columns + cellPosition.getColumnIndex();
	}

	/**
	 * Összes rács kitöltése
	 * 
	 * @param value
	 *            Érték, amellyel kitöltjük az összes rácsot
	 */
	@Override
	public void fillAllGrid(CellType value) {
		fillCells(value);
	}

	/**
	 * Cella elfogadásáért felelős metódus
	 * @param cellApplyService Cella alkalmazás szolgáltatás
	 * @param child Csomópont gyermek
	 * @return Visszaadjuk az átvett cellát
	 */
	@Override
	public <T> T applyCell(CellApplyService<T> cellApplyService, Node child) {
		Integer x = findX(cellApplyService, child);
		Integer y = findY(cellApplyService, child);
		if (x != null && y != null) {
			return cellApplyService.applyCell(new CellPosition(x, y));
		}

		return null;
	}

	private <T> Integer findX(CellApplyService<T> cellApplyService, Node child) {
		Integer x = null;
		for (Node node = child; node != this; node = node.getParent()) {
			if ((x = GridPane.getColumnIndex(node)) != null) {
				break;
			}
		}
		return x;
	}

	private <T> Integer findY(CellApplyService<T> cellApplyService, Node child) {
		Integer y = null;
		for (Node node = child; node != this; node = node.getParent()) {
			if ((y = GridPane.getRowIndex(node)) != null) {
				break;
			}
		}
		return y;
	}

}
