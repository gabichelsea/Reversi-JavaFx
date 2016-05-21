package hu.unideb.inf.reversi.service.container;

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
	 *            A kép elérési útja {@link String} típusként ábrázolva.
	 */
	public void addImage(T imageKey, String imageUrl) {
		Image image = new Image(ClassLoader.getSystemResourceAsStream(imageUrl));
		imageMap.put(imageKey, image);
	}


	/**
	 * Visszaadjuk a képeket tároló adatszerkezetet.
	 * 
	 * @return A képeket tároló adatszerkezet.
	 */
	public Map<T, Image> getImageMap() {
		return imageMap;
	}

}
