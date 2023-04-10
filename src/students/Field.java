package students;
import students.items.*;

import java.util.Random;

public class Field 
{	
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
			for (int widthcount = 0; widthcount < width; widthcount++)
			{
				field[heightcount][widthcount]= new Soil();
			}
		}
	}
	
	public void tick()
	{
		/* Execute aging process of every item in the field,
		 * 1/5 chance randomly grow weed pest if item is Soil,
		 * and turn item to UntilledSoil if died after aging. */
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int widthcount = 0; widthcount < width; widthcount++)
			{
				field[heightcount][widthcount].tick();
				if (field[heightcount][widthcount] instanceof Soil)
					{
						Random dice = new Random();
						int percentage = dice.nextInt(101);
						if (percentage <= 20)
							{
								field[heightcount][widthcount] = new Weed();
							}
					}
				if (field[heightcount][widthcount].died() == true)
					{
						field[heightcount][widthcount] = new UntilledSoil();
					}
				
				}
			}
	}
		
	public void till(int x, int y) 
	{	
		field[x][y]= new Soil();
	}
	
	public Item get(int x, int y) throws CloneNotSupportedException
	{
		/* Check if an item in the field is instance of specific type item such as Soil, Food,
		 * create copy of that item using clone() and return it.
		 * Throwing CloneNotSupportedException while using clone(), get() is necessary */
		
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
		/* To harvest, this function will get value of item in given location
		 * turn the current location back to soil after harvesting,
		 * and return the value of item */
		
		int foodValue = field[x][y].getValue();
		field[x][y] = new Soil();
		return foodValue;
	}

	public int getValue()
	{
		int totalValue = 0;
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int widthcount = 0; widthcount < width; widthcount++)
			{
				totalValue += field[heightcount][widthcount].getValue();
			}
		}
		return totalValue;
	}
	
	public String getSummary()
	{	
		/* Calculate the amount of each item in the field,
		 * and generate a summary with total value of field */
		
		int numOfApple = 0;
		int numOfGrain = 0;
		int numOfSoil = 0;
		int numOfUntilledSoil = 0;
		int numOfWeed = 0;
		for (int heightcount = 0; heightcount < height; heightcount++)
		{
			for (int widthcount = 0; widthcount < width; widthcount++)
			{
				if(field[heightcount][widthcount] instanceof Apples)
				{
					numOfApple +=1;
				}
				else if(field[heightcount][widthcount] instanceof Grain)
				{
					numOfGrain +=1;
				}
				else if(field[heightcount][widthcount] instanceof Soil)
				{
					numOfSoil +=1;
				}
				else if(field[heightcount][widthcount] instanceof UntilledSoil)
				{
					numOfUntilledSoil +=1;
				}
				else if(field[heightcount][widthcount] instanceof Weed)
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
	
	@Override
	public String toString()
	{	
		/* Generate numbered grid with all soil item */
		
		String printable = "";
		for (int heightcount = 0; heightcount <= height; heightcount++)
		{
			for (int widthcount = 0 ; widthcount <= width; widthcount++) 
			{
				if (heightcount == 0 && widthcount == 0) 
		        {
		        	printable+="  ";
		        } 
				// print numbered column
				else if (heightcount == 0)
		        {
					printable+=" "+ widthcount;
		        } 
				// print numbered row
				else if (widthcount == 0)
		        {
		        	printable+=" "+ heightcount;
		        }
				//print item in the field
				else 
				printable +=" " + field[heightcount - 1][widthcount - 1].toString();
		    }
			printable+= "\n";
		}
	return printable;
	}
}