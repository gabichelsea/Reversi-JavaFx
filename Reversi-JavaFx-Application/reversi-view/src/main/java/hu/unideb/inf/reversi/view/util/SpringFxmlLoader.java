package hu.unideb.inf.reversi.view.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.fxml.FXMLLoader;

public class SpringFxmlLoader {

	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-view.xml");

	public Object load(String url) {
		try (InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url)) {

			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
			return loader.load(fxmlStream);

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void close() {
		((ConfigurableApplicationContext) applicationContext).close();
	}
}