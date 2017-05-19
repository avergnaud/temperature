package cron;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 518400 relevés de température par an 1 par minute
 */
public enum ToutesLesMinutes {

	INSTANCE;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public void start() {
		scheduler.scheduleAtFixedRate(new PriseDeTemperature(), 1, 1, TimeUnit.SECONDS);
	}

}
