package src.students.items;

public class Item {
	
	private int age;
	private int maturationAge;
	private int deathAge;
	private int monetaryValue;
	
	
	
	public Item(int maturation_age,int death_age,int monetary_value)
	{
		this.age = 0;
		maturationAge = maturation_age;
		deathAge = death_age;
		monetaryValue = monetary_value;
	}
	
	
	public void tick() 
	{
		 age ++;
	}
	
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	
	public boolean died () 
	{
		if (age > deathAge) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int getValue() 
	{
		return monetaryValue;
	}
	
	/*Uncompleted function*/
	public boolean equals()
	{
		return true;
	}
	
	/*Uncompleted function*/
	@Override
	public String toString()
	{
		return "";
		
	}
	
	
	
}
