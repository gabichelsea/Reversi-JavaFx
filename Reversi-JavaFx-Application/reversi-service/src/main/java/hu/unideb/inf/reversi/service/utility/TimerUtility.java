package hu.unideb.inf.reversi.service.utility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

/**
 * Időzítést segítő segédosztály.
 */
public class TimerUtility {

	/**
	 * Feladatok elvégzését segítő metódus, amely adott késésse toldja meg az
	 * elvégzést.
	 * 
	 * @param delay
	 *            A késleltés ideje.
	 * @param tasks
	 *            A feladatok.
	 */
	public static void runDelayed(Integer delay, Runnable... tasks) {
		runDelayed(new Timer(), delay, new LinkedList<Runnable>(Arrays.asList(tasks)));
	}

	private static void runDelayed(Timer timer, Integer delay, Queue<Runnable> queue) {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (!queue.isEmpty()) {
					for (Runnable runnable : queue) {
						Platform.runLater(runnable);
					}
				}
				timer.cancel();
			}
		}, delay);
	}

}
