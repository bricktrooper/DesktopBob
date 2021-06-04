
public class DesktopBob
{
	public static void main(String [] args) throws InterruptedException
	{
		if (args.length != 3)
		{
			System.out.println("Incorrect arguments");
			System.out.println("Usage: DesktopBob <x> <y> <jumps>");
			return;
		}

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int jumps = Integer.parseInt(args[2]);

		Bob bob = new Bob(x, y, 4, 110);

		while (true)
		{
			bob.setDirection('R');

			while (bob.getX() < x + 900)
			{
				bob.walk();
			}

			bob.jump(jumps);

			bob.setDirection('L');

			while (bob.getX() > x)
			{
				bob.walk();
			}

			bob.jump(jumps);
		}

	} // end of main()

} // end of class DesktopBob