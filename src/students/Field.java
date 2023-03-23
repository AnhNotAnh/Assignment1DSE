package students;
import src.students.items.Soil;

public class Field {
	
	protected String[][] field;
	
	public Field(int height, int width)
	{
		this.field = new String[width][height];
		for (int witdthcount = 0; witdthcount < width; witdthcount++)
		{
			for (int heightcount = 0; heightcount < height; heightcount++)
			{
				Soil soil = new Soil(); //how can field create new soil to put it inside array?
				field [witdthcount][heightcount]= soil.toString();
			}
		}
	}
}
