package hu.unideb.inf.reversi.service.board;

import javafx.scene.layout.GridPane;

public abstract class GameBoard<T> extends GridPane {

	protected Integer rows;
	protected Integer columns;


	public GameBoard() {
		this.rows = 0;
		this.columns = 0;
	}

	protected abstract void setDimensions(Integer columns, Integer rows);

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public final void setRows(Integer rows) {
		this.rows = rows;
		setDimensions(columns, rows);
	}

	public final void setColumns(Integer columns) {
		this.columns = columns;
		setDimensions(columns, rows);
	}

}
