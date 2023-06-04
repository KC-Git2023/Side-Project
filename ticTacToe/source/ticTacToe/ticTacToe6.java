package ticTacToe;

import java.io.*;

class gameFlowController {
	static PrintWriter pw = new PrintWriter(System.out, true);
	static private boolean hasWinner = false;
	
	private inputHelper input = new inputHelper();
	private NPCActBranch npcBranch = new NPCActBranch();
	
	private char userInput;
	private char ignore;
	
	
	public void startGame() {
		npcBranch.stepTable();
		gameTable.showContent();
		pw.println();
		
		do {
			try {
				pw.println("Please input corresponding grid number: ");
				userInput = input.getUserValidInput();
			} catch (IOException exc){
				pw.println("Something went wrong.");
			}
			
			gameTable.setTable(userInput);
			pw.println();
			
			npcBranch.stepTable();
			gameTable.showContent();
			pw.println();

		} while( !checkGameEnd());
		
		
	}
	
	private boolean checkGameEnd() {
		if( (npcBranch.getStep() == 10) && !hasWinner ){
			pw.println();
			pw.println("Draw!");
			return true;
		}
		else if(hasWinner) {
			pw.println();
			pw.println("Game over. Try again!");
			return true;
		}
		else 
			return false;
	}
	
	static public void setHasWinner(){
		hasWinner = true;
	}
	
	
}


class ticTacToe6 {
	public static void main(String[] args)
	{	
	  gameFlowController gameFlow = new gameFlowController();
	  gameFlow.startGame();
	  
	
	}
}