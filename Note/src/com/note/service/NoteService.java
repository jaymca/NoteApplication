/**
 * 
 */
package com.note.service;

import java.util.List;

import com.note.dao.NoteDAO;
import com.note.entity.Note;
import com.note.service.exception.NoteException;

/**
 * @author jay.prakash
 *
 */
public class NoteService {
	
	NoteDAO notedao = new NoteDAO();
	
	public void createNote(Note note) throws NoteException{		
		notedao.createNote(note);		
	}
	
	public List<Note> getNoteByUserId(int userId)throws NoteException{
		return notedao.getNoteByUserId(userId);
	}
	
	public Note getNoteById(int noteId)throws NoteException{
		return notedao.getNoteById(noteId);
	}
	
	
	public Note updateNote(Note note)throws NoteException{
		return notedao.updateNote(note);
	}
	
	public void deleteNote(int noteId)throws NoteException{
		notedao.deleteNote(noteId);
	}

}
