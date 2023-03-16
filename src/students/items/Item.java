package src.students.items;

public class Item {
	
	public int age = 0;
	public int maturationAge;
	public int deathAge;
	public int monetaryValue;
	
	/*public Item (int maturation_age,int death_age,int monetary_value)*/
	
	public Item(int maturation_age,int death_age,int monetary_value)
	{
		this.maturationAge = maturation_age;
	}
	
	
	public void tick() 
	{
		 this.age ++;
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
