package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.model.CellPosition;

/**
 * Cellát elfogadó szolgáltatás interfész, amelynek pontosan egy metódusa van,
 * ezáltal a {@link FunctionalInterface} annotációval el is van látva.
 * 
 * @param <T>
 *            Azon típus, amely a cellák elfogadásában szerepet játszik.
 */
@FunctionalInterface
public interface CellApplyService<T> {

	/**
	 * T típusű értéket visszadó metódus, amennyiben az elfogadás siker volt.
	 * 
	 * @param cellPosition
	 *            A megvizsgálandó cella pozíciója.
	 * @return A T típusú érték.
	 */
	public T applyCell(CellPosition cellPosition);

}
