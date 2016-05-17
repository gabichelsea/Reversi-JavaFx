package hu.unideb.inf.reversi.service.board;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.container.ImageContainer;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * KépesJátékTábla amely tartalmazz egy képtárolót és egy képlistát ami mátrixot
 * szimulál
 * 
 * @param <T>
 *            Amely egy általános típust jelöl
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

	/**
	 * Lekérünk egy képNézetet és egy képet, majd a képNézetnek beállítjuk a
	 * képet
	 * 
	 * @param imageKey
	 *            Képkulcs, amely alapján lekérjük a képTárolóból az adott képet
	 * @param cellPosition
	 *            Cellapozició, amely alapján lekérjük a listánkból az adott
	 *            pozicioju képnézetet
	 */
	public void setImage(T imageKey, CellPosition cellPosition) {
		ImageView imageView = getImageView(cellPosition);
		Image image = getImageByKey(imageKey);
		imageView.setImage(image);
	}

	/**
	 * Visszaadja a képNézetet, a cellapozició alapján
	 * 
	 * @param cellPosition
	 *            Az a cellapozició, amelyik poziciónál lévő képNézetet
	 *            szeretnénk lekérni
	 * @return ImageView Képnézet, a cellapozicio alapján visszaadva, ha ez
	 *         null, akkor egy új példányt adunk vissza
	 */
	private ImageView getImageView(CellPosition cellPosition) {
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

	/**
	 * Visszaadja a képtároló objektumból a képkulcs-hoz tartozó objektumot
	 * 
	 * @param imageKey
	 *            Képkulcs, amely alapján kérjük le a hozzá tartozó objekumot
	 * @return Image Visszaadja a képet, amit a képkulcs alapján kérünk le
	 */
	private Image getImageByKey(T imageKey) {
		return imageContainer.getImageMap().get(imageKey);
	}

	/**
	 * Visszaadja a képtároló objektumot
	 * 
	 * @return imageContainer Visszaadja a képtároló objektumot
	 */
	public ImageContainer<T> getImageContainer() {
		return imageContainer;
	}

}
