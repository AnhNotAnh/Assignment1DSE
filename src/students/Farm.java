package students;
import java.util.Scanner;
import students.items.*;

public class Farm {
	
	protected int fieldWidth;
	protected int fieldHeight;
	protected int startingFunds;
	protected Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
		this.field = new Field(fieldHeight, fieldWidth);
	}
	
	public void run()
	{
		boolean quit = true;
		while(quit) 
		{
			System.out.println(field);
			System.out.printf("Bank balance: "+ "%2d ", startingFunds);
			System.out.println();
			System.out.println("Enter your next action:"+"\n"+
								"  t x y: till"+"\n"+
								"  h x y: harvest"+ "\n"+
								"  p x y: plant"+ "\n"+
								"  s: field summary"+ "\n"+
								"  w: wait"+ "\n"+
								"  q: quit" +"\n");
			Scanner keyboard = new Scanner(System.in);
			String userInput = keyboard.nextLine();
			if(userInput.substring(0,1).equals("q"))
			{
				quit = false;
			}
			else if(userInput.substring(0,1).equals("t")) // works
			{
				int height = Integer.parseInt(userInput.substring(2,3));
				int weight = Integer.parseInt(userInput.substring(4));
				field.till(height -1, weight -1);
				System.out.println(height +" "+ weight);
			}
			else if(userInput.substring(0,1).equals("h"))
			{
				int height = Integer.parseInt(userInput.substring(2, 3));
				int weight = Integer.parseInt(userInput.substring(4));
				field.harvest(height -1, weight -1);
			}
			else if(userInput.substring(0,1).equals("p")) // uncompleted, plant 3 4 but at 4 5 ??
			{
				int height = Integer.parseInt(userInput.substring(2, 3));
				int weight = Integer.parseInt(userInput.substring(4));
				if(field.field[height-1][weight-1] instanceof Food)
				{
					System.out.println("Food has been planted");
				}
				else 
				{
					System.out.println("Enter:"+"\n"+
										"- 'a' to buy an apple for $2" + "\n"+
										"- 'g' to buy an grain for $1"+ "\n");
					String plantTree = keyboard.nextLine();
					if(plantTree.substring(0).equals("a"))
					{
						field.plant(height-1, weight-1,new Apples());
						startingFunds -= Apples.getCost();
					}
					else if(plantTree.substring(0).equals("g"))
					{
						field.plant(height-1, weight -1, new Grain());
						startingFunds -= Grain.getCost();
					}
					else
					{
						System.out.println("Invalid input");
					}
				}
			}
			else if(userInput.substring(0,1).equals("s"))
			{
				System.out.println(field.getSummary());
			}
			else if(userInput.substring(0,1).equals("w"))
			{
				field.tick();
			}
			else
			{
				System.out.println("Invalid input"+"\n");
			}
		}
	}
}
