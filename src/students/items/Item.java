package src.students.items;

public abstract class Item {
	
	protected int age;
	protected int maturationAge;
	protected int deathAge;
	protected int monetaryValue;
	
	
	
	public Item(int maturation_age,int death_age,int monetary_value)
	{
		this.age =0;
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
		return monetaryValue;
	}
	
	/*Uncompleted function, review lecture 2, page 210 */
	@Override
	public boolean equals(Object otherObject)
	{
		if(otherObject == this)
			return true;
		else
			if(!(otherObject instanceof Item))
			{
				return false;
			}
			else
			{
				Item itemObject = (Item)otherObject; 
				return itemObject.age == this.age &&
					   itemObject.deathAge ==this.deathAge &&
					   itemObject.maturationAge ==this.maturationAge &&
					   itemObject.monetaryValue ==this.monetaryValue;
			}
	}
	
	@Override
	public abstract String toString(); 

}
