// Parth dhameliya
// CSC 15
// Ben White
// Memory Game Board (project 4)


// Imports the scanner class
import java.util.Random;


// This the mathod for helper class

public class MemoryGameBoard {
	public int BOARD_SIZE = 4;
	private int NUM_SWAPS = 1000;
	private Card[][] gameBoard;
	Random rand = new Random();
	
   
   // it will fix the intial possition of card
	public MemoryGameBoard() {
		gameBoard = new Card[BOARD_SIZE+1][BOARD_SIZE+1];
		initializeCards();
	}
	
   // It will shuffle the cards and after that choose random one
	public void shuffleCards() {
		turnCardsFaceDown();
		for(int i = 1; i <= NUM_SWAPS; i++) {
			int row1 = rand.nextInt(BOARD_SIZE) +1;
			int row2 = rand.nextInt(BOARD_SIZE) +1;
			int col1 = rand.nextInt(BOARD_SIZE) +1;
			int col2 = rand.nextInt(BOARD_SIZE) +1;
			Card temp = gameBoard[row1][col1];
			gameBoard[row1][col1] = gameBoard[row2][col2];
			gameBoard[row2][col2] = temp;
		}		
	}
	
   // To display the Boar
	public void showBoard() {
		hideBoard();
		
		System.out.println(this);
	}

// It will ask for input and then runthis mathod
	public boolean cardsMatch(int r1, int c1, int r2, int c2) {
		if(gameBoard[r1][c1].getValue() == gameBoard[r2][c2].getValue()) {
			return true;
		}
		else {
			return false;
		}
	}
	
   // As user click it will turn card and face it up
	public boolean isFaceUp(int r, int c) {
		return gameBoard[r][c].isFaceUp();
	}
	
   // after above work done it will flip the card
	public void flipCard(int r, int c) {
		gameBoard[r][c].flipCard();
	}
	
	public String toString() {
		String result = "   ";
		
		// Do header
      // This is all for size of board 
		for(int i = 1; i <= BOARD_SIZE; i++) {
			result += " " + i ;
		}
		result += "\n   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			result += "=";
		}
      // Print the value
		result += "\n";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			result += i + " | ";
			for(int j = 1 ; j <= BOARD_SIZE; j++) {
				result += String.format("%s ", gameBoard[i][j].toString());
			}
			result += "|\n";
		}
      // returns the stored value
		result += "   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			result += "=";
		}
		return result;	
		
	}
	
   // it will initialize the card
	private void initializeCards() {
		for (int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE; j++) {
				gameBoard[i][j] = new Card(j + (BOARD_SIZE*((i-1)%(BOARD_SIZE/2))));
			}
		}
	}
	
   // During this mathos program won't show board to user
	private void hideBoard() {
		for(int i =1; i<=10; i++) {
			System.out.println();
		}
	}
	
   // As user done it will change card from face up to down
   // Also it is depand on board size
	private void turnCardsFaceDown() {
		for (int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE; j++) {
				gameBoard[i][j].setFaceDown();
			}
		}
	}
	
   // it will display the value of board
	public void displayGameBoardValues() {
		String start = "   ";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			start += " " + i ;
		}
		start += "\n   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			start += "=";
		}
      
      // it will start the game
		start += "\n";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			start = i + " | ";
			for(int j = 1 ; j <= BOARD_SIZE; j++) {
				gameBoard[i][j].flipCard();
				start += String.format("%s ", gameBoard[i][j].toString());
			}
			start += "|\n";
		}
		start += "   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			start += "=";
		}
		System.out.println(start);
	}
}
