package com.dtchin2.passgen.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PasswordRandomizer {

	private Map<String, String> replaceCharMap;
	private List<String> randomWords;
	
	public PasswordRandomizer() {
		replaceCharMap = new HashMap<>();
		replaceCharMap.put("a", "@");
		replaceCharMap.put("o", "0");
		replaceCharMap.put("i", "1");
		replaceCharMap.put("e", "3");
		replaceCharMap.put("l", "!");
		replaceCharMap.put("s","$");
		replaceCharMap.put("t","%");
		replaceCharMap.put("u","^");
		
		randomWords = new ArrayList<>();
		randomWords.add("brown");
		randomWords.add("quick");
		randomWords.add("foxy");
		randomWords.add("jumps");
		randomWords.add("over");
		randomWords.add("the");
		randomWords.add("lazy");
		randomWords.add("cash");
		randomWords.add("tooth");
		randomWords.add("mary");
		randomWords.add("church");
		randomWords.add("money");
		randomWords.add("stone");
		randomWords.add("animal");
		randomWords.add("ghost");
	}
	
	public String generatePasswordWithNoWords(int passLength) {
		String randomPass = "";
		String[] suggWords = new String[5];
		
		// choose 5 random selected words
		
		for(int i=0; i < 5; i++) {
			// select random word and add it to the array
			Random randomIndex = new Random();
			int randomIndexSelected = randomIndex.nextInt(randomWords.size());
			
			String selectedWord = randomWords.get(randomIndexSelected);
			
			suggWords[i] = selectedWord;
		}
		
		// after random words are selected... then proceeded to the "generatePasswordWithWords" method
		randomPass = generatePasswordWithWords(passLength, suggWords);
		
		
		return randomPass;
	}
	
	// create random password with suggested words
	public String generatePasswordWithWords(int passLength, String[] suggWords) {
		String randomPass = "";
		
		for(String word: suggWords) {
			randomPass = randomPass + word;
		}
		
		// now check if character length of 'randomPass' is equal to the suggested passLength
		if(randomPass.length() > passLength) {
			randomPass = randomPass.substring(0, passLength);
		}
//		else {
//			// TODO: if the length of the word's total characters is less than passLength... add random words
//			// from the random word array
//			
//			// and then take the substring from (0 to the max specified passLength)
//			
//		}
		
		// now that the randomPass is the appropriate size... we can begin randomizing characters
		
		// first lowercase everything
		randomPass = randomPass.toLowerCase();
		
		char[] arrOfChars = randomPass.toCharArray();
		
		// replace some letters with numbers from the arrOfChars ex.'O' can be replaced with '0'
		for(int i=0; i < arrOfChars.length - 1; i++) {
			if(replaceCharMap.containsKey(String.valueOf(arrOfChars[i]))) {
				arrOfChars[i] = replaceCharMap.get(String.valueOf(arrOfChars[i])).charAt(0);
			}
		}
		
		// begin by capitalizing random letters
		for(int i = 0; i < arrOfChars.length - 1; i++) {
			if(i % 2 == 0) {
				arrOfChars[i] = Character.toUpperCase(arrOfChars[i]);
			}
		}
		
		randomPass = Arrays.toString(arrOfChars);
		
		return randomPass;
	}
	
	
	
	// TODO: Create method to randomize suggested word order
	private String randomizeCharacters(String randomPassword) {
		String randomizedPasswordChars = "";
		
		return "";
	}
	
	
}
