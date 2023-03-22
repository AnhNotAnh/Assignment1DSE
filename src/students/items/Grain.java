package src.students.items;

public class Grain extends Food{

	private static int counter =0;

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
	
	//Should have actual value > variables ?
	@Override
	public int getValue() 
	{ 
		if(age > maturationAge)
			return monetaryValue;
		else
			return 0;
	}
	
	public String toString()
	{
		if(age < maturationAge )
			return "g";
		else
			return "G";
	}
}
