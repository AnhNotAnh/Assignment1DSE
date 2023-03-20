package src.students.items;

public abstract class  Apples extends Food {

	public Apples(int maturationAge, int deathAge, int monetaryValue) 
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
		if(Apples.age < maturationAge )
			return "a";
		else
			return "A";
	}

}
