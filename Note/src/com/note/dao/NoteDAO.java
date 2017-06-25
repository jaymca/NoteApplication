/**
 * 
 */
package com.note.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.note.entity.Note;
import com.note.entity.User;
import com.note.util.EntityManagerUtil;

/**
 * @author jay.prakash
 *
 */

public class NoteDAO {
	EntityManager entityManager = null;
	
	public void createNote(Note note) {		
		try {
			int userid = note.getUser().getUserId();
			System.out.println("UserId:: "+userid);
			User user = findUser(userid);
			note.setUser(user);
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(note);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User findUser(int userId) {		
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			User user = entityManager.find(User.class, userId);
			entityManager.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Note> getNoteByUserId(int userId) {		
		List<Note> notes = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			Query query =  entityManager.createNamedQuery("QUERY_NOTE_BY_USERID");
			query.setParameter("userId", userId);
			notes= query.getResultList();
			System.out.println("notes:: "+notes.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}
	
	public Note getNoteById(int noteId) {		
		Note note = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			note =  entityManager.find(Note.class, noteId);
			System.out.println("notes:: "+note);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return note;
	}
	
	public Note updateNote(Note notein){
		Note note = null;
		try {			
			entityManager = EntityManagerUtil.getEntityManager();
			note =  entityManager.find(Note.class, notein.getNoteId());
			entityManager.getTransaction().begin();
			note.setNoteDesc(notein.getNoteDesc());
			note.setTitle(notein.getTitle());
			note.setLastUpdateTime(notein.getLastUpdateTime());
			entityManager.merge(note);
			System.out.println(note);
			entityManager.getTransaction().commit();		
		}catch (Exception e){
			e.printStackTrace();
		}
		return note;	
	}
	
	public void deleteNote(int noteId){

		try {			
			entityManager= EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			Note note = (Note)entityManager.find(Note.class, noteId);
			entityManager.remove(note);
			entityManager.getTransaction().commit();			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}

	public void insertUser(User user) {		
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
