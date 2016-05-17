package hu.unideb.inf.reversi.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Játékos eredményeit tároló osztály
 */
@Entity
@Table(name = "player_result")
public class PlayerResult extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * Játékos objektum, amely tartalmazza, hogy kihez tartoznak az eredmények
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "player_id")
	@NotNull
	private Player player;

	/**
	 * Meccsek számát tároló változó
	 */
	@Column(name = "number_of_matches")
	private Integer numberOfMatches;

	/**
	 * Győzelmek számát tároló változó
	 */
	@Column(name = "win")
	private Integer win;

	/**
	 * Döntetlenek számát tároló változó
	 */
	@Column(name = "draw")
	private Integer draw;

	/**
	 * Vereségek számát tároló változó
	 */
	@Column(name = "lose")
	private Integer lose;

	/**
	 * Megszerzett korongok számát tároló változó
	 */
	@Column(name = "won_pieces")
	private Integer wonPieces;

	/**
	 * Elvesztett korong számát tároló változó
	 */
	@Column(name = "lost_pieces")
	private Integer lostPieces;

	/**
	 * Adatbázisban 0 értékkel kerülnek be az alábbi értékek, a null értékek
	 * helyett
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
	 * Pamaméter nélküli üres konstruktor
	 */
	public PlayerResult() {
	}

	/**
	 * Adott játékos objektumot visszaadó metódus
	 * 
	 * @return player Az adott játékost adja vissza
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Adott játékos beállító metódus
	 * 
	 * @param player
	 *            A paraméterként szerelő Játékos objektum, amelyet beállitunk
	 *            majd
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Visszaadja a mérkőzések számát
	 * 
	 * @return numberOfMatches A mérkőzések számát adja vissza
	 */
	public Integer getNumberOfMatches() {
		return numberOfMatches;
	}

	/**
	 * Beállítja a mérkőzések számát
	 * 
	 * @param numberOfMatches
	 *            Beállítja a mérkőzések számát a paraméterként szereplő értékre
	 */
	public void setNumberOfMatches(Integer numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	/**
	 * Visszaadja a győzelmek számát
	 * 
	 * @return win A győzelmek számát adja vissza
	 */
	public Integer getWin() {
		return win;
	}

	/**
	 * Beállítja a győzelmek számát
	 * 
	 * @param win
	 *            Beállítja a győzelmek számát a paraméterként szereplőre
	 */
	public void setWin(Integer win) {
		this.win = win;
	}

	/**
	 * Visszaadja a döntetlenek számát
	 * 
	 * @return draw A döntetlenek számát adja vissza
	 */
	public Integer getDraw() {
		return draw;
	}

	/**
	 * Beállítja a döntetlenek számát
	 * 
	 * @param draw
	 *            Beállítja a döntetlenek számát a paraméterként szereplőre
	 */
	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	/**
	 * Visszaadja a vereségek számát
	 * 
	 * @return lose A vereségek számát adja vissza
	 */
	public Integer getLose() {
		return lose;
	}

	/**
	 * Beállítja a vereségek számát
	 * 
	 * @param lose
	 *            A vereségek számát állítja be, a paraméterként szereplő
	 *            értékre
	 */
	public void setLose(Integer lose) {
		this.lose = lose;
	}

	/**
	 * Visszaadja a megszerzett korongok számát
	 * 
	 * @return wonPieces A megszerzett korongok számát adja vissza
	 */
	public Integer getWonPieces() {
		return wonPieces;
	}

	/**
	 * Beállítja a megszerzett pontokat a paraméterként szereplőre
	 * 
	 * @param wonPieces
	 *            A megszerzett pontokat állitja be a paraméterként szereplőre
	 */
	public void setWonPieces(Integer wonPieces) {
		this.wonPieces = wonPieces;
	}

	/**
	 * Visszaadja az elvesztett korongok számát
	 * 
	 * @return lostPieces Az elvesztett korongok számát adja vissza
	 */
	public Integer getLostPieces() {
		return lostPieces;
	}

	/**
	 * Beállítja az elvesztett korongok számát a paraméterként szereplőre
	 * 
	 * @param lostPieces
	 *            Beállítja az elvesztett korongok számát a paraméterként lévőre
	 */
	public void setLostPieces(Integer lostPieces) {
		this.lostPieces = lostPieces;
	}

}
