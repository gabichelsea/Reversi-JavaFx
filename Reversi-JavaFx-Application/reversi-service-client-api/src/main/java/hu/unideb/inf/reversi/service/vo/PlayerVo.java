package hu.unideb.inf.reversi.service.vo;

import java.io.Serializable;
/**
 * Játékos osztály, amely tartalmazza egy adott játékos felhasználónevét és
 * jelszavát
 */
public class PlayerVo implements Serializable {
	/**
	 * Serialazációs szám azonosító
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id, amely egyértelműen azonosítja a játékost, a felhasználóneve mellett
	 */
	private Long id;
	
	/**
	 * Felhasználónév, amelynek egyedinek kell lennie és legalább 3 karaktert
	 * kell tartalmaznia
	 */
	private String userName;
	
	/**
	 * Jelszó, amely legalább 5 karakterből kell hogy álljon
	 */
	private String password;
	
	/**
	 * Az adott játékoshoz tartozó pontokat tárolja, amit az adott meccsen elér
	 */
	private Integer score;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor, ami a {@link Serializable}
	 * interfész miatt ajánlott
	 */
	public PlayerVo() {
	}

	/**
	 * Visszaadja az adott játékoshoz tartozó id-t
	 * @return id Az adott játékoshoz tartozó id-t adja vissza
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Az adott játékoshoz tartozó id-t állítja be
	 * @param id Az adott játékoshoz tartozó id-t állitja be
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Visszaadja az adott Játékos objektum felhasználónevét
	 * 
	 * @return userName A Player objektumhoz tartozó felhasználónév
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Beállítja az adott Játékos objektum felhasználónevét
	 * 
	 * @param userName
	 *            A paraméterben szereplő felhasználónév
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Visszaadja az adott Játékos objektum jelszavát
	 * 
	 * @return password A Player objektumhoz tartozó jelszó
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Beállítja az adott Játékos objektum jelszavát
	 * 
	 * @param password
	 *            A paraméterben szereplő jelszó
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * A mérkőzés közben lévő játákos pontok tárolására szolgál
	 * @return score Az adott játékos adott mérkőzésén lévő pontjait adja vissza
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Beállítja az adott játékoshoz tartozó pontokat
	 * @param score Az adott játékos pontjait beállításra kitüzött változó
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
