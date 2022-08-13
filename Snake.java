import edu.du.dudraw.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Snake<T> 
{
	public Segment header, trailer, temp;
	public LinkedList obj = new LinkedList();
	public Food food;
	public int count = 2;
	public int direction;
	public Snake(Draw d)
	{
		food = new Food(d);
		this.direction = 0;
		this.header = new Segment(250, 250, null, null);
		this.trailer = new Segment(270, 250, null, header);
		header.next = trailer;
		temp = header;
	}
	
	public void addSegment()
	{
		obj.addLast(new Segment(trailer.x+20, trailer.y+20, null, trailer));
		count++;
	}
	public void updatePositions()
	{
		temp = header;
		for(int i = 0; i < count; i++)
		{
			if(direction == 0)
			{
				if(temp.next != null)
				{
					temp.y += 40;
					//temp = temp.next;
				}
			}
			if(direction == 1)
			{
				if(temp.next != null)
				{
					temp.x -= 40;
					//temp = temp.next;
				}
			}
			if(direction == 2)
			{
				if(temp.next != null)
				{
					temp.y -= 40;
					//temp = temp.next;
				}
			}
			if(direction == 3)
			{
				if(temp.next != null)
				{
					temp.x += 40;
					//temp = temp.next;
				}
			}
			temp = temp.next;
		}
	}
	class Segment
	{
		public Segment next;
		public Segment prev;
		public int x;
		public int y;
		public Segment(int xVal, int yVal, Segment n, Segment p)
		{
			this.x = xVal;
			this.y = yVal;
			this.next = n;
			this.prev = p;
		}
	}
}
