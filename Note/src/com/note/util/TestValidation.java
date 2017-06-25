package com.note.util;

public class TestValidation {

	public static void main(String[] args) {
		CustomValidator customValidator = new CustomValidator();
		customValidator.validateEmail("jptowinner@gmail.om");
		System.out.println(customValidator.validateEmail("jptowinner@gmail.om"));
	}

}
