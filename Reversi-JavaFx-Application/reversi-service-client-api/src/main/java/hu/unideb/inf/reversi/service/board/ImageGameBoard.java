package hu.unideb.inf.reversi.service.board;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.container.ImageContainer;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * KépesJátékTábla amely tartalmazz egy képtárolót és egy képlistát ami mátrixot szimulál
 * @param <T> Amely egy általános típust jelöl
 */
public abstract class ImageGameBoard<T> extends GameBoard<T> {

	/**
	 * Képlista, ami mátrixnak feletethető meg
	 */
	private List<ImageView> imageViewList;
	
	/**
	 * Képtároló, amelyből a képlistánkat felépítjük
	 */
	private ImageContainer<T> imageContainer = new ImageContainer<T>();

	/**
	 * Alapértelmezett konstruktor hogy legyen
	 */
	public ImageGameBoard() {
	}

	/**
	 * Beállítja a képListánk méretét a sorok és oszlopok számának szorzatára
	 */
	@Override
	protected void setDimensions(Integer columns, Integer rows) {
		imageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < columns * rows; ++i) {
			imageViewList.add(null);
		}
	}
	
	public void setImage(T imageKey, CellPosition cellPosition) {
		ImageView imageView = getImageView(imageKey, cellPosition);
		Image image = getImageByKey(imageKey);
		imageView.setImage(image);
	}

	private ImageView getImageView(T imageKey, CellPosition cellPosition) {
		Integer x = cellPosition.getRowIndex();
		Integer y = cellPosition.getColumnIndex();
		Integer imagePosition = x * columns + y;
		
		ImageView imageView = imageViewList.get(imagePosition);
		if (imageView == null) {
			imageView = new ImageView();
			add(imageView, x, y);
		}
		return imageView;
	}

	private Image getImageByKey(T imageKey) {
		return imageContainer.getImageMap().get(imageKey);
	}

	public ImageContainer<T> getImageContainer() {
		return imageContainer;
	}
	
	
	
}
