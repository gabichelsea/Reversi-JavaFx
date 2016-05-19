package hu.unideb.inf.reversi.service.interfaces;

/**
 * Általános funkciókat definiáló interfész.
 */
public interface BoardGameManager {

	/**
	 * Új játék.
	 */
	public void newGame();

	/**
	 * Következő kör.
	 */
	public void nextTurn();

	/**
	 * Játék állapot frissítése.
	 */
	public void updateStatus();

	/**
	 * Állapot frissítése játék vége esetén(végeredmény).
	 */
	public void updateGameOverStatus();
}
