/**
 * 
 */
package com.note.controller;

import java.util.Date;

import com.note.entity.Note;
import com.note.json.response.NoteResponse;
import com.note.json.response.UserResponse;
import com.note.service.NoteService;
import com.note.service.exception.NoteException;

/**
 * @author jay.prakash
 *
 */
public class TestService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoteService noteService = new NoteService();
		//Create Note
		//System.out.println(createNote(noteService));
		
		//Update Note
		System.out.println(updateNote(noteService));
	}
	
	private static void createNote(NoteService noteService) throws NoteException{
		 noteService.createNote(processNote(getNoteResponse()));		
	}
	
	private static Note updateNote(NoteService noteService){
		try {
			return noteService.updateNote(processUpdateNote(getNoteUpdateResponse()));
		} catch (NoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
	}
	
	private static Note processNote(NoteResponse noteResponse){
		Note note = new Note();
		note.setNoteId(noteResponse.getNoteId());
		note.setTitle(noteResponse.getTitle());
		note.setNoteDesc(noteResponse.getNoteDesc());
		//note.setCreateTime(noteResponse.getCreateTime());
		//note.setLastUpdateTime(noteResponse.getLastUpdateTime());		
		return note;
	}
	
	private static NoteResponse getNoteResponse(){
		NoteResponse noteResponse = new NoteResponse();
		noteResponse.setTitle("Service test12");
		noteResponse.setNoteDesc("Service testing on");
		//noteResponse.setCreateTime(new Date());
		//noteResponse.setLastUpdateTime(new Date());
		UserResponse user = new UserResponse();
		user.setUserId(1);
		noteResponse.setUser(user);
		
		return noteResponse;
	}
	
	private static Note processUpdateNote(NoteResponse noteResponse){
		Note note = new Note();
		note.setNoteId(noteResponse.getNoteId());
		note.setNoteId(noteResponse.getNoteId());
		note.setTitle(noteResponse.getTitle());
		note.setNoteDesc(noteResponse.getNoteDesc());
		//note.setCreateTime(noteResponse.getCreateTime());
		//note.setLastUpdateTime(noteResponse.getLastUpdateTime());		
		return note;
	}
	
	private static NoteResponse getNoteUpdateResponse(){
		NoteResponse noteResponse = new NoteResponse();
		noteResponse.setNoteId(6);
		noteResponse.setTitle("Service test12");
		noteResponse.setNoteDesc("Service testing on");
		//noteResponse.setCreateTime(new Date());
		//noteResponse.setLastUpdateTime(new Date());
		UserResponse user = new UserResponse();
		user.setUserId(1);
		noteResponse.setUser(user);
		
		return noteResponse;
	}

}
