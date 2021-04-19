
public class HolidayBonus 
{
	/*
	 * Calculates the holiday bonus for each store 
	 * returns an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] bonus = new double[data.length];
		
		for(int row = 0; row < data.length; row++)
		{
			double total = 0;
		
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] > 0)
				{
					if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data,col) == row)
					{
						total += high;	
					}
					else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,col) == row)
					{
						total += low;
					}
					else
						total += other;					
				}
			}
			bonus[row] = total;
			//System.out.println("checking " + bonus[row]); this output was for debugging reasons
		}
		return bonus;
	}
	
	/*
	 * Calculates the total holiday bonuses 
	 * returns the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double totalBonus = 0;
		double bonus[] = calculateHolidayBonus(data,high,low,other);
		
		for(int i = 0; i < bonus.length; i++)
		{
			totalBonus += bonus[i];
		}	
		return totalBonus;
	}
}
