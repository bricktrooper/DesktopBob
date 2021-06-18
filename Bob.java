import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Bob
{
	public enum Direction
	{
		LEFT,
		RIGHT
	}

	private int x;
	private int y;
	private int speed;
	private int animationDelay;
	private Direction direction;

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
		direction = Direction.RIGHT;
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
		direction = Direction.RIGHT;

		sprite = new JFrame("Bob");
		sprite.setSize(50, 46);
		sprite.setLocation(x, y);
		sprite.setUndecorated(true);
		sprite.setBackground(new Color(0, 0, 0, 0));

		image = new JLabel();
		sprite.add(image);

		// create array of Bob's costumes
		costumes = new ImageIcon[14];

		costumes[0] = new ImageIcon(getClass().getResource("costumes/Stationary R.png"));

		costumes[1] = new ImageIcon(getClass().getResource("costumes/Left Foot Forward R.png"));
		costumes[2] = new ImageIcon(getClass().getResource("costumes/Left Foot Stride R.png"));
		costumes[3] = new ImageIcon(getClass().getResource("costumes/Right Foot Backward R.png"));
		costumes[4] = new ImageIcon(getClass().getResource("costumes/Right Foot Forward R.png"));
		costumes[5] = new ImageIcon(getClass().getResource("costumes/Right Foot Stride R.png"));
		costumes[6] = new ImageIcon(getClass().getResource("costumes/Left Foot Backward R.png"));

		costumes[7] = new ImageIcon(getClass().getResource("costumes/Stationary L.png"));

		costumes[8] = new ImageIcon(getClass().getResource("costumes/Left Foot Forward L.png"));
		costumes[9] = new ImageIcon(getClass().getResource("costumes/Left Foot Stride L.png"));
		costumes[10] = new ImageIcon(getClass().getResource("costumes/Right Foot Backward L.png"));
		costumes[11] = new ImageIcon(getClass().getResource("costumes/Right Foot Forward L.png"));
		costumes[12] = new ImageIcon(getClass().getResource("costumes/Right Foot Stride L.png"));
		costumes[13] = new ImageIcon(getClass().getResource("costumes/Left Foot Backward L.png"));

		for (int i = 0; i < costumes.length; i++)
		{
			Image scaled = costumes[i].getImage().getScaledInstance(18, 22,  Image.SCALE_DEFAULT); // scale it the smooth way
			costumes[i] = new ImageIcon(scaled);  // transform it back
		}

		sprite.setAlwaysOnTop(true);
		sprite.setIconImage(costumes[0].getImage());
		sprite.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		sprite.setVisible(true);
	}

	// ACCESSORS //

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getAnimationDelay()
	{
		return animationDelay;
	}

	public int getSpeed()
	{
		return speed;
	}

	public Direction getDirection()
	{
		return direction;
	}

	// MUTATORS //

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public void setAnimationDelay(int animationDelay)
	{
		this.animationDelay = animationDelay;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	// WALK //

	public void walk() throws InterruptedException
	{
		if (direction == Direction.RIGHT)
		{
			for (int i = 1; i <= 6; i++)
			{
				image.setIcon(costumes[i]);

				if (i == 2 || i == 5 || i == 3 || i == 6)
				{
					sprite.setLocation(x += speed, y);
					//TimeUnit.MILLISECONDS.sleep(animationDelay);
				}

				TimeUnit.MILLISECONDS.sleep(animationDelay);
			}

			image.setIcon(costumes[0]);
		}
		else if (direction == Direction.LEFT)
		{
			for (int i = 7; i <= 13; i++)
			{
				image.setIcon(costumes[i]);

				if (i == 9 || i == 12 || i == 10 || i == 13)
				{
					sprite.setLocation(x -= speed, y);
				}

				TimeUnit.MILLISECONDS.sleep(animationDelay);
			}

			image.setIcon(costumes[5]);
		}
	}

	public void jump(int jumps) throws InterruptedException
	{
		if (direction == Direction.RIGHT)
		{
			image.setIcon(costumes[0]);
			TimeUnit.MILLISECONDS.sleep(200);
		}
		else if (direction == Direction.LEFT)
		{
			image.setIcon(costumes[3]);
			TimeUnit.MILLISECONDS.sleep(200);
		}

		for (int i = 0; i < jumps; i++)
		{
			sprite.setLocation(x, y - 14);
			TimeUnit.MILLISECONDS.sleep(100);
			sprite.setLocation(x, y);
			TimeUnit.MILLISECONDS.sleep(100);
		}

		TimeUnit.MILLISECONDS.sleep(200);
	}

	public void wait(int milliseconds) throws InterruptedException
	{
		TimeUnit.MILLISECONDS.sleep(milliseconds);
	}

	@Override
	public String toString()
	{
		return String.format("X: %4d Y: %4d Direction: %s", x, y, direction);
	}

} // end of class Bob
