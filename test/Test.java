package JavaTestFilePackage;
import javax.swing.*;
import java.awt.*;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("Benson Chu");
		System.out.println("Josh Patterson");
		System.out.println("Test");
		new NoahClass();
	}
}

class NoahClass extends JFrame
{
	public NoahClass()
	{
		setSize(200, 200);
		setResizable(false);
		setVisible(true);
		setContentPane(new GUI());
		
		run();
	}
	
	public void run()
	{
		while(true)
		{
			repaint();
			try{
				Thread.sleep(50);
			}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
	
	class GUI extends JPanel
	{
		public GUI(){}
		public void paintComponent(Graphics g)
		{
			Color f = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
			Color b = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
			
			g.setColor(b);
			g.fillRect(0,0,200,200);
			
			g.setColor(f);
			g.setFont(new Font("Impact",Font.BOLD ,48 ));
			g.drawString("Noah", 50, 50);
		}
	}
}