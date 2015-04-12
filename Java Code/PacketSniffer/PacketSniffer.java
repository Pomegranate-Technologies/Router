import javax.swing.*;
import java.awt.*;

public class PacketSniffer
{
	public static void main(String[] args)
	{
		new Enviroment();
	}
}

class Enviroment
{
	JFrame frame;
	public Enviroment()
	{
		frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setContentPane(new GUIPanel());
		frame.setVisible(true);
	}
	class GUIPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{

		}
	}
}