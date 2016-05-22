package hu.unideb.inf.reversi.service.vo;

import java.io.Serializable;

/**
 * Egy játékoshoz tartozó eredményeket reprezentáló osztály.
 */
public class PlayerResultVo implements Serializable {
	/**
	 * Serialazációs szám azonosító.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Azonosító, amely egyértelműen azonosítja az eredményt.
	 */
	private Long id;

	/**
	 * Játékos, akihez tartoznak az eredmények.
	 */
	private PlayerVo player;

	/**
	 * Meccsek száma.
	 */
	private Integer numberOfMatches;

	/**
	 * Győzelmek száma.
	 */
	private Integer win;

	/**
	 * Döntetlenek száma.
	 */
	private Integer draw;

	/**
	 * Vereségek száma.
	 */
	private Integer lose;

	/**
	 * Megszerzett korongok száma.
	 */
	private Integer wonPieces;

	/**
	 * Elvesztett korong száma.
	 */
	private Integer lostPieces;

	/**
	 * Pamaméter nélküli üres konstruktor.
	 */
	public PlayerResultVo() {
	}

	/**
	 * Visszaadja az eredményhez tartozó azonosítót.
	 * 
	 * @return Az eredmény azonosítója.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Az eredményhez tartozó azonosítót állítja be.
	 * 
	 * @param id
	 *            A beállítandó azonosító.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Visszaadja a játékost.
	 * 
	 * @return A játékos.
	 */
	public PlayerVo getPlayer() {
		return player;
	}

	/**
	 * Beállítja a játékost.
	 * 
	 * @param player
	 *            A beállítandó paraméter.
	 */
	public void setPlayer(PlayerVo player) {
		this.player = player;
	}

	/**
	 * Visszaadja a mérkőzések számát.
	 * 
	 * @return A mérkőzések száma.
	 */
	public Integer getNumberOfMatches() {
		return numberOfMatches;
	}

	/**
	 * Beállítja a mérkőzések számát.
	 * 
	 * @param numberOfMatches
	 *            A beállítandó paraméter.
	 */
	public void setNumberOfMatches(Integer numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	/**
	 * Visszaadja a győzelmek számát.
	 * 
	 * @return A győzelmek száma.
	 */
	public Integer getWin() {
		return win;
	}

	/**
	 * Beállítja a győzelmek számát.
	 * 
	 * @param win
	 *            A beállítandó paraméter.
	 */
	public void setWin(Integer win) {
		this.win = win;
	}

	/**
	 * Visszaadja a döntetlenek számát.
	 * 
	 * @return A döntetlenek száma.
	 */
	public Integer getDraw() {
		return draw;
	}

	/**
	 * Beállítja a döntetlenek számát.
	 * 
	 * @param draw
	 *            A beállítandó paraméter.
	 */
	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	/**
	 * Visszaadja a vereségek számát.
	 * 
	 * @return A vereségek száma.
	 */
	public Integer getLose() {
		return lose;
	}

	/**
	 * Beállítja a vereségek számát.
	 * 
	 * @param lose
	 *            A beállítandó paraméter.
	 */
	public void setLose(Integer lose) {
		this.lose = lose;
	}

	/**
	 * Visszaadja a megszerzett korongok számát.
	 * 
	 * @return A megszerzett korongok száma.
	 */
	public Integer getWonPieces() {
		return wonPieces;
	}

	/**
	 * Beállítja a megszerzett pontokat a paraméterként szereplőre.
	 * 
	 * @param wonPieces
	 *            A megszerzett pontokat állitja be a paraméterként szereplőre.
	 */
	public void setWonPieces(Integer wonPieces) {
		this.wonPieces = wonPieces;
	}

	/**
	 * Visszaadja az elvesztett korongok számát.
	 * 
	 * @return Az elvesztett korongok száma.
	 */
	public Integer getLostPieces() {
		return lostPieces;
	}

	/**
	 * Beállítja az elvesztett korongok számát.
	 * 
	 * @param lostPieces
	 *            A beállítandó paraméter.
	 */
	public void setLostPieces(Integer lostPieces) {
		this.lostPieces = lostPieces;
	}

}
