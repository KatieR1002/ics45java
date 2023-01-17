package labs.lab3;

/**
 * A magic square is an n x n matrix which, if filled with numbers, the sum of
 * the elements in each row, each column, and the two diagonal is the same
 * value.
 */
public class Square {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int[][]nums;
	
	/**
	 * Construct a Square object.
	 * 
	 * @param nums	the square array (assume it will always be n x n)
	 */
	
	public Square(int[][] nums) {
		// FILL IN
		this.nums = nums;
	}

	/**
	 * Add the numbers in a row of the square.
	 * 
	 * @param i the row index
	 * @return the sum of the row
	 */
	public int rowSum(int i) {
		int sum = 0;
		for (int j = 0; j < nums.length; j++) {
			sum += nums[i][j];
		}
		return sum;
	}

	/**
	 * Add the numbers in a column of the square.
	 * 
	 * @param i the column index
	 * @return the sum of the column
	 */
	public int columnSum(int i) {
		int sum = 0;
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j][i];
		}
		return sum;
				
	}

	/**
	 * Find the sum of the diagonal.
	 * 
	 * @param mainDiagonal true if it is the main diagonal (left/top to right/bottom),
	 * false otherwise (right/top to left/bottom)
	 * 
	 * @return sum the sum of the diagonal
	 */
	public int diagonalSum(boolean mainDiagonal) {
		int sum = 0;
		int j = nums.length - 1;
		for( int i = 0; i < nums.length; i++) {
			if (mainDiagonal) {
				sum += nums[i][i];
			}
			else {
				sum += nums[i][j];
				j--;
			}
		}
			
		return sum; // FIX ME
	}

	/**
	 * Determine if the square is a magic square.
	 * 
	 * @return true if square is a magic square, false otherwise
	 */
	public boolean isMagic() {
		boolean r = true;
		int td = diagonalSum(true);
		int fd = diagonalSum(false);
		if (td != fd) {
			r = false;
		}
		for( int i = 0; i < nums.length; i++) {
			if (rowSum(i) != td || columnSum(i) != td) {
				r = false;
			}
				
		}		
		
		
		return r;
	}
}
