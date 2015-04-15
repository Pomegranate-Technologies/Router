import javax.swing.*;

import java.util.*;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class Main
{
	public static void main(String args[])
	{
        JFrame window = new JFrame();
        window.setTitle("GUI Practice");
        window.setSize(MyPanel.WIDTH, MyPanel.HEIGHT);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new MyPanel());

        window.setResizable(false);
        window.pack();
        window.setVisible(true);
	}
}

class MyPanel extends JPanel implements Runnable
{
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;

	private Thread thread;

	private BufferedImage image;
	private Graphics2D g;
	private boolean running;

	private WindowManager wm;

	public MyPanel()
	{
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify()
	{
		super.addNotify();

		if(thread == null)
		{
			addKeyListener(new Listen());
			thread = new Thread(this);
			thread.start();
		}
	}

	private void init()
	{
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		running = true;

		wm = new WindowManager();
	}

	public void run()
	{
		init();

		while(running)
		{
			for(int x = 0; x < wm.getTime(); x++)
			{
				update();
				draw();
				drawToScreen();
				try{
					Thread.sleep(wm.getDelay());
				}
				catch(InterruptedException e){e.printStackTrace();}
			}
			wm.shift();
		}
	}

	private void update() {
	       wm.update();
	}

	private void draw() {
	       wm.draw(g);
	}

	private void drawToScreen() {
	        Graphics g2 = getGraphics();
	        g2.drawImage(image, 0, 0, null);
	        g2.dispose();
	}

	class Listen implements KeyListener
	{
	    public void keyTyped(KeyEvent k) {

	    }
	    public void keyPressed(KeyEvent k) {
			wm.keyPressed(k.getKeyCode());
			draw();
			drawToScreen();
	    }
	    public void keyReleased(KeyEvent k) {

	    }

	}
}

class WindowManager
{
	private ArrayList<Window> windows;
	private int currentState;

    public WindowManager()
    {
		windows = new ArrayList<Window>();

		windows.add(new ExampleWindow(this));
		windows.add(new WillsGUI(this));
    }

    public void shift()
    {
    	if(currentState < windows.size())
    	{
    		currentState++;
    	}
    	else
    	{
    		currentState = 0;
    	}
    }

    public int getCurrentState()
    {
    	return currentState;
    }

    public void setCurrentState(int i)
    {
        currentState = i;
    }

    public void update()
    {
		windows.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g)
    {
		windows.get(currentState).draw(g);
    }

    public void keyPressed(int k)
    {
		windows.get(currentState).keyPressed(k);
    }

    public int getDelay()
    {
    	return windows.get(currentState).getDelay();
    }

    public int getTime()
    {
    	return windows.get(currentState).getTime();
    }
}