package students.items;

public class Grain extends Food{

	private static int counter =0;
	protected final static int cost = 1;

	public Grain()
	{
		super(2,6,2);
		counter++;
	}
	
	/*Lecture 3? explanation*/
	public static int getGenerationCount()
	{
		return counter;
	}
	
	public String toString()
	{
		if(age < maturationAge )
			return "g";
		else
			return "G";
	}
	
	public static int getCost()
	{
		return cost;
	}
}
