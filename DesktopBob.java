import java.awt.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class DesktopBob
{
	public static void main(String [] args) throws Exception
	{
		Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenDimensions.getWidth());
		int screenHeight = (int)(screenDimensions.getHeight());

		int [] dockDimensions = getDockDimensions();
		int dockWidth = dockDimensions[0];
		int dockHeight = dockDimensions[1];

		int dockMidpoint = screenWidth / 2;
		int xMin = dockMidpoint - (dockWidth / 2) + 30;
		int xMax = dockMidpoint + (dockWidth / 2) - 50;
		int y = screenHeight - dockHeight - 34;
		int speed = 3;

		Bob bob = new Bob(xMin, y, speed, 110);

		while (true)
		{
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

	public static int [] getDockDimensions() throws Exception
	{
		Runtime runtime = Runtime.getRuntime();
		String command = "tell application \"System Events\" to " +
		                 "tell application process \"Dock\" to " +
		                 "set {width, height} to " +
		                 "the size of list 1\n" +
		                 "return {width, height}";

		String [] args = { "osascript", "-e", command };
		Process process = runtime.exec(args);
		InputStreamReader stream = new InputStreamReader(process.getInputStream());
		BufferedReader stdout = new BufferedReader(stream);
		String output = stdout.readLine();

		if (output == null)
		{
			throw new Exception("Failed to get dock dimensions");
		}

		int [] dimensions = new int[2];

		dimensions[0] = Integer.parseInt(output.split(", ", 2)[0]);
		dimensions[1] = Integer.parseInt(output.split(", ", 2)[1]);

		return dimensions;
	}

} // end of class DesktopBob
