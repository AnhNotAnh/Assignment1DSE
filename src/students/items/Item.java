package src.students.items;

public abstract class Item {
	
	protected static int age = 0;
	protected static int maturationAge;
	protected static int deathAge;
	protected static int monetaryValue;
	
	
	
	public Item(int maturation_age,int death_age,int monetary_value)
	{
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
		Item.age = age;
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
	
	/*Uncompleted function*/
	public int getValue() 
	{ 
		if(Food.age > Food.maturationAge)
			return Food.monetaryValue;
		else
			return monetaryValue;
	}
	
	/*Uncompleted function, review lecture 2, page 210 */
	public boolean equals(Object obj)
	{
		if(obj.equals(this))
			return true;
		else 
			return false;
	}
	
	@Override
	public abstract String toString(); 

}
