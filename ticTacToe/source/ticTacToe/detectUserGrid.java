package ticTacToe;
import static ticTacToe.NPCAction.creator;

public class detectUserGrid {
	
	boolean isUserOccCenter() {
		boolean status = gameTable.isOccupied('5') ? true : false;
		
		return status;
	}
	
	
	/*
		This method check is user occupied any corner
	*/
	
	public boolean isUserOccAnyCorner() {
		char[] checkOrder = {'1', '3', '7', '9'};
		
		int[] row = creator.createRowGridPosArray(checkOrder,
														checkOrder.length);
	
		int[] col = creator.createColGridPosArray(checkOrder,
														checkOrder.length);		

		boolean[] gridStatus = creator.createGriStaArr(row,
											col, checkOrder.length, 'O');
		
		for(boolean temp : gridStatus)
			if(temp) return true;
		
		return false;
	}
	
	/*
		if NPC set corner one of the corner(1/3/7/9)
		then check whether user set the grid is adjacent 
		that corner.
	*/
	
	public boolean isUserSetAdjNPCCorn() {
		char isUserOccGridA, isUserOccGridB, npcLastMove;
		
		isUserOccGridA = isUserOccGridB = 'a';
		
		npcLastMove = gameTable.getNpcLastMove();
		switch(npcLastMove)
		{
			case '1':
				isUserOccGridA = '2';
				isUserOccGridB = '4';
				break;
			case '3':
				isUserOccGridA = '2';
				isUserOccGridB = '6';
				break;
			case '7':
				isUserOccGridA = '4';
				isUserOccGridB = '8';
				break;
			case '9':
				isUserOccGridA = '6';
				isUserOccGridB = '8';
				break;
			default :
				System.out.println("Something get Wrong!");
		}
		
		if( gameTable.isOccupied(isUserOccGridA) || 
					gameTable.isOccupied(isUserOccGridB)  )
		    return true;
		 else return false;

	}
	
	/*
		if NPC set corner one of the corner(1/3/7/9)
		then check whether user set the grid is not 
		adjacent that corner.
	*/
	
	public boolean isUserSetNotAdjNPCCorn() {
		char isUserOccGridA, isUserOccGridB, npcLastMove;
		
		isUserOccGridA = isUserOccGridB = 'a';
		
		npcLastMove = gameTable.getNpcLastMove();
		switch(npcLastMove)
		{
			case '1':
				isUserOccGridA = '6';
				isUserOccGridB = '8';
				break;
			case '3':
				isUserOccGridA = '4';
				isUserOccGridB = '8';
				break;
			case '7':
				isUserOccGridA = '2';
				isUserOccGridB = '6';
				break;
			case '9':
				isUserOccGridA = '2';
				isUserOccGridB = '4';
				break;
			default :
				System.out.println("Something get Wrong!");
		}
		
		if( gameTable.isOccupied(isUserOccGridA) || 
					gameTable.isOccupied(isUserOccGridB)  )
		    return true;
		 else return false;

	}
	
	public boolean isUserLastMoveACross() {
		char userLastMove = gameTable.getUserLastMove();
		
		if( (userLastMove == '2') || (userLastMove == '4') ||
				(userLastMove == '6') || (userLastMove == '8') )
			return true;
		else return false;
	}
	
	public boolean isUserLastMoveACorner() {
		char userLastMove = gameTable.getUserLastMove();
		
		if( (userLastMove == '1') || (userLastMove == '3') ||
				(userLastMove == '7') || (userLastMove == '9') )
			return true;
		else return false;
		
	}
	

}