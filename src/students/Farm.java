package students;
import java.util.Scanner;
import students.items.*;

public class Farm {
	
	protected int fieldWidth;
	protected int fieldHeight;
	protected int startingFunds;
	protected Field fieldObj;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
		this.fieldObj = new Field(fieldHeight, fieldWidth);
	}
	
	public void run() // fail to test t 10 2 as x = "1" and y =" 2"
	{
		boolean quit = true;
		while(quit) 
		{
			System.out.println(fieldObj);
			System.out.printf("Bank balance: $"+ "%2d ", startingFunds);
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
			userInput = userInput.trim();
			try 
			{
				if(userInput.substring(0,1).equals("q"))
				{
					quit = false;
				}
				else if(userInput.substring(0,1).equals("t")) // e.g t 10 2 -> width = 10 and height =2 , fix other functions !!!!!!!!
				{
					int firstSpaceIdx = userInput.indexOf(" "); // return 1
					String location = userInput.substring(firstSpaceIdx + 1); // return "10 2"
					int secondSpaceIdx = location.indexOf(" "); // return 2
					
					int width = Integer.parseInt(location.substring(0, secondSpaceIdx)); // return 10
					int height = Integer.parseInt(location.substring(secondSpaceIdx + 1)); // return 2
					fieldObj.till(height -1, width -1); //(x, y)
					
					System.out.println(firstSpaceIdx+ " "+location+" " + secondSpaceIdx+ "\n"); // return 1 10 2 2
					System.out.println(width +" "+ height ); // 10 2
				}
				else if(userInput.substring(0,1).equals("h"))
				{
					int width = Integer.parseInt(userInput.substring(2,3));
					int height = Integer.parseInt(userInput.substring(4));
					String foodName = fieldObj.field[height-1][width-1].toString();
					int value = fieldObj.harvest(height -1, width -1);
					startingFunds += value;
					System.out.println("Sold "+ foodName + " for "
										+ value+"\n");
				}
				else if(userInput.substring(0,1).equals("p")) 
				{
					int width = Integer.parseInt(userInput.substring(2,3));
					int height = Integer.parseInt(userInput.substring(4));
					if(fieldObj.field[height-1][width-1] instanceof Food)
					{
						System.out.println("Food has been planted");
					}
					else 
					{
						System.out.println("Enter:"+"\n"+
											"- 'a' to buy an apple for $2" + "\n"+
											"- 'g' to buy an grain for $1"+ "\n");
						String plantTree = keyboard.nextLine();
						if(plantTree.substring(0).equals("a") && startingFunds - Apples.getCost() >=0 )
						{
							fieldObj.plant(height-1, width-1, new Apples());
							startingFunds -= Apples.getCost();
						}
						else if(plantTree.substring(0).equals("g") && startingFunds - Grain.getCost() >=0 )
						{
							fieldObj.plant(height-1, width -1, new Grain());
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
					System.out.println(fieldObj.getSummary());
				}
				else if(userInput.substring(0,1).equals("w"))
				{
					fieldObj.tick();
					continue;
				}
				else
				{
					System.out.println("Invalid input, please try again !"+"\n");
					continue;
				}
				fieldObj.tick(); // after each action, the field ages.
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println("Empty input found, please try again !"+"\n");
			}
		}
	}
}
