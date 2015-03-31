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
	}
	class GUI extends JPanel
	{
		public GUI(){}
		public void paintComponent(Graphics g)
		{
			g.setFont(new Font("Impact",Font.BOLD ,48 ));
			g.drawString("Noah", 50, 50);
		}
	}
}