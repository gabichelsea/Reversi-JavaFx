package hu.unideb.inf.reversi.service.vo;

import java.io.Serializable;

/**
 * Játékos amely tartalmazza egy adott játékos felhasználónevét és jelszavát,
 * illetve még az aktuális játék során lévő megszerzett pontok számát.
 */
public class PlayerVo implements Serializable {
	/**
	 * Serialazációs szám azonosító.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Azonosító, amely egyértelműen azonosítja a játékost, a felhasználóneve mellett.
	 */
	private Long id;

	/**
	 * Felhasználónév.
	 */
	private String userName;

	/**
	 * Jelszó.
	 */
	private String password;

	/**
	 * A játékoshoz tartozó pontokat tárolja, amit az adott meccsen elért.
	 */
	private Integer score;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor, ami a {@link Serializable}
	 * interfész miatt ajánlott.
	 */
	public PlayerVo() {
	}

	/**
	 * Visszaadja a játékoshoz tartozó azonosítót.
	 * 
	 * @return A játékos azonosítója.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * A játékoshoz tartozó azonosítót állítja be.
	 * 
	 * @param id A beállítandó azonosító.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Visszaadja a játékos felhasználónevét.
	 * 
	 * @return A játékos felhasználóneve.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Beállítja a játékos felhasználónevét.
	 * 
	 * @param userName
	 *            A beállítandó felhasználónév.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Visszaadja a játékos jelszavát.
	 * 
	 * @return A játékos jelszava.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Beállítja a játékos jelszavát.
	 * 
	 * @param password
	 *            A beállítandó jelszó.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Visszaadja a játékos adott mérkőzésen megszerzett pontjait.
	 * 
	 * @return A játékos mérkőzésén lévő megszerzett pontjait adja vissza.
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Beállítja a játékoshoz tartozó megszerzett pontokat.
	 * 
	 * @param score
	 *            A beállítandó megszerzett pontok.
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
