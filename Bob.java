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

	public static final int WIDTH = 18;
	public static final int HEIGHT = 22;

	private int x;
	private int y;
	private int speed;
	private int animationDelay;
	private Direction direction;

	private JFrame sprite;
	private JLabel image;
	private ImageIcon [] costumes;

	// costume array indicies
	public static final int STATIONARY_R = 0;
	public static final int LEFT_FOOT_FORWARD_R = 1;
	public static final int LEFT_FOOT_STRIDE_R = 2;
	public static final int RIGHT_FOOT_BACKWARD_R = 3;
	public static final int RIGHT_FOOT_FORWARD_R = 4;
	public static final int RIGHT_FOOT_STRIDE_R = 5;
	public static final int LEFT_FOOT_BACKWARD_R = 6;
	public static final int STATIONARY_L = 7;
	public static final int LEFT_FOOT_FORWARD_L = 8;
	public static final int LEFT_FOOT_STRIDE_L = 9;
	public static final int RIGHT_FOOT_BACKWARD_L = 10;
	public static final int RIGHT_FOOT_FORWARD_L = 11;
	public static final int RIGHT_FOOT_STRIDE_L = 12;
	public static final int LEFT_FOOT_BACKWARD_L = 13;
	public static final int COSTUME_COUNT = 14;

	// CONSTRUCTOR //

	public Bob(int x, int y, int speed, int animationDelay)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.animationDelay = animationDelay;
		this.direction = Direction.RIGHT;

		sprite = new JFrame("DesktopBob");
		sprite.setLocation(x, y);
		sprite.setSize(WIDTH, HEIGHT);
		sprite.setUndecorated(true);
		sprite.setBackground(new Color(0, 0, 0, 0));
		sprite.setAlwaysOnTop(true);
		sprite.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		sprite.setVisible(true);

		image = new JLabel();
		sprite.add(image);

		costumes = loadCostumes();   // create array of Bob's costumes
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
		setLocation(x, this.y);
	}

	public void setY(int y)
	{
		setLocation(this.x, y);
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

	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		sprite.setLocation(x, y);
	}

	// COSTUMES //

	private ImageIcon [] loadCostumes()
	{
		costumes = new ImageIcon[COSTUME_COUNT];

		costumes[STATIONARY_R] = new ImageIcon(getClass().getResource("costumes/Stationary R.png"));
		costumes[LEFT_FOOT_FORWARD_R] = new ImageIcon(getClass().getResource("costumes/Left Foot Forward R.png"));
		costumes[LEFT_FOOT_STRIDE_R] = new ImageIcon(getClass().getResource("costumes/Left Foot Stride R.png"));
		costumes[RIGHT_FOOT_BACKWARD_R] = new ImageIcon(getClass().getResource("costumes/Right Foot Backward R.png"));
		costumes[RIGHT_FOOT_FORWARD_R] = new ImageIcon(getClass().getResource("costumes/Right Foot Forward R.png"));
		costumes[RIGHT_FOOT_STRIDE_R] = new ImageIcon(getClass().getResource("costumes/Right Foot Stride R.png"));
		costumes[LEFT_FOOT_BACKWARD_R] = new ImageIcon(getClass().getResource("costumes/Left Foot Backward R.png"));
		costumes[STATIONARY_L] = new ImageIcon(getClass().getResource("costumes/Stationary L.png"));
		costumes[LEFT_FOOT_FORWARD_L] = new ImageIcon(getClass().getResource("costumes/Left Foot Forward L.png"));
		costumes[LEFT_FOOT_STRIDE_L] = new ImageIcon(getClass().getResource("costumes/Left Foot Stride L.png"));
		costumes[RIGHT_FOOT_BACKWARD_L] = new ImageIcon(getClass().getResource("costumes/Right Foot Backward L.png"));
		costumes[RIGHT_FOOT_FORWARD_L] = new ImageIcon(getClass().getResource("costumes/Right Foot Forward L.png"));
		costumes[RIGHT_FOOT_STRIDE_L] = new ImageIcon(getClass().getResource("costumes/Right Foot Stride L.png"));
		costumes[LEFT_FOOT_BACKWARD_L] = new ImageIcon(getClass().getResource("costumes/Left Foot Backward L.png"));

		for (int i = 0; i < costumes.length; i++)
		{
			Image scaled = costumes[i].getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT); // scale it the smooth way
			costumes[i] = new ImageIcon(scaled);  // transform it back
		}

		return costumes;
	}

	public void setCostume(int index)
	{
		image.setIcon(costumes[index]);
	}

	// WALK //

	public void walk() throws InterruptedException
	{
		if (direction == Direction.RIGHT)
		{
			for (int i = LEFT_FOOT_FORWARD_R; i <= LEFT_FOOT_BACKWARD_R; i++)
			{
				setCostume(i);

				if (i == LEFT_FOOT_STRIDE_R ||
					i == RIGHT_FOOT_STRIDE_R ||
					i == RIGHT_FOOT_BACKWARD_R ||
					i == LEFT_FOOT_BACKWARD_R)
				{
					setLocation(x += speed, y);
				}

				wait(animationDelay);
			}

			setCostume(STATIONARY_R);
		}

		else if (direction == Direction.LEFT)
		{
			for (int i = 8; i <= 13; i++)
			{
				setCostume(i);

				if (i == LEFT_FOOT_STRIDE_L ||
					i == RIGHT_FOOT_STRIDE_L ||
					i == RIGHT_FOOT_BACKWARD_L ||
					i == LEFT_FOOT_BACKWARD_L)
				{
					setLocation(x -= speed, y);
				}

				wait(animationDelay);
			}

			setCostume(STATIONARY_L);
		}
	}

	public void jump(int jumps) throws InterruptedException
	{
		if (direction == Direction.RIGHT)
		{
			setCostume(STATIONARY_R);
			wait(200);
		}
		else if (direction == Direction.LEFT)
		{
			setCostume(STATIONARY_L);
			wait(200);
		}

		for (int i = 0; i < jumps; i++)
		{
			//window.setLocation(x, y - 14);
			wait(100);
			//window.setLocation(x, y);
			wait(100);
		}

		TimeUnit.MILLISECONDS.sleep(200);
	}

	public void wait(int milliseconds) throws InterruptedException
	{
		TimeUnit.MILLISECONDS.sleep(milliseconds);
	}



} // end of class Bob
