import java.awt.*;

class ExampleWindow extends Window
{
	Color c1;
	Color c2;
	Font f;

	public ExampleWindow(WindowManager w)
	{
		this.wm = w;
		delay = 30;
		time = 1000;
		f = new Font("Impact",Font.BOLD,150);
	}

	public void constructor()
	{

	}

	public void update()
	{
		c1 = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
		c2 = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
	}

	public void draw(java.awt.Graphics2D g)
	{
		g.setFont(f);
		g.setColor(c1);
		g.fillRect(0,0,MyPanel.WIDTH,MyPanel.HEIGHT);
		g.setColor(c2);
		g.drawString("Hello World!",100,200);
	}

	public void keyPressed(int k)
	{

	}
}