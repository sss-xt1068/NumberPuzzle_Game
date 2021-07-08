import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		
		int l = buttons.length-1;
		boolean isValid = false;

		// Check 4 edge cases for emptyCellId
		if(emptyCellId+1 <= l) {
			if(buttons[emptyCellId+1].equals(buttonClicked))
			{
				isValid = true;
			}
		}
		if(emptyCellId+4 <= l) {
			if(buttons[emptyCellId+4].equals(buttonClicked))
			{
				isValid = true;
			}	
		}
		if(emptyCellId >= 1) {
			if(buttons[emptyCellId-1].equals(buttonClicked))
			{
				isValid = true;
			}
		}
		if(emptyCellId >= 4) {
			if(buttons[emptyCellId-4].equals(buttonClicked))
			{
				isValid = true;
			}
		}

		if (isValid){
			swapButton(buttons[emptyCellId], buttonClicked);
			for(int i=0; i<buttons.length;i++) {
				if(buttons[i].equals(buttonClicked)) 
				{
					emptyCellId=i;
					break;
				}
			}
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		ArrayList<Integer> random_Array = new ArrayList<Integer>();
		
		// loop till array not full
		while(random_Array.size()<=15){

			int a = getRandomNumber();
			int result = ((int)((a%15)+1));

			if(random_Array.indexOf(result)==-1)
			{
				// add to created array
				random_Array.add(result);
			}
		}

		for(int i=0;i<random_Array.size();i++)
		{
			// assign values to arr
			arr[i] = random_Array.get(i);
		}
		// return original array with values
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] id_array = getIntegerArrayOfButtonIds(buttons);
		for (int i=1; i<=15; i++){
			if (id_array[i]==i){
				continue;
			}
			else{
				winner = false;
				break;
			}
		}
		return winner;
	}
}