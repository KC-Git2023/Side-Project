package ticTacToe;

import java.io.*;
import static ticTacToe.gameFlowController.pw;

public class inputHelper {
	private char userInput;
	private boolean validation = true;
	private BufferedReader br = new BufferedReader(new 
		InputStreamReader(System.in, System.console().charset()));
	
	
	private void onlyAcceptFirstChar() throws IOException
	{
		while( (char)(br.read()) != '\n')
			continue;
	}
	
	
	public boolean inputValidate() throws IOException
	{
		
		if( (userInput < '1') || (userInput > '9') ){
			pw.println("Please input valid option(1-9):");
			validation = false;
		}
		else if ( gameTable.isOccupied(userInput) ) {
			pw.println("This grid is occupied");
			validation = false;
		}
		else 
			validation = true;
		
		return validation;
	}
	
	private char getUserInput() throws IOException
	{
		userInput = (char)br.read();
		onlyAcceptFirstChar();
		return userInput;
	}
	
	public char getUserValidInput() throws IOException
	{
		do {
			userInput = getUserInput();
		}while ( !inputValidate());
		
		return userInput;
	}
	
	
	
	
	
}