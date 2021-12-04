import java.awt.*;

public class DesktopBob
{
	public static void main(String [] args) throws Exception
	{
		System.setProperty("apple.awt.UIElement", "true");
		System.setProperty("apple.awt.headless", "true");

		int speed = 3;
		int animationDelay = 110;
		Bob bob = new Bob(0, 0, speed, animationDelay);

		while (true)
		{
			Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
			int screenWidth = (int)(screenDimensions.getWidth());
			int screenHeight = (int)(screenDimensions.getHeight());

			int xMin = 0;
			int xMax = screenWidth - Bob.WIDTH;
			int y = screenHeight - Bob.HEIGHT;

			bob.setLocation(xMin, y);

			bob.setDirection(Bob.Direction.RIGHT);
			bob.wait(200);

			while (bob.getX() + speed < xMax)
			{
				bob.walk();
			}

			bob.setDirection(Bob.Direction.LEFT);
			bob.wait(200);

			while (bob.getX() - speed > xMin)
			{
				bob.walk();
			}
		}

	} // end of main()

} // end of class DesktopBob
