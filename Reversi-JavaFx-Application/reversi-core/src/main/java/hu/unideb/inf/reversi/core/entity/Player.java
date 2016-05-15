package hu.unideb.inf.reversi.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Játékos osztály, amely tartalmazza egy adott játékos felhasználónevét és
 * jelszavát
 */
@Entity
@Table(name = "player")
public class Player extends BaseEntity {
	/**
	 * Serialazációs szám azonosító
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Felhasználónév, amelynek egyedinek kell lennie és legalább 3 karaktert kell tartalmaznia
	 */
	@Column(name = "user_name", unique = true)
	@Size(min = 3)
	private String userName;
	
	/**
	 * Jelszó, amely legalább 5 karakterből kell hogy álljon
	 */
	@Column(name = "password", unique = false)
	@Size(min = 5)
	private String password;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor, ami a {@link Serializable} interfész miatt ajánlott
	 */
	public Player() {
	}

	/**
	 * Visszaadja az adott Játékos objektum felhasználónevét
	 * @return userName A Player objektumhoz tartozó felhasználónév
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Beállítja az adott Játékos objektum felhasználónevét
	 * @param userName A paraméterben szereplő felhasználónév
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Visszaadja az adott Játékos objektum jelszavát
	 * @return password A Player objektumhoz tartozó jelszó
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Beállítja az adott Játékos objektum jelszavát
	 * @param password A paraméterben szereplő jelszó
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
