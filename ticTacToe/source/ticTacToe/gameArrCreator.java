package ticTacToe;
class gameArrCreator {
	

	/*
		createNotOccArr()
		retrurn a boolean array that whether  
		the corresponding grid is not occupied 
		
		(Occupied mean: Value of the grid is not equal 
		grid ordercorresponding grid order)
		
		variable size is the length of checkOrder
		
	*/
	public boolean[] createNotOccArr(char[] checkOrder, int size) {
		boolean[] isNotOccupied = new boolean[size];
		
		for(int i = 0; i < size; i++){
		isNotOccupied[i] = 
			!gameTable.isOccupied(checkOrder[i]);
		}
		
		return isNotOccupied;
	}
	
	/*
		createGriStaArr()
		retrurn a boolean array that whether  
		the corresponding grid is occupied by X(NPC)
		(is the grid value equal X?)
		
		Variable row and col is the coordinate
		of the grid in gameTable.table
		
	*/
	
	
	public boolean[] createGriStaArr(int[] row, int[] col , int size) {
	  boolean[] gridStatus = new boolean[size];
		
	  for(int i = 0; i < size; i++){
	    gridStatus[i] = 
		  (gameTable.getTableGrid(row[i], col[i])
		    == 'X');
	  }
	  
	  return gridStatus;
	}
	
	/*
		Overload version of createGriStaArr()
		retrurn a boolean array that whether  
		the corresponding grid is occupied by 'symbol'
		(is the grid value equal 'symbol'?)
		
		Parameter symbol decide the value of this method checking
		
		Parameter row and col is the coordinate
		of the grid in gameTable.table
		
	*/
	
	
	public boolean[] createGriStaArr(int[] row, int[] col , 
				int size, char symbol) 
	{
	  boolean[] gridStatus = new boolean[size];
		
	  for(int i = 0; i < size; i++){
	    gridStatus[i] = 
		  (gameTable.getTableGrid(row[i], col[i])
		    == symbol );
	  }
	  
	  return gridStatus;
	}
	
	/*
		getPositonObject() return the GridPosition object of 
		corresponding checkOrder element(is not array).
		
		Parameter checkOrderElem should be the element of a 
		checkOrder array.
		
		This method is sub-method of createPositonArray()
		
	*/
	
	private GridPosition getPositonObject(char checkOrderElem){
	  GridPosition[] gridArray = GridPosition.values();
	  GridPosition gridObj = null;
	
	
	  switch(checkOrderElem)
	  {   
	    case '1':
			gridObj = gridArray[0];
		    break;
	    case '2':
		    gridObj = gridArray[1];
			break;
			case '3':
				gridObj = gridArray[2];
				break;
			case '4':
				gridObj = gridArray[3];
				break;
			case '5':
				gridObj = gridArray[4];
				break;
			case '6':
				gridObj = gridArray[5];
				break;
			case '7':
				gridObj = gridArray[6];
				break;
			case '8':
				gridObj = gridArray[7];
				break;
			case '9':
				gridObj = gridArray[8];
				break;
			default :
				System.out.println("Check Order exceed the switch option!");
	  }
		
		return gridObj;
  }

	
		
	/*
		createPositonArray() retrun the GridPosition[] array.
		Parameter posSize is the length of checkOrder.
	
	*/
    
	public GridPosition[] createPositonArray(char[] checkOrder, int posSize){
			GridPosition[] gridArray = new GridPosition[posSize];
			
			for(int i = 0; i < posSize; i++){
				gridArray[i] = getPositonObject(checkOrder[i] );
			}
		return gridArray;
	}
	
	/*
		createRowGridPosArray() return a array that store
		the row coordinate of corresponding grid
	*/
	
	public int[] createRowGridPosArray(char[] checkOrder, int size) {
		GridPosition[] gridObjArray = new GridPosition[size];
		gridObjArray = createPositonArray(checkOrder, size);
		int[] gridRow = new int[size];
		
		
		for(int i = 0; i < size; i++) 
			gridRow[i] = gridObjArray[i].getRow();
	  
		/*
		for(int temp : gridRow)
			System.out.println("Row coordinate is " + temp);
		
		*/
		
		return gridRow;
		
		
	}
	
	/*
		createRowGridPosArray() return a array that store
		the col coordinate of corresponding grid
	*/
	
	public int[] createColGridPosArray(char[] checkOrder, int size) {
		GridPosition[] gridObjArray = new GridPosition[size];
		gridObjArray = createPositonArray(checkOrder, size);
		int[] gridCol = new int[size];
		
		
		for(int i = 0; i < size; i++) 
			gridCol[i] = gridObjArray[i].getCol();
		
		/*
		for(int temp : gridCol)
			System.out.println("Col coordinate is " + temp);
		
		*/
		return gridCol;
	}
		

}