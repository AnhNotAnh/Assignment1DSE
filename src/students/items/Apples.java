package src.students.items;

public class Apples extends Food {
	
	private static int counter =0;

	public Apples() 
	{
		super(2,6,2);
		counter++;
	}
	
	/*Lecture 3? explanation*/
	public static int getGenerationCount()
	{
		return counter;
	}
	
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
			return "a";
		else
			return "A";
	}

}
