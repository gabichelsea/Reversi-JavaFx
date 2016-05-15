package hu.unideb.inf.reversi.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_result")
public class PlayerResult extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@Column(name = "number_of_matches")
	private Integer numberOfMatches;

	@Column(name = "win")
	private Integer win;

	@Column(name = "draw")
	private Integer draw;

	@Column(name = "lose")
	private Integer lose;

	@Column(name = "won_pieces")
	private Integer wonPieces;

	@Column(name = "lost_pieces")
	private Integer lostPieces;

	public PlayerResult() {
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getNumberOfMatches() {
		return numberOfMatches;
	}

	public void setNumberOfMatches(Integer numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getLose() {
		return lose;
	}

	public void setLose(Integer lose) {
		this.lose = lose;
	}

	public Integer getWonPieces() {
		return wonPieces;
	}

	public void setWonPieces(Integer wonPieces) {
		this.wonPieces = wonPieces;
	}

	public Integer getLostPieces() {
		return lostPieces;
	}

	public void setLostPieces(Integer lostPieces) {
		this.lostPieces = lostPieces;
	}

}
