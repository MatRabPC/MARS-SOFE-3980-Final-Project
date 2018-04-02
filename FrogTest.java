import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

public class FrogTest {

	@Test
	/* getBoundsTest
	 * 
	 * checks: public Rectangle getBounds()
	 * 
	 * This will create a frog object and obtain the bounds of the Frog as a Rectangle object. It will then compare the instance 
	 * variables of the Rectangle object (i.e. x, y, width, height) with their expected values 
	 * 
	 */
	public void getBoundsTest() 
	{
		//Creating Frog object
		int x = 25;
		int y = 69;
		Rectangle testBounds = new Rectangle(100,100,100,100); 
		Frog testFrog = new Frog(x,y,testBounds);
		
		//Obtaining the bounds from testFrog
		Rectangle result = testFrog.getBounds();
		
		//Expected Values
		int radius = testFrog.RADIUS;
		
		int xExpected = x-radius;
		int yExpected = y-radius;
		int width = radius * 2;
		int height = radius *  2;
		
		
		assertEquals(xExpected,result.x);
		assertEquals(yExpected, result.y);
		assertEquals(width,result.width);
		assertEquals(height,result.height);
	}
	
	@Test
	/* drawTest
	 * 
	 * checks: public void draw(Graphics g)
	 * 
	 * This will create a frog object and will display it on a JFrame at the request position
	 * 
	 * For the purpose of this test the JFrame will be displayed for 6 seconds
	 * 
	 */
	public void drawTest()
	{
		//Creating Frog Object
		int x = 70;
		int y = 100;
		Rectangle testBounds = new Rectangle(0,0,250,250);
		
		Frog testFrog = new Frog(x, y, testBounds);
		
		//Creating new JFrame and displaying Frog
		JFrame frame = createJFrame("Draw (Frog) Test");
		frame.setVisible(true);
		frame.setSize(300,300);
		
		JPanel pannel = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
					}
				};
		frame.add(pannel);
		
		sleep(6);
		
	}
	
	@Test
	/* moveTo
	 * 
	 * checks: 	public Frog moveTo(int x, int y)
	 * 
	 * Checks if the new Frog object is in the requested location
	 * 
	 * For the purpose of this test the JFrame will contain the orginal Frog object will appear in its location and surrounded by a square while the
	 * new Frog object will appear in the requested location. In addition, the JFrame will only appear for 6 seconds
	 * 
	 */
	public void moveTo()
	{
		//Oringal location of Frog object
		Rectangle testBounds = new Rectangle(0,0,250,250);
		Frog testFrog = new Frog(250/2,250-5, testBounds);
		
		//New location of Frog object
		int x = 200;
		int y = 200;
		Frog result = testFrog.moveTo(x, y);
		
		//Creating JFrame & Displaying the orginal and new Frog objects
		JFrame frame = createJFrame("moveTo Test");
		
		JPanel pannel = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				testFrog.draw(g);
				Rectangle boundedFrog = testFrog.getBounds();
				g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
				
				result.draw(g);
			}
		};
		frame.add(pannel);
		
		
		sleep(6);
	}
		
	
	@Test
	/* moveTest
	 * 
	 * checks: public Frog move(int dx, int dy)
	 * 
	 * This will be used to test if the Frog is being requested to move out of bounds
	 * 
	 * For the purpose of this test the JFrame will display both instances (i.e. the requested location that is within bound and the requested location that is out of bound)
	 * with an interval of 3 seconds
	 * 			Within Bounds
	 * 				- The expected result will display the Frog's boundary as a rectangle, the orginal Frog represented as a rectangle containing a circle and the Frog at the requested
	 * 				  location as a circle
	 * 			Out of Bounds
	 * 				- The expected result will display the Frog's boundary as a rectangle, the orginal Frog represented as a rectangle containing a circle
	 */
	public void moveTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(250/2,250-5, frogBounds);
		
		
		//Creating JFrame
		JFrame frame = createJFrame("moveTest Frame");
		
		
		
		//Testing the result of a Frog that moves within bounds
		Frog resultFrog = testFrog.move(100,100);
		JPanel FrogWithinBound = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
						Rectangle boundedFrog = testFrog.getBounds();
						g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
						g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
						
						resultFrog.draw(g);
					}
				}; 
				
		frame.add(FrogWithinBound);
		
		sleep(3);
		
		FrogWithinBound.setVisible(false);
		
		
		//Testing the result of a Frog that is requested to move out of bounds
		Frog resultFrog2 = testFrog.move(500,6);
		JPanel FrogOutBound = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				testFrog.draw(g);
				Rectangle boundedFrog = testFrog.getBounds();
				g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
				g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
				
				resultFrog2.draw(g);
			}
		};
		
		frame.add(FrogOutBound);
		
		sleep(6);
		
	}
	
	
	@Test
	/* moveUpTest
	 * 
	 * checks: public Frog moveUp()
	 * 
	 * This is used to check if the frog object's new location is vertically upward.
	 * 
	 * It will first create the Frog object and then use a Frog array and the moveUp function to display the 
	 * resulting Frog object.  
	 * 
	 * The original Frog object is represented as a circle enclosed in square and the new Frog object is represented 
	 * as a circle
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void moveUpTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(150,200, frogBounds);
				
				
		//Creating JFrame
		JFrame frame = createJFrame("moveUpTest Frame");
		
		//Testing the result of the moveUp method
		Frog [] resultFrog = new Frog[4];
		resultFrog[0] = testFrog;
		
		for (int i = 1; i < resultFrog.length; i++)
		{
			resultFrog[i] = resultFrog[i-1].moveUp();
		}
		
		JPanel moveUpResults = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
						Rectangle boundedFrog = testFrog.getBounds();
						g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
						g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
						
						
						resultFrog[resultFrog.length-1].draw(g);
					}
				}; 
				
		frame.add(moveUpResults);
				
		sleep(6);
	}
	
	
	@Test
	/* moveDownTest
	 * 
	 * checks: public Frog moveDown()
	 * 
	 * This is used to check if the frog object's new location is vertically downward.
	 * 
	 * It will first create the Frog object and then use a Frog array and the moveDown function to display the 
	 * resulting Frog object.  
	 * 
	 * The original Frog object is represented as a circle enclosed in square and the new Frog object is represented 
	 * as a circle
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void moveDownTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(150,200, frogBounds);
				
				
		//Creating JFrame
		JFrame frame = createJFrame("moveDownTest Frame");
		
		//Testing the result of the moveUp method
		Frog [] resultFrog = new Frog[4];
		resultFrog[0] = testFrog;
		
		for (int i = 1; i < resultFrog.length; i++)
		{
			resultFrog[i] = resultFrog[i-1].moveDown();
		}
		
		JPanel moveDownResults = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
						Rectangle boundedFrog = testFrog.getBounds();
						g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
						g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
						
						
						resultFrog[resultFrog.length-1].draw(g);
					}
				}; 
				
		frame.add(moveDownResults);
				
		sleep(6);
	}
	
	
	@Test
	/* moveLeftTest
	 * 
	 * checks: public Frog moveLeft()
	 * 
	 * This is used to check if the frog object's new location is hoziontaily to the left.
	 * 
	 * It will first create the Frog object and then use a Frog array and the moveDown function to display the 
	 * resulting Frog object.  
	 * 
	 * The original Frog object is represented as a circle enclosed in square and the new Frog object is represented 
	 * as a circle
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void moveLeftTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(150,200, frogBounds);
				
				
		//Creating JFrame
		JFrame frame = createJFrame("moveLeftTest Frame");
		
		
		//Testing the result of the moveUp method
		Frog [] resultFrog = new Frog[4];
		resultFrog[0] = testFrog;
		
		for (int i = 1; i < resultFrog.length; i++)
		{
			resultFrog[i] = resultFrog[i-1].moveLeft();
		}
		
		JPanel moveLeftResults = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
						Rectangle boundedFrog = testFrog.getBounds();
						g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
						g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
						
						
						resultFrog[resultFrog.length-1].draw(g);
					}
				}; 
				
		frame.add(moveLeftResults);
				
		sleep(6);
	}
	
	@Test
	/* moveRightTest
	 * 
	 * checks: public Frog moveRight()
	 * 
	 * This is used to check if the frog object's new location is hoziontaily to the right.
	 * 
	 * It will first create the Frog object and then use a Frog array and the moveDown function to display the 
	 * resulting Frog object.  
	 * 
	 * The original Frog object is represented as a circle enclosed in square and the new Frog object is represented 
	 * as a circle
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void moveRightTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(150,200, frogBounds);
				
				
		//Creating JFrame
		JFrame frame = createJFrame("moveRightTest Frame");
		
		
		//Testing the result of the moveUp method
		Frog [] resultFrog = new Frog[4];
		resultFrog[0] = testFrog;
		
		for (int i = 1; i < resultFrog.length; i++)
		{
			resultFrog[i] = resultFrog[i-1].moveRight();
		}
		
		JPanel moveRightResults = new JPanel()
				{
					public void paintComponent(Graphics g)
					{
						testFrog.draw(g);
						Rectangle boundedFrog = testFrog.getBounds();
						g.drawRect(boundedFrog.x, boundedFrog.y, boundedFrog.width, boundedFrog.height);
						g.drawRect(frogBounds.x, frogBounds.y, frogBounds.width, frogBounds.height);
						
						resultFrog[resultFrog.length-1].draw(g);
					}
				}; 
				
		frame.add(moveRightResults);
				
		sleep(6);
	}
	
	@Test 
	/* drawLevelTest
	 * 
	 * checks: public void drawLevel(Graphics g,int levelNumber)
	 * 
	 * This will check if the String indicating the user's current level is displaying the approperaite contents
	 * on the JFrame
	 * 
	 */
	public void drawLevelTest()
	{
		//Initializing Frog object
		Rectangle frogBounds = new Rectangle(6,100,250,250);
		Frog testFrog = new Frog(150,200, frogBounds);
		
		
		//Creating JFrame and displaying contents from drawLevel
		JFrame frame = createJFrame("drawLevelTest Frame");
		
		JPanel levelInfo = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				int level = 4;
				testFrog.drawLevel(g,level);
			}
		}; 
		
		frame.add(levelInfo);
		
		sleep(6);
	}
	

	
	/* sleep 
	 * 
	 * Makes the thread sleep for time seconds. This is used for tests that require the user to view the contents for a longer period of time
	 * 
	 * parameter
	 * 		- time -> the amount of time for the thread to wait
	 * 
	 */
	public static void sleep(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			System.out.println("Error: Thread Interupted");
		}
	}
	
	/* createJFrame
	 * 
	 * Makes and returns a new JFrame. This is used for test that require a JFrame
	 * 		- title -> The title that will appear on the JFrame
	 * 
	 */
	public static JFrame createJFrame (String title)
	{
		JFrame frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(600,600);
		
		return frame;
	}

}
