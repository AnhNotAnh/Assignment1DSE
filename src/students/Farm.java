package students;
import java.util.Scanner;
import students.items.*;

public class Farm 
{	
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
		/* The player will initiate the game by executing the 'run()' function. 
		 * This function prompts the user to input commands according to the given rules,
		 * and the program will respond accordingly.
		 * Unexpected input will result in skipping the turn of user, and prompting error message */
		
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
			try 
			{
				String order = userInput.substring(0,1);
				if(userInput.length()==1) // To manage the case when double one-word order is entered (e.g qq or ww) 
				{
					if(userInput.isEmpty()) 
					{
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
				}
				else if(userInput.length()>1)
				{
					int firstSpaceIdx = userInput.indexOf(" "); 
					String location = userInput.substring(firstSpaceIdx + 1);
					int secondSpaceIdx = location.indexOf(" "); 
					int width = Integer.parseInt(location.substring(0, secondSpaceIdx)); 
					int height = Integer.parseInt(location.substring(secondSpaceIdx + 1)); 
					
					if(order.equals("t"))
					{
						fieldObj.till(height -1, width -1); //(x, y)
					}
					else if(order.equals("h"))
					{
						String foodName = fieldObj.field[height-1][width-1].toString();
						int value = fieldObj.harvest(height -1, width -1);
						startingFunds += value;
						System.out.println("Sold "+ foodName + " for "
											+ value+"\n");
					}
					else if(order.equals("p")) 
					{
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
								System.out.println("Invalid input"+"\n");
								continue;
							}
						}
					}
					else 
					{
						System.out.println("Invalid input"+"\n");
						continue;
					}
				}
				else 
				{
					System.out.println("Invalid input, please try again !"+"\n");
					continue;
				}
				fieldObj.tick(); // After each action, the field ages.
			}
			catch(ArrayIndexOutOfBoundsException e) // Out of field's bound.
			{
				System.out.println("Out of bounds, please enter number within width of "
									+ this.fieldWidth + " and height of "+ this.fieldHeight +" !" +"\n");
			}
			catch(StringIndexOutOfBoundsException e) // Empty input from user.
			{
				System.out.println("Empty/Invalid input found, please try again !"+"\n");
			}
			catch(NumberFormatException e) // Wrong format lead to being unable to parse integer because it may contain non-integer value.
			{
				System.out.println("Wrong format, please try again !"+"\n");
			}
		}
	}
}
