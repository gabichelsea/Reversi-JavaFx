package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import javafx.scene.input.MouseEvent;

/**
 * Játék logikát szolgáltató interfész.
 */
public interface ReversiGameManager extends BoardGameManager {

	/**
	 * Visszadja az aktuális játékoshoz tartozó korongok számát.
	 * @param actualPlayer Az aktuális játékos.
	 * @return Az aktuális játékoshoz tartozó korongok száma.
	 */
	public Integer countPieces(ActualPlayer actualPlayer);

	/**
	 * Megszámolja, hogy hány olyan cella van, ahova letudja rakni az adott játékos a korongját.
	 * @param actualPlayer Az aktuális játékos
	 * @return Azon cellák száma, ahova letudja rakni a saját korongját.
	 */
	public Integer countRemainingValidCells(ActualPlayer actualPlayer);

	/**
	 * Visszaadja az aktuális játékost.
	 * @return Aktuális játékos.
	 */
	public ActualPlayer getActualPlayer();

	/**
	 * Egérkattintásért felelős metódus.
	 * @param mouseEvent Egéresemény, ami a kattintás miatt fontos.
	 */
	public void mouseClicked(MouseEvent mouseEvent);
	
	/**
	 * Visszaadja a játék jelenlegi eredményét
	 * @return A játék aktuális állása, eredménye.
	 */
	public String getStatus();

}
