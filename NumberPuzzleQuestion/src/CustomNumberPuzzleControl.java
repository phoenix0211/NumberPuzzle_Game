import java.awt.*;

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
		int clickedButtonId = -1;
		for(int i = 0; i<16; i++) {
			if(buttons[i] == buttonClicked) {
				clickedButtonId = i;
				break;
			}
		}
		int up = emptyCellId - 4 >= 0 ? emptyCellId - 4 : -1;
		int down = emptyCellId + 4 < 16 ? emptyCellId + 4 : -1;
		int left = emptyCellId % 4 != 0 ? emptyCellId - 1 : -1;
		int right = emptyCellId % 4 != 3 ? emptyCellId + 1 : -1;
		if(clickedButtonId == up || 
				clickedButtonId == down || 
				clickedButtonId == left ||
				clickedButtonId == right) {
			swapButton(buttons[emptyCellId], buttonClicked);
			game.setEmptyCellId(clickedButtonId);
			emptyCellId = clickedButtonId;
		}
		return emptyCellId;
	}
	
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		boolean [] check = new boolean[15];
		for(int i=0; i<15; i++) {
			int temp;
			while(true) {
				temp = getRandomNumber()%15;
				if(!check[temp]) {
					check[temp] = true;
					break;
				}
			}
			arr[i] = temp + 1;
		}
		return arr;
	}
	
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int [] arr = getIntegerArrayOfButtonIds(buttons);
		int k = 1;
		for(int x: arr) {
			if(x != k) {
				winner = false;
				break;
			}
			k++;
		}
		return winner;
	}
}