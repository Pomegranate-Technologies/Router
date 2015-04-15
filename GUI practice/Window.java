abstract class Window
{
	int delay = 30;
	int time = 300;
	protected WindowManager wm;

	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int k);

	public int getDelay()	{ return delay;	}

	public int getTime()	{ return time;	}
}