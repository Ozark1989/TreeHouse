package TreeHouse;

import java.util.Scanner;

public class Hangman {

	  public static void main(String[] args) {
		  
//This was commented so the program runs in an IDE	  	    
	   /* if (args.length == 0) {
	      System.out.println("Usage: java Hangman <answer>");
	      System.err.println("answer is required");
	      System.exit(1);
	    }
	    */
  
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String answer = scanner.nextLine();
		for (int i = 0; i < 10; i++) {
			System.out.println("");
		}
		
	    Game game = new Game(answer);
	    
	    Prompter prompter = new Prompter(game);
	    
	    while (game.getRemainingTries() > 0 && !game.isWon()) {
	      prompter.displayProgress();
	      prompter.promptForGuess();
	    }
	   
	    prompter.displayOutCome();
	  }
	}
