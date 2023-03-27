package students;
import students.items.*;

import java.util.Random;

public class Field {
	
	protected Item[][] field;
	protected int height;
	protected int width;
	
	public Field(int height, int width)
	{
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				field [heightcount][witdthcount]= new Soil();
			}
		}
	}
	
	
	public void tick()
	{
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				Item itemChild = field [heightcount][witdthcount];
				if (itemChild instanceof Soil)
				{
					Random dice = new Random();
					int percentage = dice.nextInt(101);
					if (percentage <= 20)
					{
						field [heightcount][witdthcount] = new Weed();
					}
					else
						itemChild.tick();
				}
				else
				{
					if (itemChild.died() == true)
					{
						field [heightcount][witdthcount] = new Weed();
					}
					else
					{
						itemChild.tick();
					}
				}
			}
		}
	}
		
	
	
	public void till(int i, int j) 
	{	
		field[i][j]= new Soil();
	}
	
	
	// using clone or copy?
	public String get(int i, int j)
	{
		return null;
	}
	

	public void plant(int i, int j, Item food) 
	{
		field[i][j]= food;
	}

	
	public int getValue()
	{
		int totalValue = 0;
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				totalValue += field [heightcount][witdthcount].getValue();
			}
		}
		return totalValue;
	}
	
	// Will this using getGenCount?
	public String getSummary()
	{
		return null;
	}
	
	//How to create numbered grid?
	@Override
	public String toString()
	{
		return null;
	}
	
	
	
}