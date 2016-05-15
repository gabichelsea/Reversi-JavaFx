package hu.unideb.inf.reversi.service.vo;

import java.io.Serializable;

public class PlayerResultVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private PlayerVo player;

	private Integer numberOfMatches;
	private Integer win;
	private Integer draw;
	private Integer lose;
	private Integer wonPieces;
	private Integer lostPieces;

	public PlayerResultVo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayerVo getPlayer() {
		return player;
	}

	public void setPlayer(PlayerVo player) {
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

	@Override
	public String toString() {
		return "PlayerResultVo [id=" + id + ", player=" + player + ", numberOfMatches=" + numberOfMatches + ", win="
				+ win + ", draw=" + draw + ", lose=" + lose + ", wonPieces=" + wonPieces + ", lostPieces=" + lostPieces
				+ "]";
	}

}
