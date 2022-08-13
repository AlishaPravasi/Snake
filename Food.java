import edu.du.dudraw.*;
public class Food 
{
	public int x, y;
	//private Draw draw = new Draw();
	public Food(Draw d)
	{
		this.x = (int) (Math.random() * 501);
		this.y = (int) (Math.random() * 501);
	}
	public void drawFood(Draw d)
	{
		d.filledCircle(x, y, 5);
	}
	public boolean foodEaten(int headY, int headX, Draw d)
	{
		if(Math.sqrt((y - headY) * (y - headY) * (x - headX) * (x - headX)) < 10)
		{
			d.clear();
			return true;
		}
		else
			return false;
	}
}

