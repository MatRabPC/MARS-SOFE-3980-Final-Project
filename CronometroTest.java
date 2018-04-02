/* CronometroTest
 * 
 * This is used to check the methods in the Cronometro class
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class CronometroTest {

	@Test
	/* CronometroDisplayTest
	 * 
	 * checks: public Cronometro()
	 * 
	 * The result of creating an Cronometro object should display the initial state of the Cronometro object which is the time at 0:00:00:0
	 * 
	 * For the purpose of this test the JFrame will display for 6 seconds
	 * 
	 */
	public void CronometroDisplayTest() {
		System.out.println("Currently Testing: CronometroDisplaytest");
		
		Cronometro displayTimer = new Cronometro();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interupted");
		}	
		
		System.out.println("Compeleted Testing: CronometroDisplaytest\n");
	}
	
	@Test
	/* inizioTest
	 * 
	 * checks: public void inizio()
	 * 
	 * The result of using the inizio method will cause the Cronometro object (timer) to start
	 * 
	 * For the purpose of this test the JFram will display for 6 seconds
	 */
	public void inizioTest() {
		System.out.println("Currently Testing: inizioTest");
		
		Cronometro timer = new Cronometro();
		timer.inizio();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interupted");
		}	
		
		System.out.println("Compeleted Testing: inizioTest\n");
	}
	
	@Test
	/* stopTest
	 * 
	 * checks: public void stop()
	 * 
	 * The result of using the stop method will cause the Cronometro object (timer) to stop
	 * 
	 * For the purpose of this test the Cronometro object will be initialized and wait for 3 until the stop method is called. Finally, the 
	 * JFrame will display for 4 additional seconds
	 * 
	 */
	public void stopTest() 
	{
		System.out.println("Currently Testing: stopTest");
		
		Cronometro timer = new Cronometro();
		timer.inizio();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interupted");
		}
		
		timer.stop();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interupted");
		}
		
		System.out.println("Compeleted Testing: stopTest\n");
	}
	
}
