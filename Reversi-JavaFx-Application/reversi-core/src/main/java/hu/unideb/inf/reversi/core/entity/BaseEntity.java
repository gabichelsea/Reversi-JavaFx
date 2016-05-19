package hu.unideb.inf.reversi.core.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Főentitás amely egy absztrakt osztály, mely az azonosítót szolgáltatja az őt
 * kiterjesztő osztályok számára.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	/**
	 * Serialazációs szám azonosító.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Azonosító amely egyértelműen azonosítja majd a leszármaztatottakat.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor, ami a {@link Serializable}
	 * interfész implementálása miatt ajánlott.
	 */
	public BaseEntity() {
	}

	/**
	 * Visszaadja az azonosítót.
	 * 
	 * @return Az azonosító.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Beállítja az azonosítót.
	 * 
	 * @param id
	 *            A beállítandó azonosító.
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
