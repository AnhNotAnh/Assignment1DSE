package src.students.items;

public class UntilledSoil extends Item {

	public UntilledSoil() 
	{
		super(maturationAge, deathAge, monetaryValue);
		maturationAge = Integer.MAX_VALUE;
		deathAge = Integer.MAX_VALUE;
		monetaryValue = -1;
	}
	
	public String toString()
	{
		return "/";
	}
}
