import javax.swing.text.Segment;

import edu.du.dudraw.*;

public class Game implements DrawListener 
{
	private Snake s1;
	private Draw draw;
	private Food food = new Food(draw);;
	public Game()
	{
		s1 = new Snake(draw);
		draw = new Draw();
		draw.setCanvasSize(500, 500);
		draw.setXscale(0,500);
		draw.setYscale(0,500);
		draw.addListener(this);
		draw.setPenColor(draw.BLACK);
		drawSnake();
		//update();
	}

	@Override
	public void keyPressed(int arg0) 
	{
		
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(char arg0) 
	{
		if(arg0 == 'w')
		{
			s1.direction = 0;
			update();
		}
		if(arg0 == 'a')
		{
			s1.direction = 1;
			update();
		}
		if(arg0 == 's')
		{
			s1.direction = 2;
			update();
		}
		if(arg0 == 'd')
		{
			s1.direction = 3;
			update();
		}
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}
	
	public void drawSnake()
	{
		s1.temp = s1.header;
		for(int i = 0; i<s1.count; i++)
		{
			if(s1.temp != null)
			{
				draw.filledRectangle(s1.temp.x, s1.temp.y, 20, 20);
				s1.temp = s1.temp.next;
			}
		}
	}
	
	public boolean contains()
	{
		return false;
	}

	@Override
	public void update()
	{
		draw.clear();
		food.drawFood(draw);
		if(food.foodEaten(s1.header.x, s1.header.y, draw))
		{
			s1.addSegment();
			food.x = (int) (Math.random() * 501);
			food.y = (int) (Math.random() * 501);
		}
		s1.updatePositions();
		drawSnake();		
	}
}
