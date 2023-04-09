package students.items;

public class Apples extends Food 
{	
	private static int counter =0;
	protected final static int cost = 2;
	
	public Apples() 
	{
		super(3,5,3);
		counter++;
	}
	
	public static int getGenerationCount()
	{
		return counter;
	}
	
	public String toString()
	{
		if(age < maturationAge )
			return "a";
		else
			return "A";
	}
	
	public static int getCost()
	{
		return cost;
	}

}
