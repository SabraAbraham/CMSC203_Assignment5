import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() 
	{
		//Default constructor
	}

	/*
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * Suggestion: You need to know how many rows and how many columns there are for
	 * each row to create a ragged array.
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(file);
		String[][] temp = new String[10][];
		double[][] realArray;
		int i = 0;
		
		while(inputFile.hasNext())
		{
			String[] array = inputFile.nextLine().split(" ");
			temp[i] = new String[array.length];
			
			for(int row = 0; row < array.length; row++)
			{
				temp[i][row] = array[row];
			}
			i++;
		}
		inputFile.close();
		realArray = new double[i][];
		
		for(int a = 0; a < temp.length; a++)
		{
			if(temp[a] != null)
			{
				realArray[a] = new double[temp[a].length]; 
				
				for(int b = 0; b < temp[a].length; b++)
				{
					realArray[a][b] = Double.parseDouble(temp[a][b]);
				}
			}
		}
		return realArray;
	}
	
	/*
	 * Writes the ragged array of doubles into the file.
	 */
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(file);
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col =0; col < data[row].length; col++)
			{
				pw.print(data[row][col] + " ");
			}
			pw.println();
		}
		pw.close();	
	}

	/*
	 * Returns the total of all the elements of the two dimensional array
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	/*
	 *  Returns the average of the elements in the two dimensional array
	 *  */
	public static double getAverage(double[][] data)
	{
		double sum = 0;
		int count = 0;
		
		for (int row = 0; row < data.length; row++)
			for (int col = 0; col < data[row].length; col++) 
			{
				sum += data[row][col];
				count++;
			}
		return sum/count;
	}

	/*
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double   rowTotal = 0;
		
		for(int col = 0; col < data[row].length; col++)
		{
			rowTotal += data[row][col];
		}
		return rowTotal;
	}

	/*
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column.
	 */	
	public static double getColumnTotal(double[][] data, int col) // correct with debugging
	{
		double colTotal = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(data[row].length > col)
				colTotal += data[row][col];
		}
		 return colTotal;
	}

	/*
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 */	
	public static double getHighestInRow(double[][] data,int row)
	{
		double max = data[row][0];
		
		for(int col = 0; col < data[row].length; col++)
		{
			if(data[row][col] > max)
				max = data[row][col];
		}
		return max;
	}

	/*
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int highIndex = 0;
		double high = data[row][0];
		
		for(int col = 0; col < data[row].length; col++)
		{
			if(data[row][col] > high)
			{
				high = data[row][col];
				highIndex = col;
			}
		}
		return highIndex;
	}

	/*
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double low = data[row][0];
		
		for(int col = 0; col < data[row].length; col++)
		{
			if(data[row][col] < low)
				low = data[row][col];
		}
		return low;
	}

	/*
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 */
	public static int getLowestInRowIndex(double[][] data, int row) // correct through debugger
	{
		double low = data[row][0];
		int lowIndex = 0;
		
		for(int col = 0; col < data[row].length; col++)
		{
			if(data[row].length > row)
			{
				if(data[row][col] < low)
				{
					low = data[row][col];
					lowIndex = col;
				}
			}
		}
		return lowIndex;
	}

	/*
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column.
	 */	
	public static double getHighestInColumn(double[][] data, int col)
	{
		
		double high = data[0][col];

		for (int row = 0; row < data.length; row++) {
			if (data[row].length > col) {
				if (data[row][col] > high)
					high = data[row][col];
			}
		}
		return high;
		 
		
	}

	/*
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column.
	 */	
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double high = 0;
		int highIndex = 0;
		
		for(int row = 0; row < data.length; row++)
		{
			if(data[row].length > col)
			{	
				if(data[row][col] > high)
				{	high = data[row][col];
					highIndex = row;
				}
			}
		}
		return highIndex;
	}

	/*
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column.
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
	
		double low = data[0][col];
		
		for(int row = 0; row < data.length; row++)
		{
			if(data[row].length > col)
			{
				if(data[row][col] < low)
					low = data[row][col];
			}
		}
		return low;
	}

	/*
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double low = 0;
		int lowIndex = 0;
		
		for(int row = 0; row < data.length; row++)
		{
			if(data[row].length > col)
			{	
				if(data[row][col] < low|| low==0)
 				{	low = data[row][col];
					lowIndex = row;
				}
			}
		}
		return lowIndex;
	}

	/*
	 * Returns the largest element in the two dimensional array
	 */	
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length;col++ )
			{
				if(data[row][col] > highest)
					highest = data[row][col];
			}
		}
		return highest;
	}
	
	/*
	 * Returns the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length;col++ )
			{
				if(data[row][col] < lowest)
					lowest = data[row][col];
			}
		}
		return lowest;
	}
}
