/**
 * 
 */
package com.note.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.note.entity.Note;
import com.note.entity.User;
import com.note.json.response.NoteResponse;
import com.note.json.response.UserResponse;
import com.note.service.NoteService;
import com.note.service.exception.NoteException;
import com.note.util.CustomValidator;
import com.note.util.DateUtil;

/**
 * @author jay.prakash
 *
 */
@Path("/")
public class NoteController {
	private static final String SUCCESS = "Success";
	private static final String COLON = " : ";
	private static final String FOR = " for ";
	private String caughtException = " caught exception: ";
	private static final Integer MAX_LOG_ID = 999999;

	NoteService noteService = new NoteService();

	private Random randGen;

	public NoteController() {
		Long seed = System.currentTimeMillis() + 1234;
		randGen = new Random(seed);
	}

	@GET
	@Path("getNoteByNoteId/{noteId}")
	@Produces(MediaType.APPLICATION_JSON)
	public NoteResponse getNoteById(@PathParam("noteId") int noteId) {
		System.out.println("@PathParam noteId:: " + noteId);
		NoteResponse noteResponse = new NoteResponse();
		String method = "getNoteById()";
		String logId = getLogId(method + FOR + "");
		Note note;
		try {
			note = noteService.getNoteById(noteId);
			System.out.println(logId + method + COLON + SUCCESS);
			return getNoteResponse(note);
		} catch (NoteException ne) {
			System.out.println(logId + method + caughtException + ne);
			return noteResponse;
		}

	}

	@GET
	@Path("getNoteByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NoteResponse> getNotesByUserId(@PathParam("userId") int userId) {
		String method = "getNotesByUserId()";
		String logId = getLogId(method + FOR + "");
		List<NoteResponse> response = new ArrayList<>();
		List<Note> notes;
		try {
			notes = noteService.getNoteByUserId(userId);
			for (Note note : notes) {
				response.add(getNoteResponse(note));
			}
			System.out.println(logId + method + COLON + SUCCESS);
			return response;
		} catch (NoteException ne) {
			return response;
		}

	}

	@POST
	@Path("createNote")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public String createNote(NoteResponse noteResponse) {
		System.out.println("Entering methods .createNote() :: ");
		String method = "createNote()";
		String logId = getLogId(method + FOR + "");
		try {
			noteService.createNote(processNote(noteResponse));
			System.out.println(logId + method + COLON + SUCCESS);
			return "Success";
		} catch (Exception e) {
			return "Failure";
		}

	}

	@POST
	@Path("updateNote/{noteId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public NoteResponse updateNote(NoteResponse noteResponse) {
		System.out.println("Entering methods .updateNote() :: ");
		String method = "updateNote()";
		String logId = getLogId(method + FOR + "");
		Note note = null;
		try {
			note = noteService.updateNote(processNote(noteResponse));
			System.out.println(logId + method + COLON + SUCCESS);
			return getNoteResponse(note);
		} catch (NoteException ne) {
			return getNoteResponse(note);
		}

	}

	@DELETE
	@Path("deleteNote/{noteId}")
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteNote(@PathParam("noteId") int noteId) {
		String method = "deleteNote()";
		String logId = getLogId(method + FOR + "");
		try {
			noteService.deleteNote(noteId);
			System.out.println(logId + method + COLON + SUCCESS);
		} catch (NoteException ne) {
			// TODO Auto-generated catch block
			ne.printStackTrace();
		}
	}

	private NoteResponse getNoteResponse(Note note) {
		NoteResponse noteResponse = new NoteResponse();
		noteResponse.setNoteId(note.getNoteId());
		noteResponse.setNoteDesc(note.getNoteDesc());
		noteResponse.setTitle(note.getTitle());
		Date createTime = note.getCreateTime();
		noteResponse.setCreateTime(DateUtil.convertDateToString(createTime));
		Date updateTime = note.getLastUpdateTime();
		noteResponse.setLastUpdateTime(DateUtil.convertDateToString(updateTime));
		
		UserResponse userResponse = new UserResponse();
		User user = note.getUser();
		userResponse.setUserId(user.getUserId());
		if(CustomValidator.validateEmail(user.getEmail())){
			userResponse.setEmail(user.getEmail());
		}else{
			try {
				throw new Exception("Invalid Email Id");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Date userCreateTime = note.getCreateTime();
		userResponse.setCreateTime(DateUtil.convertDateToString(userCreateTime));
		Date userUpdateTime = note.getLastUpdateTime();
		userResponse.setLastUpdateTime(DateUtil.convertDateToString(userUpdateTime));
		noteResponse.setUser(userResponse);

		return noteResponse;
	}

	private Note processNote(NoteResponse noteResponse) {
		Note note = new Note();
		if (noteResponse.getNoteId() != 0) {
			note.setNoteId(noteResponse.getNoteId());
		}
		note.setTitle(noteResponse.getTitle());
		note.setNoteDesc(noteResponse.getNoteDesc());
		String createTime = noteResponse.getCreateTime();
		note.setCreateTime(DateUtil.convertStringToDate(createTime));
		String updateTime = noteResponse.getLastUpdateTime();
		note.setLastUpdateTime(DateUtil.convertStringToDate(updateTime));
		User user = new User();
		user.setUserId(noteResponse.getUser().getUserId());
		note.setUser(user);
		return note;
	}

	public String getLogId(String tracked) {
		int randNum = randGen.nextInt(MAX_LOG_ID);
		String randString = String.valueOf(randNum);
		while (randString.length() < 6) {
			randString = "0" + randString;
		}
		String logId = "[" + randString + "] ";
		if (tracked != null) {
			System.out.println(logId + "Tracking " + tracked + " using " + logId);
		}
		return logId;
	}

}
