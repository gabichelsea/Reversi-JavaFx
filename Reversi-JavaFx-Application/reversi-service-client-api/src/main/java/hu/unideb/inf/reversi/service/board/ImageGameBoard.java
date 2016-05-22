package hu.unideb.inf.reversi.service.board;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.container.ImageContainer;
import hu.unideb.inf.reversi.service.model.CellPosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Játéktábla, amely tartalmaz egy képtárolót illetve egy képeket tartalmazó
 * listát.
 * 
 * @param <T>
 *            A tábla típusa
 */
public abstract class ImageGameBoard<T> extends GameBoard<T> {

	/**
	 * Képeket tartalmazó lista.
	 */
	private List<ImageView> imageViewList;

	/**
	 * Képek tárolására szolgáló osztály.
	 */
	private ImageContainer<T> imageContainer = new ImageContainer<T>();

	/**
	 * Alapértelmezett paraméternélküli konstruktor.
	 */
	public ImageGameBoard() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setDimensions(Integer columns, Integer rows) {
		imageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < columns * rows; ++i) {
			imageViewList.add(null);
		}
	}

	/**
	 * Lekérünk egy képnézetet, majd beállítjuk neki a képkulcs által lekért
	 * képet.
	 * 
	 * @param imageKey
	 *            Ezen képkulcs alapján kérjük le a képet.
	 * @param cellPosition
	 *            Ezen cellapozíció alapján kérjük le az adott pozíciójú
	 *            képnézetet.
	 */
	public void setImage(T imageKey, CellPosition cellPosition) {
		getImageView(cellPosition).setImage(getImageByKey(imageKey));
	}

	/**
	 * Visszaadja a képtárolót.
	 * 
	 * @return A képtároló.
	 */
	public ImageContainer<T> getImageContainer() {
		return imageContainer;
	}

	/**
	 * Visszaadja a képNézetet, a cellapozició alapján.
	 * @param cellPosition
	 *            Az a cellapozició, amelyik poziciónál lévő képNézetet
	 *            szeretnénk lekérni
	 * @return {@link ImageView}, a cellapozicio alapján visszaadva, ha ez null,
	 *         akkor egy új példányt adunk vissza
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
	 * Visszaadja a képtároló objektumból a képkulcshoz tartozó képet.
	 * 
	 * @param imageKey
	 *            A képkulcs alapján kapunk egy képet a képtárolónkból.
	 * @return A képkulcshoz tartozó kép.
	 */
	private Image getImageByKey(T imageKey) {
		return imageContainer.getImageMap().get(imageKey);
	}

}
