import javax.swing.*;
import java.awt.*;
import java.net.*;
public class PacketSniffer
{
	public static void main(String[] args)
	{
		new Enviroment();
	}
}

class Enviroment
{
	private JTextArea mainOutput;
	JFrame frame;
	DatagramSocket sock;
	public Enviroment()
	{
		frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new GUIPanel());
		frame.setVisible(true);
		try{
			sock = new DatagramSocket();
		}catch(SocketException e){e.printStackTrace();}
	}
	class GUIPanel extends JPanel
	{
		GUIPanel()
		{
			mainOutput = new JTextArea("",20,45);
				mainOutput.setEditable(true);
				mainOutput.setBackground(Color.gray);
				mainOutput.setForeground(Color.GREEN);
				mainOutput.setFont(new Font("Serif", Font.PLAIN, 20));
			add(mainOutput);
		}
		public void paintComponent(Graphics g)
		{
			mainOutput.setText("hello");
		}
	}
}
