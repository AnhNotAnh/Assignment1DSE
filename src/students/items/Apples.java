package students.items;

public class Apples extends Food {
	
	private static int counter =0;
	
	public Apples() 
	{
		super(3,5,3);
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
			return "a";
		else
			return "A";
	}

}
