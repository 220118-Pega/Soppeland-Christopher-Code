package com.revature.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		//Use Scanner to read console to get user input via console
		//needs an input stream, in this case we use the System.in, which is the console
		Scanner myScanner = new Scanner(System.in);
		//Every wrong guess adds body part to noose and decreases this number
		int bodyParts = 6;
		
		//Asks for user input
		//System.out.println("Enter word to be guessed: ");
		//Gets user input
		String mysteryWord = JOptionPane.showInputDialog("Enter word to be guessed: ");
		List<String> correctlyGuessedLetters = new ArrayList<String>();
		String originalWord = mysteryWord;
		String wordOuput = "";
		
		while(bodyParts > 0) {
			//Looking for letter in word
			//guessing part of game
			//asking for user input
			//System.out.println("Guess a letter in the word: ");
			//gets user input
			//String guessedLetter = myScanner.nextLine();
			String guessedLetter = JOptionPane.showInputDialog("Guess a letter in the word: ");
			if(mysteryWord.contains(guessedLetter)) {
				//true run this
				//System.out.println("the word contains " + guessedLetter);
				JOptionPane.showMessageDialog(null, "the word contains " + guessedLetter);
				//Remove correctly guessed letters
				mysteryWord = mysteryWord.replaceAll(guessedLetter,  "");
				correctlyGuessedLetters.add(guessedLetter);
			} else {
				//false run this
				//System.out.println("the word does not contain " + guessedLetter);
				JOptionPane.showMessageDialog(null, "the word does not contains " + guessedLetter);
				
				//decrement the bodyParts
				bodyParts--;
			}
			//System.out.println("How the guessing is going: ");
			for(Character letter:originalWord.toCharArray()) {
				if(correctlyGuessedLetters.contains(letter.toString())) {
					//System.out.print(letter);
					wordOuput += letter.toString();
				} else {
					//System.out.print("#");
					wordOuput += "#";
					
				}
			}
			
			//System.out.println();
			if(mysteryWord.length() == 0) {
				//System.out.println("Congratulations you've guessed all the letters in the word");
				JOptionPane.showMessageDialog(null, "How the guessing is going: \n" + wordOuput + "\nCongratulations you've guessed all the letters in the word");
				break;
			}
			
			JOptionPane.showMessageDialog(null, "How the guessing is going: \n" + wordOuput);
			wordOuput = "";
		}
		if(bodyParts == 0) {
			//System.out.println("Better luck next time");
			JOptionPane.showMessageDialog(null, "Better luck next time");
		}
	}

}
