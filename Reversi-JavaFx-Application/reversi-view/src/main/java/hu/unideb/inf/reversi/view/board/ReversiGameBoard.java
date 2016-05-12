package hu.unideb.inf.reversi.view.board;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.CellService;
import hu.unideb.inf.reversi.service.model.CellPosition;

public class ReversiGameBoard extends ImageGameBoard<CellType> implements CellService {

	private List<CellType> cellList = new ArrayList<CellType>();

	public ReversiGameBoard() {
	}

	@Override
	public Boolean isValidCellPosition(CellPosition cellPosition) {
		Integer x = cellPosition.getRowIndex();
		Integer y = cellPosition.getColumnIndex();
		return ((x >= 0 && x < columns) && (y >= 0 && y < rows));
	}

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

	@Override
	public void updateCell(CellPosition cellPosition) {
		setImage(getCellByPosition(cellPosition), cellPosition);
	}

	@Override
	public void fillCells(CellType value) {
		Integer startX = 0, startY = 0;
		for (int x = startX; (x < columns); ++x) {
			for (int y = startY; (y < rows); ++y) {
				setCell(new CellPosition(x, y), value);
			}
		}
	}

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

	@Override
	public Integer getCellPositionNumber(CellPosition cellPosition) {
		return cellPosition.getRowIndex() * columns + cellPosition.getColumnIndex();
	}

	public void fillAllGrid(CellType value) {
		fillCells(value);
	}

}
