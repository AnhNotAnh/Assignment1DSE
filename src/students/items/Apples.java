package src.students.items;

public class Apples extends Food {

	public Apples() 
	{
		super(2,6,2);
	}
	
	/*Lecture 3? explanation*/
	public static int getGenerationCount()
	{
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
