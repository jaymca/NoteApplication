/**
 * 
 */
package com.note.json.response;

import java.util.Date;

/**
 * @author jay.prakash
 *
 */

public class NoteResponse{

	private int noteId;	
	private String title;
	private String noteDesc;
	private String createTime;
	private String lastUpdateTime;
	private UserResponse user;
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoteDesc() {
		return noteDesc;
	}

	public void setNoteDesc(String noteDesc) {
		this.noteDesc = noteDesc;
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
		return "Note [noteId=" + noteId + ", user=" + user + ", title=" + title + ", noteDesc=" + noteDesc
				+ ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}

}
