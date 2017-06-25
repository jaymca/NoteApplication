/**
 * 
 */
package com.note.service.exception;

/**
 * @author jay.prakash
 *
 */
public class NoteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMesage;

	public NoteException() {
		super();
	}

	
	public NoteException(String errorMesage) {
		super(errorMesage);
		
	}


	@Override
	public String toString() {
		return "NoteException [errorMesage=" + errorMesage + "]";
	}

}
