package hu.unideb.inf.reversi.service.container;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * Képeket tároló osztály, amely ezt kulcs-érték párok formájában valósítja meg.
 * 
 * @param <T>
 *            Azon típus, amely kulcsként szolgál a hozzá rendelt képhez.
 */
public class ImageContainer<T> {

	/**
	 * Képeket tároló adatszerkezet.
	 */
	private Map<T, Image> imageMap = new HashMap<T, Image>();
	
	/**
	 * Paraméter nélküli üres konstruktor.
	 */
	public ImageContainer() {
	}

	/**
	 * A paraméterként megadott kulccsal és a hozzá tartozó URL által elérhető
	 * képpel egy új kulcs-érték párat adunk hozzá a képtárolóhoz.
	 * 
	 * @param imageKey
	 *            A képhez tartozó kulcsunk.
	 * @param imageUrl
	 *            A kép url-je {@link String} típusként ábrázolva.
	 */
	public void addImage(T imageKey, String imageUrl) {
		Image image = getImageByUrl(imageUrl);
		if (image == null) {
			imageException(imageUrl);
		}
		imageMap.put(imageKey, image);
	}

	/**
	 * Visszaadja a képet, URL alapján.
	 * 
	 * @param imageUrl
	 *            Azon URL, mely alapján visszaadjuk a képet.
	 * @return Az URL alapján lekért kép.
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
	 * Visszaadjuk a képeket tároló adatszerkezetet.
	 * 
	 * @return A képeket tároló adatszerkezet.
	 */
	public Map<T, Image> getImageMap() {
		return imageMap;
	}

	/**
	 * {@link IllegalArgumentException} dobása, mivel ezen URL által nem érhető
	 * el kép.
	 * 
	 * @param imageUrl
	 *            A hibás URL
	 */
	private void imageException(String imageUrl) {
		throw new IllegalArgumentException(TextContainer.IMG_NOT_FOUND + imageUrl);
	}

}
