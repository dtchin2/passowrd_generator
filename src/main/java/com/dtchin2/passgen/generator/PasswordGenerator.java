package com.dtchin2.passgen.generator;

import com.dtchin2.passgen.exception.InvalidPasswordLengthException;

public class PasswordGenerator {

	private String password;
	private int passwordLength;
	private String[] suggestedWords;
	
	public PasswordGenerator(int passwordLength) {
		// user determines password length...no less than 6 chars, no more than 32
		this.setPasswordLength(passwordLength);
	}
	
	public PasswordGenerator(int passwordLength, String[] suggestedWords) {
		// user determines password length...no less than 6 chars, no more than 32
		// user can enter up to 5 suggested words
		this.setPasswordLength(passwordLength);
		this.setSuggestedWords(suggestedWords);
	}
	
	public String generatePassword(int passwordLength, String[] suggestedWords) 
		throws InvalidPasswordLengthException{
		
		String password = "";
		final int minPassLength = 6;
		final int maxPassLength = 32;
		PasswordRandomizer passwordRandomizer = new PasswordRandomizer();
		
		if(passwordLength < minPassLength || passwordLength > maxPassLength) {
			String errMessage = "Password must be between " + minPassLength + " and " +
					maxPassLength + " characters. ";
			throw new InvalidPasswordLengthException(errMessage);
		}
		else {
			// password length is valid...proceed to check if the suggested words list is not null
			
			if(suggestedWords == null) {
				password = passwordRandomizer.generatePasswordWithNoWords(passwordLength);
			}
			else {
				// suggested words is null, no need to incorporate them
				password = passwordRandomizer.generatePasswordWithWords(passwordLength, suggestedWords);
			}
		}
		
		return password;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPasswordLength() {
		return passwordLength;
	}

	public void setPasswordLength(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	public String[] getSuggestedWords() {
		return suggestedWords;
	}

	public void setSuggestedWords(String[] suggestedWords) {
		this.suggestedWords = suggestedWords;
	}
	
	
}
