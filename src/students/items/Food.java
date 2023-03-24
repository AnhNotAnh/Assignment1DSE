package students.items;

public abstract class Food extends Item {

	public Food(int maturationAge,int deathAge,int monetaryValue) 
	{
		super(maturationAge, deathAge, monetaryValue);
	
	}
	
	@Override
	public int getValue() 
	{ 
		if(age > maturationAge)
			return monetaryValue;
		else
			return 0;
	}
	


}
	


