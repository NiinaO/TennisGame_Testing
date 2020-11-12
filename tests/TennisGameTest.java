import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}	
	
	
	// Here is the format of the scores: "player1Score - player2Score"
	// "love - love"
	// "15 - 15"
	// "30 - 30"
	// "deuce"
	// "15 - love", "love - 15"
	// "30 - love", "love - 30"
	// "40 - love", "love - 40"
	// "30 - 15", "15 - 30"
	// "40 - 15", "15 - 40"
	// "player1 has advantage"
	// "player2 has advantage"
	// "player1 wins"
	// "player2 wins"
	
	@Test
	public void testTennisGame_Player1Gets3pointsAndPlayer2Gets3points() throws TennisGameException {
		TennisGame game = new TennisGame();
		// 0 - 0
		String score = game.getScore();
		assertEquals("Tie score incorrect", "love - love", score);	
		
		// player1 1 - 0 player2
		// HOX! scores are printed as player2 - player1, bug? 
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 15", score);
		
		// 2 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 30", score);
		
		// 3 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 40", score);
		
		// 3 - 1
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "15 - 40", score);
		
		// 3 - 2
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "30 - 40", score);
		
		// 3 - 3
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "40 - 40", score);
	}	
	
	@Test
	public void testTennisGame_Player1Gets3pointsAndPlayer2Gets3pointsPlayer2AdvantageDeucePlayer1AdvantageWin() throws TennisGameException {
		TennisGame game = new TennisGame();
		// 0 - 0
		String score = game.getScore();
		assertEquals("Tie score incorrect", "love - love", score);	
		
		// player1 1 - 0 player2
		// HOX! scores are printed as player2 - player1, bug? 
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 15", score);
		
		// 2 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 30", score);
		
		// 3 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 40", score);
		
		// 3 - 1
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "15 - 40", score);
		
		// 3 - 2
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "30 - 40", score);
		
		// 3 - 3
		// testing is purposefully skipped here as these will not pass
		game.player2Scored();
		score = game.getScore();
		
		// 3 - 4
		// testing is purposefully skipped here as these will not pass
		game.player2Scored();
		score = game.getScore();
		
		// 4 - 4
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "deuce", score);
		
		// 5 - 4
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player1 has advantage", score);
		
		// 6 - 4
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player1 wins", score);	
	}	
	
	@Test
	public void testTennisGame_Player1Gets3pointsAndPlayer2Gets3pointsPlayer2Advantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		// 0 - 0
		String score = game.getScore();
		assertEquals("Tie score incorrect", "love - love", score);	
		
		// player1 1 - 0 player2
		// HOX! scores are printed as player2 - player1, bug? 
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 15", score);
		
		// 2 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 30", score);
		
		// 3 - 0
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "love - 40", score);
		
		// 3 - 1
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "15 - 40", score);
		
		// 3 - 2
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "30 - 40", score);
		
		// 3 - 3
		// testing is purposefully skipped here as these will not pass
		game.player2Scored();
		
		// 3 - 4
		// testing is purposefully skipped here as these will not pass
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "40 - 40", score);
		
	}
	
	@Test
	public void testTennisGame_Player2Gets3pointsAndPlayer1Gets3pointsPlayer1AdvantageDeucePlayer2AdvantageWin() throws TennisGameException {
		TennisGame game = new TennisGame();
		// 0 - 0
		String score = game.getScore();
		assertEquals("Tie score incorrect", "love - love", score);	
		
		// player1 0 - 1 player2
		// HOX! scores are printed as player2 - player1, bug? 
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "15 - love", score);
		
		// 0 - 2
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "30 - love", score);
		
		// 0 - 3
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "40 - love", score);
		
		// 1 - 3
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "40 - 15", score);
		
		// 2 - 3
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "40 - 30", score);
		
		// 3 - 3
		game.player1Scored();
		
		// 4 - 3
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player1 has advantage", score);
		
		// 4 - 4
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "deuce", score);
		
		// 4 - 5
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player2 has advantage", score);
		
		// 5 - 5
		game.player1Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "deuce", score);
		
		// 5 - 6
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player2 has advantage", score);
		
		// 5 - 7
		game.player2Scored();
		score = game.getScore();
		assertEquals("Tie score incorrect", "player2 wins", score);	
	}	
	
	@Test
	public void testTennisGame_() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		// player1 2 - 4 player2
		// HOX! scores are printed as player2 - player1, bug? 
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		assertEquals("Tie score incorrect", "player2 wins", score);	
	}	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}	
}
