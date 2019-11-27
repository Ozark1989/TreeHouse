package TreeHouse;

public class Game {
	  
	  public static final int MAX_MISSES = 7;
	  private String answer;
	  private String hits;
	  private String misses;
	 
	  public Game(String answer) {
	    this.answer = answer.toLowerCase();
	    hits = "";
	    misses = "";
	  }
	  
	  public String getAnswer() {
	    return answer;
	  }
	  
	  
	  //Character in this methods refers to the char wrapper class "Character", which allows you to use  the "primitive helper methods"
	  //This method first checks to make sure the input is a char, if so it's converted toLowerCase "NORMALIZATION", then it determines if the char has already been guessed
	  //For all the hits it creates a String = hits and the same for the misses, so if the index is -1 "not in the String array" it can be passed on 
	  
	  private char normalizeGuess(char letter) {
	    if (! Character.isLetter(letter)) {
	      throw new IllegalArgumentException("A letter is required");
	    }
	    letter = Character.toLowerCase(letter);
	        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
	      throw new IllegalArgumentException(letter + " has already been guessed");
	    }
	    return letter;
	  }
	  
	  public boolean applyGuess(String letters) {
	    if (letters.length() == 0) {
	      throw new IllegalArgumentException("No letter found");
	    }
	    return applyGuess(letters.charAt(0));
	  }
	  
	  public boolean applyGuess(char letter) {
	    letter = normalizeGuess(letter);
	    boolean isHit = answer.indexOf(letter) != -1;
	    if (isHit) {
	      hits += letter;
	    } else {
	      misses += letter;
	    }
	  return isHit;
	  }
	  
	  public int getRemainingTries() {
	    return MAX_MISSES - misses.length();
	  }
	  
	  
	  public String getCurrentProgress() {
	    String progress = "";
	    for (char letter : answer.toCharArray()) {
	      char display = '-';
	       if ( hits.indexOf(letter) != -1) {
	        display = letter;
	      }
	      progress += display;
	    }
	    return progress;
	  }
	  //This method deteremines if the user hasn't won. If all of the indexOf('-') in the progress are equal to -1 ->(which is not in the array) 
	  public boolean isWon() {
	    return getCurrentProgress().indexOf('-') == -1;
	  }
	  
	  
	}