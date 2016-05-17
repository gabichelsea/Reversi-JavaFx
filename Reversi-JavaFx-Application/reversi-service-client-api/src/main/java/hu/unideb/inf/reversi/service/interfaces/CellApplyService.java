package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.model.CellPosition;

/**
 * Cellát elfogadó szolgáltatás interfész, amelynek pontosan egy metódusa van
 * @param <T> Egy általános típusú paraméter
 */
@FunctionalInterface
public interface CellApplyService<T> {
	
	/**
	 * Alkalmaz cella metódus, amely visszaadja azt a cellát, melyet majd átváltunk a sajátunkra
	 * @param cellPosition Cellapozíció, amely a paraméterként lévő cella pozíciót tartalmazza
	 * @return T Amely visszaadja az általunk elfogadott, átváltott cellát
	 */
	public T applyCell(CellPosition cellPosition);

}
