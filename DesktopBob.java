import java.awt.*;

public class DesktopBob
{
	public static void main(String [] args) throws Exception
	{
		System.setProperty("apple.awt.UIElement", "true");
		System.setProperty("apple.awt.headless", "true");

		Window window = new Window(0, 0, 0, 0);
		Bob bob = new Bob(0, 0, 0, 0);
		window.add(bob.getSprite());

		while (true)
		{
			Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
			int screenWidth = (int)(screenDimensions.getWidth());
			int screenHeight = (int)(screenDimensions.getHeight());

			window.setX(0);
			window.setY(screenHeight - Bob.HEIGHT);
			window.updateLocation();

			window.setWidth(screenWidth);
			window.setHeight(Bob.HEIGHT);
			window.updateSize();

			// Bob's (x, y) is relative to the window, not the screen
			int xMin = 0;
			int xMax = screenWidth - Bob.WIDTH;
			int y = 0;
			int speed = 3;
			int animationDelay = 110;

			bob.setX(xMin);
			bob.setY(y);
			bob.setSpeed(speed);
			bob.setAnimationDelay(animationDelay);

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
