package src.students.items;

public abstract class Grain extends Food{
	

	public Grain(int maturationAge, int deathAge, int monetaryValue)
	{
		super(maturationAge, deathAge, monetaryValue);
		maturationAge = 2;
		deathAge = 6;
		monetaryValue = 2;	
	}
	
	/*Lecture explanation*/
	public static int getGenerationCount()
	{
		return 0;
	}
	
	public String toString()
	{
		if(Grain.age < maturationAge )
			return "g";
		else
			return "G";
	}
}
