/**
 * 
 */
package com.json.data;

import java.util.Date;

import com.google.gson.Gson;
import com.note.entity.Note;
import com.note.entity.User;
import com.note.json.response.NoteResponse;
import com.note.json.response.UserResponse;

/**
 * @author jay.prakash
 *
 */
public class ResponseData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String noteResponse = createJsonString(processNote());
		System.out.println(noteResponse);
	}
	
	private static String createJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);

	}
	
	private static NoteResponse processNote(){
		NoteResponse noteResponse = new NoteResponse();
		//noteResponse.setNoteId(note.getNoteId());
		noteResponse.setNoteDesc("UI Testing going on");
		noteResponse.setTitle("UI Testing");
		noteResponse.setCreateTime("18 Jun 2017 9:51:53");
		noteResponse.setLastUpdateTime("18 Jun 2017 19:51:53");
		UserResponse userResponse = new UserResponse();
		
		userResponse.setUserId(1);		
		noteResponse.setUser(userResponse);

		return noteResponse;
	}

}
