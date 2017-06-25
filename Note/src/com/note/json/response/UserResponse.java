/**
 * 
 */
package com.note.json.response;

import java.util.Date;

/**
 * @author jay.prakash
 *
 */

public class UserResponse {

	private int userId;

	private String email;
	
	private String createTime;

	private String lastUpdateTime;

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
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", createTime=" + createTime + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}

}