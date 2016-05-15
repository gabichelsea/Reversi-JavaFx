package hu.unideb.inf.reversi.view.utility;

import javafx.beans.property.SimpleStringProperty;

public class PlayerResultUtil {

	private SimpleStringProperty playerName;
	private SimpleStringProperty numberOfMatches;
	private SimpleStringProperty win;
	private SimpleStringProperty draw;
	private SimpleStringProperty lose;
	private SimpleStringProperty wonPieces;
	private SimpleStringProperty lostPieces;
	private SimpleStringProperty differentPieces;
	private SimpleStringProperty score;

	public PlayerResultUtil() {
		this.playerName = new SimpleStringProperty();
		this.numberOfMatches = new SimpleStringProperty();
		this.win = new SimpleStringProperty();
		this.draw = new SimpleStringProperty();
		this.lose = new SimpleStringProperty();
		this.wonPieces = new SimpleStringProperty();
		this.lostPieces = new SimpleStringProperty();
		this.differentPieces = new SimpleStringProperty();
		this.score = new SimpleStringProperty();
	}

	public PlayerResultUtil(String playerName, String numberOfMatches, String win, String draw, String lose,
			String wonPieces, String lostPieces, String differentPieces, String score) {
		this.playerName = new SimpleStringProperty(playerName);
		this.numberOfMatches = new SimpleStringProperty(numberOfMatches);
		this.win = new SimpleStringProperty(win);
		this.draw = new SimpleStringProperty(draw);
		this.lose = new SimpleStringProperty(lose);
		this.wonPieces = new SimpleStringProperty(wonPieces);
		this.lostPieces = new SimpleStringProperty(lostPieces);
		this.differentPieces = new SimpleStringProperty(differentPieces);
		this.score = new SimpleStringProperty(score);
	}

	public String getPlayerName() {
		return playerName.get();
	}

	public void setPlayerName(String playerName) {
		this.playerName.set(playerName);
	}

	public String getNumberOfMatches() {
		return numberOfMatches.get();
	}

	public void setNumberOfMatches(String numberOfMatches) {
		this.numberOfMatches.set(numberOfMatches);
	}

	public String getWin() {
		return win.get();
	}

	public void setWin(String win) {
		this.win.set(win);
	}

	public String getDraw() {
		return draw.get();
	}

	public void setDraw(String draw) {
		this.draw.set(draw);
	}

	public String getLose() {
		return lose.get();
	}

	public void setLose(String lose) {
		this.lose.set(lose);
	}

	public String getWonPieces() {
		return wonPieces.get();
	}

	public void setWonPieces(String wonPieces) {
		this.wonPieces.set(wonPieces);
	}

	public String getLostPieces() {
		return lostPieces.get();
	}

	public void setLostPieces(String lostPieces) {
		this.lostPieces.set(lostPieces);
	}

	public String getDifferentPieces() {
		return differentPieces.get();
	}

	public void setDifferentPieces(String differentPieces) {
		this.differentPieces.set(differentPieces);
	}

	public String getScore() {
		return score.get();
	}

	public void setScore(String score) {
		this.score.set(score);
		;
	}

	@Override
	public String toString() {
		return "PlayerResultVo [numberOfMatches=" + numberOfMatches + ", win=" + win + ", draw=" + draw + ", lose="
				+ lose + ", wonPieces=" + wonPieces + ", lostPieces=" + lostPieces + "]";
	}
}
