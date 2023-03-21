package src.students.items;

public abstract class Item {
	
	protected int age = 0;
	protected int maturationAge;
	protected int deathAge;
	protected int monetaryValue;
	
	
	
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
	
	/*Uncompleted function*/
	public int getValue() 
	{ 
		// do we need to check whether it is food items??
		if(age > maturationAge)
			return monetaryValue;
		else
			return 0; 
	}
	
	/*Uncompleted function, review lecture 2, page 210 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		else
			return false;
	}
	
	@Override
	public abstract String toString(); 

}
