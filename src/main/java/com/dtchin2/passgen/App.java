package com.dtchin2.passgen;

import java.util.Scanner;

import com.dtchin2.passgen.exception.InvalidPasswordLengthException;
import com.dtchin2.passgen.generator.PasswordGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InvalidPasswordLengthException {
        // Application for Password generator
    	String password = "";
    	
    	// take valid input length from user
    	System.out.println("Welcome To Password Generator");
    	System.out.println("Please enter your desired password length between 6 and 32 characters.");
    	Scanner inputScanner = new Scanner(System.in);
    	
    	Integer desiredLength = inputScanner.nextInt();
    	
    	// select 5 random words from user if necessary
    	System.out.println("Would you like to enter suggested words? Please enter y for yes and n for no");
    	String chooseWords = inputScanner.next();
    	
    	if(chooseWords.equalsIgnoreCase("n")) {
    		PasswordGenerator passGenerator = new PasswordGenerator(desiredLength);
    		password = passGenerator.generatePassword(desiredLength, null);
    	}
    	else if(chooseWords.equalsIgnoreCase("y")) {
    		String[] suggestedWords = new String[5];
    		
    		for(int i=0; i < 5; i++) {
        		System.out.println("Please enter a suggested word.");
        		String suggestedWord = inputScanner.next();
        		
        		suggestedWords[i] = suggestedWord;
        	}
    		
    		PasswordGenerator passGenerator = new PasswordGenerator(desiredLength, suggestedWords);
    		password = passGenerator.generatePassword(desiredLength, suggestedWords);
    	}
    		
    	
    	
    	
    	// ...y if yes ... if no (ignore case)
    	
    	// user must choose 5 selected words
    	
    	// the password is generated and returned to the user via console
    	inputScanner.close();
    	System.out.println("Generated Password: [" + password.toString() + "].");
    }
}
