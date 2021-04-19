

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT1 = {{25,2,3},{4,5},{6,7,8}};
	private double[][] dataSetSTUDENT2 = { {6,2,9,4},{5,1},{8,1,3},{11,6,7,2}};
	private double[][] dataSetSTUDENT3 = { {-1,-5,6.1},{-4, 8.2},{2, -7.5},{-4.2,7,-5},{3}};	
	private File inputFile, outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT1 = dataSetSTUDENT2 = dataSetSTUDENT3 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(60.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT1),.001);
		assertEquals(65.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2),.001);
		assertEquals(-0.4,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT3),.001);

	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(7.5,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT1),.001);
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
		assertEquals(-0.03636363648,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT3),.001);

	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT1,1),.001);
		assertEquals(21.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,0),.001);
		assertEquals(4.2,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,1),.001);

	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(35.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT1,0),.001);
		assertEquals(30.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,0),.001);
		assertEquals(-4.2,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,0),.001);	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT1,2),.001);
		assertEquals(5.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT2,1),.001);
		assertEquals(6.1,TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT3,0),.001);	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT1, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(25, array[0][0],.001);
		assertEquals(2, array[0][1],.001);
		assertEquals(3, array[0][2],.001);
		assertEquals(4, array[1][0],.001);
		assertEquals(5, array[1][1],.001);
		assertEquals(6, array[2][0],.001);
		assertEquals(7, array[2][1],.001);
		assertEquals(8, array[2][2],.001);
			
		
	}

}