import javax.swing.*;

class Window
{
	private int width;
	private int height;
	private int x;
	private int y;
	private JFrame window;

	Window(int width, int height, int x, int y)
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		window = new JFrame("DesktopBob");
		window.setSize(width, height);
		window.setLocation(x, y);
		window.setUndecorated(true);
		//window.setBackground(new Color(0, 0, 0, 0));

		window.setAlwaysOnTop(true);
		//window.setIconImage(costumes[0].getImage());
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void add(JLabel sprite)
	{
		window.add(sprite);
	}
}
