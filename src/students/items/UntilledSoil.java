package src.students.items;

public class UntilledSoil extends Item {

	public UntilledSoil(int maturation_age, int death_age, int monetary_value) 
	{
		super(maturation_age, death_age, monetary_value);
		maturation_age = Integer.MAX_VALUE;
		death_age = Integer.MAX_VALUE;
		monetary_value = -1;
	}
	
	public String toString()
	{
		return "/";
	}
}
