package students.items;

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
		 this.age ++;
	}
	
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	
	public boolean died () 
	{
		if (this.age > this.deathAge) {
			return true;
		}
		return false;
		
	}
	
	// getValue for Food item will be in Food class
	public int getValue() 
	{ 
		return monetaryValue;
	}
	
	/*Uncompleted function, review lecture 2, page 210 */
	@Override
	public boolean equals(Object otherObject)
	{
		
		if(otherObject == this)//check if otherObject and item are same memory location
			return true;
		else // check if it is an instance of Item then assigning new variable, casting it to Item and check condition otherwise false
			if(otherObject instanceof Item)
			{
				Item itemObject = (Item)otherObject; 
				return itemObject.age == this.age &&
						itemObject.deathAge ==this.deathAge &&
						itemObject.maturationAge ==this.maturationAge &&
						itemObject.monetaryValue ==this.monetaryValue;
			}
			else // if it's not instance of Item
				return false;
	}
	
	@Override
	public abstract String toString(); 

}
