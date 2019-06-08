package msg.notification.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Singleton
@Startup
public class NotificationsCleanerTask {
@EJB
private PrintTask printTask;

    @PostConstruct
    public void execute() {
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 43);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        timer.schedule(printTask,
                time);
    }


}



