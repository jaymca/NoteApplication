/**
 * 
 */
package com.note.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jay.prakash
 *
 */
@NamedQueries(value =
{
	/*******************************
     * Note Query
     *******************************/

    @NamedQuery(name = "QUERY_NOTE_BY_USERID", query = "SELECT n FROM Note n " + "WHERE n.user.userId = :userId ")

})
@Entity
public class Note implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "note_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "note_gen")
	private int noteId;	

	@NotNull
	@Size(max = 50)
	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@Size(max = 1000)
	@Column(name = "noteDesc", length = 50)
	private String noteDesc;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateTime;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable=false)
	private User user;
	
	/*
	public Note() {
		super();
	}

	public Note(String title, String noteDesc, Date createTime, Date lastUpdateTime, User user) {
		this.title = title;
		this.noteDesc = noteDesc;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.user = user;
	}*/

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
		return "Note [noteId=" + noteId + ", user=" + user + ", title=" + title + ", noteDesc=" + noteDesc
				+ ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}

}
