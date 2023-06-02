package ticTacToe;

/*
	This class is the implement of npc branch.
*/

class NPCActBranch {
	private static int step = 1;
	private int lastTableOption = 0;
	private NPCAction npcAct = new NPCAction();
	private detectUserGrid detecter = new detectUserGrid();
	
	public void stepTable() {
		switch(step){
			case 1: 
				tableOne();
				break;
			case 2: 
				tableTwo();
				break;
			case 3: 
				tableThree();
				break;
			case 4: 
				tableFour();
				break;
			case 5: 
				tableFive();
				break;
			case 6: 
				tableSix();
				break;
			case 7: 
				tableSeven();
				break;
			case 8: 
				tableEight();
				break;
			case 9: 
				tableNine();
				break;
			default:
				System.out.println("Something Wrong!");
		}
	}
	
	
	private void tableOne() {
		boolean shouldNPCRun = !gameTable.getIsUser();
		
		//System.out.println("This is table One!");
		if(shouldNPCRun) npcAct.setRandomCorner();
	}
	
	private void tableTwo() {
		//System.out.println("This is table Two!");
	}
	
	private void tableThree() {
		//System.out.println("This is table Three!");
		if( detecter.isUserOccCenter() ){
			npcAct.setDiagonalCorner();
			lastTableOption = 1; //3-1
		}
		else if ( detecter.isUserOccAnyCorner() ){
			npcAct.setRandomCorner();
			lastTableOption = 2; //3-2
		}
		else if ( detecter.isUserSetAdjNPCCorn() ){
			setInverseUserCorner();
			lastTableOption = 3; //3-3
		}
		else if( detecter.isUserSetNotAdjNPCCorn()){
			npcAct.setNotAdjUserCorn();
			lastTableOption = 4; //3-4
		}
		
	}
	
	private void tableFour() {
		//System.out.println("This is table Four!");
	}
	
	private void tableFive() {
		//System.out.println("This is table Five!");
		switch(lastTableOption) {
			case 1: 
				tableFiveCaseOneAndTwo();
				break;
			case 2: 
				tableFiveCaseThreeAndFour();
				break;
			case 3: 
			case 4:
				tableFiveCaseFiveSixSevenAndEight();
				break;
			default:
				System.out.println("Something Wrong!");
		}
	}
	
	private void tableSix() {
		//System.out.println("This is table Six!");
	}
	
	private void tableSeven() {
		//System.out.println("This is table Seven!");
		//After switch case lastTableOption in range 1-2
		switch(lastTableOption) {
			case 1: 
				tableSevenCaseOneAndTwo();
				break;
			case 2: 
			case 3:
			case 5:
				npcAct.startThrConse('X');
				lastTableOption = 3;  //7-3 7-4 7-5 7-6
				break;
			default:
				System.out.println("Something Wrong!");
		}
	}
	
	private void tableEight() {
		System.out.println("This is table Eight!");
	}
	
	private void tableNine() {
		//System.out.println("This is table Nine!");
		if( !npcAct.startThrConse('X') )
			npcAct.setOnlyEmptyGrid();
	}
	
	
	//same row or column corner
	private void setInverseUserCorner() {
		char npcLastMove = gameTable.getNpcLastMove();
		char userLastMove = gameTable.getUserLastMove();
		
		if( ( npcLastMove == ( (int)userLastMove + 1) ) ||
				( ( npcLastMove == ( (int)userLastMove - 1) ) ) )
			npcAct.setSameColCorn();
		else npcAct.setSameRowCorn();
	}
	
	private void tableFiveCaseOneAndTwo() {
		if( detecter.isUserLastMoveACross() )
			lastTableOption = 1; //5-1
		else lastTableOption = 2; //5-2
		npcAct.startThrConse('O');
			
	}
	
	
	private void tableFiveCaseThreeAndFour() {
		if( npcAct.startThrConse('X') )
			lastTableOption = 4; //5-4
		else {
			npcAct.setRandomCorner();
			lastTableOption = 3; //5-3
		}
		//System.out.println("lastTableOption is " + lastTableOption);
			
	}
	
	private void tableFiveCaseFiveSixSevenAndEight() {
		if( npcAct.startThrConse('X') )
			lastTableOption = 6; //5-6 5-8
		else {
			npcAct.setCenterGrid();
			lastTableOption = 5; //5-5 5-7
		}
		//System.out.println("lastTableOption is " + lastTableOption);
			
	}
	
	private void tableSevenCaseOneAndTwo() {
		if( npcAct.startThrConse('X') )
			lastTableOption = 2; //7-2
		else {
			npcAct.startThrConse('O');
			lastTableOption = 1; //5-5 5-7
		}
		//System.out.println("lastTableOption is " + lastTableOption);
			
	}
	

	/*
	public void testTable() {
		if( !npcAct.startThrConse('X') )
			npcAct.setOnlyEmptyGrid();

	}
	*/
	

	public static void stepIncre(){
		step++;
	}
	
	
	public int getStep(){
		return step;
	}
	
	
	
}














