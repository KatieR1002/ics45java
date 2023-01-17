package lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	private int width;
	private int length;
	private int size;

	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
	
		this.width = 841;
		this.length = 1189;
		this.size = 0;
		// WRITE YOUR CODE HERE
	}

	/**
	 * @return the width of the paper
	 */
	public int getWidth() {
		return width;// FIX ME
	}

	/**
	 * @return the length of the paper
	 */
	public int getLength() {
		return length; // FIX ME
	}

	/**
	 * @return the ISO name for the paper
	 */
	public String getName() {
		return "A" + String.valueOf(size); // FIX ME
	}

	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		this.size += 1;
		int temp = 0;
		if (length > width) {
			temp = width;
			width = length/2;
			length = temp;}
		else {
			temp = length;
			length = width/ 2;
			 width = temp;}
		return this;
		// FIX ME
	}

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		System.out.println(sheet.getName()); // returns "A0"
		System.out.println(sheet.getWidth()); // returns 841
		System.out.println(sheet.getLength()); // returns 1189

		sheet = sheet.cutInHalf();
		System.out.println(sheet.getName()); // returns "A1"
		System.out.println(sheet.getWidth()); // returns 594
		System.out.println(sheet.getLength()); // returns 841

		sheet = sheet.cutInHalf();
		System.out.println(sheet.getName()); // returns "A2"
		System.out.println(sheet.getWidth()); // returns 420
		System.out.println(sheet.getLength()); // returns 594
	}
}
