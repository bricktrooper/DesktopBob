import javax.swing.*;
import java.awt.*;

public class Window
{
	private int width;
	private int height;
	private int x;
	private int y;
	private JFrame window;

	Window(int x, int y, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		window = new JFrame("DesktopBob");
		updateSize();
		updateLocation();
		window.setUndecorated(true);
		window.setBackground(new Color(0, 0, 0, 0));

		window.setAlwaysOnTop(true);
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

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void updateLocation()
	{
		window.setLocation(x, y);
	}

	public void updateSize()
	{
		window.setSize(width, height);
	}

	public void add(JLabel sprite)
	{
		window.add(sprite);
	}
}
