import java.awt.*;

public class DesktopBob
{
	public static void main(String [] args) throws Exception
	{
		System.setProperty("apple.awt.UIElement", "true");
		System.setProperty("apple.awt.headless", "true");

		Window window = new Window(100, 100, 20, 20);
		Bob bob = new Bob(10, 10, 3, 110);

		window.add(bob.getSprite());

		while (true)
		{
			bob.walk();
		}

		//while (true)
		//{
		//	Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
		//	int screenWidth = (int)(screenDimensions.getWidth());
		//	int screenHeight = (int)(screenDimensions.getHeight());

		//	//int [] dockDimensions = getDockDimensions();
		//	//int dockWidth = dockDimensions[0];
		//	//int dockHeight = dockDimensions[1];

		//	//int dockMidpoint = screenWidth / 2;
		//	//int xMin = dockMidpoint - (dockWidth / 2) + 30;
		//	//int xMax = dockMidpoint + (dockWidth / 2) - 50;
		//	//int y = screenHeight - dockHeight - Bob.HEIGHT;
		//	int xMin = 0;
		//	int xMax = screenWidth - Bob.WIDTH;
		//	int y = screenHeight - Bob.HEIGHT;
		//	int speed = 3;
		//	int animationDelay = 110;

		//	bob.setX(xMin);
		//	bob.setY(y);
		//	bob.setSpeed(speed);
		//	bob.setAnimationDelay(animationDelay);

		//	bob.setDirection(Bob.Direction.RIGHT);
		//	bob.wait(200);

		//	while (bob.getX() + speed < xMax)
		//	{
		//		bob.walk();
		//	}

		//	bob.setDirection(Bob.Direction.LEFT);
		//	bob.wait(200);

		//	while (bob.getX() - speed > xMin)
		//	{
		//		bob.walk();
		//	}
		//}

	} // end of main()

} // end of class DesktopBob
