package hu.unideb.inf.reversi.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
public class Player extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_name", unique = true)
	@Size(min = 3)
	private String userName;
	@Column(name = "password", unique = false)
	@Size(min = 5)
	private String password;

	public Player() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
