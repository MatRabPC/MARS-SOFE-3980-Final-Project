/* Car Test
 * 
 * This tests the methods in the Car class
 */

import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarTest {

	@Test
	/* moveLeftTest
	 * 
	 * checks: public Car moveLeft()
	 * 
	 * This creates a new Car object (testCar) and stores the results of the moveLeft function into a different Car object (actualCar)
	 * The function then compares the value of actualCar.x with the expectedXValue variable. This is to ensure, the expected value 
	 * is less (i.e. the expected Value of actualCar.x should be x-speed. Similarly, it also compares the value of actualCar.y with
	 * the expectedYValue variable to ensure this value has not changed.
	 * 
	 * This approach is used because the x and y variables are used to change the Car's position.
	 * 
	 */
	public void moveLeftTest() 
	{
		int x = 10;
		int y = 10;
		int speed = 5;
		Color colour = new Color(24,24,24);
		
		Car testCar = new Car(x, y, speed, colour);
		
		Car actualCar = testCar.moveLeft();
		
		int expectedXValue = x - speed;
		assertEquals(expectedXValue, actualCar.x);
		
		int expectedYValue = actualCar.y;
		assertEquals(expectedYValue, actualCar.y);
	}
	
	@Test
	/* moveRightTest
	 * 
	 * checks: public Car moveRight()
	 * 
	 * This creates a new Car object (testCar) and stores the results of the moveLeft function into a different Car object (actualCar)
	 * The function then compares the value of actualCar.x with the expectedXValue variable. This is to ensure, the expected value 
	 * is less (i.e. the expected Value of actualCar.x should be x+speed. Similarly, it also compares the value of actualCar.y with
	 * the expectedYValue variable to ensure this value has not changed.
	 * 
	 * This approach is used because the x and y variables are used to change the Car's position.
	 * 
	 */
	public void moveRightTest()
	{
		int x = 12;
		int y = 16;
		int speed = 5;
		Color colour = new Color(24,24,24);
		
		Car testCar = new Car(x, y, speed, colour);
		
		Car actualCar = testCar.moveRight();
		
		int expectedYValue = x + speed;
		assertEquals(expectedYValue, actualCar.x);
	}
	
	
	@Test
	/* emptyTest
	 * 
	 * checks: public boolean empty()
	 * 
	 * This test checks:
	 * 		- if the color instance variable in Car is equal null
	 * 		- if the color instance variable is Car is not equal to null
	 * 
	 * 
	 */
	public void emptyTest()
	{
		//Test the value of testCar.color is not null
		int x = 23;
		int y = 24;
		int speed = 6;
		Color colour = new Color (10,10,10);
		
		Car testCar = new Car(x,y,speed,colour);
		
		boolean colourValue = testCar.empty();
		assertFalse(colourValue);
		
		
		//Test the value of testCar.color is null 
		x = 3;
		y = 74;
		speed = 5;
		Color noColour = null;
		
		Car testCar2 = new Car(x,y,speed,noColour);
		
		colourValue = testCar2.empty();
		assertTrue(colourValue);
		
	}
	
	@Test
	/* drawTest
	 * 
	 * checks: public void draw(Graphics g)
	 * 
	 * This creates a car object and displays it in a JFrame.
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void drawTest()
	{
		int x = 70;
		int y = 100;
		int speed = 6;
		Color colour = new Color (0,0,0);
		
		Car testCar = new Car(x,y,speed,colour);
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300,300);
		
		JPanel pannel = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testCar.draw(g);
					}
				};
		frame.add(pannel);
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
