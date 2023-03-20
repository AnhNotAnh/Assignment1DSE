package src.students.items;

public class Weed extends Item
{

	public Weed() {
		super(maturationAge, deathAge, monetaryValue);
		maturationAge = Integer.MAX_VALUE;
		deathAge = Integer.MAX_VALUE;
		monetaryValue = -1;
	}
	
	public String toString()
	{
		return "#";
	}
		
		
}
