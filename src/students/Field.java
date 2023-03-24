package students;
import students.items.Item;
import students.items.Soil;

public class Field {
	
	// will field be a object of item ?
	protected Item[][] field;
	
	public Field(int height, int width)
	{
		this.field = new Item[height][width];
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				field [heightcount][witdthcount]= new Soil();
			}
		}
	}
	public void till(int i, int j) 
	{	
		
	}
	
	

	public String get(int i, int j)
	{
		return null;
	}
	
	
	

	public void plant(int i, int j, Item food) 
	{
		
	}

	
	public int getValue()
	{
		return 0;
	}
	
	public String getSummary()
	{
		return null;
	}
	
	
	
	
	
	
}
