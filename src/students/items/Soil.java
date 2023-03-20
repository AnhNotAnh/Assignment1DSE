package src.students.items;

public class Soil extends Item {

	public Soil() 
	{
		super(maturationAge, deathAge, monetaryValue);
		maturationAge = Integer.MAX_VALUE;
		deathAge = Integer.MAX_VALUE;
		monetaryValue = 0;
	}
	
	public String toString()
	{
		return ".";
	}
}
