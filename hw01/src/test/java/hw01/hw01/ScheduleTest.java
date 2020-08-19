package hw01.hw01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {
	private  Schedule schedule;
	private  Movie movie1;
    private  Movie movie2;
    private Seance seance1;
    private Seance seance2;
    
    
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@Before
	public  void beforeTest() {
		schedule = new Schedule();
		movie1 = new Movie("Film1", new Time(1, 55));
        movie2 = new Movie("Film2", new Time(1, 40));
        seance1 = new Seance(movie1, new Time(9, 20));
        seance2 = new Seance(movie2, new Time(18, 0));
       
		
	}

	@After
	public  void afterTest() {
		schedule = null;
		movie1 = null;
        movie2 = null;
        seance1 = null;
        seance2 = null;
       
	}
	
	@Test
	public void addSeanceShouldOutputTrue() {
		boolean addSeance = schedule.addSeance(seance1);
		Assert.assertTrue(addSeance);
	}
	
	@Test
	public void removeSeanceShouldOutputTrue() {
		schedule.addSeance(seance1);
		boolean removeSeance = schedule.removeSeance(seance1);
		Assert.assertTrue(removeSeance);
	}
	
	
	@Test
	public void removeSeanceShouldOutputFalse() {
		schedule.addSeance(seance1);
		boolean removeSeance = schedule.removeSeance(seance2);
		Assert.assertFalse(removeSeance);
	}
	
	
	
	
}
