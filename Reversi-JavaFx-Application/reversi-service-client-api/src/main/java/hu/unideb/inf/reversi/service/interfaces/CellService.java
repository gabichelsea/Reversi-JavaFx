package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.model.CellPosition;

public interface CellService {

	public Boolean isValidCellPosition(CellPosition cellPosition);

	public void setCell(CellPosition cellPosition, CellType value);

	public void updateCell(CellPosition cellPosition);

	public void fillCells(CellType value);

	public CellType getCellByPosition(CellPosition cellPosition);

	public Integer getCellPositionNumber(CellPosition cellPosition);
}
