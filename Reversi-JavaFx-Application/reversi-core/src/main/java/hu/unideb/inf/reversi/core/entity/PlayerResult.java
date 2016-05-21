package hu.unideb.inf.reversi.core.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Egy játékoshoz tartozó eredményeket reprezentáló osztály.
 */
@Entity
@Table(name = "player_result")
public class PlayerResult extends BaseEntity {
	/**
	 * Serialazációs szám azonosító.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Játékos, ő hozzá fognak tartozni az osztályban lévő eredmények.
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "player_id")
	@NotNull
	private Player player;

	/**
	 * A meccsek száma.
	 */
	@Column(name = "number_of_matches")
	private Integer numberOfMatches;

	/**
	 * A győzelmek száma.
	 */
	@Column(name = "win")
	private Integer win;

	/**
	 * A döntetlenek száma.
	 */
	@Column(name = "draw")
	private Integer draw;

	/**
	 * A vereségek száma.
	 */
	@Column(name = "lose")
	private Integer lose;

	/**
	 * A megszerzett korongok száma.
	 */
	@Column(name = "won_pieces")
	private Integer wonPieces;

	/**
	 * Az elvesztett korongok száma.
	 */
	@Column(name = "lost_pieces")
	private Integer lostPieces;

	/**
	 * Az adatbázisba 0 értékkel kerülnek be az alábbi értékek, a null értékek
	 * helyett.
	 */
	@PrePersist
	private void init() {
		numberOfMatches = 0;
		win = 0;
		draw = 0;
		lose = 0;
		wonPieces = 0;
		lostPieces = 0;
	}

	/**
	 * Pamaméter nélküli üres konstruktor, ami a {@link Serializable} interfész
	 * implementálása miatt ajánlott.
	 */
	public PlayerResult() {
	}

	/**
	 * Visszaadja a játékost.
	 * 
	 * @return A játékos.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Beállítja a játékost.
	 * 
	 * @param player
	 *            A beállítandó paraméter.
	 */
	public void setPlayer(Player player) {
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
	 * Beállítja a megszerzett pontokat.
	 * 
	 * @param wonPieces
	 *            A beállítandó paraméter.
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
