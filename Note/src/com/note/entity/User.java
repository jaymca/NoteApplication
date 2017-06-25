/**
 * 
 */
package com.note.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jay.prakash
 *
 */
@Entity
@Table(name = "N_USER", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	private int userId;

	@NotNull
	private String email;

	@NotNull
	@Size(min = 8)
	@Column(name = "password", nullable = false, length = 8)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateTime;

	/*public User() {
	}

	public User(String email, String password, Date createTime, Date lastUpdateTime) {
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}*/

	public String getEmail() {
		return email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", createTime=" + createTime + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}

}