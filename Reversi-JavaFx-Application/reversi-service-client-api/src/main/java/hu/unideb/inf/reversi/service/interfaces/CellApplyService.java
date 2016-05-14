package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.model.CellPosition;

@FunctionalInterface
public interface CellApplyService<T> {
	
	public T applyCell(CellPosition cellPosition);

}
