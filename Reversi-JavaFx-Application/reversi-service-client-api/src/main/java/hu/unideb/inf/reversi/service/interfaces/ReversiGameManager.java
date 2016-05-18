package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import javafx.scene.input.MouseEvent;

/**
 * Játék logikát szolgáltató interfész
 */
public interface ReversiGameManager extends BoardGameManager {

	/**
	 * Visszadja az aktuális játékoshoz tartozó korongok számát
	 * @param actualPlayer Az aktuális játékoshoz megszámoljuk, hogy hány korongja van
	 * @return {@link Integer} Visszaadja az adott játékoshoz tartozó korongok számát
	 */
	public Integer countPieces(ActualPlayer actualPlayer);

	/**
	 * Megszámolja, hogy hány olyan cella van, ahova letudja rakni az adott játékos a bábuját
	 * @param actualPlayer Az aktuális játékos
	 * @return {@link Integer} Visszaadja az adott játékos számára lerakható cellák számát
	 */
	public Integer countRemainingValidCells(ActualPlayer actualPlayer);

	/**
	 * Visszaadja az aktuális játékost
	 * @return {@link ActualPlayer} Visszaadja az aktuális játékost
	 */
	public ActualPlayer getActualPlayer();

	/**
	 * Mikor kattintok a felhasználói felületen, ezen metódus fog aktiválódni
	 * @param mouseEvent Egéresemény
	 */
	public void mouseClicked(MouseEvent mouseEvent);
	
	/**
	 * Visszaadja a játék jelenlegi eredményét
	 * @return {@link String} A játék jelenlegi eredményét adja vissza {@link String} formában
	 */
	public String getStatus();

}
