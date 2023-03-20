package src.students.items;

public abstract class Soil extends Item {

	public Soil(int maturation_age, int death_age, int monetary_value) 
	{
		super(maturation_age, death_age, monetary_value);
		maturation_age = Integer.MAX_VALUE;
		death_age = Integer.MAX_VALUE;
		monetary_value = 0;
	}
	
	public String toString()
	{
		return ".";
	}
}
