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
				field[heightcount][witdthcount]= new Soil();
			}
		}
	}
	
	
	public void tick()
	{
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				field[heightcount][witdthcount].tick();
				if (field[heightcount][witdthcount] instanceof Soil)
					{
						Random dice = new Random();
						int percentage = dice.nextInt(101);
						if (percentage <= 20)
							{
								field[heightcount][witdthcount] = new Weed();
							}
					}
				if (field[heightcount][witdthcount].died() == true)
					{
						field[heightcount][witdthcount] = new UntilledSoil();
					}
				
				}
			}
	}
		
	public void till(int x, int y) 
	{	
		field[x][y]= new Soil();
	}
	
	
	// using clone or copy? (uncompleted)
	public Item get(int x, int y) throws CloneNotSupportedException
	{
		if(field[x][y] instanceof Apples)
		{
			Apples appleCopy = (Apples)field[x][y].clone();
			return appleCopy;
		}
		else if(field[x][y] instanceof Grain)
		{
			Grain grainCopy = (Grain)field[x][y].clone();
			return grainCopy;
		}
		else if(field[x][y] instanceof Soil)
		{
			Soil soilCopy = (Soil)field[x][y].clone();
			return soilCopy;
		}
		else if(field[x][y] instanceof UntilledSoil)
		{
			UntilledSoil untilledSoilCopy = (UntilledSoil)field[x][y].clone();
			return untilledSoilCopy;
		}
		else if(field[x][y] instanceof Weed)
		{
			Weed weedCopy = (Weed)field[x][y].clone();
			return weedCopy;
		}
		else
			return field[x][y];
	}
	
	public void plant(int x, int y, Item food) 
	{
		field[x][y]= food;
	}
	
	public int harvest(int x, int y) 
	{
		int foodValue = field[x][y].getValue();
		field[x][y] = new Soil();
		return foodValue;
	}

	public int getValue()
	{
		int totalValue = 0;
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				totalValue += field[heightcount][witdthcount].getValue();
			}
		}
		return totalValue;
	}
	
	// Will this using getGenCount? use instance of, using switch, case?
	// Do we need to check if that's food ?
	public String getSummary()
	{	
		int numOfApple = 0;
		int numOfGrain = 0;
		int numOfSoil = 0;
		int numOfUntilledSoil = 0;
		int numOfWeed = 0;
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int witdthcount = 0; witdthcount < width; witdthcount++)
			{
				if(field[heightcount][witdthcount] instanceof Apples)
				{
					numOfApple +=1;
				}
				else if(field[heightcount][witdthcount] instanceof Grain)
				{
					numOfGrain +=1;
				}
				else if(field[heightcount][witdthcount] instanceof Soil)
				{
					numOfSoil +=1;
				}
				else if(field[heightcount][witdthcount] instanceof UntilledSoil)
				{
					numOfUntilledSoil +=1;
				}
				else if(field[heightcount][witdthcount] instanceof Weed)
				{
					numOfWeed +=1;
				}
				
			}
		}
		return "Apples:        " + numOfApple +"\n" +
				"Grain:         " + numOfGrain +"\n" +
				"Soil:          " + numOfSoil + "\n" +
				"Untilled:      " + numOfUntilledSoil + "\n" +
				"Weed:          " + numOfWeed + "\n" +
				"For a total of $"+ getValue() + "\n" +
				"Total apples created: "+ Apples.getGenerationCount() + "\n" +
				"Total grain created: "+ Grain.getGenerationCount();
	}
	
	//How to create numbered grid?
	@Override
	public String toString()
	{	
		String printable = "";
		for (int heightcount = 0; heightcount <= height; heightcount++)
		{
			for (int witdthcount = 0 ; witdthcount <= width; witdthcount++) 
			{
				if (heightcount == 0 && witdthcount == 0) 
		        {
		        	printable+="  ";
		        } 
				// print numbered column
				else if (heightcount == 0)
		        {
					printable+=" "+ witdthcount;
		        } 
				// print numbered row
				else if (witdthcount == 0)
		        {
		        	printable+=" "+ heightcount;
		        }
				//print item in the field
				else 
				printable +=" " + field[heightcount - 1][witdthcount - 1].toString();
		    }
			printable+= "\n";
		}
	return printable;
	}
}