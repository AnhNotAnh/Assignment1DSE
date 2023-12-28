package students.items;

public abstract class Item implements Cloneable 
{	
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
		return false;
		
	}
	
	public int getValue() 
	{
		// Return value when it passes maturationAge otherwise when harvesting it will return 0.
		if(this instanceof Food)
		{
			if(age >= maturationAge)
				return monetaryValue;
			else
				return 0;
		}
		else
			return monetaryValue;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		/* Make deep copy of object and return the copy,
		 * throw CloneNotSupportedException when using clone method. */
		
		Item copy =(Item)super.clone();
		copy.monetaryValue = this.monetaryValue;
		copy.maturationAge = this.maturationAge;
		copy.deathAge = this.deathAge;
		copy.age = this.age;		
		return copy;
	}

	@Override
	public boolean equals(Object otherObject)
	{
		/* Check if otherObject and item are same memory location, 
		 * else check if it is an instance of Item then assigning new variable,
		 * casting it to Item and check against condition otherwise false */
		
		if(otherObject == this)
			return true;
		else
			if(otherObject instanceof Item)
			{
				Item itemObject = (Item)otherObject; 
				return itemObject.age == this.age &&
						itemObject.deathAge ==this.deathAge &&
						itemObject.maturationAge ==this.maturationAge &&
						itemObject.monetaryValue ==this.monetaryValue;
			}
			else
				return false;
	}
	
	@Override
	public abstract String toString(); 

}
