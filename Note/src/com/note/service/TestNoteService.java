/**
 * 
 */
package com.note.service;

import java.util.Date;

import com.note.dao.NoteDAO;
import com.note.entity.Note;
import com.note.entity.User;

/**
 * @author jay.prakash
 *
 */

public class TestNoteService{
	public static void main(String[] args) {
		
		
		NoteDAO notedao = new NoteDAO();
		
		
		
		//notedao.getNoteById(2);
		//notedao.getNoteByUserId(1);
		
		//notedao.getNoteById(1);
		
		//notedao.deleteNote(3);
		Note note = new Note();
		/*User user= notedao.findUser(2);
		note.setUser(user);*/
		note.setNoteId(2);
		note.setTitle("QA Testing5");
		note.setNoteDesc("QA update5");
		note.setLastUpdateTime(new Date());
		note.setCreateTime(new Date());
		notedao.updateNote(note);
		
		
		/*note.setTitle("Test1234");
		note.setCreateTime(new Date());
		note.setLastUpdateTime(new Date());
		note.setNoteDesc("Test JPA");		
		notedao.createNote(note,1);		
		System.out.println(note);*/ 
		
		
		
	}
}
