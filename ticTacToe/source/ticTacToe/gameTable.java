package ticTacToe;
import static ticTacToe.gameFlowController.pw;


public class gameTable {
	private static char[][] table = { 
					   {'1',' ','|',' ','2',' ','|',' ','3'},
					   {'-','-','-','-','-','-','-','-','-'},
					   {'4',' ','|',' ','5',' ','|',' ','6'},
					   {'-','-','-','-','-','-','-','-','-'},
					   {'7',' ','|',' ','8',' ','|',' ','9'} };
					   
	//private static final char[][] defTable = table;
	
	
	//userlastmove decide which action in specific table
	//npclastmove narrow the search
	private static char userLastMove, npcLastMove;
	
	/*
		Variable isUser have 2 meanings.
		1.In settable(), The one who are going to setting table is user?
		2.If isUser is true, it represent now is user turn.
	*/	
	private static boolean isUser = false;
	
	
	public static void showContent() {
		 int rowSize = 5; 
		 int colSize = 9;
		for(int i=0; i<rowSize;i++){
			for(int j=0; j<colSize;j++){
				pw.print(table[i][j]);
				
				if (j == (colSize - 1)){
					pw.println();
				}
			}
		}
	}
	
	
	public static void setTable(char input){
		char symbol = isUser ? 'O' : 'X';

		switch(input){
			case '1':
				table[0][0] = symbol;
				break;
			case '2':
				table[0][4] = symbol;
				break;
			case '3':
				table[0][8] = symbol;
				break;
			case '4':
				table[2][0] = symbol;
				break;
			case '5':
				table[2][4] = symbol;
				break;
			case '6':
				table[2][8] = symbol;
				break;
			case '7':
				table[4][0] = symbol;
				break;
			case '8':
				table[4][4] = symbol;
				break;
			case '9':
				table[4][8] = symbol;
				break;
		
		}
		
		NPCActBranch.stepIncre();
		updateLastMove(input);
		isUser = !isUser;
		
	}

	
	public static void updateLastMove(char input){
		if(isUser) userLastMove = input;
		else npcLastMove = input;
  }
	

	public static boolean isOccupied(char input){
		boolean occupied = false;
		
		switch(input){
			case '1':
				if (table[0][0] != '1')
					occupied = true;
				break;
			case '2':
				if (table[0][4] != '2')
					occupied = true;
				break;
			case '3':
				if (table[0][8] != '3')
					occupied = true;
				break;
			case '4':
				if (table[2][0] != '4')
					occupied = true;
				break;
			case '5':
				if (table[2][4] != '5')
					occupied = true;
				break;
			case '6':
				if (table[2][8] != '6')
					occupied = true;
				break;
			case '7':
				if (table[4][0] != '7')
					occupied = true;
				break;
			case '8':
				if (table[4][4] != '8')
					occupied = true;
				break;
			case '9':
				if (table[4][8] != '9')
					occupied = true;
				break;
			
		}
		return occupied;
		
	}
	
	public static char getTableGrid(int row, int col) {
		return table[row][col];
	}
	
	public static char getNpcLastMove() {
		return npcLastMove;
	}
	
	public static char getUserLastMove() {
		return userLastMove;
	}
	
	public static boolean getIsUser() {
		return isUser;
	}
	
	
	
	/*
	
	public static void resetTable(){
		table = defTable;
	}
	
	*/
	

}
