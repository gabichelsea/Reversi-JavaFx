package hu.unideb.inf.reversi.core.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Főentitás amely egy absztrakt osztály, amely az id-t szolgáltatja az őt
 * kiterjesztő osztályok számára.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	/**
	 * Serialazációs szám azonosító
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id amely egyértelműen azonosítja majd a leszármaztatott objektumokat
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Alapértelmezett paraméter nélküli konstruktor a {@link Serializable} interfész implementálása jóvoltából
	 */
	public BaseEntity() {
	}

	/**
	 * Visszaadja az objektum id-ját 
	 * @return id Az adott objektumhoz tartozó id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Beállítja az objektum id-ját a paraméterben lévőre
	 * @param id A paraméterben szereplő id
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
