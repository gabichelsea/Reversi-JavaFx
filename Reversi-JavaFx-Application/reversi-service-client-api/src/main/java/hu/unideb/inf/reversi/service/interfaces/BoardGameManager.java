package hu.unideb.inf.reversi.service.interfaces;

/**
 * TáblaJátékMenedzser, amely definiál pár fontos müveletet a táblajátékok
 * számára
 */
public interface BoardGameManager {

	/**
	 * Új játék
	 */
	public void newGame();

	/**
	 * Játék állapot frissítése
	 */
	public void updateStatus();

	/**
	 * Következő kör
	 */
	public void nextTurn();

	/**
	 * Állapot frissítése játék vége esetén(végeredmény)
	 */
	public void updateGameOverStatus();
}
