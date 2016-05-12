package hu.unideb.inf.reversi.view.container;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class ImageContainer<T> {

	private Map<T, Image> imageMap = new HashMap<T, Image>();

	public void addImage(T imageKey, String imageUrl) {
		Image image = getImageByUrl(imageUrl);
		if (image == null) {
			imageException(imageUrl);
		}
		imageMap.put(imageKey, image);
	}

	public Image getImageByUrl(String imageUrl) {
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

	public Map<T, Image> getImageMap() {
		return imageMap;
	}

	private void imageException(Object imageKey) {
		throw new IllegalArgumentException(TextContainer.IMG_NOT_FOUND + imageKey);
	}

}
