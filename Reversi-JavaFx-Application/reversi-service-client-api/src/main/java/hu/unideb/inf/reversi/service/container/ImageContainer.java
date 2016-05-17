package hu.unideb.inf.reversi.service.container;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * Képeket tároló osztály
 * 
 * @param <T>
 *            Amely egy általános típust jelöl
 */
public class ImageContainer<T> {

	/**
	 * Képeket tároló adatszerkezet
	 */
	private Map<T, Image> imageMap = new HashMap<T, Image>();

	/**
	 * Képek hozzáadását végző metódus
	 * 
	 * @param imageKey
	 *            Képkulcs, amely alapján adjuk hozzá vagy modositsuk a képeket
	 *            tároló adatszerkezetben a képeket
	 * @param imageUrl
	 *            A kép url-jét tároló változó
	 */
	public void addImage(T imageKey, String imageUrl) {
		Image image = getImageByUrl(imageUrl);
		if (image == null) {
			imageException(imageUrl);
		}
		imageMap.put(imageKey, image);
	}

	/**
	 * Visszaadja a képet, képUrl alapján
	 * @param imageUrl Képurl, amely alapján adjuk vissza a képet
	 * @return Image Kép, amelyet a képUrl alapján adunk vissza
	 */
	private Image getImageByUrl(String imageUrl) {
		Image image = imageMap.get(imageUrl);
		if (image == null) {
			URL url = null;

			try {
				url = new URL("file:" + imageUrl);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			if (url != null) {
				image = new Image(url.toExternalForm());
			}
		}
		return image;
	}

	/**
	 * Képeket tároló adatszerkezet visszaadása
	 * @return Map<T, Image> képeket tároló adatszerkezet visszaadása
	 */
	public Map<T, Image> getImageMap() {
		return imageMap;
	}

	/**
	 * {@link IllegalArgumentException} dobása, amennyiben nem található a képünk
	 * @param imageUrl KépUrl amely alapján nem található a kép
	 */
	private void imageException(String imageUrl) {
		throw new IllegalArgumentException(TextContainer.IMG_NOT_FOUND + imageUrl);
	}

}
