package src.students.items;

public class Grain extends Food{

	public Grain()
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
			return "g";
		else
			return "G";
	}
}
