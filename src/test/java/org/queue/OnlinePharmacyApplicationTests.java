package org.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.queue.initializer.DrugsInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class OnlinePharmacyApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		DrugsInitializer drugsInitializer = new DrugsInitializer();
		drugsInitializer.run();
	}

}
