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
				System.out.println(quit);
			}
			else if(userInput.substring(0,1).equals("t"))
			{
				int height = Integer.parseInt(userInput.substring(2,3));
				int weight = Integer.parseInt(userInput.substring(4));
				field.till(height, weight);
				System.out.println(height +" "+ weight);
			}
			else if(userInput.substring(0,1).equals("h"))
			{
				int height = Integer.parseInt(userInput.substring(2, 3));
				int weight = Integer.parseInt(userInput.substring(4));
				field.harvest(height, weight);
			}
			else if(userInput.substring(0,1).equals("p")) // uncompleted
			{
				int height = Integer.parseInt(userInput.substring(2, 3));
				int weight = Integer.parseInt(userInput.substring(4));
				System.out.println("Enter:"+"\n"+
									"- 'a' to buy an apple for $2" + "\n"+
									"- 'g' to buy an grain for $1"+ "\n");
				String plantTree = keyboard.nextLine();
				if(plantTree.substring(0).equals("a"))
				{
					Apples apple = new Apples();
					field.plant(height, weight, apple);
					startingFunds -= field.field[height][weight].getCost();// need to be fixed
				}
				else if(plantTree.substring(0).equals("g"))
				{
					Grain grain = new Grain();
					field.plant(height, weight, grain);
					startingFunds -= field.field[height][weight].getCost(); // need to be fixed
				}
				else
				{
					System.out.println("Invalid input");
				}
				
				
				field.till(height, weight);
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
