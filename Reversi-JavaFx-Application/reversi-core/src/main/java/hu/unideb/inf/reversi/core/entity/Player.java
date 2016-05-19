package hu.unideb.inf.reversi.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Játékos amely tartalmazza egy adott játékos felhasználónevét és jelszavát.
 */
@Entity
@Table(name = "player")
public class Player extends BaseEntity {
	/**
	 * Serialazációs szám azonosító.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Felhasználónév, amelynek egyedinek kell lennie és legalább 3 karaktert
	 * kell tartalmaznia.
	 */
	@Column(name = "user_name", unique = true)
	@Size(min = 3)
	private String userName;

	/**
	 * Jelszó, amely kötelezően legalább 5 karakterből áll.
	 */
	@Column(name = "password", unique = false)
	@Size(min = 5)
	private String password;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor, a {@link Serializable}
	 * interfész miatt ajánlott hogy legyen.
	 */
	public Player() {
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
	 * @param userName A beállítandó felhasználónév.
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
	 * @param password A beállítandó jelszó.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
