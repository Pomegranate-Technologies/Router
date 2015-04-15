import java.awt.*;

class WillsGUI extends Window
{
	Color c1;

	public WillsGUI(WindowManager w)
	{
		this.wm = w;
	}

	public void constructor()
	{

	}

	public void update()
	{

	}

	public void draw(java.awt.Graphics2D g)
	{
		c1 = new Color(255,65,89);

		g.setColor(c1);

		g.drawRect(30,64,23,89);
	}

	public void keyPressed(int k)
	{

	}
}