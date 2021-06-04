import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Bob
{
	private int x;
	private int y;
	private int speed;
	private int animationDelay;
	private char direction;
	private JFrame sprite;
	private JLabel image;
	private ImageIcon [] costumes;

	// DEFAULT CONSTRUCTOR //

	public Bob()
	{
		x = 0;
		y = 0;
		speed = 0;
		animationDelay = 0;
		direction = 'R';
		sprite = null;
		image = null;
		costumes = null;
	}

	// PARAMETRIC CONSTRUCTOR //

	public Bob(int x, int y, int speed, int animationDelay)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.animationDelay = animationDelay;
		direction = 'R';

		sprite = new JFrame("Bob");
		sprite.setSize(50, 46);
		sprite.setLocation(x, y);
		sprite.setUndecorated(true);
		sprite.setBackground(new Color(0, 0, 0, 0));

		image = new JLabel();
		sprite.add(image);

		// Create array of Bob's costumes //

		// /Users/Kyle/Documents/Java Projects/Desktop Bob/

		costumes = new ImageIcon[6];
		costumes[0] = new ImageIcon("costumes/Bob R.png");
		costumes[1] = new ImageIcon("costumes/Bob Forward R.png");
		costumes[2] = new ImageIcon("costumes/Bob Backward R.png");
		costumes[3] = new ImageIcon("costumes/Bob L.png");
		costumes[4] = new ImageIcon("costumes/Bob Forward L.png");
		costumes[5] = new ImageIcon("costumes/Bob Backward L.png");

		sprite.setAlwaysOnTop(true);
		sprite.setIconImage(costumes[0].getImage());
		sprite.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		sprite.setVisible(true);
	}

	// GET / SET ("x") //

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	// GET / SET ("y") //

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	// GET / SET ("speed") //

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	// GET / SET ("animationDelay") //

	public int getAnimationDelay()
	{
		return animationDelay;
	}

	public void setAnimationDelay(int animationDelay)
	{
		this.animationDelay = animationDelay;
	}

	// GET / SET ("direction") //

	public int getDirection()
	{
		return direction;
	}

	public void setDirection(char direction)
	{
		this.direction = direction;
	}

	// WALK //

	public void walk() throws InterruptedException
	{
		if (direction == 'R')
		{
			for (int i = 0; i < 3; i++)
			{
				image.setIcon(costumes[i]);
				sprite.setLocation(x += speed, y);
				TimeUnit.MILLISECONDS.sleep(animationDelay);
			}

			image.setIcon(costumes[0]);
		}
		else if (direction == 'L')
		{
			for (int i = 3; i < 6; i++)
			{
				image.setIcon(costumes[i]);
				sprite.setLocation(x -= speed, y);
				TimeUnit.MILLISECONDS.sleep(animationDelay);
			}

			image.setIcon(costumes[3]);
		}
	}

	public void jump(int jumpCount) throws InterruptedException
	{
		if (direction == 'R')
		{
			image.setIcon(costumes[0]);
			TimeUnit.MILLISECONDS.sleep(200);
		}
		else if (direction == 'L')
		{
			image.setIcon(costumes[3]);
			TimeUnit.MILLISECONDS.sleep(200);
		}

		for (int i = 0; i < jumpCount; i++)
		{
			sprite.setLocation(x, y - 14);
			TimeUnit.MILLISECONDS.sleep(100);
			sprite.setLocation(x, y);
			TimeUnit.MILLISECONDS.sleep(100);
		}

		TimeUnit.MILLISECONDS.sleep(200);
	}

	@Override
	public String toString()
	{
		return String.format("X: %d   Y: %d   Direction: %c", x, y, direction);
	}

} // end of class Bob
