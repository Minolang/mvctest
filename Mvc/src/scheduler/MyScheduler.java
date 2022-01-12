package scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class MyScheduler {
	public MyScheduler() throws Exception  {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler s = sf.getScheduler();
		
		JobDetail job1 = new JobDetailImpl("job","group",Myjob.class);
		Trigger trigger1 = new CronTriggerImpl("trigger","group","0/20 * * * * ?");
		
		s.scheduleJob(job1,trigger1);
		s.start();
		
	}
}
