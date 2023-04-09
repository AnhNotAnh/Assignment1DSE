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
	
	public void run() throws ArrayIndexOutOfBoundsException
	{
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		while(!quit) 
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
			String userInput = keyboard.nextLine().trim();
			String order = userInput.substring(0,1);
			try 
			{
				if(userInput.isEmpty()) {
				    throw new StringIndexOutOfBoundsException();
				}
				if(order.equals("q")) 
				{
					quit = true;
				}
				else if(order.equals("s"))
				{
					System.out.println(fieldObj.getSummary());
				}
				else if(order.equals("w"))
				{
					fieldObj.tick();
					continue;
				}
				else if(order.equals("t"))
				{
					int firstSpaceIdx = userInput.indexOf(" "); 
					String location = userInput.substring(firstSpaceIdx + 1);
					int secondSpaceIdx = location.indexOf(" "); 
					int width = Integer.parseInt(location.substring(0, secondSpaceIdx)); 
					int height = Integer.parseInt(location.substring(secondSpaceIdx + 1)); 
					
					fieldObj.till(height -1, width -1); //(x, y)
				}
				else if(order.equals("h"))
				{
					int firstSpaceIdx = userInput.indexOf(" "); 
					String location = userInput.substring(firstSpaceIdx + 1);
					int secondSpaceIdx = location.indexOf(" "); 
					int width = Integer.parseInt(location.substring(0, secondSpaceIdx)); 
					int height = Integer.parseInt(location.substring(secondSpaceIdx + 1)); 
					
					String foodName = fieldObj.field[height-1][width-1].toString();
					int value = fieldObj.harvest(height -1, width -1);
					startingFunds += value;
					System.out.println("Sold "+ foodName + " for "
										+ value+"\n");
				}
				else if(order.equals("p")) 
				{
					int firstSpaceIdx = userInput.indexOf(" "); 
					String location = userInput.substring(firstSpaceIdx + 1);
					int secondSpaceIdx = location.indexOf(" "); 
					int width = Integer.parseInt(location.substring(0, secondSpaceIdx)); 
					int height = Integer.parseInt(location.substring(secondSpaceIdx + 1)); 
					
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
				else 
				{
					System.out.println("Invalid input, please try again !"+"\n");
					continue;
				}
				fieldObj.tick(); // after each action, the field ages.
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Out of bounds, please enter number within width of "
									+ this.fieldWidth + " and height of "+ this.fieldHeight +" !" +"\n");
			}
			catch(StringIndexOutOfBoundsException e) // Empty input
			{
				System.out.println("Empty input found, please try again !"+"\n");
			}
			catch(NumberFormatException e) // Wrong format lead to incorrectly parse integer because it may contain non-integer value.
			{
				System.out.println("Wrong format, please try again !"+"\n");
			}
		}
	}
}
