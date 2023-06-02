package ticTacToe;
import java.util.ArrayList;

class NPCAction {
	/*
	private boolean isFinish = false;
	private String gameResult = "";
	*/
	private int[] row = {0,0,4,4};
	private int[] col = {0,8,0,8};
	private int size = 4;
	
	public static gameArrCreator creator = new gameArrCreator();
	
	/*
		This method select a non-occupied corner randomly.
	*/
	public void setRandomCorner() {
		boolean notYetSet = true;
		
		int range = 4;
		int random = (int)(Math.random() * range);
		
		ArrayList<Character> cornerArray = new ArrayList<Character>();
		cornerArray.add('1');
		cornerArray.add('3');
		cornerArray.add('7');
		cornerArray.add('9');
		
		
		while(notYetSet){
			if(gameTable.isOccupied( cornerArray.get(random) ) ){
				range--;
				cornerArray.remove(random);
				random = (int)(Math.random() * range);
			}
			else{
				gameTable.setTable(cornerArray.get(random));
				notYetSet = false;
			}
		}
	}
	


	
	/*
		setCorrespondCorn()
		
		if the specified grid A is X 
		and the specified grid B is not occupied
		
		Then, set the specified grid C
		
		This method is to set a specific corner 
		based on certain condition.
		
	*/
	
	private void setCorrespondCorn(boolean[] gridStatus, boolean[] isNotOccupied,
							char[] correspondingCorner, int size){
	  for(int i = 0 ; i < size; i++){
	  if( gridStatus[i] && isNotOccupied[i])
	    gameTable.setTable( correspondingCorner[i]);
	  }
	}
	
	/*
		setDiagonalCorner()
		
		if {1,3,7,9} is occupied by X and the corresponding 
		diagonal corner is not occupied then set it to X.
	*/
	
	public void setDiagonalCorner() {
	  char[] checkOrder = {'9', '7', '3', '1'};
	  boolean[] isNotOccupied = creator.createNotOccArr(checkOrder, size);
	  boolean[] gridStatus = creator.createGriStaArr(row,col,size);	  
	  
	  setCorrespondCorn(gridStatus, isNotOccupied, checkOrder, size);

	}
		
	
	public void setSameRowCorn() {
		char npcLastMove = gameTable.getNpcLastMove();
		
		switch(npcLastMove)
		{
			case '1':
				gameTable.setTable('3');
				break;
			case '3':
				gameTable.setTable('1');
				break;
			case '7':
				gameTable.setTable('9');
				break;
			case '9':
				gameTable.setTable('7');
				break;
			default :
				System.out.println("Something get Wrong!");
		}
		
	}
	
	public void setSameColCorn() {
		char npcLastMove = gameTable.getNpcLastMove();
		
		switch(npcLastMove)
		{
			case '1':
				gameTable.setTable('7');
				break;
			case '3':
				gameTable.setTable('9');
				break;
			case '7':
				gameTable.setTable('1');
				break;
			case '9':
				gameTable.setTable('3');
				break;
			default :
				System.out.println("Something get Wrong!");
		}
		
	}
	
	/*
	  setNotAdjacentNPCCorn()
	  Check npc select which corner in previous turn.
	  Then check user select which grid in previous turn.
		Then select the corner is not adjancent user
	*/
	
	
	public void setNotAdjUserCorn() {
		char npcLastMove = gameTable.getNpcLastMove();
		char userLastMove = gameTable.getUserLastMove();
		boolean isUser = false;
		
		switch(npcLastMove)
		{
			case '1':
				if(userLastMove == '6') gameTable.setTable('7');
				else gameTable.setTable('3');
				break;
			case '3':
				if(userLastMove == '4') gameTable.setTable('9');
				else gameTable.setTable('1');
				break;
			case '7':
				if(userLastMove == '2') gameTable.setTable('9');
				else gameTable.setTable('1');
				break;
			case '9':
				if(userLastMove == '2') gameTable.setTable('7');
				else gameTable.setTable('3');
				break;
			default :
				System.out.println("Something get Wrong!");
		}
		
		
	}
	

	public void setCenterGrid() {
	  boolean isCenterNotOccupied =
	    !gameTable.isOccupied('5');
	
	  if(isCenterNotOccupied)
			gameTable.setTable('5');
	}
	
	
	
	/*
		For startThrConse, symbolToCheck represent 2 case
		X: npc try to complete 3 consecutive grid
		O: prevent user complete 3 consecutive grid
		
		Use this method to start ThrConse.
		
		if symbolToCheck is 'X' and this method successfully set table
		this mean NPC win.

	*/
	
	
	public boolean startThrConse(char symbolToCheck) {
		boolean thisMethodSetTable = false;
	  char[][] allGridToCheck = { 
		  {'1','2','3'}, {'4','5','6'}, {'7','8','9'},
		  {'1','4','7'}, {'2','5','8'}, {'3','6','9'}, 
		  {'1','5','9'}, {'3','5','7'}
		};
	  
	  for(int i = 0; i < 8; i++){
		  char[] checkOrder = allGridToCheck[i];
		  if( ThrConse(checkOrder, symbolToCheck) ){
				thisMethodSetTable = true;
	      break; 
			}
	  }
		
		if ( (symbolToCheck == 'X') && thisMethodSetTable){
			gameFlowController.setHasWinner();
		}
			
		return thisMethodSetTable;
	  
	}
	
	
	/*
	For ThrConse method, if symbol is 'O', usage of this method
	is to prevent to have 3 consecutive grid.
	
	Otherwise, if symbol is 'X', this method is to set
	3 consecutive grid for NPC.
	
	This method is started by startThrConse.
	
	*/
	
	private boolean ThrConse(char[] checkOrder, char symbol){
	  boolean isAction = false;
	  int checkLength = checkOrder.length;
	  GridPosition[] gridObjArray = new GridPosition[checkLength];
	  gridObjArray = creator.createPositonArray(checkOrder, checkLength);
	  
	  int[] gridRow = new int[checkLength];
	  int[] gridCol = new int[checkLength];
	  
	  for(int i = 0; i < checkLength; i++) {
			gridRow[i] = gridObjArray[i].getRow();
			gridCol[i] = gridObjArray[i].getCol();
	  }
	  

	  boolean[] isGridEquOArray = creator.createGriStaArr(gridRow,
				gridCol, checkLength, symbol);
	   
	  if( (isGridEquOArray[0] && isGridEquOArray[1]) || 
		  (isGridEquOArray[1] && isGridEquOArray[2]) ||
		  (isGridEquOArray[0] && isGridEquOArray[2]) ){
		
	    boolean[] isNotOccupied = creator.createNotOccArr(checkOrder, checkLength);
		
			for(int i = 0; i < checkLength; i++)
				if(isNotOccupied[i]){
					gameTable.setTable(checkOrder[i]);
					isAction = true;
					break;
				}
	
	  }
	  
	  /*
			isAction = true which represent NPC made his movement
			So the loop can be end,
	  */

	  return isAction;
	  
	}
	
	/*
	 The usage of setOnlyEmptyGrid is set the only remaning
	 empty gird.
	 
	 Although the algorithm itself is set 1 empty grid,
	 the only remaning empty gird part is guaranteed by the 
	 option table(NPC branch).
	 
	 That mean when this method is called, there only have
	 one grid is empty.
	
	*/
	public void setOnlyEmptyGrid() {
	  char[] checkOrder = {
	   '1', '2', '3', 
	   '4', '5', '6', 
	   '7', '8', '9'
	  };
		
	  boolean[] isNotOccupied = creator.createNotOccArr(checkOrder, 
					checkOrder.length);
	
	  for(int i = 0; i< 9; i++)
		if(isNotOccupied[i]){
		  gameTable.setTable( checkOrder[i]);
		  break;
		}
	}
	

	
}